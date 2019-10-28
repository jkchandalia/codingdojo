import random
def randInt(min=0, max=100):
    if min > max:
        print("min must be less than max")
        return False
    if max < 0:
        print("max must be greater than zero")
        return False
    float_rand = random.random()
    num_rand = round(float_rand * (max-min)+min)
    return num_rand

print(randInt()) 		    # should print a random integer between 0 to 100
print(randInt(max=50)) 	    # should print a random integer between 0 to 50
print(randInt(min=50)) 	    # should print a random integer between 50 to 100
print(randInt(min=50, max=500))    # should print a random integer between 50 and 500