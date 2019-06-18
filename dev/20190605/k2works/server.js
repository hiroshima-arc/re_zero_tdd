const app = require('./api/src/app');
const port = process.env.PORT || 3000;

if ( process.env !== 'Production' ) {
  const server = app.listen(port, function () {
    console.log("Node.js is listening to PORT:" + server.address().port);
  });
}