$(document).ready(function () {
    $('#btnConfirm').click(function () {
        $.ajax({
            type: 'POST',
            url: 'registration/confirm',
            async: false,
            data: {
                email: $('#email').val(),
                login: $('#login').val(),
                companyLogin: $('#companyLogin').val(),
                companyName: $('#companyName').val(),
                password: $('#password').val(),
                passwordRepeat: $('#passwordRepeat').val(),
                username: $('#username').val(),
                position: $('#position').val()
            },
            success: function (response) {
                alert(response);
            }
        });
    });
});