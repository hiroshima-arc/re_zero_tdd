function makeServer(done) {
  const express = require("express");
  const path = require("path");
  const app = express();

  app.get("/", function (req, res) {
    res.status(200).sendFile("index.html", {root: path.resolve()});
  });
  const server = app.listen(3000, function () {
    const port = server.address().port;
    done();
  });
  return server;
}
module.exports = makeServer;