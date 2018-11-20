import unittest
from test.support import captured_stdout
from fizz_buzz import execute, MAX_COUNT

class MainTest(unittest.TestCase):
    def setUp(self):
        with captured_stdout() as stdout:
            execute()
            self.lines = stdout.getvalue().splitlines()

    def test_1から10まで数をプリントする(self):
        with captured_stdout() as stdout:
            execute(count=10)
            self.lines = stdout.getvalue().splitlines()
        self.assertNotIn("11", self.lines)
        self.assertEqual("Buzz", self.lines[10])

    def test_1から100まで数をプリントする(self):
        self.assertEqual("1", self.lines[1])
        self.assertEqual("Buzz", self.lines[MAX_COUNT])

    def test_3の倍数のときは数の代わりにFizzをプリントする(self):
        self.assertEqual("Fizz", self.lines[3])

    def test_5の倍数のときはBuzzとプリントする(self):
        self.assertEqual("Buzz", self.lines[5])

    def test_3と5両方の倍数の場合にはFizzBuzzとプリントする(self):
        self.assertEqual("FizzBuzz", self.lines[15])

    def test_100より多い場合はプリントしない(self):
        with captured_stdout() as stdout:
            execute(count=101)
            self.lines = stdout.getvalue().splitlines()
        self.assertEqual(f"回数は{MAX_COUNT}までです", self.lines[0])


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
        list1 = [MAX_COUNT, 200, 300]
        tpl1 = (123, 'ok', True)
        rng1 = range(10, 20)
        result = list1 + list(tpl1) + list(rng1)
        self.assertEqual([MAX_COUNT, 200, 300, 123, 'ok', True, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19], result)


if __name__ == "__main__":
    unittest.main()
