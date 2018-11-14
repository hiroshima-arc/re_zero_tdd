import unittest
from test.support import captured_stdout

        
def execute():
    count = 100
    iterate(count)
    

def iterate(count):
    for n in range(count + 1):
        generate(n)
    
            
def generate(number):
    if number % 3 == 0 and number % 5 == 0:
        print("FizzBuzz")
    elif number % 3 == 0:
        print("Fizz")        
    elif number % 5 == 0:
        print("Buzz")
    else:
        print(number)    

        

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