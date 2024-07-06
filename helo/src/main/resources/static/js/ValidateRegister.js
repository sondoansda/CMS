$(document).ready(function () {
    $("#form-register").validate({
        rules: {
            user_name: {
                required: true,
                minlength: 3,
                maxlength: 30
            },
            email: {
                required: true,
                email: true,
                minlength: 5,
            },
            password: {
                required: true,
                minlength: 8,
                maxlength: 30,
            },
            re_password: {
                required: true,
                minlength: 8,
                maxlength: 30,
                equalTo: "#password"
            }
        },
        messages: {
            user_name: {
                minlength: "Your name must be at least 3 characters long",
                maxlength: "Your name must be at most 30 characters long",
                required: "Please enter your name"
            },
            email: {
                minlength: "Your email must be at least 5 characters long",
                required: "Please enter your email",
                email: "Please enter a valid email address"
            },
            password: {
                minlength: "Your password must be at least 8 characters long",
                maxlength: "Your password must be at most 30 characters long",
                required: "Please enter your password"
            },
            re_password: {
                minlength: "Your password must be at least 8 characters long",
                maxlength: "Your password must be at most 30 characters long",
                required: "Please re-enter your password",
                equalTo: "Passwords do not match"
            }
        }
    });
});
