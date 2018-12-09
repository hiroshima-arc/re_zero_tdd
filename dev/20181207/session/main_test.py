import unittest
from test.support import captured_stdout


def execute(count):
    count = count + 1
    for n in range(count):
        print(fizz_buzz(n))


def fizz_buzz(num):
    if (num % 3 == 0) and (num % 5 == 0):
        return 'FizzBuzz'
    elif(num % 3 == 0):
        return 'Fizz'
    elif(num % 5 == 0):
        return 'Buzz'
    else:
        return print(num)


class MainTest(unittest.TestCase):
    def test_1から100まで表示する(self):
        with captured_stdout() as stdout:
            execute(100)
            lines = stdout.getvalue().splitlines()

        self.assertEqual('1', lines[1])
        self.assertEqual('Buzz', lines[100])

    def test_3で割りきれる場合はFizzを返す(self):
        self.assertEqual('Fizz', fizz_buzz(3))

    def test_5で割りきれる場合はBuzzを返す(self):
        self.assertEqual('Buzz', fizz_buzz(5))

    def test_3と5で割りきれる場合はFizzBuzzを返す(self):
        self.assertEqual('FizzBuzz', fizz_buzz(15))


if __name__ == "__main__":
    unittest.main()
