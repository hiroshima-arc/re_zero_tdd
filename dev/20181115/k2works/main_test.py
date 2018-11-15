import unittest
from test.support import captured_stdout


def execute():
    for n in range(101):
        print(generate(n))


def generate(number):
    value = number

    if number % 3 == 0 and number % 5 == 0:
        value = "FizzBuzz"
    elif number % 3 == 0:
        value = "Fizz"
    elif number % 5 == 0:
        value = "Buzz"

    return value

class MainTest(unittest.TestCase):

    def setUp(self):
        with captured_stdout() as stdout:
            execute()
            self.lines = stdout.getvalue().splitlines()

    def test_1から100まで数をプリントする(self):
        self.assertEqual("Buzz", self.lines[100])
        self.assertEqual("1", self.lines[1])

    def test_3の倍数のときは数の代わりにFizzをプリントする(self):
        self.assertEqual("Fizz", self.lines[3])

    def test_5の倍数のときはBuzzとプリントする(self):
        self.assertEqual("Buzz", self.lines[5])

    def test_3と5両方の倍数の場合にはFizzBuzzとプリントする(self):
        self.assertEqual("FizzBuzz", self.lines[15])


if __name__ == "__main__":
    unittest.main()
