from movie import Movie


class Customer:
    def __init__(self, name):
        self.__name = name

        self.__rentals = []

    @property
    def name(self):
        return self.__name

    def add_rental(self, arg):
        self.__rentals.append(arg)

    def statement(self):
        total_amount, frequent_renter_points = 0, 0

        result = f"{self.name}様のレンタル明細\n"

        for element in self.__rentals:
            this_amount = self.amount_for(element)

            # レンタルポイントを加算
            frequent_renter_points += 1
            # 新作2日間レンタルでボーナス点を加算
            if element.movie.price_code == Movie.NEW_RELEASE and element.days_rented > 1:
                frequent_renter_points += 1
            # このレンタルの料金を表示
            result += f"\t{element.movie.title}\t{str(this_amount)}円\n"
            total_amount += this_amount
        # フッター行を追加
        result += f"合計金額 {total_amount}円\n"
        result += f"獲得ポイント {frequent_renter_points}ポイント"
        return result

    def amount_for(self, rental):
        result = 0
        # 各行の金額を計算
        if rental.movie.price_code == Movie.REGULAR:
            result += 200
            if rental.days_rented > 2:
                result += (rental.days_rented - 2) * 1.5
        elif rental.movie.price_code == Movie.NEW_RELEASE:
            result += rental.days_rented * 300
        elif rental.movie.price_code == Movie.CHILDREN:
            result += 150
            if rental.days_rented > 3:
                result += (rental.days_rented - 3) * 1.5
        return result
