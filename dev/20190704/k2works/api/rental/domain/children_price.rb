require_relative './price'

module Domain
  class ChildrenPrice
    include Price

    def charge(days_rented)
      result = 150
      result += (days_rented - 3) * 1.5 if days_rented > 3
      result
    end
  end
end
