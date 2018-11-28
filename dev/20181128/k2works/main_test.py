import unittest
from test.support import captured_stdout

def execute():
    for n in range(101):
        print(fizz_buzz(n))

def fizz_buzz(n):
    if n % 3 == 0:
        return 'Fizz'
    elif n % 5 == 0:
        return 'Buzz'
    else:
        return n

class MainTest(unittest.TestCase):
    def testカウントが1から100までプリントする(self):
        with captured_stdout() as stdout:
            execute()
            lines = stdout.getvalue().splitlines()

        self.assertEqual(lines[1], '1')
        self.assertEqual(lines[100], 'Buzz')

    def test値が3ならばFizzをプリントする(self):
        self.assertEqual('Fizz', fizz_buzz(3))

    def test値が5ならばBuzzをプリントする(self):
        self.assertEqual('Buzz', fizz_buzz(5))

    def test値が3と5で割り切れるならばFizzBuzzをプリントする(self):
        self.assertEqual('FizzBuzz', fizz_buzz(15))

if __name__ == "__main__":
    unittest.main()