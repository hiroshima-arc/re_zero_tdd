import unittest


class TestFizzBuzz(unittest.TestCase):
    def test_1から100までの数をプリントする_ただし3で割り切れる場合はFizz5で割り切れる場合はBuzz両方割り切れる場合はFizzBuzzをプリントする(self):
        array = FizzBuzz.generate_array()
        self.assertEqual(1, array[0])
        self.assertEqual('Fizz', array[2])
        self.assertEqual('Buzz', array[4])
        self.assertEqual('FizzBuzz', array[14])
        self.assertEqual('Buzz', array[-1])
        FizzBuzz.print()

    def test_3で割り切れる場合はFizzをプリントする(self):
        self.assertEqual('Fizz', FizzBuzz.execute(3))
        self.assertEqual(1, FizzBuzz.execute(1))

    def test_5で割り切れる場合はBuzzをプリントする(self):
        self.assertEquals('Buzz', FizzBuzz.execute(5))

    def test_3と5で割り切れる場合はFizzBuzzをプリントする(self):
        self.assertEqual('FizzBuzz', FizzBuzz.execute(15))


class FizzBuzz:
    @staticmethod
    def generate_array():
        array = []

        for i in range(100):
            array.append(FizzBuzz.execute(i + 1))

        return array

    @staticmethod
    def print():
        for i in FizzBuzz.generate_array():
            print(i)

    @staticmethod
    def execute(number):
        if (number % 3 == 0) and (number % 5 == 0):
            return 'FizzBuzz'
        if number % 3 == 0:
            return 'Fizz'
        if number % 5 == 0:
            return 'Buzz'

        return number



if __name__ == "__main__":
    unittest.main()
