from bank_account import BankAccount
class User:
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self._create_default_account()
        
    def _create_default_account(self):
        self.accounts = {"primary": BankAccount(int_rate=0.02, balance=0)}

    def make_deposit(self, amount, account="primary"):	# takes an argument that is the amount of the deposit
    	self.accounts[account].deposit(amount)	# the specific user's account increases by the amount of the value received
        return self

    def make_withdrawal(self, amount, account="primary"):
        self.accounts[account].withdrawal(amount)
        return self

    def display_user_balance(self, account="primary"):
        print("Name: "+self.name)
        print("Account: "+account)
        self.accounts[account].display_account_info()
        #print("Balance: "+str(self.account.balance))
        return self

    def transfer_money(self, other_user, amount, account_from="primary", account_to="primary"):
        self.make_withdrawal(amount, account_from)
        other_user.make_deposit(amount, account_to)
        return self

    def add_account(self, account_name, int_rate, balance):
        self.append({account_name: BankAccount(int_rate=int_rate, balance=balance)})
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
