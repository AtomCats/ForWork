<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> REST</title>
</head>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">

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
</script>

</html>