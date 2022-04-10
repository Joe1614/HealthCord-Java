 
$("#healthRecordForm").on("submit",function(event){
    event.preventDefault();
    // debugger;
    var data = convertFormToJSON("#healthRecordForm");
    data.userId = JSON.parse(sessionStorage.getItem("user")).id;
    data.file = document.getElementById("file-upload").files[0]
    $.ajax({
        url: "/myhealth",
        type: "POST",
        data: data,
        success: function(data){
            $("#healthRecordForm input.form_control").val('');
            alert("Records added successfully. View your record in myhealth page.");
        },
        error: function(error){
            console.log(error);
        }
    })
})
function convertFormToJSON(form) {
    const array = $(form).serializeArray(); // Encodes the set of form elements as an array of names and values.
    const json = {};
    $.each(array, function () {
        json[this.name] = this.value || "";
    });
    return json;
}