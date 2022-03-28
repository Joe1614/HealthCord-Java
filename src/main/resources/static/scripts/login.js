const toggleForm = ()=>{
    const container = document.querySelector('.container');
    container.classList.toggle('active');
};

$("#loginForm").on("submit",function(event){
    // debugger;
    event.preventDefault();
    const data = convertFormToJSON("#loginForm");
    $.ajax({
        url: "/login",
        type: "POST",
        data: data,
        success: function(data){
            // debugger;
            window.location.href = "/home";
        },
        error: function(error){
            
        }
    })
})

$("#registerForm").on("submit",function(event){
    event.preventDefault();
    
    if($("[name=password]").val() !== $("[name=cpassword]").val()){
        $("#message").html("Password and confirm password does not match");
    }
    const data = convertFormToJSON("#registerForm"); 
    delete data.cpassword;
    debugger;   
    $.ajax({
        url:"/register",
        type: "POST",
        data: data,
        success : function(data){
            window.location.href = "/login";
        },
        error: function(error){
            console.log(error);
        }
    })
});

function convertFormToJSON(form) {
    const array = $(form).serializeArray(); // Encodes the set of form elements as an array of names and values.
    const json = {};
    $.each(array, function () {
        json[this.name] = this.value || "";
    });
    return json;
}
