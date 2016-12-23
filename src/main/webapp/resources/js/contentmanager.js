$(document).ready(function () {
    var valid = 1;
    var modelData;
    var msisdn;
    var contentId;
    
    //enable cacheing of fetched resources
    $.ajaxSetup({
        cache: true
    });



    /*form submission for edited content*/
    $("button#submitEditedContent").click(function (event) {
        validateForm();
        if (valid !== 1)
            return 1;
        
        var phone;
        var isNegotiable = 0;
        var shortDescription = $("div [name='shortDescription']").val();
        var location = $("div [name='location']").val();
        var email = $("div [name='email']").val();
        var expiryDate = $("div [name='expiryDate']").val();
        
        if ($("label input[name='isNegotiable']").is(":checked"))
        {
            isNegotiable = 1;
        }

        var formData = {
            "shortDescription": shortDescription,
            "location": location,
            "phone": msisdn,
            "expiryDate": expiryDate,
            "email": email,
            "isNegotiable": isNegotiable

        };

        var docc = JSON.stringify(formData);
        console.log(docc);
        $.ajax({
            type: 'PUT', // define the type of HTTP verb we want to use (POST for our form)
            url: 'updateContentById?contentId='+contentId, // the url where we want to POST
            contentType: 'application/json; charset=utf-8',
            data: docc, // our data object
            dataType: 'json', // what type of data do we expect back from the server
            encode: true,
            success: function (data, textStatus, jqXHR) {
                
                console.log("successs");

            },
            error: function (response, request) {

                var parsed_data = JSON.parse(response.responseText);
                for (var i = 0; i < parsed_data.length; i++) {
                    var obj = parsed_data[i];
                    $('.' + obj.id).css('visibility', 'visible');
                    console.log("the * id: " + obj.id);
                }
              //  closeAlert();

            }

        });


    });


    /*perform fetching of content from server by phone number*/
    $("button#searchContentByPhone").click(function (event) {
       
         msisdn= $("input#searchMsisdn").val();
         if(msisdn.trim().length===0) return 1;
        $.ajax({
            type: 'GET', // define the type of HTTP verb we want to use (POST for our form)
            url: 'getAllContentByMsisdn?msisdn=' + msisdn + '', // the url where we want to POST
            dataType: 'json', // what type of data do we expect back from the server
            encode: true,
            success: function (data, textStatus, jqXHR) {
               $('table#contentItems').find("tr:gt(0)").remove();
                populateContentTable(data);
            },
            error: function (response, request) {
                 $('table#contentItems').find("tr:gt(0)").remove();
                $('table#contentItems').append("<tr style='width: 100%;'><td colspan=6 style='color:red;text-align: center;'>Error Processing request</td></tr>");
                console.log("error");
            }

        });
    });

    /*add click event to all edit buttons from content table*/
    function addClickEventToLink() {
        $(".contenteditlink").click(function (event) {
            var classnegotiable = false;
            var idd = $(event.target).closest("a").prop("id");
            var selectedContentModel = modelData[idd];
            contentId=selectedContentModel.contentId;
            $("#contentDesc").val(selectedContentModel.shortDescription);
            $("#locationDesc").val(selectedContentModel.location);
            $("#expirydateDesc").val(selectedContentModel.expiryDate);
            $("#emailDesc").val(selectedContentModel.email);
            if (selectedContentModel.isNegotiable === 1)
                classnegotiable = true;
            $('#negotiableCheckbox').prop('checked', classnegotiable);
            $("div#contentModal").modal();
        });
    }

    /*populates html table with content if any from sever after search*/
    function populateContentTable(data) {

        $.each(data, function (index, objValue) {

            modelData = data;
            var content = objValue;
            var classnegotiable = "no";
            content.phone;
            if (content.isNegotiable === 1)
                classnegotiable = "yes";
            var trHTML;
            trHTML += '<tr><td>' + " " + '</td>'
                    + '<td>' + content.shortDescription + '</td>'
                    + '<td>' + content.location + '</td>'
                    + '<td>' + content.expiryDate + '</td>'
                    + '<td>' + content.email + '</td>'
                    + '<td>' + classnegotiable + '</td>'
                    + '<td> <a id=\'' + index + '\'  class="contenteditlink" href=\'#\'><i class=\'fa fa-pencil fa-lg \' style="margin-right: 20px;" aria-hidden=\'true\'></i></a>\n\
                            <a href=\'#\'><i class=\'fa fa-trash-o fa-lg\' aria-hidden=\'true\'></i></a>\n\
                      </td>'

                    + '</tr>';
            $('table#contentItems').append(trHTML);
        });
        addClickEventToLink();
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
            $('label i.shortDescription').css('visibility', 'hidden');
            shortDescription_validation.text("");
        }


    }



});