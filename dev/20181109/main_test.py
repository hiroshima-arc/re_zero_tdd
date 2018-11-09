import unittest

class FizzBuzz():
  @staticmethod
  def generate(number):
    value = number

    if FizzBuzz.can_be_divided_by_three_and_five(number):
      return "FizzBuzz"
    elif FizzBuzz.三で割れる(number):
      return "Fizz"
    elif FizzBuzz.五で割れる(number):
      return "Buzz"

    return value

  @staticmethod
  def can_be_divided_by_three_and_five(number):
    return number % 3 == 0 and number % 5 == 0

  @staticmethod
  def 三で割れる(number):
    return number % 3 == 0

  @staticmethod
  def 五で割れる(number):
    return number % 5 == 0
    

  @staticmethod
  def iterate(count):
    array = []

    for n in range(count):
      array.append(FizzBuzz.generate(n + 1))      

    return array

class FizzBuzzTest(unittest.TestCase):
  def test_値が３ならばFizzを返すようにする(self):        
    self.assertEqual("Fizz", FizzBuzz.generate(3))

  def test_値が５ならばBuzzを返すようにする(self):        
    self.assertEqual("Buzz", FizzBuzz.generate(5))    

  def test_値が１５ならばFizzBuzzを返すようにする(self):        
    self.assertEqual("FizzBuzz", FizzBuzz.generate(15))        

  def test_値が１０１ならば１０１を返すようにする(self):        
    self.assertEqual(101, FizzBuzz.generate(101))            

  def test_回数を５回実行すると配列を返すようにする(self):
    self.assertEqual([1, 2, "Fizz", 4, "Buzz"], FizzBuzz.iterate(5))

  def test_回数を１０回実行すると配列を返すようにする(self):
    self.assertEqual([1, 2, "Fizz", 4, "Buzz", "Fizz", 7, 8, "Fizz", "Buzz"], FizzBuzz.iterate(10))    


if __name__ == "__main__":
  unittest.main()