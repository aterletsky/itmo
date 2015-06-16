package tersletsky.ru;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.*;

import except.StringException;
import except.NumberException;
import except.DateException;
import except.SubStringException;

@SuppressWarnings("serial")
public class Exceptions extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html; charset=cp1251");
		if (req.getParameter("task").equals("1")) {
			String enteredString = req.getParameter("var1");
			try {
				checkNumber(enteredString);
				resp.getWriter().print("Это действительно чило");
			} catch (NumberException e) {
				resp.getWriter().print(e);
			}
		} else if (req.getParameter("task").equals("2")) {
			String enteredString = req.getParameter("var1");
			try {
				checkDate(enteredString);
				resp.getWriter().print("Это действительно дата");
			} catch (DateException e) {
				resp.getWriter().print(e);
			}
		} else if (req.getParameter("task").equals("3")) {
			Zad substr = new Zad(String.valueOf(Math.PI));
			String enteredString = req.getParameter("var1");
			try {
				checkSubString(substr.getAnswer(), enteredString);
				resp.getWriter().print("В PI присутствует введенная комбинация цифр");
			} catch (SubStringException e) {
				resp.getWriter().print(e);
			}
		} else if (req.getParameter("task").equals("4")) {
			Zad captcha = new Zad("CaPtChA");
			String enteredString = req.getParameter("var1");
			try {
				checkString(enteredString, captcha.getAnswer());
				resp.getWriter().print("Это действительно капча");
			} catch (StringException e) {
				resp.getWriter().print(e);
			}
		}

	}

	static void checkNumber(String str) throws NumberException {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException eDef) {
			NumberException e = new NumberException("Это не число");
			throw e;
		}
	}

	static void checkDate(String str) throws DateException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(str.trim());
		} catch (ParseException eDef) {
			DateException e = new DateException("Это не дата");
			throw e;
		}
	}

	static void checkString(String str, String ans) throws StringException {
		if (!(str.equals(ans))) {
			StringException e = new StringException(
					"Не правильно. Повторите попытку");
			throw e;
		}
	}
	
	static void checkSubString(String str, String substr)
			throws SubStringException {
		if (!(str.contains(substr))) {
			SubStringException e = new SubStringException("В PI введенная комбинация цифр отсутствует");
			throw e;
		}
	}

}