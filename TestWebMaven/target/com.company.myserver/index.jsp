<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> REST</title>
</head>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
    var prefix = '/myProject/save';

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
                            'id': '1',
                            'title':'Gavno ebanoe',
                            'remindDate': new Date()
                        };

			$.ajax({
		             type: "POST",
		             contentType: "application/json",
		             url: "/myProject/reminders/save",
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

    <h3>Requests tests</h3>

    <button type="button" onclick="RestGet()">GetAll</button>
    <button type="button" onclick="RestPost()">Save</button>
    <button type="button" onclick="RestDelete()">Delete</button>


</body>
</html>
