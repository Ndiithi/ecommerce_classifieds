$("form").submit(function (event) {
    /* stop form from submitting normally */
    event.preventDefault();

    console.log("The event id: " + event.target.id);

    var element = event.target.id;
    var s = "#" + element;
    console.log("the s: " + s);


    var shortDescription = $('textarea#houseforsale').val();
    var location = $('input#houselocation').val();
    var phone = $('input#housephone').val();
    var expiryDate = $('input#expirydate').val();
    var email = $('input#housesaleemail').val();
    var isNegotiable = 0;
    if ($('input#housesalenego').is(":checked"))
    {
        isNegotiable = 1;
    }



    console.log(shortDescription + " " + location + " " + phone + " " + expiryDate + " " + email + " " + isNegotiable);

    var formData = {
        "shortDescription": shortDescription,
        "location": location,
        "phone": phone,
        "expiryDate": expiryDate,
        "email": email,
        "isNegotiable": isNegotiable

    };

    var docc = JSON.stringify(formData);

    clearValidationMarkers();

    $.ajax({
        type: 'POST', // define the type of HTTP verb we want to use (POST for our form)
        url: 'process-content', // the url where we want to POST
        contentType: 'application/json; charset=utf-8',
        data: docc, // our data object
        dataType: 'json', // what type of data do we expect back from the server
        encode: true,
        success: function () {
            
            alert("successs");
            
        },
        error: function (response, request) {

            var parsed_data = JSON.parse(response.responseText);
            for (var i = 0; i < parsed_data.length; i++) {
                var obj = parsed_data[i];
                $('.' + obj.id).css('visibility', 'visible');
                console.log(obj.id);
            }
            closeAlert();

        }

    });


    function clearValidationMarkers() {
        $('.shortDescription').css('visibility', 'hidden');
        $('.location').css('visibility', 'hidden');
        $('.phone').css('visibility', 'hidden');
        $('.expiryDate').css('visibility', 'hidden');
        $('.email').css('visibility', 'hidden');
        $('.isNegotiable').css('visibility', 'hidden');
    }

    function  closeAlert() {
        $("#success-alert").css('display', 'block');
        $("#success-alert").fadeTo(3000, 500).slideUp(500, function () {
            $("#success-alert").slideUp(500);
        });
    }




});
