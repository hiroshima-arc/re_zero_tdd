import unittest

class TestMain(unittest.TestCase):
    def test1から100までを出力する(self):
      actual = []
      actual = print1from100()
      self.assertEqual(1 , actual[1])
      self.assertEqual(100, actual[-1])

def print1from100():
    array = []
    for i in range(101):
        array.append(i)

    return array

if __name__ == '__main__':
    unittest.main()