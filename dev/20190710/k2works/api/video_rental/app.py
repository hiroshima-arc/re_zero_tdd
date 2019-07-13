import os

import sys

sys.path.append(os.path.join(os.path.abspath(os.path.dirname(__file__)), "vendor"))
sys.path.append(os.path.join(os.path.abspath(os.path.dirname(__file__)), "domain"))

import awsgi

from flask import Flask, jsonify

from flask_cors import CORS

app = Flask(__name__)

app.config["JSON_AS_ASCII"] = False

CORS(app)

from movie import Movie

from rental import Rental

from customer import Customer


@app.route("/api/statement")
def statement():
    new_release_movie = Movie("新作", Movie.NEW_RELEASE)

    children_movie = Movie("子供", Movie.CHILDREN)

    regular_movie = Movie("一般", Movie.REGULAR)

    new_release = Rental(new_release_movie, 3)

    children = Rental(children_movie, 2)

    regular = Rental(regular_movie, 1)

    customer = Customer("山田")

    customer.add_rental(new_release)

    customer.add_rental(children)

    customer.add_rental(regular)

    return jsonify(status=200, statement=customer.statement())


def lambda_handler(event, context):
    return awsgi.response(app, event, context)
