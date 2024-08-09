function onSubmit() {
    console.log("on submit function called");
    let email = document.getElementById("emailID");
    console.log(email);
    let emailValue = email.value;
    if (emailValue == '') {
        console.log("Email is required");

        //below applies the is-invalid class to the input so it is red
        email.classList.add("is-invalid");
        //these lines change the sub-sentence text and style
        document.getElementById("emailHelp").textContent = "Email is required";
        document.getElementById("emailHelp").classList.add("invalid-feedback");
        // return false;


    }
    else if (!emailValue.match(/(?:[a-z0-9#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])/)) {
        console.log("Email must include '@' ")

        //below applies the is-invalid class to the input so it is red
        email.classList.add("is-invalid");
        //these lines change the sub-sentence text and style
        document.getElementById("emailHelp").textContent = "Email must include '@'";
        document.getElementById("emailHelp").classList.add("invalid-feedback");

        // return false;

    }
    else {
        email.classList.add("is-valid");
        console.log(emailValue);
        return true;

    }
return false;

}