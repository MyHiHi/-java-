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
									<h3 class="panel-title"><a href="brandAdd.jsp?manuId=${manuId }" style="color:red">添加品牌</a></h3>
								</div>
								<div class="panel-body">
									<table class="table">
										<thead>
											<% int i=1; %>
											<tr>
												<th>ID</th><th>英文名</th><th>中文名</th><th>LOGO</th><th>操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="brands" items="${brands }">
								    			<tr >
								    			<td><%=i %></td>
								    				<td>${brands.enName}</td>
								    				<td>${brands.cnName}</td>
								    			<%-- <td><img src="${brands.logo}"> </td>  --%>
								    				<td>${brands.logo}</td> 
								  
								    				<td><a href="brandDelete.do?brandId=${brands.brandId }">删除</a>　　<a href="brandEdit.do?brandId=${brands.brandId }">编辑</a></td>
								    				
								    			
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