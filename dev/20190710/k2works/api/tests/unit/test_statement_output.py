import unittest

from video_rental.domain.movie import Movie
from video_rental.domain.rental import Rental
from video_rental.domain.customer import Customer


class StatementOutputTest(unittest.TestCase):
    def setUp(self):
        new_release_movie = Movie("新作", Movie.NEW_RELEASE)
        children_movie = Movie("子供", Movie.CHILDREN)
        regular_movie = Movie("一般", Movie.REGULAR)

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