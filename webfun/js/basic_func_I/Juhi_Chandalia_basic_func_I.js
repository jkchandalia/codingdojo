// All correct except I thought console.log(10,3) would print "10, 3" not "10 3"
function a(){
    return 35;
}
console.log(a())
//35
function a1(){
    return 4;
}
console.log(a1()+a1());
//8
function a2(b){
    return b;
}
console.log(a2(2)+a2(4));
//6
function a3(b){
    console.log(b);
    return b*3;
}
console.log(a3(3));
//3
//9
function a4(b){
   return b*4;
   console.log(b);
}
console.log(a4(10));
//40
function a5(b){
    if(b<10) {
        return 2;
    }
    else     {
        return 4;
    }
    console.log(b);
}
console.log(a5(15));
//4
function a6(b,c){
    return b*c;
}
console.log(10,3);
//10,3
console.log( a6(3,10) );
//30
function a7(b){
    for(var i=0; i<10; i++){
        console.log(i);
    }
    return i;
}
console.log(3);
//3
console.log(4);
//4
function a8(){
    for(var i=0; i<10; i++){
        i = i +2;
        console.log(i);
    }
}
a8();
//2
//5
//8
//11
function a9(b,c){
    for(var i=b; i<c; i++) {
       console.log(i);
   }
   return b*c;
}
a9(0,10);
//0
//1
//2
//3
//4
//5
//6
//7
//8
//9
console.log(a9(0,10));
//0
//1
//2
//3
//4
//5
//6
//7
//8
//9
//0
function a10(){
    for(var i=0; i<10; i++){
       for(var j=0; j<10; j++){
           console.log(j);
       }
       console.log(i);
    }
}
//
function a11(){
    for(var i=0; i<10; i++){
        for(var j=0; j<10; j++){
            console.log(i,j);
        }
        console.log(j,i);
    }
}
//
var z = 10;
function a12(){
    var z = 15;
    console.log(z);
}
console.log(z);
//10

var z = 10;
function a13(){
    var z = 15;
    console.log(z);
}
a13();
//15
console.log(z);
//10

var z = 10;
function a14(){
    var z = 15;
    console.log(z);
    return z;
}
z = a14();
//15
console.log(z);
//15
