from domain.price import Price


class NewReleasePrice(Price):
    def charge(self, days_rented):
        result = days_rented * 300
        return result

    def frequent_renter_points(self, days_rented):
        return 2 if days_rented > 1 else 1
