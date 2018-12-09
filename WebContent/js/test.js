//存放主要交互逻辑js代码
//javascript模块化
//包名.类名.方法
var test1={
		url:{
			login:"http://localhost:8080/SSH2/department_getJson",
		},
		detail:{
			init : function(params){
				console.log("init:"+params.text);
			}
		},
		main:{
			get:function(){
				 $.get(test1.url.login,function(result){
					 console.log("login_get:"+result);
				 })
			},
		post:function(data){
			 $.get(test1.url.login,data,function(result){
				 console.log("login_post:"+result);
			 })
		}
		}
		 
}