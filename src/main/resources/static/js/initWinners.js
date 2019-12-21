(function ($) {

    $(function () {

        $('.sidenav').sidenav();

        let mainURL = "https://balondeoro.chiringo.club";
        let imagesURL = "https://balondeoro.chiringo.club/images/fiesteros";


        $.get( mainURL + "/quiz/fiestero/winners", function (data) {

            $("#winnerName").html(data.winner.name);
            $("#winner").attr("src", data.winner.photoURL);
            $("#drunkName").html(data.drunk.name);
            $("#drunk").attr("src",data.drunk.photoURL);
            $("#constantName").html(data.constant.name);
            $("#constant").attr("src", data.constant.photoURL);
            $("#marriedName").html(data.married.name);
            $("#married").attr("src", data.married.photoURL);
        });

    });

})(jQuery); // end of jQuery name space

