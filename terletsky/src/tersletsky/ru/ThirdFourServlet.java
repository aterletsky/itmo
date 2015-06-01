package tersletsky.ru;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ThirdFourServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String var1 = req.getParameter("var1");
		int i1 = Integer.parseInt(var1);
		String var2 = req.getParameter("var2");
		int i2 = Integer.parseInt(var2);
		long t = 1;
		int ret = 0;
		boolean flag = false;
		int maxint = -99;
		Random rnd = new Random();
		resp.getWriter().println(
				"<table border=" + "1" + "bgcolor=" + "#FAC864" + ">");
		resp.getWriter().println("<tr>");
		int dec = 0;
		for (t = 1; t <= i1*i2; t++) {
			if (dec == i2) {
				resp.getWriter().println("</tr>");
				resp.getWriter().println("<tr>");
				dec = 0;
			}
			dec++;
			resp.getWriter().println("<td>");
			flag = rnd.nextBoolean();
			if (flag){
			ret = rnd.nextInt(100);
			
			} else {
				ret = - rnd.nextInt(100);
			}
			if (ret > maxint) {
				maxint = ret;
			}
			resp.getWriter().println(ret + "</td>");
		}
		resp.getWriter().println("</tr>");
		resp.getWriter().println("</table>");
		resp.getWriter().println("Maximum: " + maxint);
	}
	
}
