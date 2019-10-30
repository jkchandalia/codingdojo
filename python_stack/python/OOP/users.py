class User:
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account_balance = 0
    # adding the deposit method
    def make_deposit(self, amount):	# takes an argument that is the amount of the deposit
    	self.account_balance += amount	# the specific user's account increases by the amount of the value received
        return self

    def make_withdrawal(self, amount):
        self.account_balance -= amount
        return self

    def display_user_balance(self):
        print("Name: "+self.name)
        print("Balance: "+str(self.account_balance))
        return self

    def transfer_money(self, other_user, amount):
        self.make_withdrawal(amount)
        other_user.make_deposit(amount)
        return self

jasmine = User("Jasmine", "jasminequanta@gmail.com")
vik = User("Vik", "vik@yahoo.com")
simi = User("Simi","simi@simi.ai")

jasmine.make_deposit(100).make_deposit(100000).make_deposit(50).make_withdrawal(50000).display_user_balance()

vik.make_deposit(200).make_deposit(1000).make_withdrawal(100).make_withdrawal(2000).display_user_balance()

simi.make_deposit(600000).make_withdrawal(50).make_withdrawal(5000).make_withdrawal(25000).display_user_balance()

simi.transfer_money(jasmine,10000)
simi.display_user_balance()
jasmine.display_user_balance()
