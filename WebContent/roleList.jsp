<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="header.jsp"%> 


<!-- MAIN -->
		<div class="main">
		
		
		
 <div class="main-content">
				<div class="container-fluid">
					<h3 class="page-title">GMC</h3>
					<div class="row">
						<div class="col-md-12">
							<!-- BASIC TABLE -->
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">我的公司</h3>
								</div>
								<div class="panel-body">
									<table class="table">
										<thead>
											<tr>
												<th>ID</th><th>英文名</th><th>中文名</th><th>认证类型</th><th>状态</th><th>操作</th>
											</tr>
										</thead>
										<tbody>
										<% int i=1; %>
											<c:forEach var="roles" items="${roles }">
											
								    			<tr >
								    			<td><%=i %></td>
								    			<%-- <td>${roles.manuId}</td> --%>
								    				<td><a href="brandList.do?manuId=${roles.manuId }" title="查看品牌信息">${roles.enName}</a></td>
								    				<td>${roles.cnName}</td>
								    				<td>${roles.certiType}</td>
								  
								    				<td>${roles.status}</td>
								    				<td><a href="roleDelete.do?manuId=${roles.manuId }">删除</a>　　<a href="roleEdit.do?manuId=${roles.manuId}">编辑</a></td>
								    				
								    			
    											</tr>
    											<%i++;%>
    		
    										</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
							<!-- END BASIC TABLE -->
						</div>
 					</div>
 				</div>
		
		
		<!-- 这里是**************************************** -->
		
		</div>
	</div>
	
	<%@ include file="footer.jsp"%> 