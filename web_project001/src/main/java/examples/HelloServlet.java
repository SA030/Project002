package examples;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public HelloServlet() {
    super();
  }
  //
  // @Override
  // public void init(ServletConfig config) throws ServletException {
  // System.out.println("init test 호출");
  // }
  //
  // @Override
  // public void destroy() {
  // System.out.println("destory 호출");
  // }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    // System.out.println("service 호출");

    response.setContentType("text/html;charset-UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head><title>form</title></head>");
    out.println("<body>");

    // Enumeration<String> headerNames = request.getHeaderNames();
    // while (headerNames.hasMoreElements()) {
    // String headerName = headerNames.nextElement();
    // String headerValue = request.getHeader(headerName);
    // out.println(headerName + ":" + headerValue + "<br>");
    // }


    // String name = request.getParameter("name");
    // String age = request.getParameter("age");
    // out.println("name : " + name + "<br>");
    // out.println("age : " + age + "<br>");


    String uri = request.getRequestURI();
    StringBuffer url = request.getRequestURL();
    String contentPath = request.getContextPath();
    String remoteAddr = request.getRemoteAddr();
    out.println("uri : " + uri + "<br>"); // uri : /web_project001/HelloServlet
    out.println("url : " + url + "<br>"); // url : http://localhost:8080/web_project001/HelloServlet
    out.println("contentPath : " + contentPath + "<br>"); // contentPath : /web_project001
    out.println("remoteAddr : " + remoteAddr + "<br>"); // remoteAddr : 0:0:0:0:0:0:0:1

    out.println("</body>");
    out.println("</html>");

  }



  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
