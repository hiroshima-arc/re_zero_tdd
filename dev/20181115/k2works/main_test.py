import unittest
from test.support import captured_stdout


def execute():
    n = 100
    while n != 0:
        print(n)


class MainTest(unittest.TestCase):

    def test_1から100まで数をプリントする(self):
        with captured_stdout() as stdout:
            execute()
            lines = stdout.getvalue().splitlines()

        self.assertEqual(lines[0], "1")
        self.assertEqual(lines[99], "100")


if __name__ == "__main__":
    unittest.main()
