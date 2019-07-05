module Domain
  class Rental
    attr_reader :movie, :days_rented
    def initialize(movie, days_rented)
      @movie, @days_rented = movie, days_rented
    end

    def charge
      result = 0
      case movie.price_code
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

    def frequent_renter_point(frequent_renter_points)
      # レンタルポイントを加算
      frequent_renter_points += 1
      # 新作２日間レンタルでボーナス点を加算
      if movie.price_code == Movie::NEW_RELEASE &&
          days_rented > 1
        frequent_renter_points += 1
      end
      frequent_renter_points
    end
  end
end
