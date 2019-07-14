

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

    def frequent_renter_points(self):
        return self.movie.frequent_renter_points(self.days_rented)

