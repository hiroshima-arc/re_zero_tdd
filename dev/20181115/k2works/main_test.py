import unittest
from test.support import captured_stdout

BUZZ = "Buzz"
FIZZ = "Fizz"
FIZZ_BUZZ = "FizzBuzz"
data = {
    'count': 0,
    'values': []
}


def execute(count=100):
    set_data(count)
    set_values_by_generate(data['count'])
    print_values()


def print_values():
    for value in data['values']:
        print(value)


def set_data(count):
    data['count'] = count + 1
    data['values'] = []


def set_values_by_generate(count):
    for n in range(count):
        value = generate(n)
        data['values'].append(value)


def generate(number):
    value = number

    if number % 3 == 0 and number % 5 == 0:
        value = FIZZ_BUZZ
    elif number % 3 == 0:
        value = FIZZ
    elif number % 5 == 0:
        value = BUZZ

    return value


class MainTest(unittest.TestCase):

    def setUp(self):
        with captured_stdout() as stdout:
            execute()
            self.lines = stdout.getvalue().splitlines()

    def test_1から10まで数をプリントする(self):
        with captured_stdout() as stdout:
            execute(10)
            self.lines = stdout.getvalue().splitlines()

        self.assertNotIn("11", self.lines)
        self.assertEqual("Buzz", self.lines[10])

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
