x = [ [5,2,3], [10,8,9] ] 
students = [
     {'first_name':  'Michael', 'last_name' : 'Jordan'},
     {'first_name' : 'John', 'last_name' : 'Rosales'}
]
sports_directory = {
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer' : ['Messi', 'Ronaldo', 'Rooney']
}
z = [ {'x': 10, 'y': 20} ]

for i,l in enumerate(x):
    for j,item in enumerate(l):
        if item==10:
            x[i][j]=15

print(x)

students[0]["last_name"]=="Bryant"

for key, value in sports_directory.items():
    for i, item in enumerate(value):
        if item == "Messi":
            sports_directory[key][i]="Andres"

print(sports_directory)


z[0]["y"]=30
print(z)


students = [
         {'first_name':  'Michael', 'last_name' : 'Jordan'},
         {'first_name' : 'John', 'last_name' : 'Rosales'},
         {'first_name' : 'Mark', 'last_name' : 'Guillen'},
         {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]


def iterateDictionary(l):
    for student in l:
        print(f"first_name - {student['first_name']}, last_name - {student['last_name']}")
iterateDictionary(students) 


def iterateDictionary2(key_name, arr):
    for item in arr:
        print(item[key_name])

iterateDictionary2("first_name",students)

dojo = {
   'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
   'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}

def printInfo(d):
    for key,value in d.items():
        print(f"{len(value)} {key.upper()}")
        for v in value:
            print(v)
            
printInfo(dojo)
    
