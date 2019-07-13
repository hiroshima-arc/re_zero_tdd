class RegularPrice:
    def charge(self, days_rented):
        result = 200
        if days_rented > 2:
            result += (days_rented - 2) * 1.5
        return result

    def frequent_renter_points(self, days_rented):
        return 1
