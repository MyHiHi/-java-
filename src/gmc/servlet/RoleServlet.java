package gmc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.core.ApplicationPart;

import gmc.entity.Brand;
import gmc.entity.Manufacture;
import gmc.entity.User;
import gmc.service.BrandService;
import gmc.service.BrandServiceImpl;
import gmc.service.RoleService;
import gmc.service.RoleServiceImpl;
import gmc.service.UserService;
import gmc.service.UserServiceImpl;

/**
 * Servlet implementation class RoleServlet
 */
@WebServlet("*.do")
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf(".do"));
		RoleService role = new RoleServiceImpl();
		BrandService brand = new BrandServiceImpl();
		UserService myUser = new UserServiceImpl();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		if ("/roleList".equals(path)) {
			try {
				User user = (User)request.getSession().getAttribute("user");
				System.out.println("*(*(*(*(*(*(*("+user.getUserId());
				List<Manufacture> roles = role.findRoleByUserId(user.getUserId());
				request.setAttribute("roles", roles);
				request.getRequestDispatcher("roleList.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("roleList.jsp").forward(request, response);
			
		}else if ("/roleAdd".equals(path)) {
			String manuEnName = request.getParameter("manuEnName");
			String manuCnName = request.getParameter("manuCnName");
			String  manuCertiType = request.getParameter("manuCertiType");
			User user = (User)request.getSession().getAttribute("user");
			System.out.println("&*&*&*&*"+user.getUserId());
			String status = request.getParameter("status");
			Manufacture manu = new Manufacture();
			manu.setUserId(user.getUserId());
			manu.setEnName(manuEnName);
			manu.setCnName(manuCnName);
			manu.setCertiType(manuCertiType);
		
			manu.setStatus(status);
			System.out.println("^^^^^^^^^^^^^^^^^^^"+manu.getUserId());
			try {
				role.save(manu);	
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				response.sendRedirect("roleList.do");
			}
			
		}else if ("/roleUpdate".equals(path)) {
			
			Manufacture manu=new Manufacture();
			int manuId = Integer.parseInt(request.getParameter("manuId"));
	
			String manuEnName = request.getParameter("manuEnName");
			String manuCnName = request.getParameter("manuCnName");
			String  manuCertiType = request.getParameter("manuCertiType");
			User user = (User)request.getSession().getAttribute("user");
			String status = request.getParameter("status");
			manu.setManuId(manuId);
			manu.setUserId(user.getUserId());
			manu.setEnName(manuEnName);
			manu.setCnName(manuCnName);
			manu.setCertiType(manuCertiType);
	
			manu.setStatus(status);
			try {
				role.update(manu);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				response.sendRedirect("roleList.do");
			}
			
		}else if ("/roleEdit".equals(path)) {
			int manuId = Integer.parseInt(request.getParameter("manuId"));
			Manufacture manu=null;
			try {
				manu = new Manufacture();
				manu = role.findRoleById(manuId);
				request.setAttribute("role", manu);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				request.getRequestDispatcher("roleEdit.jsp").forward(request, response);
			}
			
		}else if ("/roleDelete".equals(path)) {
			int manuId = Integer.parseInt(request.getParameter("manuId"));
			try {
				int t = role.delete(manuId);
				brand.deleteByManuId(manuId);
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				response.sendRedirect("roleList.do");
			}
			
		}else if ("/roleQueryList".equals(path)) {
			try {
				String name = request.getParameter("name");
				
				List<Brand> brands = brand.findBrandByName(name);
				request.setAttribute("brands", brands);
				request.getRequestDispatcher("brandList.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}else if ("/brandList".equals(path)) {
			try {
				System.out.println("***sssllllllsssss*********"+request.getParameter("manuId")+"&*&*&&&"+request.getSession().getAttribute("manuId"));
				int manuId = 0;
				if ( request.getParameter("manuId")==null ) {
					//System.out.println("AAAAAAAAAAAAAAAAAAAAA:"+request.getSession().getAttribute("manuId"));
					manuId = (Integer)request.getSession().getAttribute("manuId");
				}
				else {
				//	System.out.println("BBBBBBBBBBBBBBBB:"+request.getParameter("manuId"));
					manuId = Integer.parseInt((String) request.getParameter("manuId"));
				}
				
				System.out.println("manuId: "+manuId);
				List<Brand> brands = brand.findBrandByManuId(manuId);
				
				request.setAttribute("brands", brands);
				request.setAttribute("manuId", manuId);
				request.getSession().setAttribute("manuId", manuId);
				request.getRequestDispatcher("brandList.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}else if ("/brandAdd".equals(path)) {
			
			String brandEnName = request.getParameter("brandEnName");
			String brandCnName = request.getParameter("brandCnName");
			
		
			String  logo =  request.getParameter("logo");
			System.out.println("HUHUHUHUHU***"+(String)request.getParameter("manuId"));
			int manuId = Integer.parseInt((String)request.getParameter("manuId"));
			
			Brand brand2 = new Brand();
			brand2.setManuId(manuId);
			brand2.setCnName(brandCnName);
			brand2.setEnName(brandEnName);
			brand2.setLogo(logo);
			try {
				brand.insert(brand2, manuId);
				request.getSession().setAttribute("manuId", manuId);
				//request.setAttribute("manuId", manuId);
				request.getRequestDispatcher("brandList.do").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				//response.sendRedirect("roleList.do");
			}
			
		}else if ("/brandDelete".equals(path)) {
			int brandId = Integer.parseInt(request.getParameter("brandId"));
			try {
				int t = brand.delete(brandId);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				System.out.println("KKKKKKKKKKKSSS"+request.getSession().getAttribute("manuId"));
				request.getSession().setAttribute("manuId", request.getSession().getAttribute("manuId"));
				//request.setAttribute("manuId", request.getSession().getAttribute("manuId"));
				request.getRequestDispatcher("brandList.do").forward(request, response);
			}
			
		}else if ("/brandEdit".equals(path)) {
			int brandId = Integer.parseInt(request.getParameter("brandId"));
			Brand brand2=null;
			try {
				brand2 = new Brand();
				brand2 = brand.findBrandByBrandId(brandId);
				request.setAttribute("brand", brand2);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				request.getRequestDispatcher("brandEdit.jsp").forward(request, response);
			}
		}else if ("/brandUpdate".equals(path)) {
			System.out.println("OOOOOOOOOOOOOOOOOOOOOOo");
			int brandId = Integer.parseInt(request.getParameter("brandId"));
			int manuId = Integer.parseInt(request.getParameter("manuId"));
			System.out.println("brandId:"+brandId+" manuId:"+manuId);
			String brandEnName = request.getParameter("brandEnName");
			String brandCnName = request.getParameter("brandCnName");
			String  logo = request.getParameter("logo");
			
			Brand brand2 = new Brand();
			brand2.setManuId(manuId);
			brand2.setBrandId(brandId);
			brand2.setCnName(brandCnName);
			brand2.setEnName(brandEnName);
			brand2.setLogo(logo);
			try {
				int t = brand.update(brand2);
			} catch (Exception e) {
				
				e.printStackTrace();
			}finally {
				request.setAttribute("manuId", manuId);
				request.getRequestDispatcher("brandList.do").forward(request, response);
			}
		}else if ("/userEdit".equals(path)) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			User user;
			try {
				user = myUser.findUserByUserId(id);
				request.setAttribute("user", user);
				request.getRequestDispatcher("userEdit.jsp").forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}else if ("/userUpdate".equals(path)) {
			int userId = Integer.parseInt(request.getParameter("userId"));
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String nickName = request.getParameter("nickName");
			String  email = request.getParameter("email");
			String  status = request.getParameter("status");
			System.out.println("PPPPPPPPPPPPPPPPP: "+password);
			User user = new User();
			user.setUserId(userId);
			user.setUserName(userName);
			user.setPassword(password);
			user.setNickName(nickName);
			user.setEmail(email);
			user.setStatus(status);
			try {
				int t = myUser.update(user);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}finally {
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("roleList.do").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
