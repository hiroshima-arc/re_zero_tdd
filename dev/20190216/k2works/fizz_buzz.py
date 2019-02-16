import unittest


class TestFizzBuzz(unittest.TestCase):
    def test_1から100までの数をプリントする(self):
        array = FizzBuzz.generate_array()
        self.assertEqual(1, array[0])
        self.assertEqual(100, array[-1])
        FizzBuzz.print()


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


if __name__ == "__main__":
    unittest.main()
