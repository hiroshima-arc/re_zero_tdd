import os

import sys

sys.path.append(os.path.join(os.path.abspath(os.path.dirname(__file__)), "vendor"))
sys.path.append(os.path.join(os.path.abspath(os.path.dirname(__file__)), "domain"))
sys.path.append(os.path.join(os.path.abspath(os.path.dirname(__file__)), "application"))
sys.path.append(os.path.join(os.path.abspath(os.path.dirname(__file__)), "."))

import awsgi

from flask import Flask, jsonify, render_template

from flask_cors import CORS

app = Flask(__name__)

app.config["JSON_AS_ASCII"] = False

CORS(app)

from statement_service import StatementService


@app.route('/')
def index():
    return render_template('index.html')


@app.route("/api/text-statement")
def text_statement():
    service = StatementService()
    return jsonify(status=200, statement=service.create_text_statement())


@app.route("/api/html-statement")
def html_statement():
    service = StatementService()
    return jsonify(status=200, statement=service.create_html_statement())


def lambda_handler(event, context):
    return awsgi.response(app, event, context)
