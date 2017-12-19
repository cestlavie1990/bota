$(document).ready(function () {
    $('.confirm').click(function () {
        $.ajax({
            type: 'POST',
            url: '/BOtA/registration/confirm',
            async: false,
            data: {
                email: $('#email-reg').val(),
                login: $('#login-reg').val(),
                companyName: $('#companyName-reg').val(),
                password: $('#password-reg').val(),
                passwordConfirm: $('#passwordConfirm-reg').val(),
                username: $('#username-reg').val(),
                position: $('#position-reg').val()
            },
            success: function (response) {
                alert(response);
            }
        });
    });
});