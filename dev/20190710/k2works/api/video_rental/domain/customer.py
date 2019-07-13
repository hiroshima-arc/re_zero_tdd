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
        result = f"{self.name}様のレンタル明細\n"

        frequent_renter_points = 0
        for element in self.__rentals:
            frequent_renter_points += element.frequent_renter_point()
            # このレンタルの料金を表示
            result += f"\t{element.movie.title}\t{str(element.charge())}円\n"

        total_amount = 0
        for element in self.__rentals:
            total_amount += element.charge()

        # フッター行を追加
        result += f"合計金額 {total_amount}円\n"
        result += f"獲得ポイント {frequent_renter_points}ポイント"
        return result

