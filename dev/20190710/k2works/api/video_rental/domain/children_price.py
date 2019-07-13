from domain.price import Price


class ChildrenPrice(Price):
    def charge(self, days_rented):
        result = 150
        if days_rented > 3:
            result += (days_rented - 3) * 1.5
        return result

