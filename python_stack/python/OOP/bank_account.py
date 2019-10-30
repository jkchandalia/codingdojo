class BankAccount:
    def __init__(self, int_rate=.02, balance=0):
        self.int_rate = int_rate
        self.balance = balance # don't forget to add some default values for these parameters!
		# your code here! (remember, this is where we specify the attributes for our class)
                # don't worry about user info here; we'll involve the User class soon

    def deposit(self, amount):
        self.balance += amount
        return self
    
    def withdraw(self, amount):
        self.balance -= amount
        return self
        
    def display_account_info(self):
        print("Balance: " + str(self.balance))
        return self
        
    def yield_interest(self):
        if self.balance > 0:
            self.balance += self.balance * self.int_rate
        return self

savings_acct = BankAccount()
checking_acct = BankAccount()

savings_acct.deposit(100).deposit(1000).deposit(500).withdraw(10).yield_interest().display_account_info()

checking_acct.deposit(500).deposit(50000).withdraw(100).withdraw(1000).withdraw(50).withdraw(10).yield_interest().display_account_info()