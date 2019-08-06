let indexeddb;
function onError(e) {
  alert("Error:" + e.message);
}

function setUpIndexedDb() {
  const DB_NAME = "todo.db";
  const DB_VER = 100;
  const req = indexedDB.open(DB_NAME, DB_VER);
  req.onsuccess = function(e) {
    indexeddb = e.target.result;
    showList();
  };
  req.onerror = onError;

  req.onupgradeneeded = function(e) {
    indexeddb = e.target.result;
    const store_name = "items";
    const store_opt = {
      keyPath: "id",
      autoIncrement: true
    };
    indexeddb.createObjectStore(store_name, store_opt);
  };
}

const dbName = "todo.test.db";
const storeName = "items";

function createRequest() {
  const openReq = indexedDB.open(dbName);

  openReq.onupgradeneeded = function(event) {
    const db = event.target.result;
    const os = db.createObjectStore(storeName, {
      keyPath: "id"
    });
    os.createIndex("order", "order", { unique: false });
  };

  return openReq;
}

function indexedDbSetItem(data) {
  const req = createRequest();
  req.onsuccess = function(event) {
    const db = event.target.result;
    const trans = db.transaction(storeName, "readwrite");
    const store = trans.objectStore(storeName);
    const putReq = store.put(data);

    putReq.onsuccess = function() {
      console.log("put data success");
    };

    trans.oncomplete = function() {
      // トランザクション完了時(putReq.onsuccessの後)に実行
      console.log("transaction complete");
    };
  };
}

function indexedDbGetItem(keyValue) {
  return new Promise(resolve => {
    const req = createRequest();
    req.onsuccess = function(event) {
      const db = event.target.result;
      const trans = db.transaction(storeName, "readwrite");
      const store = trans.objectStore(storeName);
      const getReq = store.get(keyValue);

      getReq.onsuccess = function(event) {
        const result = event.target.result;
        console.log(result);
        resolve(result);
      };
    };
  });
}

function indexedDbGetItems() {
  return new Promise(resolve => {
    const req = createRequest();
    req.onsuccess = function(event) {
      const db = event.target.result;
      const trans = db.transaction(storeName, "readwrite");
      const store = trans.objectStore(storeName);
      const getReq = store.openCursor();

      let list = [];
      getReq.onsuccess = function(event) {
        let cur = event.target.result;
        if (!cur) return resolve(list);
        console.log(cur.value);
        list.push(cur.value);
        cur.continue();
      };
    };
  });
}

function indexedDbGetItemsByRange(from, to) {
  return new Promise(resolve => {
    const req = createRequest();
    req.onsuccess = function(event) {
      const db = event.target.result;
      const trans = db.transaction(storeName, "readwrite");
      const store = trans.objectStore(storeName);
      const index = store.index("order");
      const range = IDBKeyRange.bound(from, to);
      const getReq = index.openCursor(range);

      let list = [];
      getReq.onsuccess = function(event) {
        let cur = event.target.result;
        if (!cur) return resolve(list);
        console.log(cur.value);
        list.push(cur.value);
        cur.continue();
      };
    };
  });
}

function indexedDbDeleteItem(keyValue) {
  const req = createRequest();
  req.onsuccess = function(event) {
    const db = event.target.result;
    const trans = db.transaction(storeName, "readwrite");
    const store = trans.objectStore(storeName);
    const getReq = store.delete(keyValue);

    getReq.onsuccess = function(event) {
      console.log(event.target.result);
    };
  };
}

function indexedDbDestroy() {
  const deleteReq = indexedDB.deleteDatabase(dbName);
  deleteReq.onsuccess = function(event) {
    console.log("db delete success");
  };

  deleteReq.onerror = function() {
    console.log("db delete error");
  };
}

function indexedDbaddItem() {
  const tr = indexeddb.transaction(["items"], "readwrite");
  const os = tr.objectStore("items");
  const req = os.put({ title: $("indexed-db-title").value });
  req.onerror = onError;
  tr.oncomplete = function() {
    showList();
    $("indexed-db-title").value = "";
    $("indexed-db-title").focus();
  };
}

function showList() {
  $("indexed-db-list").innerHTML = "";
  const tr = indexeddb.transaction(["items"]);
  const os = tr.objectStore("items");
  const req = os.openCursor();
  req.onerror = onError;
  req.onsuccess = showListOnSuccess;
}

function showListOnSuccess(e) {
  const cur = e.target.result;
  if (!cur) return;
  const v = cur.value;
  const li = document.createElement("li");
  li.innerHTML =
    "<button onclick='" +
    "rmIndexedDbItem(" +
    v.id +
    ")'>x" +
    "</button> " +
    tohtml(v.title);
  $("indexed-db-list").appendChild(li);
  cur.continue();
}

function rmIndexedDbItem(id) {
  const tr = indexeddb.transaction(["items"], "readwrite");
  const os = tr.objectStore("items");
  const req = os.delete(id);
  req.onerror = onError;
  tr.oncomplete = showList;
}
