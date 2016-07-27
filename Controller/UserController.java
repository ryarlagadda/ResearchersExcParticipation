package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Data.StudyDB;
import Data.UserDB;
import Model.User;
import Constants.UserConstants;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                String action = request.getParameter("action");
		HttpSession session = request.getSession();
		String url = "/home.jsp";
		if (action == null || action.equals("") || action.isEmpty()) {
			url = "/home.jsp";
			Cookie c = new Cookie("host", request.getRemoteHost());
			Cookie c1 = new Cookie("port", request.getRemotePort() + "");
			c.setMaxAge(60 * 60 * 24 * 365 * 1);
			c1.setMaxAge(60 * 60 * 24 * 365 * 1);
			response.addCookie(c);
			response.addCookie(c1);
			Cookie[] cookies = request.getCookies();
			if(cookies==null){
			   response.setIntHeader("Refresh", 1);
                        }
		
		}
		else {
			if (action.equals("login")) {
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				if (UserDB.validateUser(email, password)) {
					User user = UserDB.getUser(email);
					String userType = user.getUserType();
					if (userType.equalsIgnoreCase("Participant")) {
						session.setAttribute("theUser", user);
						int participants = StudyDB.getParticipants(user.getEmail());
						session.setAttribute("par", participants);
						url = "/main.jsp";
					} else if (userType.equalsIgnoreCase("Admin")) {
						session.setAttribute("theAdmin", user);
						url = "/admin.jsp";
					}
				} else {
					request.setAttribute("msg", UserConstants.INVALID_USER);
					url = "/login.jsp";
				}

			}
			if (action.equals("signup")) {
				String email = request.getParameter("email");
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				String conf_Password = request.getParameter("confirm_password");
				if (UserDB.getUser(email) != null) {
					request.setAttribute("msg", UserConstants.EMAIL_EXISTS);
					request.setAttribute("email", email);
					request.setAttribute("name", name);
					url = "/signup.jsp";
				} else if (!password.equals(conf_Password)) {
					request.setAttribute("msg", UserConstants.PASSWORDS_DONOT_MATCH);
					request.setAttribute("email", email);
					request.setAttribute("name", name);
					url = "/signup.jsp";
				} else {
					User user = new User(name, email, "Participant", password, conf_Password, 0, 0, 0);
					int participants = StudyDB.getParticipants(user.getEmail());
					session.setAttribute("par", participants);
					UserDB.addUser(user);
					session.setAttribute("theUser", user);
					url = "/main.jsp";
				}

			}
                        
                        if (action.equals("logout")) {
				if (session.getAttribute("theUser") != null || session.getAttribute("theAdmin") != null) {
					session.invalidate();
				}
				url = "/home.jsp";
			}

			if (action.equals("how")) {
				if (session.getAttribute("theUser") != null || session.getAttribute("theAdmin") != null) {
					url = "/main.jsp";
				} else {
					url = "/how.jsp";
				}
			}
                        
			if (action.equals("main")) {
				if (session.getAttribute("theUser") != null || session.getAttribute("theAdmin") != null) {
					url = "/main.jsp";
				} else {
					url = "/login.jsp";
				}
                        }

			if (action.equals("about")) {
				if (session.getAttribute("theUser") != null || session.getAttribute("theAdmin") != null) {
					url = "/aboutl.jsp";
				} else {
					url = "/about.jsp";
				}
			}

			if (action.equals("home")) {
				if (session.getAttribute("theUser") != null || session.getAttribute("theAdmin") != null) {
					url = "/main.jsp";
				} else {
					url = "/home.jsp";
				}
			}

		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
        
	public UserController() {
		super();
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
