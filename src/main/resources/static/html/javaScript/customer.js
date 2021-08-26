var p = document.createElement('p');
document.body.append(p);

p.append("Name, ", username);

var email = document.createElement('p');
var customerEmail = 'user@test.com';
email.append(customerEmail);

p.append(email);

console.log("Hello, ", this.data);