import unittest

class TestFizzBuzz(unittest.TestCase):
  def testGreeting(self):
    self.assertEqual('Hello, World!', FizzBuzz.greeting())

class FizzBuzz:
  @staticmethod
  def greeting():
    return 'Hello, World!'

if __name__ == "__main__":
  unittest.main()