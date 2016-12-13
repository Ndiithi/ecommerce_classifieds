$(document).ready(function () {
    
    openclassifiedoptions();
    closeallforms();
    function  closeclassifiedoptions() {

        $(".classifiedoption").hide("slow", "linear");

    }

    function  openclassifiedoptions() {

        $(".classifiedoption").show("slow", "linear");

    }

    function closeallforms(){
         $("#houseforsale").hide();
        $("#houseforrent").hide();
        $("#jobsad").hide();
        $("#buyandsell").hide();
    }

    $("#houseforsalebtn").click(function () {
        $("#houseforsale").show("slow", "linear");
        $("#houseforrent").hide("slow", "linear");
        $("#jobsad").hide("slow", "linear");
        $("#buyandsell").hide("slow", "linear");
        closeclassifiedoptions();
    });

    $("#jobsadbtn").click(function () {
        $("#houseforsale").hide("slow", "linear");
        $("#houseforrent").hide("slow", "linear");
        $("#jobsad").show("slow", "linear");
        $("#buyandsell").hide("slow", "linear");
        closeclassifiedoptions();
    });

    $("#houseforrentbtn").click(function () {
        $("#houseforsale").hide("slow", "linear");
        $("#houseforrent").show("slow", "linear");
        $("#jobsad").hide("slow", "linear");
        $("#buyandsell").hide("slow", "linear");
        closeclassifiedoptions();
    });

    $("#buyandsellbtn").click(function () {
        $("#houseforsale").hide("slow", "linear");
        $("#houseforrent").hide("slow", "linear");
        $("#jobsads").hide("slow", "linear");
        $("#buyandsell").show("slow", "linear");
        closeclassifiedoptions();
    });


    $(".closeopenform").click(function () {
        openclassifiedoptions();
        $("#houseforsale").hide("slow", "linear");
        $("#houseforrent").hide("slow", "linear");
        $("#jobsad").hide("slow", "linear");
        $("#buyandsell").hide("slow", "linear");

    });

});


        