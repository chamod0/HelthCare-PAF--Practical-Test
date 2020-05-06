$(document).ready(function()
{
if ($("#alertSuccess").text().trim() == "")
 {
 $("#alertSuccess").hide();
 }
 $("#alertError").hide();
});
// SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
// Clear alerts---------------------
 $("#alertSuccess").text("");
 $("#alertSuccess").hide();
 $("#alertError").text("");
 $("#alertError").hide();
// Form validation-------------------
var status = validateItemForm();
if (status != true)
 {
		$("#alertError").text(status);
		$("#alertError").show();
 
 
			return;
 }
//If valid
var type = ($("#hidDoctorIDSave").val() == "") ? "POST" : "PUT";
$.ajax(
		{
		 url : "DoctorAPI",
		 type : type,
		 data : $("#DoctorForm").serialize(),
		 dataType : "text",
		 complete : function(response, status)
		 {
		 onDoctorSaveComplete(response.responseText, status);
		 }
		});

});

function onDoctorSaveComplete(response, status)
{
if (status == "success"){
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success"){
			
				$("#alertSuccess").text("Successfully saved.");
				$("#alertSuccess").show();
				$("#divDoGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error"){
			
				$("#alertError").text(resultSet.data);
					$("#alertError").show();
		}
 		} else if (status == "error")
 		{
 				$("#alertError").text("Error while saving.");
 					$("#alertError").show();
 		} else
 		{
 			$("#alertError").text("Unknown error while saving..");
 			$("#alertError").show();
 		}
			$("#hidDoctorIDSave").val("");
			$("#DoctorForm")[0].reset();
}
// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{
 $("#hidDoctorIDSave").val($(this).closest("tr").find('#hidDoIDUpdate').val());
 $("#id").val($(this).closest("tr").find('td:eq(0)').text());
 $("#name").val($(this).closest("tr").find('td:eq(1)').text());
 $("#Tel").val($(this).closest("tr").find('td:eq(2)').text());
 $("#Specialization").val($(this).closest("tr").find('td:eq(3)').text());
 $("#Hospital").val($(this).closest("tr").find('td:eq(4)').text());
 $("#Email").val($(this).closest("tr").find('td:eq(5)').text());
 $("#password").val($(this).closest("tr").find('td:eq(6)').text());
});


//remove
$(document).on("click", ".btnRemove", function(event)
{
	$.ajax(
	{
		url : "DoctorAPI",
		type : "DELETE",
		data : "DoId=" + $(this).data("doid"),
		dataType : "text",
		complete : function(response, status)
	 {
		 onDoctorDeleteComplete(response.responseText, status);
		 }
	 });
});
function onDoctorDeleteComplete(response, status)
{
if (status == "success"){
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success"){
			
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divDoGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
				
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
		} else if (status == "error") {
			
			$("#alertError").text("Error while deleting.");
			$("#alertError").show();
		} else{
			$("#alertError").text("Unknown error while deleting..");
			$("#alertError").show();
 }
}



// CLIENTMODEL=========================================================================
function validateItemForm()
{
// CODE
if ($("#name").val().trim() == "")
 {
 return "Insert  name.";
 }


// PRICE-------------------------------
if ($("#Specialization").val().trim() == "")
 {
 return "Insert Specialization.";
 }

// Hospital------------------------
if ($("#Hospital").val().trim() == "")
{
return "Insert Hospital.";
}

//Email
if ($("#Email").val().trim() == "")
{
return "Insert Item Email.";
}
//password
if ($("#password").val().trim() == "")
{
return "Insert Item password.";
}


//is numerical value
var tmpPrice = $("#Tel").val().trim();
if (!$.isNumeric(tmpPrice))
 {
 return "Insert a numerical value for Tel Number.";
 } 
return true;
}
