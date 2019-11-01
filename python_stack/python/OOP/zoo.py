class Zoo:
    def __init__(self, zoo_name):
        self.animals = []
        self.name = zoo_name

    def add_animal(self, animal):
        animal.set_location(self)
        self.animals.append(animal)
        return self

    def remove_corpses(self):
        for animal in self.animals:
            if animal.health == 0:
                self.animals.remove(animal)
        return self

    def print_all_info(self):
        print("-"*30, self.name, "-"*30)
        for animal in self.animals:
            animal.display_info()
        print("-" * (62+len(self.name)))
        return self

class Animal:
    def __init__(self, name, age, health, happiness):
        self.name = name
        self.age = age
        self.health = health
        self.happiness = happiness
        self.type = None
        self.location = None
        
    def __str__(self):
        return f"I am a {self.type} named {self.name} who is {self.age} years old with a health score of {self.health} and happiness score of {self.happiness}."
    
    def display_info(self):
        print(f"I am a {self.type} named {self.name} who is {self.age} years old with a health score of {self.health} and happiness score of {self.happiness}.")
        return self

    def feed(self):
        self.health += 10
        self.happiness += 10
        return self

    def set_location(self, location):
        self.location = location
        return self

class Tiger(Animal):
    def __init__(self, name, age, health=100, happiness=80):
        super().__init__(name, age, health, happiness)
        self.type = "tiger"
    
    def feed(self):
        self.health+=15
        self.happiness+=15
        return self

    def kill(self, animal):
        animal.health=0
        print(f"{self.name} the {self.type} kills {animal.name} the {animal.type}.")
        self.location.remove_corpses()
        return self

class Giraffe(Animal):
    def __init__(self, name, age, health=50, happiness=90):
        super().__init__(name, age, health, happiness)
        self.type = "giraffe"
    
    def feed(self):
        self.health+=15
        self.happiness+=15
        return self
            
class Gazelle(Animal):
    def __init__(self, name, age, health=80, happiness=70):
        super().__init__(name, age, health, happiness)
        self.type = "gazelle"
    
    def feed(self):
        self.health+=15
        self.happiness+=15
        return self

tiger1 = Tiger("Tanya", 3)
tiger1.display_info()
gazelle1 = Gazelle("Gary",2)
giraffe1 = Giraffe("Gigi",4)

zoo1 = Zoo("John's Zoo")
zoo1.add_animal(tiger1).add_animal(gazelle1).add_animal(giraffe1).print_all_info()
tiger1.kill(gazelle1)
zoo1.print_all_info()
print("Use str representation of object")
print(tiger1)
print(dir(tiger1))
print(tiger1.__dict__)
