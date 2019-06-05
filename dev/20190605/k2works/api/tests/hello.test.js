const supertest = require('supertest');
const test = require('unit.js');
const app = require('../src/app.js');

const request = supertest(app);

describe('Tests app', function() {
  it('verifies get', function(done) {
    request.get('/api/hello').expect(200).end(function(err, result) {
      test.string(result.body.Output).contains('Hello');
      test.value(result).hasHeader('content-type', 'application/json; charset=utf-8');
      done(err);
    });
  });
  it('verifies post', function(done) {
    request.post('/api/hello').expect(200).end(function(err, result) {
      test.string(result.body.Output).contains('Hello');
      test.value(result).hasHeader('content-type', 'application/json; charset=utf-8');
      done(err);
    });
  });
});