function function1() { // get by id
    let id;
    if (document.getElementById('customerId1') != null) {
        id = document.getElementById("customerId1").value;
    }
    const url = "http://localhost:8080/customer/" + id;
    fetch(url)
        .then(response => response.json())
        .then(data => console.log(data))
    let win = window.open("customer.html", "Customer");
}

function function2() { //getAll

}

function function3() { // create
    let customerName, customerEmail;
    if (document.getElementById('customerName1') != null) {
        customerName = document.getElementById("customerName1").value;
    }
    if (document.getElementById('customerEmail1') != null) {
        customerEmail = document.getElementById("customerEmail1").value;
    }

    let customer = {
        name: customerName,
        email: customerEmail
    };
    $.ajax({
        dataType: 'json',
        contentType: "application/json",
        url: "http://localhost:8080/customer/create",
        type: 'POST',
        data:  JSON.stringify(customer), //if no JSON is available use the one from https://github.com/douglascrockford/JSON-js
        success: function(data) {
            // console.log("Here ");
            // $("#updateInboxView").html(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert(jqXHR + " : " + textStatus + " : " + errorThrown);
        }
    });
}

function function4() { //delete
    let id;
    if (document.getElementById('customerId3') != null) {
        id = document.getElementById("customerId3").value;
    }
    $.ajax({
        // dataType: 'json',
        // contentType: "application/json",
        url: "http://localhost:8080/customer/" + id,
        type: 'DELETE',
        success: function() {
            console.log("Success deleted")
            // console.log("Here ");
            // $("#updateInboxView").html(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert(jqXHR + " : " + textStatus + " : " + errorThrown);
        }
    });
}

function function5() { //update
    let customerId, customerName, customerEmail;
    if (document.getElementById('customerId4') != null) {
        customerId = document.getElementById("customerId4").value;
    }
    if (document.getElementById('customerName2') != null) {
        customerName = document.getElementById("customerName2").value;
    }
    if (document.getElementById('customerEmail2') != null) {
        customerEmail = document.getElementById("customerEmail2").value;
    }

    let customer = {
        id: customerId,
        name: customerName,
        email: customerEmail
    };

    // alert(JSON.stringify(student))

    $.ajax({
        dataType: 'json',
        contentType: "application/json",
        url: "http://localhost:8080/customer/" + customerId,
        type: 'PUT',
        data:  JSON.stringify(customer), //if no JSON is available use the one from https://github.com/douglascrockford/JSON-js
        success: function(data) {
            console.log("Success update");
            // $("#updateInboxView").html(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert(jqXHR + " : " + textStatus + " : " + errorThrown);
        }
    });
}