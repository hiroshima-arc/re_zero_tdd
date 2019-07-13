from customer import Customer
from movie import Movie
from rental import Rental


class StatementService:
    def create_text_statement(self):
        customer = self.create_statement()
        return customer.statement()

    def create_html_statement(self):
        customer = self.create_statement()
        return customer.html_statement()

    def create_statement(self):
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

        return customer
