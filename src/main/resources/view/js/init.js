(function ($) {
    let drunksIds = ["drunks1stars", "drunks3stars", "drunks5stars"];
    let constantsIds = ["constant1stars", "constant3stars", "constant5stars"];
    let marriedIds = ["married1stars", "married3stars", "married5Stars"];

    $(function () {

        $('.sidenav').sidenav();
        $('.parallax').parallax();

        let fiesteros;


        $.get("http://localhost:8080/quiz/fiestero/list", function (data) {
            fiesteros = data;

            drunksIds.forEach(element => {
                fiesteros.forEach(fiestero => {
                    $("#" + element).append('<option value="' + fiestero.id + '">'
                                      + fiestero.name +
                                  '</option>');
                });
            });

            constantsIds.forEach(element => {
                fiesteros.forEach(fiestero => {
                    $("#" + element).append('<option value="' + fiestero.id + '">'
                        + fiestero.name +
                        '</option>');
                });
            });

            marriedIds.forEach(element => {
                fiesteros.forEach(fiestero => {
                    $("#" + element).append('<option value="' + fiestero.id + '">'
                        + fiestero.name +
                        '</option>');
                });
            });
            $(document).ready(function () {
                $('select').formSelect();
            });
        });

        $.get("http://localhost:8080/quiz/fiestero/winners", function (data) {
            console.log(data);
        });

    }); // end of document ready



    $("#send").click(function () {

        let vote = {};
        vote.fiesteroId = 1;
        vote.scores = [];

        let married = {};
        married.type = "married";
        married.awards = [];
        let stars = 1;

        marriedIds.forEach(element => {
            married.awards.push({
                "fiesteroId": $("#" + element).val(),
                "stars": stars
            });
            stars = stars + 2;
        });

        stars = 1;

        let constant = {};
        constant.type = "constant";
        constant.awards = [];

        constantsIds.forEach(element => {
            constant.awards.push({
                "fiesteroId": $("#" + element).val(),
                "stars": stars
            });
            stars = stars + 2;
        });

        stars = 1;

        let drunk = {};
        drunk.type = "drunk";
        drunk.awards = [];

        drunksIds.forEach(element => {
            drunk.awards.push({
                "fiesteroId": $("#" + element).val(),
                "stars": stars
            });
            stars = stars + 2;
        });

        vote.scores.push(married, constant, drunk);


        console.log(JSON.stringify(vote));

        $.ajax({
            url: 'http://localhost:8080/quiz/score/vote',
            type: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': "*"
            },
            data: JSON.stringify(vote),
            contentType: "application/json"
        });
    });


})(jQuery); // end of jQuery name space

