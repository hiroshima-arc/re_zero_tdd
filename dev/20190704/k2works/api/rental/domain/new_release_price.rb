module Domain
  class NewReleasePrice
    def charge(days_rented)
      days_rented * 300
    end
  end
end
