$(document).ready(function() {
    var x = get_cookie ( "emailvv" );
    if (x === true) {
        document.getElementById('link_Id').style.display = 'none';
    }
    alert("WTF IS GOING");
});

function get_cookie(name) {
    var matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches;
}