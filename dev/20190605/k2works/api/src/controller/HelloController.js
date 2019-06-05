const express = require("express");
const router = express.Router();

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

module.exports = router;
