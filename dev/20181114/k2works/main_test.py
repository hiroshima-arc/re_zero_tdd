import unittest
from test.support import captured_stdout

def execute():
    n = 100
    
    while n != 0:
        if n % 3 == 0 and n % 5 == 0:
            print("FizzBuzz")
        elif n % 3 == 0:
            print("Fizz")        
        elif n % 5 == 0:
            print("Buzz")
        else:
            print(n)

        n = n - 1

class MainTest(unittest.TestCase):
    
    def test_1から100までの数をプリントする(self):
        with captured_stdout() as stdout:
            execute()
            lines = stdout.getvalue().splitlines()
            
        self.assertEqual(lines[99],"1")
        self.assertEqual(lines[0],"Buzz")
        
    def test_3の倍数のときは数の代わりにFizzをプリントする(self):
        with captured_stdout() as stdout:
            execute()
            lines = stdout.getvalue().splitlines()
            
        self.assertEqual(lines[97],"Fizz") 
        
    def test_5の倍数のときはBuzzをプリントする(self):
        with captured_stdout() as stdout:
            execute()
            lines = stdout.getvalue().splitlines()
            
        self.assertEqual(lines[95],"Buzz") 
        
    def test_3と5両方の倍数の場合にはFizzBuzzとプリントする(self):
        with captured_stdout() as stdout:
            execute()
            lines = stdout.getvalue().splitlines()
            
        self.assertEqual(lines[85],"FizzBuzz")         
        
        

if __name__ == "__main__":
    unittest.main()