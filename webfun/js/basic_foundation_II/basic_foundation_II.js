var arr_big = [1,2,3,10]
var arr = [1,2,3,10]

// Biggie Size - Given an array, write a function that changes all positive numbers in the array to the string "big".  Example: makeItBig([-1,3,5,-5]) returns that same array, changed to [-1, "big", "big", -5].
function biggie(arr){
    for (var i =0;i<arr.length;i++){
        if (arr[i]>0){
            arr[i]="big"
        }
    }
    return arr
}
console.log(biggie(arr_big))
// Print Low, Return High - Create a function that takes in an array of numbers.  The function should print the lowest value in the array, and return the highest value in the array.
function printLowReturnHigh(arr){
    var max=arr[0]
    var min=arr[0]
    for (var i=1; i<arr.length; i++){
        if (arr[i]<min){
            min=arr[i]}
        if (arr[i]>max){
            max=arr[i]
        }
    }
    console.log(min)
    return max
}
console.log(printLowReturnHigh(arr))

// Print One, Return Another - Build a function that takes in an array of numbers.  The function should print the second-to-last value in the array, and return the first odd value in the array.
function return2ndtolast(arr){
    console.log(arr[arr.length-2])
    var firstOdd = null
    var i = 0
    while (firstOdd == null){
        if (arr[i] % 2==1){
            firstOdd=arr[i]
        }
        i++
    }
    return firstOdd
}
console.log(return2ndtolast(arr))
// Double Vision - Given an array (similar to saying 'takes in an array'), create a function that returns a new array where each value in the original array has been doubled.  Calling double([1,2,3]) should return [2,4,6] without changing the original array.
function double(arr_input){
    for (var i=0; i<arr_input.length; i++){
        arr_input[i] = arr_input[i] * 2
    }
    return arr_input
}

function double(arr_input){
    newArr = [...arr_input]
    for (var i=0; i<newArr.length; i++){
        newArr[i] = newArr[i] * 2
    }
    return newArr
}
console.log("original array:")
console.log(arr)
console.log(double(arr))
console.log(arr)
// Count Positives - Given an array of numbers, create a function to replace the last value with the number of positive values found in the array.  Example, countPositives([-1,1,1,1]) changes the original array to [-1,1,1,3] and returns it.
function countPositives(arr){
    var pos = 0
    for (var i=0;i<arr.length;i++){
        if(arr[i]%2==0){
            pos++
        }
    }
    arr[arr.length-1]=pos
    return arr
}
console.log(countPositives(arr))
// Evens and Odds - Create a function that accepts an array.  Every time that array has three odd values in a row, print "That's odd!".  Every time the array has three evens in a row, print "Even more so!".
function evenOdds(arr){
    var counterOdd = 0
    var counterEven = 0
    for (var i=0;i<arr.length;i++){
        if (arr[i]%2==0){
            counterEven++
            counterOdd =0
        }
        else if (arr[i]%2==1){
            counterOdd++
            counterEven=0}
        if (counterOdd==3){
            console.log("That's odd!")
            counterOdd=0
        }
        if (counterEven==3){
            console.log("Even more so!")
            counterEven=0
        }
    }
}

evenOdds([1,1,1,2,2,2,2,4,4,2,1])
// Increment the Seconds - Given an array of numbers arr, add 1 to every other element, specifically those whose index is odd (arr[1], arr[3], arr[5], etc).  Afterward, console.log each array value and return arr.
function incSeconds(arr){
    for (var i=0;i<arr.length;i++){
        if (i%2==1){
            arr[i] = arr[i] + 1
        }
        console.log(arr[i])
    }
    return arr
}
var arr = [1,2,3,10]

console.log(incSeconds(arr))
// Previous Lengths - You are passed an array (similar to saying 'takes in an array' or 'given an array') containing strings.  Working within that same array, replace each string with a number - the length of the string at the previous array index - and return the array.  For example, previousLengths(["hello", "dojo", "awesome"]) should return ["hello", 5, 4]. Hint: Can for loops only go forward?
function prevLen(arr){
    for (var i=arr.length-1;i>0;i--){
        arr[i] = arr[i-1].length
    }
    return arr
}
console.log(prevLen(['24','234','324']))
// Add Seven - Build a function that accepts an array. Return a new array with all the values of the original, but add 7 to each. Do not alter the original array.  Example, addSeven([1,2,3]) should return [8,9,10] in a new array.
function addSeven(arr){
    var newArr = [...arr]
    for (var i=0;i<newArr.length;i++){
        newArr[i] = newArr[i] + 7
    }
    return newArr
}
var arr = [1,2,3,10]

console.log(arr)
console.log(addSeven(arr))
console.log(arr)
// Reverse Array - Given an array, write a function that reverses its values, in-place.  Example: reverse([3,1,6,4,2]) returns the same array, but now contains values reversed like so... [2,4,6,1,3].  Do this without creating an empty temporary array.  (Hint: you'll need to swap values).
function reverseArray(arr){
    for(var i=0; i<Math.round(arr.length/2)-1;i++){
        var temp = arr[i]
        arr[i]=arr[arr.length-i-1]
        arr[arr.length-i-1] = temp
    }
    return arr
}
console.log("reverseArray:")
console.log(reverseArray(arr))
// Outlook: Negative - Given an array, create and return a new one containing all the values of the original array, but make them all negative (not simply multiplied by -1). Given [1,-3,5], return [-1,-3,-5].
function returnNegative(arr){
    var newArr = [...arr]
    for(var i=0;i<newArr.length;i++){
        if (newArr[i]<0){
            newArr[i]=newArr[i]*-1
        }
    }
    return newArr
}
var arr = [-1,2,3,10]
console.log(returnNegative(arr))
// Always Hungry - Create a function that accepts an array, and prints "yummy" each time one of the values is equal to "food".  If no array values are "food", then print "I'm hungry" once.
function alwaysHungry(arr){
    var foodBool = false
    for (var i=0;i<arr.length;i++){
        if (arr[i]=='food'){
            console.log("yummy")
            foodBool=true
        }
    }
    if (foodBool==false){
        console.log("I'm hungry")
        }
}
console.log("always_hungry:")
alwaysHungry(['food', 'adsf','adf'])
alwaysHungry(['adsf','adf'])
// Swap Toward the Center - Given an array, swap the first and last values, third and third-to-last values, etc.  Example: swapTowardCenter([true,42,"Ada",2,"pizza"]) turns the array into ["pizza", 42, "Ada", 2, true].  swapTowardCenter([1,2,3,4,5,6]) turns the array into [6,2,4,3,5,1].  No need to return the array this time.
function swapTowardsCenter(arr){
    for(var i=0; i<Math.round(arr.length/2)-1;i=1+2){
        var temp = arr[i]
        arr[i]=arr[arr.length-i-1]
        arr[arr.length-i-1] = temp
    }
    return arr
}
var arr = [1,2,3,10]
console.log("swap towards center:")
console.log(swapTowardsCenter(arr)) 
// Scale the Array - Given an array arr and a number num, multiply all values in the array arr by the number num, and return the changed array arr.  For example, scaleArray([1,2,3], 3) should return [3,6,9].
function scaleArr(arr, num){
    for (var i=0;i<arr.length;i++){
        arr[i] = arr[i]*num
    }
    return arr
}
var arr = [1,2,3,10]

console.log(scaleArr(arr,3))
