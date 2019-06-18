const repository = require("../repository/HelloRepository");
const model = require("../model/Hello");

exports.createTable = async () => {
  await repository.create();
};

exports.dropTable = async () => {
  await repository.drop();
};

exports.saveHelloInfo = async info => {
  return await repository.save(info);
};

exports.getAllContact = async () => {
  return await repository.selectAll({ TableName: model.model.TableName });
};
