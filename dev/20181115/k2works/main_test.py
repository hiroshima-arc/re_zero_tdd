import unittest
from test.support import captured_stdout


def execute():
    n = 100
    while n != 0:
        if n % 3 == 0:
            print("Fizz")
        elif n % 5 == 0:
            print("Buzz")
        else:
            print(n)
        n = n - 1


class MainTest(unittest.TestCase):

    def test_1から100まで数をプリントする(self):
        with captured_stdout() as stdout:
            execute()
            lines = stdout.getvalue().splitlines()

        self.assertEqual("Buzz", lines[0])
        self.assertEqual("1", lines[99])

    def test_3の倍数のときは数の代わりにFizzをプリントする(self):
        with captured_stdout() as stdout:
            execute()
            lines = stdout.getvalue().splitlines()

        self.assertEqual("Fizz", lines[97])

    def test_5の倍数のときはBuzzとプリントする(self):
        with captured_stdout() as stdout:
            execute()
            lines = stdout.getvalue().splitlines()

        self.assertEqual("Buzz", lines[95])




if __name__ == "__main__":
    unittest.main()
