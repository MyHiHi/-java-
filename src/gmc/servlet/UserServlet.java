package gmc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gmc.entity.User;
import gmc.service.UserService;
import gmc.service.UserServiceImpl;



@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			//1.从request对象获取表单数据
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String nickName = request.getParameter("nickName");
			String email = request.getParameter("email");
			//2.将表单数据封装到User对象中
			User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			user.setEmail(email);
			user.setNickName(nickName);
			user.setStatus("1");
			//3.调用UserService业务组件，执行save
			UserService userService = new UserServiceImpl();
			userService.save(user);
			user = userService.findUserByName(userName);
			System.out.println("**********"+user.getUserId());
			//请求重定向,向页面传递用户信息，需要将用户信息存放在session对象中
			request.getSession().setAttribute("user", user);
		
			response.sendRedirect("roleList.do");		
		} catch (Exception e) {
			System.out.println("用户注册失败.....");
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
