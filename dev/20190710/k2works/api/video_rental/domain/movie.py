class Movie:
    REGULAR = 0

    NEW_RELEASE = 1

    CHILDREN = 2

    def __init__(self, title, price_code):
        self.__title = title

        self.__price_code = price_code

    @property
    def title(self):
        return self.__title

    @property
    def price_code(self):
        return self.__price_code
