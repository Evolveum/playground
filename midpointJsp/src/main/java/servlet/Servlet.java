package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaSource.Midpoint;
import javaSource.errors.ErrorMessage;

import com.google.gson.Gson;

/**
 * Servlet implementation class Test
 */
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=windows-1250");
		PrintWriter out = response.getWriter();
		Object object = null;
		String method = request.getParameter("method");

		Midpoint midpoint = new Midpoint();
		if (method.equals("login")) {
			object = midpoint.login(request, response);
		}else if (method.equals("getLoggedUser")) {
			object = midpoint.getLoggedUser(request, response);
		}else if (method.equals("logout")) {
			object = midpoint.logout(request, response);
		} else {
            object = new Error(ErrorMessage.ERROR_DEFAULT);
        }

		String result = "OK";
		if (object != null) {
			Gson gson = new Gson();
			result = gson.toJson(object);
		}
		out.println(result);

		try {
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		processRequest(request, response);
	}

}
