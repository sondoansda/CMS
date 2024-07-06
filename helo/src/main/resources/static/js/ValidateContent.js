$(document).ready(function () {
    $("#input-form-content").validate({
        rules: {
            title: {
                required: true,
                minlength: 10,
                maxlength: 200,
            },
            brief: {
                required: true,
                minlength: 30,
                maxlength: 150,
            },
            content: {
                required: true,
                minlength: 50,
                maxlength: 1000,
            }
        },
        messages: {
            title: {
                minlength: "Your title must be at least 10 characters long",
                maxlength: "Your title must be at most 200 characters long",
                required: "Please enter your title"
            },
            brief: {
                minlength: "Your brief must be at least 30 characters long",
                maxlength: "Your brief must be at most 150 characters long",
                required: "Please enter your brief"
            },
            content: {
                minlength: "Your content must be at least 50 characters long",
                maxlength: "Your content must be at most 1000 characters long",
                required: "Please enter your content"
            }
        }
    });
});
function resetForm() {
    window.location.href = "http://localhost:8080/formC";
}
