
function pageLoad() {
    var x = get_cookie ( "username" );
    if (x) {
        var y = document.getElementById("login");
        y.style.display ="none";
    }
}

function get_cookie(name) {
    var matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches;
}
