class Store:
    def __init__(self, name):
        self.name = name
        self.products = []
    
    def add_product(self, new_product): #takes a product and adds it to the store
        self.products.append(new_product)
        return self
    
    def sell_product(self, id):
        print("Sold product info:", self.products[id].print_info())
        self.products.pop(id) # - remove the product from the store's list of products given the id (assume id is the index of the product in the list) and print its info.
        return self

    def inflation(self, percent_increase):
        pass # - increases the price of each product by the percent_increase given (use the method you wrote in the Product class!)
    
    def set_clearance(self, category, percent_discount):
        pass


class Product:
    def __init__(self, name, price, category):
        self.name = name
        self.price = price
        self. category = category

    def update_price(self, percent_change, is_increased):
        if is_increased:
            self.price += self.price * percent_change
        else:
            self.price -= self.price * percent_change
        return self

    def print_info(self):
        print("Name:", self.name)
        print("Category:", self.category)
        print("Price:", self.price)


bStore = Store("BananaStore")
banana = Product("banana", 0.99, "fruit")
kiwi = Product("kiwi", 2.99, "fruit")
kumquat = Product("kumquat", 3.99, "fruit")

bStore.add_product(banana)
bStore.add_product(kiwi)
bStore.add_product(kumquat)
bStore.sell_product(1)