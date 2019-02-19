import unittest


class FizzBuzzTest(unittest.TestCase):
    def test_1から100までの数をプリントする_ただし3で割り切れる場合はFizz_5で割り切れる場合はBuzz_両方で割り切れる場合はFizzBuzzをプリントする(self):
        list = FizzBuzz.generate_list()
        self.assertEqual(1, list[1])
        self.assertEqual('Fizz', list[3])
        self.assertEqual('Buzz', list[5])
        self.assertEqual('FizzBuzz', list[15])
        self.assertEqual('Buzz', list[-1])

    def test_3で割り切れる場合はFizzを返す(self):
        self.assertEqual('Fizz', FizzBuzz.exec(3))
        self.assertEqual(1, FizzBuzz.exec(1))

    def test_5で割り切れる場合はBuzzを返す(self):
        self.assertEqual('Buzz', FizzBuzz.exec(5))

    def test_3と5で割り切れる場合はFizzBuzzを返す(self):
        self.assertEqual('FizzBuzz', FizzBuzz.exec(15))


class FizzBuzz:
    @staticmethod
    def print():
        [print(v) for v in FizzBuzz.generate_list()]

    @staticmethod
    def generate_list():
        return list(map(FizzBuzz.exec, range(101)))

    @staticmethod
    def exec(number):
        fizz = number % 3 == 0
        buzz = number % 5 == 0
        if (fizz) and (buzz):
            return 'FizzBuzz'
        if fizz:
            return 'Fizz'
        if buzz:
            return 'Buzz'
        return number


if __name__ == "__main__":
    unittest.main()
