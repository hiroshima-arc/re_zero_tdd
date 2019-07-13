class Movie:
    REGULAR = 0

    NEW_RELEASE = 1

    CHILDREN = 2

    def __init__(self, title, price):
        self.__title = title

        self.__price = price

    @property
    def title(self):
        return self.__title

    @property
    def price(self):
        return self.__price

    def charge(self, days_rented):
        return self.price.charge(days_rented)

    def frequent_renter_points(self, days_rented):
        return self.price.frequent_renter_points(days_rented)
