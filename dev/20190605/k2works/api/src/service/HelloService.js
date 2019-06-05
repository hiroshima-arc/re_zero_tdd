const repository = require("../repository/DynamodbRepository");
const hello = require("../model/Hello");

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
  return await repository.selectAll({ TableName: hello.model.TableName });
};
