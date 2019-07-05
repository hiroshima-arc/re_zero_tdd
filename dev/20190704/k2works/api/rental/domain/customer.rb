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
      frequent_renter_points = 0
      result = "#{@name}様のレンタル明細\n"
      @rentals.each do |element|
        frequent_renter_points += element.frequent_renter_point
        # このレンタルの料金を表示
        result += "\t" + element.movie.title + "\t" + element.charge.to_s + "円\n"
      end
      # フッター行を追加
      result += "合計金額 #{total_charge}円\n"
      result += "獲得ポイント #{frequent_renter_points}ポイント"
      result
    end

    private

    def total_charge
      total_amount = 0
      @rentals.each do |element|
        total_amount += element.charge
      end
      total_amount
    end

  end
end
