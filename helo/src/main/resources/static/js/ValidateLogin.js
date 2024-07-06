$(document).ready(function () {
    $("#form-login").validate({
        rules: {
            email: {
                minlength: 5,
                maxlength: 50,
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 8,
                maxlength: 30
            }
        },
        messages: {
            email: {
                minlength: "Your email must be at least 5 characters long",
                maxlength: "Your email must be at most 50 characters long",
                required: "Please enter your email",
                email: "Please enter a valid email address"
            },
            password: {
                required: "Please enter your password"
            }
        },
    });
});
