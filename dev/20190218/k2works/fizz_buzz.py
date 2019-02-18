import unittest


class FizzBuzzTest(unittest.TestCase):
    def test_hello_world(self):
        self.assertEqual('Hello, world!', FizzBuzz.greeting())


class FizzBuzz:
    @staticmethod
    def greeting():
        return 'Hello, world!'


if __name__ == "__main__":
    unittest.main()
