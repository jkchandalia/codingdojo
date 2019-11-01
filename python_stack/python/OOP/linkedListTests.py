import unittest
from linkedlist import SList, SLNode

class linkedListTests(unittest.TestCase):
    # each method in this class is a test to be run
    def testBase(self):
        self.assertEqual(self.my_list, SList().add_to_back(1).add_to_back(1).add_to_back(1).add_to_back(1))
        
    def setUp(self):
        print("running setUp")
        self.my_list = SList()
        self.my_list.add_to_back(1).add_to_back(1).add_to_back(1).add_to_back(1)

    def tearDown(self):
        # add the tearDown tasks
        print("running tearDown tasks")

    

if __name__ == '__main__':
    unittest.main() # this runs our tests