<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="header.jsp"%> 

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
								<p class="lead">修改品牌商信息</p>
							</div>
							<form class="form-auth-small" action="roleUpdate.do" method="post">
								<input type="hidden" value="${role.manuId }" name="manuId">
								
								<div class="form-group">
									<label for="signin-email" class="control-label sr-only">英文名</label>
									<input type="text" class="form-control" id="signin-email" name="manuEnName"  value="${role.enName }">
								</div>
								
								
								<div class="form-group">
									<label for="signin-password" class="control-label sr-only">英文名</label>
									
									<input type="text" class="form-control" name="manuCnName" id="signin-password" value="${role.cnName }" placeholder="Password">
								</div>
							
								
								<div class="form-group">
									<label for="signin-email3" class="control-label sr-only">认证类型</label>
									<input type="text" class="form-control" id="signin-email3" name="manuCertiType"  value="${ role.certiType }">
								</div>
								
								<div class="form-group">
									<label for="signin-email3" class="control-label sr-only">状态</label>
									<input type="text" class="form-control" id="signin-email3" name="status"  value="${ role.status }">
								</div>
								
							
								<button type="submit" class="btn btn-primary btn-lg btn-block">提交</button>
								<div class="bottom">
									<span class="helper-text"><i class="fa fa-lock"></i> <a href="roleList.do">回到列表页</a></span>
								</div>
							</form>
						</div>
					</div>
					
		
		
		
		
		
		
		
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
		

	
		<%@ include file="footer.jsp"%> 