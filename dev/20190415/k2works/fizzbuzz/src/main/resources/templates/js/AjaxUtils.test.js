mocha.setup("bdd");
describe("AjaxRequestTest", () => {
  var xhr, requests;
  before(function () {
    xhr = sinon.useFakeXMLHttpRequest();
    requests = [];
    xhr.onCreate = function (req) {
      requests.push(req);
    };
  });
  after(function () {
    // Like before we must clean up when tampering with globals.
    xhr.restore();
  });
  it("makes a GET request for Api call", function () {
    var url = "http://localhost:3002";
    httpGet(url, sinon.fake(), sinon.fake());
    assert.equal(requests.length, 1);
    assert.equal(requests[0].url, "http://localhost:3002");
  });
  it("makes a GET request for Api call by jQuery", function () {
    var url = "http://localhost:3002";
    httpGet(url);
    assert.equal(requests.length, 2);
    assert.equal(requests[0].url, "http://localhost:3002");
  });
});

describe("AjaxResponseTest", () => {
  var server;

  before(function () {
    server = sinon.fakeServer.create();
  });
  after(function () {
    server.restore();
  });

  it("calls callback with deserialized data", function () {
    var url = "http://localhost:3002";
    var onSuccess = sinon.fake();
    var onError = sinon.fake();
    httpGet(url, onSuccess, onError);

    // This is part of the FakeXMLHttpRequest API
    server.requests[0].respond(
      200,
      {"Content-Type": "application/json"},
      JSON.stringify([{"Output": "Hello World!", done: true}])
    );

    assert(onSuccess.calledOnce);
  });
  it("calls callback with error data", function () {
    var url = "http://localhost:3002";
    var onSuccess = sinon.fake();
    var onError = sinon.fake();
    httpGet(url, onSuccess, onError);

    // This is part of the FakeXMLHttpRequest API
    server.requests[1].respond(
      400
    );

    assert(onError.calledOnce);
  });
});
