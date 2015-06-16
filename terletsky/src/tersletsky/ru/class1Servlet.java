package tersletsky.ru;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class class1Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String var1 = req.getParameter("var1");
		String var2 = req.getParameter("var2");
		String var3 = req.getParameter("var3");
		String var4 = req.getParameter("var4");
		String var5 = req.getParameter("var5");
		MobilePhone iPhone = new MobilePhone();
		MobilePhone Nexus = new MobilePhone();
		MobilePhone Meizu = new MobilePhone();
		MobilePhone SGS = new MobilePhone();
		MobilePhone Yota = new MobilePhone();
		MobilePhone Nokia = new MobilePhone();
		if (var5.equals("5")) {
		
		resp.getWriter().println(
				"<table>");
		resp.getWriter().println("<tr>");
		int dec = 0;
		for ( long t = 1; t <= 6; t++) {
			if (dec == 1) {
				resp.getWriter().println("</tr>");
				resp.getWriter().println("<tr>");
				dec = 0;
			}
			dec++;
			String ret = "";
			if (t == 1) {
			ret = "1. Apple";
			} else if (t == 2) {
				ret = "2. LG";
			} else if (t == 3) {
				ret = "3. Meizu";
			} else if (t == 4) {
				ret = "4. Samsung";
			} else if (t == 5) {
				ret = "5. Yota";
			} else {
				ret = "6. Nokia";
			}
			resp.getWriter().println("<td>");
			resp.getWriter().println(ret + "</td>");
		}
		resp.getWriter().println("</tr>");
		resp.getWriter().println("</table>");
		/*
		resp.getWriter().println("<option value=" + "0" + ">");
		resp.getWriter().println(iPhone.getManufacturer());
		resp.getWriter().println("</option>");
		
		resp.getWriter().println("<option value=" + "1" + ">");
		resp.getWriter().println(Nexus.getManufacturer());
		resp.getWriter().println("</option>");
		
		resp.getWriter().println("<option value=" + "2" + ">");
		resp.getWriter().println(Meizu.getManufacturer());
		resp.getWriter().println("</option>");
		
		resp.getWriter().println("<option value=" + "3" + ">");
		resp.getWriter().println(SGS.getManufacturer());
		resp.getWriter().println("</option>");
		
		resp.getWriter().println("<option value=" + "4" + ">");
		resp.getWriter().println(Yota.getManufacturer());
		resp.getWriter().println("</option>");
		
		resp.getWriter().println("<option value=" + "5" + ">");
		resp.getWriter().println(Nokia.getManufacturer());
		resp.getWriter().println("</option>");*/
		}
if (var5.equals("4")) {
	String operation = req.getParameter("operation");
	String result;
	iPhone.setInfo("Apple", "iPhone 6 Plus", "USA");
	Nexus.setInfo("LG", "Nexus 5", "USA");
	Meizu.setInfo("Meizu", "MX4", "China");
	SGS.setInfo("Samsung", "Galaxy S6 Edge", "South Korea");
	Yota.setInfo("Yota", "YotaPhone 2", "Russia");
	Nokia.setInfo("Nokia", "3310", "Finland");
	if(operation.equals("0")){
		result = "Company: " + iPhone.getManufacturer() + ", Model: " + iPhone.getModel() + ", Made in " + iPhone.getMadeIn();
	} else if(operation.equals("1")){
		result = "Company: " + Nexus.getManufacturer() + ", Model: " + Nexus.getModel() + ", Made in " + Nexus.getMadeIn();
	} else if (operation.equals("2")){
		result = "Company: " + Meizu.getManufacturer() + ", Model: " + Meizu.getModel() + ", Made in " + Meizu.getMadeIn();
	} else if (operation.equals("3")){
		result = "Company: " + SGS.getManufacturer() + ", Model: " + SGS.getModel() + ", Made in " + SGS.getMadeIn();
	} else if (operation.equals("4")){
		result = "Company: " + Yota.getManufacturer() + ", Model: " + Yota.getModel() + ", Made in " + Yota.getMadeIn();
	} else {
		result = "Company: " + Nokia.getManufacturer() + ", Model: " + Nokia.getModel() + ", Made in " + Nokia.getMadeIn();
	}
	resp.getWriter().println(result);
}

	}
	
}
