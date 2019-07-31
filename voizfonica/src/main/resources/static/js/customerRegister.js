var check = function() {
    if (document.getElementById('password').value ==
        document.getElementById('confirm_password').value) {
        document.getElementById('showNotMatch').style.color = 'green';
        document.getElementById('showNotMatch').innerHTML = 'Passwords match';
    } else {
        document.getElementById('showNotMatch').style.color = 'red';
        document.getElementById('showNotMatch').innerHTML = 'Passwords do not matcht';
    }
}
