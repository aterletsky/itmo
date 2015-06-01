package tersletsky.ru;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ThirdServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String var1 = req.getParameter("var1");
		int i1 = Integer.parseInt(var1);
		int otklon1 = 0;
		String var2 = req.getParameter("var2");
		int i2 = Integer.parseInt(var2);
		int otklon2 = 0;
		int result;
		if (i1 > 10) {
			otklon1 = i1 - 10; 
		} else {
			otklon1 = 10 - i1;
		}
		if (i2 > 10) {
			otklon2 = i2 - 10; 
		} else {
			otklon2 = 10 - i2;
		}
		if (otklon1 > otklon2) {
			result = i2;
		} else {
			result = i1;
		}
		resp.getWriter().println(result);
	}
	
}
