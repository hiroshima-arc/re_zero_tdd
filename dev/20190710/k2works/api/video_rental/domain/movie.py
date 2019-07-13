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

    def charge(self, days_rented):
        result = 0
        # 各行の金額を計算
        if self.price_code == Movie.REGULAR:
            result += 200
            if days_rented > 2:
                result += (days_rented - 2) * 1.5
        elif self.price_code == Movie.NEW_RELEASE:
            result += days_rented * 300
        elif self.price_code == Movie.CHILDREN:
            result += 150
            if days_rented > 3:
                result += (days_rented - 3) * 1.5
        return result
