package tersletsky.ru;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class FourthServlet extends HttpServlet {

	public static String dextohex(long g) {
		String result = new String();
		do {
			long res = g % 16;
			g = g / 16;
			if (res == 10)
				result = "A" + result;
			else if (res == 11)
				result = "B" + result;
			else if (res == 12)
				result = "C" + result;
			else if (res == 13)
				result = "D" + result;
			else if (res == 14)
				result = "E" + result;
			else if (res == 15)
				result = "F" + result;
			else
				result = res + result;
		} while (g > 16);
		if (g != 0)
			result = g + result;
		return result;
	}

	public static void zad1(String a, String b, HttpServletResponse resp)
			throws IOException {
		long ch1 = Long.parseLong(a), ch2 = Long.parseLong(b);
		if (ch1 > ch2) {
			long temp = ch2;
			ch2 = ch1;
			ch1 = temp;
		}
		if (ch1 < 0 || ch2 < 0) {
			resp.getWriter().println("введены отрицательные числа");
			return;
		}
		if (ch1 > 113021 || ch2 > 113021) {
			resp.getWriter().println(
					"эти символы ещё не разработанны" + "<br>"
							+ "ограничтесь числом 113021");
			return;
		}
		resp.getWriter().println("<table>");
		resp.getWriter().println("<tr>");
		int dec = 0;
		for (long t = ch1; t <= ch2; t++) {
			if (dec == 10) {
				resp.getWriter().println("</tr>");
				resp.getWriter().println("<tr>");
				dec = 0;
			}
			dec++;
			resp.getWriter().println("<td>");
			char ret = (char) t;
			resp.getWriter().println(ret + "</td>");
		}
		resp.getWriter().println("</tr>");
		resp.getWriter().println("</table>");
	}

	public static void zad2(String a, String b, HttpServletResponse resp)
			throws IOException {
		long ch1 = Long.parseLong(a), ch2 = Long.parseLong(b);
		if (ch1 > ch2) {
			long temp = ch2;
			ch2 = ch1;
			ch1 = temp;
		}
		if (ch1 < 0 || ch2 < 0) {
			resp.getWriter().println("введены отрицательные числа");
			return;
		}
		if (ch1 > 113021 || ch2 > 113021) {
			resp.getWriter().println(
					"эти символы ещё не разработанны" + "<br>"
							+ "ограничтесь числом 113021");
			return;
		}
		resp.getWriter().println(
				"<table border=" + "1" + "bgcolor=" + "#FAC864" + ">");
		resp.getWriter().println("<tr>");
		int dec = 0;
		for (long t = ch1; t <= ch2; t++) {
			if (dec == 10) {
				resp.getWriter().println("</tr>");
				resp.getWriter().println("<tr>");
				dec = 0;
			}
			dec++;
			resp.getWriter().println("<td>");
			resp.getWriter().println(t + " " + "<br>");
			char ret = (char) t;
			resp.getWriter().println(ret);
			resp.getWriter().println("<br>");
			resp.getWriter().println(" " + dextohex(t));
			resp.getWriter().println("</td>");
		}
		resp.getWriter().println("</tr>");
		resp.getWriter().println("</table>");
	}

	public static void skrit(HttpServletResponse resp) throws IOException {
		resp.getWriter().println(" ");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("utf-8");
		if (req.getParameter("flag").equals("1")) {
			zad1(req.getParameter("chis1"), req.getParameter("chis2"), resp);
		} else if (req.getParameter("flag").equals("2")) {
			zad2(req.getParameter("chis3"), req.getParameter("chis4"), resp);
		} else if (req.getParameter("flag").equals("3")) {
			skrit(resp);
		} else if (req.getParameter("flag").equals("4")) {
			skrit(resp);
		}

	}
}

