<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> REST</title>
</head>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
    var prefix = '/myProject/save';

    $(document).ready(function(){
    $(#'bttnSubmit').click(function(){
    			        var data= {
                            'id': request.getParameter("first"),
                            'name':request.getParameter("name"),
                            'class': request.getParameter("class")
                        };

			$.ajax({
		             type: "POST",
		             contentType: "application/json",
		             url: "/myProject/students/save",
		             data: JSON.stringify(data),
		             dataType: 'json',
		             timeout: 600000,
		             success: function (data) {
		                 $("#btn-update").prop("disabled", false);
		                 //...
		             },
		             error: function (e) {
		                 $("#btn-save").prop("disabled", false);
		                 //...
		             }
			});
    });
    });

    var RestGet = function() {
        $.ajax({
            type: 'GET',
            url:  '/myProject/reminders',
            dataType: 'json',
            async: true,
            success: function(result) {
                alert('Время: ' + result.time
                        + ', сообщение: ' + result.message);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
    }



    var RestPost = function() {


    			        var data= {
                            'id': $(#'id'),
                            'name':$(#'stud_name'),
                            'class': $(#'class')
                        };

			$.ajax({
		             type: "POST",
		             contentType: "application/json",
		             url: "/myProject/students/save",
		             data: JSON.stringify(data),
		             dataType: 'json',
		             timeout: 600000,
		             success: function (data) {
		                 $("#btn-update").prop("disabled", false);
		                 //...
		             },
		             error: function (e) {
		                 $("#btn-save").prop("disabled", false);
		                 //...
		             }
			});
    }

    var RestDelete = function() {
        $.ajax({
            type: 'POST',
            url:  "/myProject/reminders"+'/'+1,
            dataType: 'json',
            async: true,
		             success: function () {
		                 //...
		             },
		             error: function (e) {
		                 $("#btn-save").prop("disabled", false);
		                 //...
		             }
        });
    }
</script>

<body>

<form name = "myForm" action = RestPost() method = "POST" >
Id: <input type="text" name="id" id = "id">
<br />
Name: <input type="text" name="name" id = "stud_name" />
<br />
Class: <input type="text" name="class" id = "class"/>
<input type="reset" value="Clear" name = "bttnClear"  />
<input type="submit" value="Submit" name = "bttnSubmit"  />
</form>

</body>
</html>
