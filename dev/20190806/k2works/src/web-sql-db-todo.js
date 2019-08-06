const db = openDatabase("todo.db", "1.0", "todo", 1024 * 1024 * 0);

function setupWebSqlDb() {
  db.transaction(function(tr) {
    tr.executeSql(
      "CREATE TABLE IF NOT EXISTS " +
        "items(" +
        "   id INTEGER PRIMARY KEY," +
        "   title TEXT" +
        ")",
      [],
      function() {
        showItems();
      },
      sqlError
    );
  });
}

function showItems() {
  $("list").innerHTML = "";
  db.transaction(function(tr) {
    tr.executeSql("SELECT * FROM items", [], showItemsOnResult, sqlError);
  });
  $("item").focus();
}

function showItemsOnResult(rt, rs) {
  let html = "";
  for (let i = 0; i < rs.rows.length; i++) {
    let row = rs.rows.item(i);
    html +=
      "<li><button onclick='rmItem(" +
      row.id +
      ")'>x</button> " +
      tohtml(row.title) +
      "</li>";
  }
  $("list").innerHTML = html;
}

function addItem() {
  let title = $("item").value;
  $("item").value = "";
  db.transaction(function(tr) {
    tr.executeSql(
      "INSERT INTO items" + "(title)VALUES(?)",
      [title],
      function() {
        showItems();
      },
      sqlError
    );
  });
}

function setItem(title) {
  return new Promise(resolve => {
    db.transaction(tr => {
      tr.executeSql(
        "INSERT INTO items" + "(title)VALUES(?)",
        [title],
        function() {
          resolve();
        },
        sqlError
      );
    });
  });
}

function getItems() {
  return new Promise(resolve => {
    db.transaction(tr => {
      tr.executeSql(
        "SELECT * FROM items",
        [],
        (rt, rs) => {
          let row;
          for (let i = 0; i < rs.rows.length; i++) {
            row = rs.rows.item(i);
            console.log(row);
          }
          resolve(rs.rows);
        },
        sqlError
      );
    });
  });
}

function getItem(id) {
  return new Promise((resolve, reject) => {
    db.transaction(function(tr) {
      tr.executeSql(
        "SELECT * FROM items " + "WHERE id=?",
        [id],
        function(rt, rs) {
          let row;
          for (let i = 0; i < rs.rows.length; i++) {
            row = rs.rows.item(i);
            console.log(row);
          }
          resolve(row);
        },
        sqlError
      );
    });
  });
}

function rmAllItem() {
  return new Promise((resolve, reject) => {
    db.transaction(function(tr) {
      tr.executeSql(
        "DELETE FROM items",
        [],
        function() {
          showItems();
        },
        sqlError
      );
    });
  });
}

function rmItem(id) {
  db.transaction(function(tr) {
    tr.executeSql(
      "DELETE FROM items " + "WHERE id=?",
      [id],
      function() {
        showItems();
      },
      sqlError
    );
  });
}

function sqlError(tr, e) {
  alert("ERROR:" + e.message);
}
