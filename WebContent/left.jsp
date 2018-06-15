<%@ page  pageEncoding="UTF-8" %>
		<div id="sidebar">
			<div id="sidebar-shortcuts">
				<div id="sidebar-shortcuts-large">
					<button class="btn btn-small btn-success">
					<i class="icon-signal"></i>
				</button>
					<button class="btn btn-small btn-info">
					<i class="icon-pencil"></i>
				</button>
					<button class="btn btn-small btn-warning">
					<i class="icon-group"></i>
				</button>
					<button class="btn btn-small btn-danger">
					<i class="icon-cogs"></i>
				</button>
				</div>
				<div id="sidebar-shortcuts-mini">
					<span class="btn btn-success"></span> <span class="btn btn-info"></span>
					<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
				</div>
			</div>
			<!-- #sidebar-shortcuts -->
			<ul class="nav nav-list">
				<li>
					<a href="ManufactureServlet?method=queryById" target="menuFrame">
						<i class="icon-dashboard"></i> <span>品牌商-我的信息</span>
					</a>
				</li>
				<li>
					<a href="brand-productInput-attr.html" target="menuFrame">
						<i class="icon-text-width"></i> <span>品牌商-商品录入</span>
					</a>
				</li>
				<li>
					<a href="brand-productInput-pic.html" target="menuFrame">
						<i class="icon-text-width"></i> <span>品牌商-商品主图</span>
					</a>
				</li>
				<li>
					<a href="brand-orderlist.html" class="dropdown-toggle" target="menuFrame">
						<i class="icon-file"></i> <span>品牌商-订单管理</span>
					</a>
				</li>
			</ul>
			<!--/.nav-list-->
			<div id="sidebar-collapse">
				<i class="icon-double-angle-left"></i>
			</div>
		</div>