from itertools import permutations

name = 'vodle'
perms = ["".join(i) for i in permutations(name)]
print(perms)