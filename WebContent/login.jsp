<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ include file="loginHeader.jsp" %>

  <form action="LoginServlet" method="post">
                        <h2> <span class="red"><strong>登录账户</strong></span></h2>
                        <label for="firstname">用户名</label>
                        <input type="text" id="firstname" name="userName" required="required" placeholder="输入用户名">
                        <label for="lastname">密码</label>
                        <input type="password" id="lastname" name="password" required="required" placeholder="输入密码">
                        <label for="lastname1">验证码</label>
                       	<input type="text" style="" id="code" id="lastname1" required="required" name="verifyCode" placeholder="请输入验证码">  
					                         
					                      
					    <img id="code" src="VerifyCodeServlet"  onclick="myRefersh(this)"> 
					    <br>
                        <button type="submit">登录</button>
                        <br>
                        <span style="float:right"><a href="register.jsp">注册账户</a></span>
                    </form>



<%@ include file="loginFooter.jsp" %>