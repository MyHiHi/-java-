package gmc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import gmc.entity.User;
import gmc.service.UserService;
import gmc.service.UserServiceImpl;
import gmc.util.ServletUtil;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			//1.从request对象获取表单数据
			String userName = request.getParameter("userName");
			String code = request.getParameter("verifyCode");
			String myCode = (String)request.getSession().getAttribute("code");
			System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWW"+userName+" "+code+" "+myCode+" "+ request.getParameter("password"));
			if (!myCode.toLowerCase().equals(code.toLowerCase())){
				request.setAttribute("code_error", "验证码不正确");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			UserService userService = new UserServiceImpl();
			User user = userService.findUserByName(userName);
			if (user==null) {
				response.sendRedirect("login.jsp");	
			}else {
				
				String password = request.getParameter("password");
				System.out.println("GGGGGGGGGGGGGGGGG"+user.getPassword()+"&*&*&*"+ServletUtil.md5Password(password));
				if (user.getPassword().equals(ServletUtil.md5Password(password))){
					System.out.println("@#@##@#AAAAAAAAAAAAAAAAAA"+user);
					HttpSession session = request.getSession();
				
					session.setAttribute("user",user);
					
					
					request.getRequestDispatcher("roleList.do").forward(request, response);
				
					
				}else{
					request.setAttribute("login_error", "用户名或密码不正确");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				
			}
//				
		} catch (Exception e) {
			System.out.println("用户登录失败.....");
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
