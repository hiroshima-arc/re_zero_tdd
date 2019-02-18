import unittest


class FizzBuzzTest(unittest.TestCase):
    def test_1から100までの数をプリントする(self):
        list = FizzBuzz.print()
        self.assertEqual(1, list[0])
        self.assertEqual(100, list[-1])


class FizzBuzz:
    @staticmethod
    def print():
        list = []

        for i in range(100):
            list.append(i + 1)

        return list


if __name__ == "__main__":
    unittest.main()
