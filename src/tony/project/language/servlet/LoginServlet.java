package tony.project.language.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tony.project.language.domain.Staff;
import tony.project.language.interfaces.StaffDM;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	StaffDM staffDM = new Staff();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String methodName = request.getParameter("method");
		System.out.println(methodName);
		try {
			
			Method method = getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			
			method.invoke(this, request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("Password");
		System.out.println(userName);
		System.out.println(password);
		Staff staff = staffDM.loadStaffByAccountName(userName);
		System.out.println(staff);
		System.out.println(userName.equals(staff.getAccountName()));
		
		if(userName.equals(staff.getAccountName())){
			if(password.equals(staff.getPassword())){
				if(staff.getAuthority().equals(1)){
					request.setAttribute("staff", staff);
					request.getRequestDispatcher(request.getContextPath()+"/WEB-INF/users/Instructor.jsp");
					return;
				}
				if(staff.getAuthority().equals(1)){
					request.setAttribute("staff", staff);
					request.getRequestDispatcher(request.getContextPath()+"/WEB-INF/users/HOE.jsp");
					return;
				}
			}
		}
		
		response.sendRedirect(request.getContextPath()+"/WEB-INF/Login.jsp");
		
	}
	

}
