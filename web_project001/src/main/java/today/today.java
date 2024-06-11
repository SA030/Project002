package today;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class today extends HttpServlet {
  private static final long serialVersionUID = 1L;


  public today() {
    super();
    // TODO Auto-generated constructor stub
  }


  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    // 응답의 Content Type과 인코딩 설정
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");

    // PrintWriter 객체를 이용하여 클라이언트로 응답 데이터를 보낼 수 있습니다.
    PrintWriter out = response.getWriter();

    // 현재 시간을 구하기 위해 Date 객체를 생성합니다.
    Date currentDate = new Date();

    // 날짜 포맷을 지정합니다. 여기서는 "yyyy/MM/dd HH:mm" 형식으로 지정합니다.
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");

    // 현재 시간을 포맷에 맞게 문자열로 변환합니다.
    String formattedDate = dateFormat.format(currentDate);

    // 클라이언트로 현재 시간을 응답합니다.
    out.println("<html>" + "<head><title>Insert title here</title></head>");
    out.println("<body>");
    out.println("<a href='aboutme/index.html'><div>메인화면</div></a>");
    out.println("<div style='text-align: center;'><h1>현재시간 : " + formattedDate + "</h1></div>");
    out.println("</body>");
    out.println("</html>");

    // PrintWriter를 닫습니다.
    out.close();
  }


  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
