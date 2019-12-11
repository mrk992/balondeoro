(function ($) {

    $(function () {

        $('.sidenav').sidenav();


        $.get("http://localhost:8080/quiz/fiestero/winners", function (data) {
            console.log(data.winner.photoURL);
            console.log(data.winner.photoURL);
            console.log(data.winner.photoURL);
        });

    }); // end of document ready



})(jQuery); // end of jQuery name space

