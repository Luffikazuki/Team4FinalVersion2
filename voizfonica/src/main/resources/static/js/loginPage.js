function showPassword() {
    var x = document.getElementById("password");
    if (x.type == "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}

function showConfirmPassword() {
    var x = document.getElementById("confirm_password");
    if (x.type == "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}

