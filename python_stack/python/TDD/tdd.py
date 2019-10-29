# import the python testing framework
import unittest
# our "unit"
# this is what we are running our test on
def reverseList(arr):
    l = len(arr)
    for i in range(0,int(l/2),1):
        arr[i], arr[l-i-1] = arr[l-i-1], arr[i]
    return arr
# our "unit tests"
# initialized by creating a class that inherits from unittest.TestCase
class reverseListTests(unittest.TestCase):
    # each method in this class is a test to be run
    def test(self):
        self.assertEqual( reverseList([1,3,5]), [5,3,1] )

    def testTwo(self):
        self.assertEqual( reverseList([1]), [1] )

    def testThree(self):
        self.assertNotEqual( reverseList([1,2]), [1,2] )

    def testFour(self):
        self.assertNotEqual( reverseList([1,2,3,4]), [] )

    def setUp(self):
        # add the setUp tasks
        print("running setUp")
    # any task you want run after the tests are executed, put them in the tearDown method
    def tearDown(self):
        # add the tearDown tasks
        print("running tearDown tasks")

def reverseString(string):
    l = len(string)
    reversed_string = ""
    for i in range(0,l,1):
        reversed_string = string[i] + reversed_string
    return reversed_string


def isPalindrome(string):
    if not(isinstance(string, str)):
        print("Please enter a string")
        return False
    reversed_string = reverseString(string)
    if reversed_string.lower() == string.lower():
        return True
    else:
        return False
    

# our "unit tests"
# initialized by creating a class that inherits from unittest.TestCase
class isPalindromeTests(unittest.TestCase):
    # each method in this class is a test to be run
    def test(self):
        self.assertTrue(isPalindrome('abba'))
    
    def testTwo(self):
        self.assertFalse(isPalindrome('adfad'))

    def testIsString(self):
        self.assertFalse(isPalindrome(['adfad']))

    def testFour(self):
        self.assertTrue(isPalindrome('racecar'))

    def testFive(self):
        self.assertTrue(isPalindrome('Racecar'))

    def setUp(self):
        # add the setUp tasks
        print("running setUp")
    # any task you want run after the tests are executed, put them in the tearDown method
    def tearDown(self):
        # add the tearDown tasks
        print("running tearDown tasks")

def coin(change):
    coin_vals = [25, 10, 5, 1]
    coin_nums = []
    for coin_val in coin_vals:
        num_coins = change // coin_val
        coin_nums.append(num_coins)
        change = change - num_coins * coin_val
    return coin_nums

# our "unit tests"
# initialized by creating a class that inherits from unittest.TestCase
class coinTests(unittest.TestCase):
    # each method in this class is a test to be run
    def test(self):
        self.assertEqual( coin(87), [3,1,0,2] )

    def testTwo(self):
        self.assertEqual(coin(85), [3,1,0,0])

    def testThree(self):
        self.assertEqual(coin(75), [3,0,0,0])

    def testFour(self):
        self.assertEqual(coin(24), [0,2,0,4])

    def testFive(self):
        self.assertNotEqual(coin(85), [0,1,0,0])

    def setUp(self):
        # add the setUp tasks
        print("running setUp")
    # any task you want run after the tests are executed, put them in the tearDown method
    def tearDown(self):
        # add the tearDown tasks
        print("running tearDown tasks")


def factorial(n):
    if n==1:
        return 1
    elif n<1:
        return False
    else:
        return n * factorial(n-1)
# our "unit tests"
# initialized by creating a class that inherits from unittest.TestCase
class factorialTests(unittest.TestCase):
    # each method in this class is a test to be run
    def testBase(self):
        self.assertEqual(factorial(1), 1)

    def testNegative(self):
        self.assertFalse(factorial(-1), False)

    def testPositiveOne(self):
        self.assertEqual(factorial(5), 120)

    def testPositiveTwo(self):
        self.assertEqual(factorial(3), 6)

    def setUp(self):
        # add the setUp tasks
        print("running setUp")
    # any task you want run after the tests are executed, put them in the tearDown method
    def tearDown(self):
        # add the tearDown tasks
        print("running tearDown tasks")



def fibonacci(n):
    if n==0 or n==1:
        return n
    else: 
        return fibonacci(n-1) + fibonacci(n-2)
# our "unit tests"
# initialized by creating a class that inherits from unittest.TestCase
class fibonacciTests(unittest.TestCase):
    # each method in this class is a test to be run
    def testBaseOne(self):
        self.assertEqual(fibonacci(0), 0)

    def testBaseTwo(self):
        self.assertEqual(fibonacci(1), 1)

    def testPositiveOne(self):
        self.assertEqual(fibonacci(5), 5)

    def testPositiveTwo(self):
        self.assertEqual(fibonacci(7), 13)

    def setUp(self):
        # add the setUp tasks
        print("running setUp")
    # any task you want run after the tests are executed, put them in the tearDown method
    def tearDown(self):
        # add the tearDown tasks
        print("running tearDown tasks")


if __name__ == '__main__':
    unittest.main() # this runs our tests
