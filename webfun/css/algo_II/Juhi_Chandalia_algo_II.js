function multiply(x,y){
    console.log(x);
    console.log(y);
}
b = multiply(2,3);
console.log(b);
//2
//3
//undefined

function multiply2(x,y){
    return x*y;
}
b = multiply2(2,3);
console.log(b);
console.log(multiply2(5,2));
//6
//10

var x = [1,2,3,4,5,10];
for(var i=0; i<5; i++)
{
   i = i + 3; 
   console.log(i);
}

//3
//7

var x=15;
console.log(x);
//15
function awesome(){
    var x=10;
    console.log(x);
}
console.log(x);
//15
awesome();
//10
console.log(x);
//15

for(var i=0; i<15; i+=2){
   console.log(i);
}
//0
//2
//4
//6
//8
//10
//12
//14

for(var i=0; i<3; i++){
   for(var j=0; j<2; j++){
       console.log(i*j);
   }
}
0
0
0
1
0
2

function looping(x,y){
   for(var i=0; i<x; i++){
      for(var j=0; j<x; j++){
          console.log(i*j);
      } 
   }
}
z = looping(3,3);
//0
//0
//0
//0
//1
//2
//0
//2
//4
console.log(z);
//undefined

function looping2(x,y){
    for(var i=0; i<x; i++){
        for(var j=0; j<y; j++){        
          console.log(i*j);
       } 
    }
    return x*y;
 }
 z = looping2(3,5);
//0
//0
//0
//0
//0
//0
//1
//2
//3
//4
//0
//2
//4
//6
//8

 console.log(z);
//15

console.log("functions")
function printUpTo(x){
  if (x<0) {
      console.log("negative number");
      return false;
  }
  else if (x===0){
      console.log(0);
  }
  else {
      for (var i=1; i<=x; i++){
          console.log(i);
      }
  }
}
printUpTo(10); // should print all the integers from 1 to 10
printUpTo(1000); // should print all the integers from 1 to 1000
y = printUpTo(-10); // should return false
console.log(y); // should print false

function printSum(x){
  var sum = 0;
  if (x<=0){
      return sum
  }
  else {
      for (var i=0; i<=x; i++){
          console.log(i)
          sum = sum + i
          console.log(sum)

      }
  }
  return sum
}
y = printSum(255) // should print all the integers from 0 to 255 and with each integer print the sum so far.
console.log(y) // should print 32640

function printSumArray(x){
  var sum = 0;
  if (x.length ===0){
      return 0
  }
  for(var i=0; i<x.length; i++) {
      sum = sum + x[i]
  }
  return sum;
}
console.log( printSumArray([1,2,3]) ); // should log 6

function largestElement(x){
    if (x.length === 0){
        console.log("Array is empty!")
        return false}
    var largest = x[0]
    for (var i=0;i<x.length;i++){
        if (x[i] > largest){
            largest = x[i]
        }
    }
    return largest
}

out = largestElement( [1,30,5,7] )
console.log(out)
