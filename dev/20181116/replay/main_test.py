import unittest
from test.support import captured_stdout


def execute():
    n = 1
    while n != 101:
        if n % 3 == 0 and n % 5 == 0:
            print("FizzBuzz")
        elif n % 3 == 0:
            print("Fizz")
        elif n % 5 == 0:
            print("Buzz")
        else:
            print(n)
        n = n + 1


def execute_for():
    for n in range(101):
        print(n)


class MainTest(unittest.TestCase):
    def test_execute_for(self):
        with captured_stdout() as stdout:
            execute_for()
            lines = stdout.getvalue().splitlines()
        self.assertEqual("1", lines[1])
        self.assertEqual("100", lines[-1])

    def setUp(self):
        with captured_stdout() as stdout:
            execute()
            self.lines = stdout.getvalue().splitlines()

    def test_1から100まで数をプリントできるようにする(self):
        self.assertEqual("1", self.lines[0])
        self.assertEqual("Buzz", self.lines[99])

    def test_3の倍数のときは数の代わりにFizzをプリントする(self):
        self.assertEqual("Fizz", self.lines[2])

    def test_5の倍数のときはBuzzとプリントする(self):
        self.assertEqual("Buzz", self.lines[4])

    def test_3と5両方の倍数の場合にはFizzBuzzとプリントする(self):
        self.assertEqual("FizzBuzz", self.lines[14])


class RangeTest(unittest.TestCase):
    def test_範囲を示すレンジ(self):
        rg = range(10)
        self.assertEqual(0, rg[0])
        self.assertEqual(9, rg[-1])
        rg = range(5, 10)
        self.assertEqual(5, rg[0])
        self.assertEqual(9, rg[-1])
        rg = range(10, 20, 2)
        self.assertEqual(12, rg[1])
        self.assertEqual(18, rg[-1])

    def test_レンジのシーケンス演算(self):
        rg = range(30)
        self.assertTrue(10 in rg)
        self.assertTrue(30 not in rg)
        rg = range(50)
        self.assertEqual(range(1, 4), rg[1:4])
        self.assertEqual(50, len(rg))
        self.assertEqual(49, max(rg))
        self.assertEqual(0, min(rg))

    def test_シーケンス間の変換(self):
        list1 = [100, 200, 300]
        tpl1 = (123, 'ok', True)
        rng1 = range(10, 20)
        result = list1 + list(tpl1) + list(rng1)
        self.assertEqual([100, 200, 300, 123, 'ok', True, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19], result)


if __name__ == "__main__":
    unittest.main()
