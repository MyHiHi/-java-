<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="header.jsp" %>

<!-- MAIN -->
		<div class="main">
		
		
		<!-- 这里**************************888888 -->
		
		
			<!-- WRAPPER -->
	<div id="wrapper" style="margin-top:100px">
		<div class="vertical-align-wrap">
			<div class="vertical-align-middle">
				<div class="auth-box ">
					<div class="left">
						<div class="content">
							<div class="header">
								<div class="logo text-center"><img src="assets/img/logo-dark.png" alt="Klorofil Logo"></div>
								<p class="lead">修改用户</p>
							</div>
							<form class="form-auth-small" action="userUpdate.do" method="post">
								<input type="hidden" name="userId" value="${user.userId }">
							
								<div class="form-group">
									<label for="signin-email" class="control-label sr-only">用户名</label>
									<input type="text" class="form-control" id="signin-email" value="${user.userName }" name="userName" >
								</div>
								
								
								<div class="form-group">
									<label for="signin-password" class="control-label sr-only">密码</label>
									
									<input type="password" class="form-control" name="password" id="signin-password"  value="${user.password }">
								</div>
								
							<div class="form-group">
									<label for="signin-password" class="control-label sr-only">昵称</label>
									
									 <input type="text" class="form-control" name="nickName" id="signin-password"  value="${user.nickName }"> 
								</div>
								<div class="form-group">
									<label for="signin-password1" class="control-label sr-only">email</label>
									
									 <input type="text" class="form-control" name="email" id="signin-password1"  value="${user.email }"> 
								</div>
								<div class="form-group">
									<label for="signin-password2" class="control-label sr-only">状态</label>
									
									 <input type="text" class="form-control" name="status" id="signin-password2"  value="${user.status }"> 
								</div>
							
								
							
								<button type="submit" class="btn btn-primary btn-lg btn-block">更新账户</button>
								
							</form>
						</div>
					</div>
					
	<!-- END WRAPPER -->
		
<div class="right">
						<div class="overlay"></div>
						<div class="content text">
							<h1 class="heading">跨境电商借卖平台</h1>
							<p>by 第三组</p>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	</div>
		<!-- 这里是**************************************** -->
		
	</div>
	
		<%@ include file="footer.jsp"%> 