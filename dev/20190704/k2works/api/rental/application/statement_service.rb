require_relative '../domain/movie'
require_relative '../domain/rental'
require_relative '../domain/customer'
include Domain

module Application
  class StatementService
    def create_text_statement
      customer = create_customer
      customer.statement
    end

    def create_html_statement
      customer = create_customer
      customer.html_statement
    end

    private

    def create_customer
      new_release_movie = Movie.new('新作', NewReleasePrice.new)
      children_movie = Movie.new('子供', ChildrenPrice.new)
      regular_movie = Movie.new('一般', RegularPrice.new)

      new_release_movie.price = NewReleasePrice.new
      children_movie.price = ChildrenPrice.new
      regular_movie.price = RegularPrice.new

      new_release = Rental.new(new_release_movie, 3)
      children = Rental.new(children_movie, 2)
      regular = Rental.new(regular_movie, 1)

      customer = Customer.new('山田')
      customer.add_rental(new_release)
      customer.add_rental(children)
      customer.add_rental(regular)
      customer
    end
  end
end
