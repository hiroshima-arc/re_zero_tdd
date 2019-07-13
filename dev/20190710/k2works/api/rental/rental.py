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
