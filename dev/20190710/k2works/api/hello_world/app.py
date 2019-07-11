import os

import sys

sys.path.append(os.path.join(os.path.abspath(os.path.dirname(__file__)), "vendor"))

import awsgi

from flask import Flask, jsonify

from flask_cors import CORS

app = Flask(__name__)

CORS(app)

@app.route("/api/hello")
def index():
  return jsonify(status=200, message="hello world")

def lambda_handler(event, context):
  return awsgi.response(app, event, context)
