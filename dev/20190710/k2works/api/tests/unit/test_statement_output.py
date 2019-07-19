import unittest

from domain.movie import Movie
from domain.rental import Rental
from domain.customer import Customer
from domain.new_release_price import NewReleasePrice
from domain.children_price import ChildrenPrice
from domain.regular_price import RegularPrice


class StatementOutputTest(unittest.TestCase):
    def setUp(self):
        new_release_movie = Movie("新作", NewReleasePrice())
        children_movie = Movie("子供", ChildrenPrice())
        regular_movie = Movie("一般", RegularPrice())

        self.new_release = Rental(new_release_movie, 3)
        self.children = Rental(children_movie, 2)
        self.regular = Rental(regular_movie, 1)

    def test_output_text_statement(self):
        output = "山田様のレンタル明細\n" + "\t新作\t900円\n" + "\t子供\t150円\n" + "\t一般\t200円\n" + "合計金額 1250円\n" + "獲得ポイント 4ポイント"
        customer = Customer("山田")
        customer.add_rental(self.new_release)
        customer.add_rental(self.children)
        customer.add_rental(self.regular)

        self.assertEqual(output, customer.statement())

    def test_output_html_statement(self):
        output = "<h1><em>山田様</em>のレンタル明細</h1><p>\n" + "\t新作\t900円<br>\n" +"\t子供\t150円<br>\n" + "\t一般\t200円<br>\n" + "<p>合計金額 <em>1250円</em><p>\n" + "獲得ポイント <em>4ポイント</em><p>"
        customer = Customer("山田")
        customer.add_rental(self.new_release)
        customer.add_rental(self.children)
        customer.add_rental(self.regular)

        self.assertEqual(output, customer.html_statement())


if __name__ == '__main__':
    unittest.main()
