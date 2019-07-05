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
      result = "#{@name}様のレンタル明細\n"
      @rentals.each do |element|
        # このレンタルの料金を表示
        result += "\t" + element.movie.title + "\t" + element.charge.to_s + "円\n"
      end
      # フッター行を追加
      result += "合計金額 #{total_charge}円\n"
      result += "獲得ポイント #{total_frequent_renter_points}ポイント"
      result
    end

    def html_statement
      result = "<h1><em>#{@name}様</em>のレンタル明細</h1><p>\n"
      @rentals.each do |element|
        # このレンタルの料金を表示
        result += "\t" + element.movie.title + "\t" + element.charge.to_s + "円<br>\n"
      end
      # フッター行を追加
      result += "<p>合計金額 <em>#{total_charge}円</em><p>\n"
      result += "獲得ポイント <em>#{total_frequent_renter_points}ポイント</em><p>"
      result
    end

    private

    def total_frequent_renter_points
      @rentals.inject(0) {|sum, rental| sum + rental.frequent_renter_points }
    end

    def total_charge
      @rentals.inject(0) {|sum, rental| sum + rental.charge}
    end

  end
end
