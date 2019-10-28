def countdown(num):
    output_list = []
    for i in range(num,-1,-1):
        output_list.append(i)
    return output_list

print(countdown(5)) 

def printReturn(l):
    print(l[0])
    return l[1]

print(printReturn([1,2]))

def firstPlusLength(arr):
    return arr[0] + len(arr)

print(firstPlusLength([1,23,4,5]))

def firstValuesGreaterThanSecond(arr):
    if len(arr)<2:
        return False
    else:
        compare_val = arr[1]
        output_arr = []
        count = 0
        for a in arr:
            if a>compare_val:
                output_arr.append(a)
                count = count + 1
        print(count)
        return output_arr

print(firstValuesGreaterThanSecond([5,2,3,2,1,4]))

def length_and_value(size, val):
    output_arr = []
    for i in range(0,size):
        output_arr.append(val)
    return output_arr

print(length_and_value(4,7))

