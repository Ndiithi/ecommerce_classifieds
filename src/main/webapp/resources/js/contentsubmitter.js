$("form").submit(function (event) {
    /* stop form from submitting normally */
    event.preventDefault();

    var valid = 1; //if form validated successfully, value remains 1


    var elementId = event.target.id;
    validateForm(elementId);



    if (valid !== 1)
        return 1;

    console.log("The event id: " + event.target.id);

    var isNegotiable = 0;


    var shortDescription = $("#" + elementId + " div div [name='shortDescription']").val();
    var phone = $("#" + elementId + " div div [name='phone']").val();
    var location = $("#" + elementId + " div div [name='location']").val();
    var email = $("#" + elementId + " div div [name='email']").val();
    var expiryDate = $("#" + elementId + " div div [name='expiryDate']").val();



    if ($("#" + event.target.id + " div div div label input[name='isNegotiable']").is(":checked"))
    {
        alert("checked");
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



    $.ajax({
        type: 'POST', // define the type of HTTP verb we want to use (POST for our form)
        url: 'process-content', // the url where we want to POST
        contentType: 'application/json; charset=utf-8',
        data: docc, // our data object
        dataType: 'json', // what type of data do we expect back from the server
        encode: true,
        success: function () {
            clearValidationMarkers();
            alert("successs");

        },
        error: function (response, request) {

            var parsed_data = JSON.parse(response.responseText);
            for (var i = 0; i < parsed_data.length; i++) {
                var obj = parsed_data[i];
                $('.' + obj.id).css('visibility', 'visible');
                console.log("the * id: " + obj.id);
            }
            closeAlert();

        }

    });


    function clearValidationMarkers() {

        $('#' + elementId + ' div div label i.location').css('visibility', 'hidden');
        $('#' + elementId + ' div div label i.email').css('visibility', 'hidden');
        $('#' + elementId + ' div div label i.shortDescription').css('visibility', 'hidden');
        $('#' + elementId + ' div div label i.phone').css('visibility', 'hidden');
        $('#' + elementId + ' div div label i.expiryDate').css('visibility', 'hidden');
    }

    function  closeAlert() {
        $("#success-alert").css('display', 'block');
        $("#success-alert").fadeTo(3000, 500).slideUp(500, function () {
            $("#success-alert").slideUp(500);
        });
    }




// Validate form before submitting.
    function validateForm(elementId) {




        var description = $("#" + elementId + " div div [name='shortDescription']");
        var phone = $("#" + elementId + " div div [name='phone']");
        var location = $("#" + elementId + " div div [name='location']");
        var email = $("#" + elementId + " div div [name='email']");

        var shortDescription_validation = $("#" + elementId + " div div [name='shortDescription_validation']");
        var phone_validation = $("#" + elementId + " div div [name='phone_validation']");
        var location_validation = $("#" + elementId + " div div [name='location_validation']");
        var email_validation = $("#" + elementId + " div div [name='email_validation']");
        var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;


        if (location.val().trim().length === 0) {
            valid = 0;
            location_validation.text("Location field Required");
        } else {

            $('#' + elementId + ' div div label i.location').css('visibility', 'hidden');
            location_validation.text("");
        }

        if (email.val().trim().length !== 0 && !filter.test(email.val())) {

            valid = 0;
            email_validation.text("Fill in correct email");

        } else {


            $('#' + elementId + ' div div label i.email').css('visibility', 'hidden');
            email_validation.text("");
        }

        if (description.val().trim().length === 0) {

            valid = 0;
            shortDescription_validation.text("Description field Required");

        } else {
            $('#' + elementId + ' div div label i.shortDescription').css('visibility', 'hidden');
            shortDescription_validation.text("");
        }

        if (phone.val().trim().length === 0) {
            valid = 0;
            phone_validation.text("Phone field Required");

        } else {

            $('#' + elementId + ' div div label i.phone').css('visibility', 'hidden');
            phone_validation.text("");
        }




    }


});
