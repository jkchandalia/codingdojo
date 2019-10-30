def insertion_sort(arr):
    for i in range(1,len(arr)):
        new_value=arr[i]
        insert_needed=False
        for j in range(i-1,-1,-1):
            if new_value<arr[j]:
                arr[j+1]=arr[j]
                insert_needed=True
            elif new_value>=arr[j]:
                arr[j+1]=new_value
                insert_needed = False
                break
        if insert_needed:
            arr[0]=new_value
    return arr

print(insertion_sort([2, 6, 23,9,2]))


