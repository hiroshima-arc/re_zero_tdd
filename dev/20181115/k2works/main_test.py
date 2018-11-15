import unittest
from test.support import captured_stdout


def execute():
    n = 100
    while n != 0:
        print(n)
        n = n - 1


class MainTest(unittest.TestCase):

    def test_1から100まで数をプリントする(self):
        with captured_stdout() as stdout:
            execute()
            lines = stdout.getvalue().splitlines()

        self.assertEqual("100", lines[0])
        self.assertEqual("1", lines[99])


if __name__ == "__main__":
    unittest.main()
