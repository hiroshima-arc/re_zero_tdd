require 'test/unit'
require_relative '../../rental/domain/movie'
require_relative '../../rental/domain/rental'
require_relative '../../rental/domain/customer'

class StatementOutputTest < Test::Unit::TestCase
  include Domain

  def setup
    new_release_movie = Movie.new('新作', Movie::NEW_RELEASE)
    children_movie = Movie.new('子供', Movie::CHILDREN)
    regular_movie = Movie.new('一般', Movie::REGULAR)

    new_release_movie.price_code = Movie::NEW_RELEASE
    children_movie.price_code = Movie::CHILDREN
    regular_movie.price_code = Movie::REGULAR

    @new_release = Rental.new(new_release_movie, 3)
    @children = Rental.new(children_movie, 2)
    @regular = Rental.new(regular_movie, 1)
  end

  def teardown
    # Do nothing
  end

  test "テキストステートメント出力" do
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

  test "HTMLステートメント出力" do
    output =
        "<h1><em>山田様</em>のレンタル明細</h1><p>\n" +
            "\t新作\t900円<br>\n" +
            "\t子供\t150円<br>\n" +
            "\t一般\t200円<br>\n" +
            "<p>合計金額 <em>1250円</em><p>\n" +
            "獲得ポイント <em>4ポイント</em><p>"

    customer = Customer.new('山田')
    customer.add_rental(@new_release)
    customer.add_rental(@children)
    customer.add_rental(@regular)

    assert_equal(output, customer.html_statement)
  end
end