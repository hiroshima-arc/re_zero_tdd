const express = require("express");
const router = express.Router();
const service = require("../service/HelloService");

router.get("/hello", function(req, res) {
  res.send({
    Output: "Hello World!"
  });
});

router.post("/hello", function(req, res) {
  res.send({
    Output: "Hello World!"
  });
});

router.post("/hello/create", async function(req, res) {
  let message;

  try {
    const data = await service.createTable();
    console.log(
      "Create table. Table description JSON:",
      JSON.stringify(data, null, 2)
    );
    message = "あいさつテーブルを作成しました";
  } catch (err) {
    console.error(
      "Unable to create table. Error JSON:",
      JSON.stringify(err, null, 2)
    );
    message = "あいさつテーブルを作成できませんでした";
  }

  res.send({
    Message: message
  });
});

router.post("/hello/drop", async function(req, res) {
  let message;

  try {
    const data = await service.dropTable();
    console.log(
      "Drop table. Table description JSON:",
      JSON.stringify(data, null, 2)
    );
    message = "あいさつテーブルを削除しました";
  } catch (err) {
    console.error(
      "Unable to drop table. Error JSON:",
      JSON.stringify(err, null, 2)
    );
    message = "あいさつテーブルを削除できませんでした";
  }

  res.send({
    Message: message
  });
});

router.post("/hello/save", async function(req, res) {
  let message;

  try {
    const info = params(req);
    const data = await service.saveHelloInfo(info);
    console.log(
      "Save table. Table description JSON:",
      JSON.stringify(data, null, 2)
    );
    message = "あいさつを送信しました";
  } catch (err) {
    console.error(
      "Unable to save table. Error JSON:",
      JSON.stringify(err, null, 2)
    );
    message = "あいさつを送信できませんでした";
  }

  res.send({
    Message: message
  });
});

const params = req => {
  return {
    name: req.body.name
  };
};

module.exports = router;
