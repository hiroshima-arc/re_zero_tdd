require_relative './price'

module Domain
  class RegularPrice
    include Price

    def charge(days_rented)
      result = 200
      result += (days_rented -2) * 1.5 if days_rented > 2
      result
    end
  end
end
