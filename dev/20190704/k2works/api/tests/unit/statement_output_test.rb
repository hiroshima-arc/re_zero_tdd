require 'test/unit'
require_relative '../../rental/movie'
require_relative '../../rental/rental'
require_relative '../../rental/customer'

class StatementOutputTest < Test::Unit::TestCase
  def setup
    new_release_movie = Movie.new('新作', Movie::NEW_RELEASE)
    children_movie = Movie.new('子供', Movie::CHILDREN)
    regular_movie = Movie.new('一般', Movie::REGULAR)

    @new_release = Rental.new(new_release_movie, 3)
    @children = Rental.new(children_movie, 2)
    @regular = Rental.new(regular_movie, 1)
  end

  def teardown
    # Do nothing
  end

  test "ステートメント出力" do
    output =
        "山田様のレンタル明細\n" +
            "\t新作\t900円\n" +
            "\t子供\t150円\n" +
            "\t一般\t200円\n" +
            "合計金額 1250円\n" +
            "獲得ポイント 4ポイント"

    customer = Customer.new('山田')
    customer.add_rental(@new_release)
    customer.add_rental(@children)
    customer.add_rental(@regular)

    assert_equal(output, customer.statement)
  end
end