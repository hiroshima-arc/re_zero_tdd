import unittest

class TestFizzBuzz(unittest.TestCase):
  def testGreeting(self):
    self.assertEqual('Hello, World!', FizzBuzz.greeting)

class FizzBuzz:
  def greeting(self):
    return 'Hello, World!'

if __name__ == "__main__":
  unittest.main()