import unittest
from test.support import captured_stdout

def execute():
    print(1)


class MainTest(unittest.TestCase):
    
    def test_1から100まで数をプリントできるようにする(self):
        with captured_stdout() as stdout:
            execute()
        self.assertEqual(stdout.getvalue(), "1\n")


if __name__ == "__main__":
    unittest.main()
    