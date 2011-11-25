package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaSource.Aaa;
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
		
		if (method.equals("getContentOfObjectB")) {
			Aaa aaa = new Aaa();
			object = aaa.getObjectB();
		}if (method.equals("getContentOfObjectC")) {
			Aaa aaa = new Aaa();
			object = aaa.getObjectC();
		}if (method.equals("getContentOfXmlDocument")) {
			Aaa aaa = new Aaa();
			object = aaa.getXmlDocument("http://localhost:8080/midPoint_JSP/xml/catalog.xml");
			System.out.println(object);
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
