const model = require("../model/Hello");
const DynamodbRepository = require("./DynamodbRepository");
this.prototype = DynamodbRepository.prototype;

exports.create = () => {
  this.prototype.create(model);
};

exports.drop = () => {
  this.prototype.drop(model);
};

exports.save = info => {
  this.prototype.save(model, info);
};

exports.selectAll = params => {
  this.prototype.selectAll(params);
};
