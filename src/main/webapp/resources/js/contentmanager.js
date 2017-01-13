$(document).ready(function () {
    var valid = 1;
    var modelData;
    var msisdn;
    var contentId;
    var idd; //the index of selected content from table;
    var contentCategory = ['house_for_sale', 'jobs_ad', 'house_for_rent', 'buy_and_sell'];

    //enable cacheing of fetched resources
    $.ajaxSetup({
        cache: true
    });


    /*form submission for edited content*/
    $("button#submitEditedContent").click(function (event) {
        valid = 1;
        console.log("submit event started");
        clearValidationMarkers();
        console.log("submit event started 2");
        validateForm();
        console.log("submit event started 3");
        console.log("Valid status: " + valid);
        if (valid !== 1)
            return 1;


        var modelObj = modelData[idd];
        var content_category = modelObj.content_category;
        var phone;
        var isNegotiable = 0;
        var shortDescription = $("div [name='shortDescription']").val();
        var location = $("div [name='location']").val();
        var email = $("div [name='email']").val();
        var expiryDate = $("div [name='expiryDate']").val();
        var price = $("div div [name='price']").val();
        var sub_category = $("div [name='sub-category']").val();
        
        if ($("label input[name='isNegotiable']").is(":checked"))
        {
            isNegotiable = 1;
        }

        var formData = {
            "price":price,
            "sub_category":sub_category,
            "content_category": content_category,
            "contentId": contentId,
            "shortDescription": shortDescription,
            "location": location,
            "phone": msisdn,
            "expiryDate": expiryDate,
            "email": email,
            "isNegotiable": isNegotiable,
            "country": userCountry

        };
        console.log("submit event started 4 abut to stringfy");
        var docc = JSON.stringify(formData);
        console.log(docc);
        console.log(modelData);
        $("p.showEditProgress").show();
        $.ajax({
            type: 'PUT', // define the type of HTTP verb we want to use (POST for our form)
            url: 'updateContentById?contentId=' + contentId, // the url where we want to POST
            contentType: 'application/json; charset=utf-8',
            data: docc, // our data object
            dataType: 'json', // what type of data do we expect back from the server
            encode: true,
            success: function (data, textStatus, jqXHR) {
                console.log("submit Successfully");
                $("div#contentModal").modal('hide');
                $("div .alert").addClass("alert-success");
                $("p.messageFeedback").text("Updated successfully");
                closeAlert();
                modelData.splice(idd, 1, formData);  // {idd} the element to update/replace from model
                populateContentTable(modelData);

                clearValidationMarkers();


            },
            error: function (response, request) {
                console.log("submit failed");
                var parsed_data = JSON.parse(response.responseText);
                for (var i = 0; i < parsed_data.length; i++) {
                    var obj = parsed_data[i];

                    console.log("the * id: " + obj.id);

                    if ($('.' + obj.id).length) {
                        $('.' + obj.id).css('visibility', 'visible');
                        if (obj.id === "shortDescription")
                            $("div div [name='shortDescription_validation']").text(obj.message);
                        if (obj.id === "location")
                            $("div div [name='location_validation']").text(obj.message);
                        if (obj.id === "phone")
                            $(" div div [name='phone_validation']").text(obj.message);
                        if (obj.id === "expiryDate")
                            $("div div [name='expiryDate_validation']").text(obj.message);
                        if (obj.id === "email")
                            $("div div [name='email_validation']").text(obj.message);
                    }


                }

            }

        });
        $("p.showEditProgress").hide();

    });


    /*Delete selected content*/
    $("button#deleteSelectedContent").click(function (event) {
        $("p.showDeleteProgress").show();
        $.ajax({
            type: 'DELETE', // define the type of HTTP verb we want to use (POST for our form)
            url: 'deleteContentById?contentId=' + contentId, // the url where we want to POST
            dataType: 'json', // what type of data do we expect back from the server
            encode: true,
            success: function (data, textStatus, jqXHR) {
                $("div#confirmationModal").modal('hide');
                $("div .alert").addClass("alert-success");
                $("p.messageFeedback").text("Deleted successfully");
                closeAlert();
                modelData.splice(idd, 1);  // {idd} the element to remove from model
                populateContentTable(modelData);
            },
            error: function (response, request) {

                var parsed_data = JSON.parse(response.responseText);
                for (var i = 0; i < parsed_data.length; i++) {
                    var obj = parsed_data[i];

                    console.log("the message: " + obj.message);
                }

                closeAlert();

            }

        });
        $("p.showDeleteProgress").hide();
    });




//<script>
//            //script to show and hide image on ajax requests.
//            $(".showProgress").hide();
//
//            $(document).ajaxStart(function () {
//               
//                $(".showProgress").show();
//            });
//
//            $(document).ajaxComplete(function () {
//                $(".showProgress").hide();
//            });
//
//            </script>


    /*perform fetching of content from server by phone number*/
    $("button#searchContentByPhone").click(function (event) {

        msisdn = $("input#searchMsisdn").val();
        if (msisdn.trim().length === 0) {
            $("p.generalMessage").text("Kindly enter your phone number");
            $("p.generalMessage").show();
            return 1;
        } else {
            $("p.generalMessage").text("");
            $("p.generalMessage").hide();
        }
        $("p.showProgress").show();  //show progress icon

        $.ajax({
            type: 'GET', // define the type of HTTP verb we want to use (POST for our form)
            url: 'getAllContentByMsisdn?msisdn=' + msisdn + '', // the url where we want to POST
            dataType: 'json', // what type of data do we expect back from the server
            encode: true,
            success: function (data, textStatus, jqXHR) {
                $('table#contentItems').find("tr:gt(0)").remove();
                console.log("this is data returned: " + data);
//                if(data.trim().length !== 0)
//                    $('table#contentItems').append("<tr style='width: 100%;'><td colspan=7 style='color:red;text-align: center;'>No content found fo this number</td></tr>");
//                else
                console.log("the status gotten: " + textStatus);
                populateContentTable(data);
            },
            error: function (data, textStatus, jqXHR) {

                $('table#contentItems').find("tr:gt(0)").remove();
                $('table#contentItems').append("<tr style='width: 100%;'><td colspan=7 style='color:red;text-align: center;'>" + data.responseText + "</td></tr>");

            }

        });
        $("p.showProgress").hide();

    });

    /*add click event to all edit and delete buttons from content table*/
    function addClickEventToEditLink() {

        $(".contenteditlink").click(function (event) {
            clearValidationMarkers();
            var classnegotiable = false;
            idd = $(event.target).closest("a").prop("name");
            console.log("the id of selected model: " + idd);
            var selectedContentModel = modelData[idd];
            contentId = selectedContentModel.contentId;
            
            populateContentCategorySubtypeList();
            populateLocationList();
            $("#contentDesc").val(selectedContentModel.shortDescription);
            $("#locationDesc").val(selectedContentModel.location);
            $("#expirydateDesc").val(selectedContentModel.expiryDate);
            $("#emailDesc").val(selectedContentModel.email);
            $("#priceDesc").val(selectedContentModel.price);
            $("#subCategoryDesc").val(selectedContentModel.sub_category);
            if (selectedContentModel.isNegotiable === 1)
                classnegotiable = true;
            $('#negotiableCheckbox').prop('checked', classnegotiable);
            $("div#contentModal").modal();
        });



    }

    /* add Delete event to delete btn */
    function addClickEventToDeleteLink() {

        $(".contentDeleteLink").click(function (event) {
            clearValidationMarkers();
            idd = $(event.target).closest("a").prop("name");
            var selectedContentModel = modelData[idd];
            contentId = selectedContentModel.contentId;
            $("div#confirmationModal").modal();
        });

    }

    /*populates html table with content if any from sever after search*/
    function populateContentTable(data) {
        $('table#contentItems').find("tr:gt(0)").remove();

        $.each(data, function (index, objValue) {

            modelData = data;
            var content = objValue;
            var classnegotiable = "no";
            content.phone;
            if (content.isNegotiable === 1)
                classnegotiable = "yes";
            var trHTML;
            var shrtDescription = content.shortDescription.substring(0, 40);
            trHTML += '<tr class="paginate"><td>' + content.content_category + '</td>'
                    + '<td>' + content.sub_category + '</td>'
                    + '<td>' + shrtDescription + '</td>'
                    + '<td>' + content.location + '</td>'
                    + '<td>' + content.price + '</td>'
                    + '<td>' + content.expiryDate + '</td>'
                    + '<td>' + content.email + '</td>'
                    + '<td>' + classnegotiable + '</td>'
                    + '<td> <a name=\'' + index + '\'  class="contenteditlink" href=\'#\'><i class=\'fa fa-pencil fa-lg \' style="margin-right: 20px;" aria-hidden=\'true\'></i></a>\n\
                            <a name=\'' + index + '\'  class="contentDeleteLink" href=\'#\'><i class=\'fa fa-trash-o fa-lg\' aria-hidden=\'true\'></i></a>\n\
                      </td>'

                    + '</tr>';
            $('table#contentItems').append(trHTML);
        });
        addClickEventToEditLink();
        addClickEventToDeleteLink();
        performPagination(modelData);
    }

    //closes the alert bar
    function  closeAlert() {
        $("#success-alert").css('display', 'block');
        $("#success-alert").fadeTo(3000, 500).slideUp(500, function () {
            $("#success-alert").slideUp(500);
        });
    }

    /*validates form input data(content) before submission*/
    function validateForm() {

        var description = $("div [name='shortDescription']");
        var location = $("div [name='location']");
        var email = $("div [name='email']");

        var shortDescription_validation = $("div [name='shortDescription_validation']");
        var location_validation = $("div div [name='location_validation']");
        var email_validation = $("div div [name='email_validation']");

        var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;



        if (location.val().trim().length === 0) {
            valid = 0;
            location_validation.text("Location field Required");
            $('label i.location').css('visibility', 'visible');
        } else {

            $('label i.location').css('visibility', 'hidden');
            location_validation.text("");
        }

        if (email.val().trim().length !== 0 && !filter.test(email.val())) {

            valid = 0;
            email_validation.text("Fill in correct email");
            $('label i.email').css('visibility', 'visible');

        } else {


            $('label i.email').css('visibility', 'hidden');
            email_validation.text("");
        }

        if (description.val().trim().length === 0) {

            valid = 0;
            shortDescription_validation.text("Description field Required");
            $('label i.shortDescription').css('visibility', 'visible');
        } else {

            if (description.val().trim().length < 14 || description.val().trim().length > 300) {
                valid = 0;
                shortDescription_validation.text("The Description length should be between 14 and 300");
            } else {

                $('label i.shortDescription').css('visibility', 'hidden');
                shortDescription_validation.text("");

            }


        }


    }

    //perform paginationaion for fetched data
    function performPagination(numberOfRows) {
        jQuery(function ($) {
            // Grab whatever we need to paginate
            var pageParts = $(".paginate");

            // How many parts do we have?
            var numPages = numberOfRows.length;

            // How many parts do we want per page?
            var perPage = 10;

            // When the document loads we're on page 1
            // So to start with... hide everything else
            pageParts.slice(perPage).hide();
            // Apply simplePagination to our placeholder
            $("#page-nav").pagination({
                items: numPages,
                itemsOnPage: perPage,
                cssStyle: "compact-theme",
                // We implement the actual pagination
                //   in this next function. It runs on
                //   the event that a user changes page
                onPageClick: function (pageNum) {
                    // Which page parts do we show?
                    var start = perPage * (pageNum - 1);
                    var end = start + perPage;

                    // First hide all page parts
                    // Then show those just for our page
                    pageParts.hide()
                            .slice(start, end).show();
                }
            });
        });
    }


    /*utility functions*/
    function clearValidationMarkers() {

        $('div div label i.location').css('visibility', 'hidden');
        $('div div label i.email').css('visibility', 'hidden');
        $('div div label i.shortDescription').css('visibility', 'hidden');
        $('div div label i.phone').css('visibility', 'hidden');
        $('div div label i.expiryDate').css('visibility', 'hidden');

        $("div div [name='expiryDate_validation']").text("");
        $("div div [name='shortDescription_validation']").text("");
        $("div div [name='email_validation']").text("");
        $("div div [name='location_validation']").text("");
        $("div div [name='location_validation']").text("");
    }


});