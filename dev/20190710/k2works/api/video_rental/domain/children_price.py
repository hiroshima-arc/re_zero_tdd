class ChildrenPrice:
    def charge(self, days_rented):
        result = 150
        if days_rented > 3:
            result += (days_rented - 3) * 1.5
        return result

    def frequent_renter_points(self, days_rented):
        return 1
