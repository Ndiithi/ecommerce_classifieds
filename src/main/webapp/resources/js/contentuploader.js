$("form").submit(function (event) {

    /* stop form from submitting normally */
    event.preventDefault();

    /*Global variables*/
    var valid = 1; //if form validated successfully, value remains 1
    var elementId = event.target.id;
    var contentCategory = ['house_for_sale', 'jobs_ad', 'house_for_rent', 'buy_and_sell'];

    clearValidationMarkers();
    validateForm(elementId);

    if (valid !== 1)
        return 1;



    /*Form submission*/
    var isNegotiable = 0;
    var shortDescription = $("#" + elementId + " div div [name='shortDescription']").val();
    var phone = $("#" + elementId + " div div [name='phone']").val();
    var location = $("#" + elementId + " div div [name='location']").val();
    var email = $("#" + elementId + " div div [name='email']").val();
    var expiryDate = $("#" + elementId + " div div [name='expiryDate']").val();
    var price = $("#" + elementId + " div div div [name='price']").val();
        var sub_category = $("#" + elementId + " div div [name='sub-category']").val();

    if ($("#" + event.target.id + " div div div label input[name='isNegotiable']").is(":checked"))
    {
        isNegotiable = 1;
    }

    var formData = {
        "price":price,
        "sub_category": sub_category,
        "content_category": resolveContentCategory(elementId),
        "shortDescription": shortDescription,
        "location": location,
        "phone": phone,
        "expiryDate": expiryDate,
        "email": email,
        "isNegotiable": isNegotiable,
        "country": userCountry
    };

    var docc = JSON.stringify(formData);

    $.ajax({
        type: 'POST', // define the type of HTTP verb we want to use (POST for our form)
        url: 'process-content', // the url where we want to POST
        contentType: 'application/json; charset=utf-8',
        data: docc, // our data object
        dataType: 'json', // what type of data do we expect back from the server
        encode: true,
        success: function (data, textStatus, jqXHR) {
            clearValidationMarkers();
            closeSuccesAlert();

        },
        error: function (response, request) {

            var parsed_data = JSON.parse(response.responseText);
            for (var i = 0; i < parsed_data.length; i++) {
                var obj = parsed_data[i];
                console.log("the * id: " + obj.id);

                if ($('.' + obj.id).length) {

                    if (obj.id === "shortDescription") {
                        $('#' + elementId + ' div div label i.shortDescription').css('visibility', 'visible');
                        $("#" + elementId + " div div [name='shortDescription_validation']").text(obj.message);
                    }

                    if (obj.id === "location") {
                        $('#' + elementId + ' div div label i.location').css('visibility', 'visible');
                        $("#" + elementId + " div div [name='location_validation']").text(obj.message);
                    }

                    if (obj.id === "phone") {
                        $('#' + elementId + ' div div label i.phone').css('visibility', 'visible');
                        $("#" + elementId + " div div [name='phone_validation']").text(obj.message);
                    }

                    if (obj.id === "expiryDate") {
                        $('#' + elementId + ' div div label i.expiryDate').css('visibility', 'visible');
                        $("#" + elementId + " div div [name='expiryDate_validation']").text(obj.message);
                    }

                    if (obj.id === "email") {
                        $('#' + elementId + ' div div label i.email').css('visibility', 'visible');
                        $("#" + elementId + " div div [name='email_validation']").text(obj.message);

                    }

                }



            }
            closeFailAlert();

        }

    });


    /*utility functions*/
    function clearValidationMarkers() {

        $('#' + elementId + ' div div label i.location').css('visibility', 'hidden');
        $('#' + elementId + ' div div label i.email').css('visibility', 'hidden');
        $('#' + elementId + ' div div label i.shortDescription').css('visibility', 'hidden');
        $('#' + elementId + ' div div label i.phone').css('visibility', 'hidden');
        $('#' + elementId + ' div div label i.expiryDate').css('visibility', 'hidden');
        $('#' + elementId + ' div div label i.sub_category').css('visibility', 'hidden');
        $('#' + elementId + ' div div label i.price').css('visibility', 'hidden');
      

        $("#" + elementId + " div div [name='expiryDate_validation']").text("");
        $("#" + elementId + " div div [name='shortDescription_validation']").text("");
        $("#" + elementId + " div div [name='email_validation']").text("");
        $("#" + elementId + " div div [name='location_validation']").text("");
        $("#" + elementId + " div div [name='location_validation']").text("");
    }

    function  closeFailAlert() {
        $("#fail-alert").css('display', 'block');
        $("#fail-alert").fadeTo(3000, 500).slideUp(500, function () {
            $("#fail-alert").slideUp(500);
        });
    }

    function  closeSuccesAlert() {
        $("#success-alert").css('display', 'block');
        $("#success-alert").fadeTo(3000, 500).slideUp(500, function () {
            $("#success-alert").slideUp(500);
        });
    }

    function resolveContentCategory(categoryId) {
        var categoryName;

        if (categoryId === "houseforsaleF")
            categoryName = contentCategory[0];
        if (categoryId === "jobsadF")
            categoryName = contentCategory[1];
        if (categoryId === "houseforrentF")
            categoryName = contentCategory[2];
        if (categoryId === "buyandsellF")
            categoryName = contentCategory[3];
        return categoryName;
    }

// Validate form before submitting.
    function validateForm(elementId) {
        var description = $("#" + elementId + " div div [name='shortDescription']");
        var phone = $("#" + elementId + " div div [name='phone']");
        var location = $("#" + elementId + " div div [name='location']");
        var email = $("#" + elementId + " div div [name='email']");
        var price = $("#" + elementId + " div div div [name='price']");
        var sub_category = $("#" + elementId + " div div [name='sub-category']");

        var shortDescription_validation = $("#" + elementId + " div div [name='shortDescription_validation']");
        var phone_validation = $("#" + elementId + " div div [name='phone_validation']");
        var location_validation = $("#" + elementId + " div div [name='location_validation']");
        var email_validation = $("#" + elementId + " div div [name='email_validation']");
        var price_validation = $("#" + elementId + " div div div [name='price_validation']");
        var sub_category_validation = $("#" + elementId + " div div [name='sub_category_validation']");
        var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;


        if (location.val().trim().length === 0) {
            valid = 0;
            location_validation.text("Location field Required");
        } else {

            $('#' + elementId + ' div div label i.location').css('visibility', 'hidden');
            location_validation.text("");
        }

        if (sub_category.val().trim().length === 0) {
            valid = 0;
            sub_category_validation.text("Category field Required");
        } else {

            $('#' + elementId + ' div div label i.sub_category').css('visibility', 'hidden');
            sub_category_validation.text("");
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
            if (description.val().trim().length < 14 || description.val().trim().length > 300) {
                valid = 0;
                shortDescription_validation.text("The Description length should be between 14 and 300");
            } else {
                $('#' + elementId + ' div div label i.shortDescription').css('visibility', 'hidden');
                shortDescription_validation.text("");
            }

        }

        if (phone.val().trim().length === 0) {
            valid = 0;
            phone_validation.text("Phone field Required");

        } else {

            if ($.isNumeric(phone.val())) {
                $('#' + elementId + ' div div label i.phone').css('visibility', 'hidden');
                phone_validation.text("");
            } else {
                valid = 0;
                phone_validation.text("Please enter a valid phone number");

            }
        }
    


    if (price.val().trim().length === 0) {
        valid = 0;
        price_validation.text("Price field Required");

    } else {
        if ($.isNumeric(price.val())) {
            $('#' + elementId + ' div div label i.phone').css('visibility', 'hidden');
            price_validation.text("");
        } else {
            valid = 0;
            price_validation.text("Please enter a valid price");
        }

    }


}


});
