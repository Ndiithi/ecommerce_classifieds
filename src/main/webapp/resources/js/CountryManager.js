var ip;
$(document).ready(function () {
    userCountry = getCookie('userCountry');
    if (userCountry.trim() === '') {

        $.ajax({
            type: 'GET', // define the type of HTTP verb we want to use (POST for our form)
            url: 'getUserIp', // the url where we want to POST
            contentType: 'application/json; charset=utf-8',
            dataType: 'json', // what type of data do we expect back from the server
            encode: true,
            success: function (data, textStatus, jqXHR) {

                ip = data.message;

                $.getJSON('http://ipinfo.io/' + ip, function (data) {
                    var cont = data.country;
                    if (typeof cont == 'undefined')
                        setUserCountry('');
                    else
                        setUserCountry(cont.toLowerCase());

                });
            },
            error: function (response, request) {

            }});
    } else {
        setUserCountry(userCountry);
    }
});


function openCountryNav() {

    if (document.getElementById("countryChooser").style.display == "block") {

        closeCountryNav();
    } else {

        document.getElementById("countryChooser").style.display = "block";

    }
}

function closeCountryNav() {
    document.getElementById("countryChooser").style.display = "none";

}

function setUserCountry(countryCode) {

    userCountry = '';
    if (countryCode === 'ke') {

        $("span#countryMenu").removeClass().addClass('flag-icon flag-icon-ke');
        $("span#countryName").text(" Kenya");
        userCountry = 'ke';

        setCookie("userCountry", 'ke');
    } else if (countryCode === 'zm') {

        $("span#countryMenu").removeClass().addClass('flag-icon flag-icon-zm');
        $("span#countryName").text(" Zambia");
        userCountry = 'zm';
        setCookie("userCountry", 'zm');
    } else {
        setCookie("userCountry", 'ke');
    }
    closeCountryNav();
}



function setCookie(cookieName, cookieValue) {

    var d = new Date();
    d.setTime(d.getTime() + (10 * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toUTCString();
    document.cookie = cookieName + "=" + cookieValue + ";" + expires + ";path=/";
}

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

