import unittest

def execute():
    return "1"

class MainTest(unittest.TestCase):
    
    def test_1から100までの数をプリントする(self):
        self.assertEqual("1", execute())

if __name__ == "__main__":
    unittest.main()