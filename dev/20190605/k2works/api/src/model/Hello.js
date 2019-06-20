const name = "Hello";
const v4 = require("uuid/v4");

exports.model = {
  TableName: name,
  KeySchema: [
    { AttributeName: "id", KeyType: "HASH" },
    { AttributeName: "name", KeyType: "RANGE" }
  ],
  AttributeDefinitions: [
    { AttributeName: "id", AttributeType: "S" },
    { AttributeName: "name", AttributeType: "S" }
  ],
  ProvisionedThroughput: {
    ReadCapacityUnits: 1,
    WriteCapacityUnits: 1
  }
};

exports.create = info => {
  return {
    TableName: name,
    Item: {
      id: v4(),
      name: info.name
    }
  };
};
