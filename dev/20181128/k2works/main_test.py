import unittest
from test.support import captured_stdout

def execute():
    for n in range(101):
        print(n)

class MainTest(unittest.TestCase):
    def testカウントが1から100までプリントする(self):
        with captured_stdout() as stdout:
            execute()
            lines = stdout.getvalue().splitlines()

        self.assertEqual(lines[1], '1')
        self.assertEqual(lines[100], '100')

if __name__ == "__main__":
    unittest.main()