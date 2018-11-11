import unittest


class FizzBuzz:

    @staticmethod
    def generate(number):
        if FizzBuzz.can_be_divided_three_and_five(number):
            return "FizzBuzz"
        if FizzBuzz.can_be_divided_three(number):
            return "Fizz"
        if FizzBuzz.can_be_divided_five(number):
            return "Buzz"
        return number

    @staticmethod
    def can_be_divided_three_and_five(number):
        return number % 3 == 0 and number % 5 == 0

    @staticmethod
    def can_be_divided_three(number):
        return number % 3 == 0

    @staticmethod
    def can_be_divided_five(number):
        return number % 5 == 0

    @staticmethod
    def iterate(count):
        array = []

        for n in range(count):
            array.append(FizzBuzz.generate(n + 1))

        return array


class FizzBuzzTest(unittest.TestCase):
    def test_値が３ならばFizzを返す(self):
        self.assertEqual("Fizz", FizzBuzz.generate(3))

    def test_値が５ならばBuzzを返す(self):
        self.assertEqual("Buzz", FizzBuzz.generate(5))

    def test_値が１５ならばFizzBuzzを返す(self):
        self.assertEqual("FizzBuzz", FizzBuzz.generate(15))

    def test_値が１０１ならば１０１を返す(self):
        self.assertEqual(101, FizzBuzz.generate(101))

    def test_回数を５回実行すると配列を返す(self):
        self.assertEqual([1, 2, "Fizz", 4, "Buzz"], FizzBuzz.iterate(5))

    def test_回数を１５回実行すると配列を返す(self):
        expect = [1, 2, "Fizz", 4, "Buzz", "Fizz", 7, 8, "Fizz", "Buzz", 11, "Fizz", 13, 14, "FizzBuzz"]
        self.assertEqual(expect, FizzBuzz.iterate(15))


if __name__ == "__main__":
    unittest.main()
