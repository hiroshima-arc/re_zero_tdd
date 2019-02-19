import unittest


class FizzBuzzTest(unittest.TestCase):
    def test_1から100までの数をプリントする_ただし3で割り切れる場合はFizz_5で割り切れる場合はBuzz_両方で割り切れる場合はFizzBuzzをプリントする(self):
        list = FizzBuzz.generate_list()
        self.assertEqual(1, list[0])
        self.assertEqual('Fizz', list[2])
        self.assertEqual('Buzz', list[4])
        self.assertEqual('FizzBuzz', list[14])
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
        list = FizzBuzz.generate_list()
        for v in list:
            print(v)

    @staticmethod
    def generate_list():
        list = []

        for i in range(100):
            value = FizzBuzz.exec(i + 1)
            list.append(value)

        return list

    @staticmethod
    def exec(number):
        result = number

        if (number % 3 == 0) and (number % 5 == 0):
            result = 'FizzBuzz'
        elif number % 3 == 0:
            result = 'Fizz'
        elif number % 5 == 0:
            result = 'Buzz'

        return result


if __name__ == "__main__":
    unittest.main()
