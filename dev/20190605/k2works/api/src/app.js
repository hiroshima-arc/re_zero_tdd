const express = require("express");
const app = express();
const HelloController = require('./controller/HelloController');

const API = '/api';

app.use(API, HelloController);

module.exports = app;
