function function1() {
    let id;
    if (document.getElementById('customerId1') != null) {
        id = document.getElementById("customerId1").value;
    }
    const url = "http://localhost:8080/customer/" + id;
    fetch(url)
        .then(response => response.json())
        .then(data => console.log(data))
    let win = window.open("customer.html", "Customer");
    win.username = 'username';
}