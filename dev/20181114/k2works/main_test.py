import unittest
from test.support import captured_stdout

FIZZ_BUZZ = "FizzBuzz"
FIZZ = "Fizz"
BUZZ = "Buzz"
data = {
    "count": 0,
    "values": []
}
        
def execute(count=100):
    data["count"] = count
    iterate(data["count"])
    print_value()

        
def print_value():
    for value in data["values"]:
        print(value)    
    

def iterate(count):
    for n in range(count + 1):
        data["values"].append(generate(n))
    
            
def generate(number):
    value = number
    
    if number % 3 == 0 and number % 5 == 0:
        value = FIZZ_BUZZ
    elif number % 3 == 0:
        value = FIZZ
    elif number % 5 == 0:
        value = BUZZ
        
    return value
        

class MainTest(unittest.TestCase):
    
    def test_1から10までの数をプリントする(self):
        with captured_stdout() as stdout:
            execute(10)
            lines = stdout.getvalue().splitlines()
            
        self.assertEqual(lines[1],"1")
        self.assertEqual(lines[10],"Buzz")    
    
    
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