import unittest


class TestFizzBuzz(unittest.TestCase):
    def test_1から100までの数をプリントする(self):
        array = FizzBuzz.generate_array()
        self.assertEqual(1, array[0])
        self.assertEqual(100, array[-1])
        FizzBuzz.print()

    def test_3で割り切れる場合はFizzをプリントする(self):
        self.assertEqual('Fizz', FizzBuzz.execute(3))
        self.assertEqual(1, FizzBuzz.execute(1))


class FizzBuzz:
    @staticmethod
    def generate_array():
        array = []

        for i in range(100):
            array.append(i + 1)

        return array

    @staticmethod
    def print():
        for i in FizzBuzz.generate_array():
            print(i)

    @staticmethod
    def execute(number):
        result = number

        if number % 3 == 0:
            result = 'Fizz'

        return result



if __name__ == "__main__":
    unittest.main()
