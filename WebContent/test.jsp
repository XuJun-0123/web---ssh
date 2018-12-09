<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<input id="text" type="text" value="跨域获取数据" />
	<input id="btn" type="button" value="跨域获取数据" />
	<script src="js/jquery-3.3.1.js"></script>
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/test.js">
    
    </script>

	<script>

/*        $(document).ready(function () {

            $("#btn").click(function () {
		 
                $.getJSON({
                    url: "http://localhost:8080/SSH2/department_getJson",
                    type: "POST",
                    dataType: "jsonp", //指定服务器返回的数据类型
                    success: function (data) {
                        var result = JSON.stringify(data); //json对象转成字符串
                        $("#text").val(result);
                    }
                });
            });
        });*/
 
       	   $("#btn").click(function()
        { 
        	/*   $.ajax({
                      url:"http://localhost:8080/SSH2/department_getJson",
                      dataType:"text",
                        data: { number: $("#text").val() },
                       type:"POST",
                        success: function (data) {
                          console.log("data"+data);
                        }
                    }); */
/*                     $.get("http://localhost:8080/SSH2/department_getJson",function(data){
                    	 console.log("data1:"+data);
                    }); */
/*                     $.post("http://localhost:8080/SSH2/department_getJson",{number:$("#text").val()},function(result){
                    	console.log("result:"+result);
                    }) */
       		 test1.main.get();
             test1.main.post($("#text").val());   	
                    
        })
 	
</script>
</body>
</html>