module Domain
  class Movie
    REGULAR = 0
    NEW_RELEASE = 1
    CHILDREN = 2

    attr_reader :title
    attr_reader :price_code

    def initialize(title, price_code)
      @title, @price_code = title, price_code
    end

    def charge(days_rented)
      result = 0
      case price_code
      when Movie::REGULAR
        result += 200
        if days_rented > 2
          result += (days_rented - 2) * 1.5
        end
      when Movie::NEW_RELEASE
        result += days_rented * 300
      when Movie::CHILDREN
        result += 150
        if days_rented > 3
          result += (days_rented - 3) * 1.5
        end
      end
      result
    end

    def frequent_renter_points(days_rented)
      (price_code == Movie::NEW_RELEASE && days_rented > 1) ? 2 : 1
    end

  end
end
