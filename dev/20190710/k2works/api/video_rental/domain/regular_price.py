from domain.price import Price


class RegularPrice(Price):
    def charge(self, days_rented):
        result = 200
        if days_rented > 2:
            result += (days_rented - 2) * 1.5
        return result
