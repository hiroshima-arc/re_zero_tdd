import unittest

class TestMain(unittest.TestCase):
    def test1から100までを出力する(self):
      actual = []
      actual = print1from100()
      self.assertEqual(1 , actual[1])
      self.assertEqual(100, actual[-1])

    def test_3で割り切れたらFizzを返す(self):
        self.assertEqual('Fizz',executeFizz(3))
    
    def test_5で割り切れたらBuzzを返す(self):
        self.assertEqual('Buzz',executeFizz(5))
    def test_3かつ5で割り切れたらFizzBuzzを返す(self):
        self.assertEqual('FizzBuzz',executeFizzBuzz(15))

def print1from100():
    array = []
    for i in range(101):
        array.append(i)

    return array

def executeFizz(num):
    if (num % 3) == 0:
        return 'Fizz'
    elif (num % 5) == 0:
        return 'Buzz'

def executeFizzBuzz(num):
    if(num % 15) == 0:
        return 'FizzBuzz'

if __name__ == '__main__':
    unittest.main()
  
