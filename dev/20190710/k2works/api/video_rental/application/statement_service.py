from customer import Customer
from movie import Movie
from rental import Rental
from new_release_price import NewReleasePrice
from children_price import ChildrenPrice
from regular_price import RegularPrice


class StatementService:
    def create_text_statement(self):
        customer = self.create_statement()
        return customer.statement()

    def create_html_statement(self):
        customer = self.create_statement()
        return customer.html_statement()

    def create_statement(self):
        new_release_movie = Movie("新作", NewReleasePrice())

        children_movie = Movie("子供", ChildrenPrice())

        regular_movie = Movie("一般", RegularPrice())

        new_release = Rental(new_release_movie, 3)

        children = Rental(children_movie, 2)

        regular = Rental(regular_movie, 1)

        customer = Customer("山田")

        customer.add_rental(new_release)

        customer.add_rental(children)

        customer.add_rental(regular)

        return customer
