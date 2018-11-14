import unittest
from test.support import captured_stdout

values = []
        
def execute():
    count = 100
    iterate(count)
    for value in values:
        print(value)
    

def iterate(count):
    for n in range(count + 1):
        values.append(generate(n))
    
            
def generate(number):
    value = number
    
    if number % 3 == 0 and number % 5 == 0:
        value = "FizzBuzz"
    elif number % 3 == 0:
        value = "Fizz"
    elif number % 5 == 0:
        value = "Buzz"
        
    return value
        

class MainTest(unittest.TestCase):
    
    
    def test_1から100までの数をプリントする(self):
        with captured_stdout() as stdout:
            execute()
            lines = stdout.getvalue().splitlines()
            
        self.assertEqual(lines[1],"1")
        self.assertEqual(lines[100],"Buzz")
        
    def test_3の倍数のときは数の代わりにFizzをプリントする(self):
        with captured_stdout() as stdout:
            execute()
            lines = stdout.getvalue().splitlines()
            
        self.assertEqual(lines[3],"Fizz") 
        
    def test_5の倍数のときはBuzzをプリントする(self):
        with captured_stdout() as stdout:
            execute()
            lines = stdout.getvalue().splitlines()
            
        self.assertEqual(lines[5],"Buzz") 
        
    def test_3と5両方の倍数の場合にはFizzBuzzとプリントする(self):
        with captured_stdout() as stdout:
            execute()
            lines = stdout.getvalue().splitlines()
            
        self.assertEqual(lines[15],"FizzBuzz")         
        
        

if __name__ == "__main__":
    unittest.main()