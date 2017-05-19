function submit() {
    console.log("Submit");

    let application = {
        variables: {}
    };
    let add = application.variables;

    add.candidateJob = getValue('candidateJob');
    add.candidateLastName = getValue('candidateLastName');
    add.candidateFirstName = getValue('candidateFirstName');
    add.candidateMail = getValue('candidateMail');
    add.candidateMobile = getValue('candidateMobile');
    add.candidateMotivation = getValue('candidateMotivation');
    add.candidateAdditionalInfo = getValue('candidateAdditionalInfo');

    let file = document.querySelector('#candidateCv').files[0];
    getBase64(file, (fileContent) => {
        add.candidateCv = {
            "value": fileContent,
            "type": "File",
            "valueInfo": {
                "filename": "CV.pdf"
            }
        };
        post(application);
        showConfirmation();
    });
}

function showConfirmation() {
    document.getElementsByTagName('body')[0].innerHTML = '<h3>Thanks for submitting your application.</h3>';
}

const getValue = (id) => {
    return {
        "value": document.getElementById(id).value,
        "type": "String"
    }
};

function post(application) {
    fetch('/rest/process-definition/key/RecruitmentProcess/submit-form', {
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(application)
    });
}

function getBase64(file, callback) {
    let reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = function () {
        let result = reader.result.split(',');
        callback(result[1]);
    };
    reader.onerror = function (error) {
        console.log('Error: ', error);
    };
}