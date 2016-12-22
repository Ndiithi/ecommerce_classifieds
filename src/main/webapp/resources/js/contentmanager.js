$(document).ready(function () {

    var modelData;

    $("button#searchContentByPhone").click(function (event) {
      
        $('table#contentItems').find("tr:gt(0)").remove();
        var msisdn = $("input#searchMsisdn").val();
        $.ajax({
            type: 'GET', // define the type of HTTP verb we want to use (POST for our form)
            url: 'getAllContentByMsisdn?msisdn=' + msisdn + '', // the url where we want to POST
            dataType: 'json', // what type of data do we expect back from the server
            encode: true,
            success: function (data, textStatus, jqXHR) {

                populateContentTable(data);

            },
            error: function (response, request) {

                $('table#contentItems').append("<tr style='width: 100%;'><td colspan=6 style='color:red;text-align: center;'>Error Processing request</td></tr>");
                console.log("error");

            }

        });
    });

    function addClickEventToLink() {
        $(".contenteditlink").click(function (event) {
            var classnegotiable=false;
            var idd = $(event.target).closest("a").prop("id");
            var selectedContentModel=modelData[idd];
            
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
});