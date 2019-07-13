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
        result = 0
        # 各行の金額を計算
        if self.movie.price_code == Movie.REGULAR:
            result += 200
            if self.days_rented > 2:
                result += (self.days_rented - 2) * 1.5
        elif self.movie.price_code == Movie.NEW_RELEASE:
            result += self.days_rented * 300
        elif self.movie.price_code == Movie.CHILDREN:
            result += 150
            if self.days_rented > 3:
                result += (self.days_rented - 3) * 1.5
        return result

    def frequent_renter_point(self, frequent_renter_points):
        # レンタルポイントを加算
        frequent_renter_points += 1
        # 新作2日間レンタルでボーナス点を加算
        if self.movie.price_code == Movie.NEW_RELEASE and self.days_rented > 1:
            frequent_renter_points += 1
        return frequent_renter_points

