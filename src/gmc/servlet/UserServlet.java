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
			//1.��request�����ȡ������
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String nickName = request.getParameter("nickName");
			String email = request.getParameter("email");
			//2.�������ݷ�װ��User������
			User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			user.setEmail(email);
			user.setNickName(nickName);
			user.setStatus("1");
			//3.����UserServiceҵ�������ִ��save
			UserService userService = new UserServiceImpl();
			userService.save(user);
			user = userService.findUserByName(userName);
			System.out.println("**********"+user.getUserId());
			//�����ض���,��ҳ�洫���û���Ϣ����Ҫ���û���Ϣ�����session������
			request.getSession().setAttribute("user", user);
		
			response.sendRedirect("roleList.do");		
		} catch (Exception e) {
			System.out.println("�û�ע��ʧ��.....");
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
