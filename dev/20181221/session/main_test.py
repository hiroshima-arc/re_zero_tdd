import unittest

class TestMain(unittest.TestCase):
    def test1から100までを出力する(self):
      actual = []
      actual = print1from100()
      self.assertEqual(1 , actual[1])
      self.assertEqual(100, actual[-1])

    def test_3で割り切れたらFizzを返す(self):
        self.assertEqual('Fizz',executeFizz(3))

def print1from100():
    array = []
    for i in range(101):
        array.append(i)

    return array

def executeFizz(num):
    if (num % 3) == 0:
        return 'Fizz'

if __name__ == '__main__':
    unittest.main()