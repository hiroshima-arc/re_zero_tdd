import unittest


class FizzBuzzTest(unittest.TestCase):
    def test_1から100までの数をプリントする_ただし3で割り切れる場合はFizz_5で割り切れる場合はBuzz_両方で割り切れる場合はFizzBuzzをプリントする(self):
        fizz_buzz_list = FizzBuzz.generate_list()
        self.assertEqual(1, fizz_buzz_list[1])
        self.assertEqual('Fizz', fizz_buzz_list[3])
        self.assertEqual('Buzz', fizz_buzz_list[5])
        self.assertEqual('FizzBuzz', fizz_buzz_list[15])
        self.assertEqual('Buzz', fizz_buzz_list[-1])

    def test_3で割り切れる場合はFizzを返す(self):
        self.assertEqual('Fizz', FizzBuzz.generate(3))
        self.assertEqual(1, FizzBuzz.generate(1))

    def test_5で割り切れる場合はBuzzを返す(self):
        self.assertEqual('Buzz', FizzBuzz.generate(5))

    def test_3と5で割り切れる場合はFizzBuzzを返す(self):
        self.assertEqual('FizzBuzz', FizzBuzz.generate(15))

    def test_数字以外の場合は例外を発生させる(self):
        with self.assertRaises(ValueError):
            FizzBuzz.generate('a')


MAX_RANGE = 101
BUZZ = 'Buzz'
FIZZ = 'Fizz'
FIZZ_BUZZ = 'FizzBuzz'


class FizzBuzz:
    @staticmethod
    def print():
        try:
            [print(v) for v in FizzBuzz.generate_list()]
        except ValueError as e:
            print(e)

    @staticmethod
    def generate_list():
        return list(map(FizzBuzz.generate, range(MAX_RANGE)))

    @staticmethod
    def generate(number):
        if isinstance(number, str):
            raise ValueError

        if (FizzBuzz.is_fizz(number)) and (FizzBuzz.is_buzz(number)):
            return FIZZ_BUZZ
        if FizzBuzz.is_fizz(number):
            return FIZZ
        if FizzBuzz.is_buzz(number):
            return BUZZ
        return number

    @staticmethod
    def is_buzz(number):
        return number % 5 == 0

    @staticmethod
    def is_fizz(number):
        return number % 3 == 0


if __name__ == "__main__":
    unittest.main()
