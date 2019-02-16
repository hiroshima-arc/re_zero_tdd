import unittest


class TestFizzBuzz(unittest.TestCase):
    def testGreeting(self):
        self.assertEqual('Hello, World!', FizzBuzz.greeting())

    def test_1から100までの数をプリントする(self):
        array = FizzBuzz.generate_array()
        self.assertEqual(1, array[0])
        self.assertEqual(100, array[-1])


class FizzBuzz:
    @staticmethod
    def greeting():
        return 'Hello, World!'

    @staticmethod
    def generate_array():
        array = []

        for i in range(100):
            array.append(i + 1)

        return array


if __name__ == "__main__":
    unittest.main()
