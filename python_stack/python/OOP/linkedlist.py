class SList:
    def __init__(self):
        self.head = None

    def add_to_front(self, val):
        new_node = SLNode(val)
        current_head = self.head
        new_node.next = current_head
        self.head = new_node  # SET the list's head TO the node we created in the last step
        return self

    def print_values(self):
        runner = self.head
        while (runner is not None):
            print(runner.value)
            runner = runner.next 	# set the runner to its neighbor
        return self	                # once the loop is done, return self to allow for chaining

    def add_to_back(self, val):
        if self.head is None:  # if the list is empty
            self.add_to_front(val)  # run the add_to_front method
            return self  # let's make sure the rest of this function doesn't happen if we add to the front

        new_node = SLNode(val)
        runner = self.head
        while (runner.next is not None):
            runner = runner.next
        runner.next = new_node  # increment the runner to the next node in the list
        return self                 # return self to allow for chaining

    def remove_from_front(self):# - remove the first node and return its value
        if self.head.next is None:
            self.head = None
        else:
            self.head = self.head.next
        return self

    def remove_from_back(self):# - remove the last node and return its value
        runner = self.head
        if runner.next is None:
            self.head = None
        while runner.next.next is not None:
            runner = runner.next
        runner.next = None
        return self

    def remove_val(self, val):# - remove the first node with the given value
        if self.head.value == val:
            self.remove_from_front()
        previous = self.head
        runner = self.head.next
        while runner is not None:
            if runner.value == val:
                if runner.next is None:
                    previous.next = None
                else:
                    previous.next = runner.next
                return self
            previous = runner
            runner = runner.next
        return self


    # Consider the following cases:
    # the node with the given value is the first node
    # the node with the given value is in the middle of the list
    # the node with the given value is the last node
    def insert_at(self, val, n):
        if n==0:
            self.add_to_front(val)
            return self
        
        counter = 1
        runner = self.head.next
        previous = self.head
        while counter < n:
            previous = runner
            runner = runner.next
            counter = counter + 1
        if runner.next is None:
            self.add_to_back(val)
        else:
            new_node = SLNode(val)
            previous.next = new_node
            new_node.next=runner
        return self
        


class SLNode:
    def __init__(self, val):
        self.value = val
        self.next = None


# my_list = SList()  # create a new instance of a list
#my_list.add_to_front("are").add_to_front("Linked lists")
#print(my_list.head.value)
#my_list.add_to_front("are").add_to_front("Linked lists").add_to_back("fun!").print_values()    # chaining, yeah!
# output should be:
# Linked lists
# are
# fun!
my_list2 = SList() 
my_list2.add_to_back(1).add_to_back(1).add_to_back(1).add_to_back(1).insert_at(3,0).print_values()
print()
my_list3 = SList() 
my_list3.add_to_back(1).add_to_back(1).add_to_back(1).add_to_back(1).insert_at(3,3).print_values()