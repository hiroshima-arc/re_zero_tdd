import unittest

class TestMain(unittest.TestCase):
    def test1から100までを出力する(self):
      actual = []
      actual = print1from100()
      self.assertEqual(1 , actual[1])
      self.assertEqual('Buzz', actual[-1])

    def test_3で割り切れたらFizzを返す(self):
        self.assertEqual('Fizz',fizzBuzz(3))
    
    def test_5で割り切れたらBuzzを返す(self):
        self.assertEqual('Buzz',fizzBuzz(5))
        
    def test_3かつ5で割り切れたらFizzBuzzを返す(self):
        self.assertEqual('FizzBuzz',fizzBuzz(15))

def print1from100():
    array = []
    for i in range(101):
        array.append(fizzBuzz(i))

    return array

FIZZ_BUZZ = 'FizzBuzz'
FIZZ = 'Fizz'
BUZZ = 'Buzz'

def fizzBuzz(num):
  if isFizz(num) and isBuzz(num):
    return FIZZ_BUZZ
  elif isFizz(num):
    return FIZZ
  elif isBuzz(num):
    return BUZZ
  else: 
    return num

def isFizz(num):
  if (num % 3 == 0):
    return True
  else:
    return False

def isBuzz(num):
  if (num % 5 == 0):
    return True
  else:
    return False


if __name__ == '__main__':
    unittest.main()
  
