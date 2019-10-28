def biggie_size(arr):
    for i, item in enumerate(arr):
        if item>0:
            arr[i] = "big"
    return arr

print(biggie_size([-1, 3, 5, -5]))

def count_positives(arr):
    count = 0
    for item in arr:
        if item>0:
            count = count + 1
    arr[-1] = count
    return arr

print(count_positives([-1,1,1,1]))

def sum_total(arr):
    sum = 0
    for item in arr:
        sum = sum + item
    return sum

print(sum_total([1,2,3,4]))

def average(arr):
    sum = 0
    for item in arr:
        sum = sum + item
    return sum/len(arr)

print(average([1,2,3,4]))

def length(arr):
    count = 0
    for item in arr:
        count = count + 1
    return count

print(length([37,2,1,-9]))

def minimum(arr):
    min = arr[0]
    for item in arr:
        if item<min:
            min = item
    return min

print(minimum([37,2,1,-9]))

def maximum(arr):
    max = arr[0]
    for item in arr:
        if item>max:
            max = item
    return max

print(maximum([37,2,1,-9]))

def ultimate_analysis(arr):
    min = arr[0]
    max = arr[0]
    count = 0
    sum = 0
    for item in arr:
        if item<min:
            min = item
        if item>max:
            max = item
        count = count + 1
        sum = sum + item
    output_dict = {"sumTotal": sum, "average": sum/count, "minimum": min, "maximum": max, "length":count}
    return output_dict
    
print(ultimate_analysis([37,2,1,-9]))

def reverse_list(arr):
    l = len(arr)
    for i in range(0,int(l/2)):
        temp = arr[i]
        arr[i] = arr[l-i-1]
        arr[l-i-1] = temp
    return arr

print(reverse_list([1,2,3,4,5]))
