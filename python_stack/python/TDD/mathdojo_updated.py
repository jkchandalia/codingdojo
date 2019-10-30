import unittest

class MathDojo:
    def __init__(self):
    	self.result = 0
    def add(self, num, *nums):
        self.result += num
        for other_num in nums:
            self.result += other_num
        return self

    def subtract(self, num, *nums):
        self.result -= num
        for other_num in nums:
            self.result -= other_num
        return self



class mathDojoTests(unittest.TestCase):
    # each method in this class is a test to be run
    def testBase(self):
        self.assertEqual(self.md.result, 0)
        
    def testAddSubtractOne(self):
        self.assertEqual(self.md.add(2).add(2,5,1).subtract(3,2).result, 5)

    def testAddSubtractTwo(self):
        self.assertEqual(self.md.add(20).add(20,5,5,5,5).subtract(3,2).result,55)

    def setUp(self):
        print("running setUp")
        self.md = MathDojo()
        # any task you want run after the tests are executed, put them in the tearDown method

    def tearDown(self):
        # add the tearDown tasks
        print("running tearDown tasks")

    

if __name__ == '__main__':
    unittest.main() # this runs our tests
