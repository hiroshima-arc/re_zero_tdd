module Domain
  class Customer
    attr_reader :name

    def initialize(name)
      @name = name
      @rentals = []
    end

    def add_rental(arg)
      @rentals << arg
    end

    def statement
      total_amount, frequent_renter_points = 0, 0
      result = "#{@name}様のレンタル明細\n"
      @rentals.each do |element|
        this_amount = amount_for(element)

        # レンタルポイントを加算
        frequent_renter_points += 1
        # 新作２日間レンタルでボーナス点を加算
        if element.movie.price_code == Movie::NEW_RELEASE &&
            element.days_rented > 1
          frequent_renter_points += 1
        end
        # このレンタルの料金を表示
        result += "\t" + element.movie.title + "\t" + this_amount.to_s + "円\n"
        total_amount += this_amount
      end
      # フッター行を追加
      result += "合計金額 #{total_amount}円\n"
      result += "獲得ポイント #{frequent_renter_points}ポイント"
      result
    end

    private

    def amount_for(rental)
      rental.charge
    end
  end
end
