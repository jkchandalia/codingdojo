var users = [{name: "Michael", age:37}, {name: "John", age:30}, {name: "David", age:27}];
//print john's age
for (var i =0; i<users.length;i++){
    if (users[i]["name"]=="John"){
        console.log(users[i]["age"])
    }
}
//print name of first object
console.log(users[0]["name"])
//print/log the name and age of each user
for (var i =0; i<users.length;i++){
    console.log(users[i]["name"], "-", users[i]["age"])
}

