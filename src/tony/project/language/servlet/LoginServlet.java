package tony.project.language.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazonaws.util.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
	
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(userName);
		System.out.println(password);
		
		
		try {
			Staff staff = staffDM.loadStaffByAccountName(userName);
			System.out.println(staff);

//		ObjectMapper jsonMapper = new ObjectMapper();
//		String json = jsonMapper.writeValueAsString(staff);
//		String fjson = "["+json+"]";
//		System.out.println(fjson);
			
			if(userName.equals(staff.getAccountName())){
				if(password.equals(staff.getPassword())){
					System.out.println("Hi");
					System.out.println(staff.getAuthority().equals(0));
					if(staff.getAuthority().equals(1)){
//					request.setAttribute("staff", fjson);
						String path = "/index.html";
						System.out.println(path);
						request.getRequestDispatcher(path).forward(request, response);
						return;
					}
					if(staff.getAuthority().equals(0)){
						System.out.println("Hii");
//					request.setAttribute("staff", fjson);
						String path = "/index.html";
						System.out.println(path);
						request.getRequestDispatcher(path).forward(request, response);
						return;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(request.getContextPath()+"/login.html");
		response.sendRedirect(request.getContextPath()+"/login.html");
		//csv
	}
	

}
