

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

        for element in self.__rentals:
            # このレンタルの料金を表示
            result += f"\t{element.movie.title}\t{str(element.charge())}円\n"

        # フッター行を追加
        result += f"合計金額 {self.total_charge()}円\n"
        result += f"獲得ポイント {self.total_frequent_renter_points()}ポイント"
        return result

    def html_statement(self):
        result = f"<h1><em>{self.name}様</em>のレンタル明細</h1><p>\n"

        for element in self.__rentals:
            # このレンタルの料金を表示
            result += f"\t{element.movie.title}\t{str(element.charge())}円<br>\n"

        # フッター行を追加
        result += f"<p>合計金額 <em>{self.total_charge()}円</em><p>\n"
        result += f"獲得ポイント <em>{self.total_frequent_renter_points()}ポイント</em><p>"
        return result

    def total_frequent_renter_points(self):
        total_point = 0
        for element in self.__rentals:
            total_point += element.frequent_renter_points()
        return total_point

    def total_charge(self):
        total_amount = 0
        for element in self.__rentals:
            total_amount += element.charge()
        return total_amount
