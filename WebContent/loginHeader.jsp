<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

    <head>

        <meta charset="utf-8">
        <title>用户管理</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Oleo+Script:400,700'>
        <link rel="stylesheet" href="loginAssets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="loginAssets/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>
    
    <body>
    
    

		  <%
				String errorInfo = (String)request.getAttribute("login_error");         
				if(errorInfo != null) {
		%>
				<script type="text/javascript" language="javascript">
				alert("<%=errorInfo%>");                                            
				
				                         
				</script>
				
		<%
				}
		%>
		
		<%
				String code_error = (String)request.getAttribute("code_error");         
				if(code_error != null) {
		%>
				<script type="text/javascript" language="javascript">
				alert("<%=code_error%>");                                            
				
				                         
				</script>
				
		<%
				}
		%>
		
		

        <div class="header">
            <div class="container">
                <div class="row">
                    <div class="logo span4">
                        <h1><a href="">GMC<span class="red">.</span></a></h1>
                    </div>
                    <div class="links span8">
                        <a class="home" href="" rel="tooltip" data-placement="bottom" data-original-title="Home"></a>
                        <a class="blog" href="" rel="tooltip" data-placement="bottom" data-original-title="Blog"></a>
                    </div>
                </div>
            </div>
        </div>
      

        <div class="register-container container">
            <div class="row">
                <div class="iphone span5">
                    <img src="loginAssets/img/iphone.png" alt="">
                </div>
                <div class="register span6">
    
