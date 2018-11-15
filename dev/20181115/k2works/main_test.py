import unittest
from test.support import captured_stdout


def execute():
    n = 100
    while n != 0:
        if n % 3 == 0 and n % 5 == 0:
            print("FizzBuzz")
        elif n % 3 == 0:
            print("Fizz")
        elif n % 5 == 0:
            print("Buzz")
        else:
            print(n)
        n = n - 1


def for_execute():
    for n in range(100):
        print(n)


class MainTest(unittest.TestCase):

    def test_for(self):
        self.assertTrue(for_execute())

    def setUp(self):
        with captured_stdout() as stdout:
            execute()
            self.lines = stdout.getvalue().splitlines()

    def test_1から100まで数をプリントする(self):
        self.assertEqual("Buzz", self.lines[0])
        self.assertEqual("1", self.lines[99])

    def test_3の倍数のときは数の代わりにFizzをプリントする(self):
        self.assertEqual("Fizz", self.lines[97])

    def test_5の倍数のときはBuzzとプリントする(self):
        self.assertEqual("Buzz", self.lines[95])

    def test_3と5両方の倍数の場合にはFizzBuzzとプリントする(self):
        self.assertEqual("FizzBuzz", self.lines[85])


if __name__ == "__main__":
    unittest.main()
