<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ include file="loginHeader.jsp" %>

  <form action="UserServlet" method="post">
                        <h2> <span class="red"><strong>注册账户</strong></span></h2>
                        <label for="firstname">用户名</label>
                        <input type="text" id="firstname" name="userName" required="required" placeholder="输入用户名">
                        <label for="lastname">密码</label>
                        <input type="password" id="lastname" name="password" required="required" placeholder="输入密码">
                        <label for="username">昵称</label>
                        <input type="text" id="username" name="nickName" required="required"  placeholder="输入昵称">
                        <label for="email">Email</label>
                        <input type="email" id="email" name="email" required="required" placeholder="输入email">
                
                        <button type="submit">注册</button>
                    </form>



<%@ include file="loginFooter.jsp" %>