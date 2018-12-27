/*eslint no-undef: "error"*/
/*eslint-env node*/

const path = require("path");

module.exports = {
  entry: "./src/index.js",
  mode: "development",

  output: {
    path: path.join(__dirname, "dist"),
    filename: "main.js"
  },

  devServer: {
    contentBase: "dist",
    open: true
  },

  module: {
    rules: [
      {
        test: /\.js$/,
        use: [
          {
            loader: "babel-loader",
            options: {
              presets: [
                "@babel/preset-env"
              ]
            }
          }
        ]
      }
    ]
  }
};