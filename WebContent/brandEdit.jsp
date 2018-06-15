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
								<p class="lead">编辑品牌${brand.cnName }</p>
							</div>
							<form class="form-auth-small" action="brandUpdate.do" method="post">
								
								<input type="hidden" name="brandId" value="${brand.brandId }">
								<input type="hidden" name="manuId" value="${brand.manuId }">
								<div class="form-group">
									<label for="signin-email" class="control-label sr-only">英文名</label>
									<input type="text" class="form-control" id="signin-email" value="${brand.enName }" name="brandEnName" >
								</div>
								
								
								<div class="form-group">
									<label for="signin-password" class="control-label sr-only">中文名</label>
									
									<input type="text" class="form-control" name="brandCnName" id="signin-password"  value="${brand.cnName }">
								</div>
								
							<div class="form-group">
									<label for="signin-password" class="control-label sr-only">LOGO</label>
									
									 <input type="text" class="form-control" name="logo" id="signin-password"  value="${brand.logo }"> 
								</div>
							
								
							
								<button type="submit" class="btn btn-primary btn-lg btn-block">更新</button>
								
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