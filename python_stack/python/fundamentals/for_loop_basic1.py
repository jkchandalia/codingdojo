for i in range(0,151):
    print(i)

for i in range(5,1001,5):
    print(i)

for i in range(1,101,1):
    if i%10==0:
        print("Coding Dojo")
    elif i%5==0:
        print("Coding")
    else:
        print(i)

sum = 0
for i in range(0,500000):
    if i%2==1:
        sum = sum + i
print(sum)

for i in range(2018,0,-4):
    print(i)

def flexibleCounter(lowNum, highNum, mult):
    for i in range(lowNum, highNum+1):
        if i%mult==0:
            print(i)
flexibleCounter(2,9,3)