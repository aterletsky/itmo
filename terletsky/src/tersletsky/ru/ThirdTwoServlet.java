package tersletsky.ru;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ThirdTwoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String var1 = req.getParameter("var1");
		int i1 = Integer.parseInt(var1);
		String var2 = req.getParameter("var2");
		int i2 = Integer.parseInt(var2);
		String var3 = req.getParameter("var3");
		int i3 = Integer.parseInt(var3);
		int x1 = 0;
		int x2 = 0;
		int diskr = 0;
		diskr = i2 * i2 - 4 * i1 * i3;
		if (diskr > 0) {
			x1 = (int) ((-i2 + Math.sqrt(diskr))/(2 * i1));
			x2 = (int) ((-i2 - Math.sqrt(diskr))/(2 * i1));
			resp.getWriter().println("X1 = " + x1 + ", X2 = " + x2 + ".");
		}
        if (diskr == 0) {
			x1 = (-i2)/(2 * i1);
        	resp.getWriter().println("X1 è X2 = " + x1 + ".");
		}
        if (diskr < 0) {
        	resp.getWriter().println("Uravneniye ne imeet korney");
        }
		
	}
	
}
