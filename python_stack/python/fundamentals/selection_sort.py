def selectionSort(arr):
    for i in range(0,len(arr)):
        min_index = i
        for j in range(i,len(arr)):
            if arr[j]<arr[min_index]:
                min_index=j
        arr[i],arr[min_index] = arr[min_index],arr[i]
    return arr


print(selectionSort([1,5,3,6,3,8]))
        