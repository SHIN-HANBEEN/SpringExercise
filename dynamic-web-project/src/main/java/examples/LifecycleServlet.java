package examples;

import jakarta.servlet.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LifecycleServlet")
public class LifecycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifecycleServlet() {
        super();
        System.out.println("LifecycleServlet 생성!!");
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init test 호출!!");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy 호출!!");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");
		out.println("<form method='post' action='/dynamic-web-prject/LifecycleServlet'>");
		out.println("name : <input type='text' name='name'><br>");
		out.println("<input type='submit' value='ok'><br>");                                                 
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		out.println("<h1> hello " + name + "</h1>");
		out.close();
	}

}
