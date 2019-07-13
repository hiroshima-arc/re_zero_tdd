from movie import Movie


class Rental:
    def __init__(self, movie, days_rented):
        self.__movie = movie

        self.__days_rented = days_rented

    @property
    def movie(self):
        return self.__movie

    @property
    def days_rented(self):
        return self.__days_rented

    def charge(self):
        return self.movie.charge(self.days_rented)

    def frequent_renter_point(self):
        return 2 if self.movie.price_code == Movie.NEW_RELEASE and self.days_rented else 1

