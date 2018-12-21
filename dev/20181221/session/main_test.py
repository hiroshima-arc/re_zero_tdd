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

def fizzBuzz(num):
  if (num % 3 == 0) and (num % 5 == 0):
    return 'FizzBuzz'
  elif (num % 3) == 0:
    return 'Fizz'
  elif (num % 5) == 0:
    return 'Buzz'
  else: 
    return num

if __name__ == '__main__':
    unittest.main()
  
