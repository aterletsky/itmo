package history.value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.http.*;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;

import classes.HistoricalValuess;

@SuppressWarnings("serial")
public class HistoricalValueServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		

		String var1 =  req.getParameter("var1");
		String var2 =  req.getParameter("var2");
		
		
		
		URL url = new URL("http://localhost:8888/csv/csv2.csv");
		//TODO URL url = new URL("http://examples-web.appspot.com/io/districts.csv");
		
		
		//обязательно укажите кодировку иначе на сервере AppEngine будут проблемы с кодировкой
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				url.openStream(),"UTF-8"));
		
		String line;
		String newLine = "";
		
		for (int i = 0; (line = reader.readLine()) != null; i++) {
			if (i > 0) {
				//парсинг данных строки из CSV происходит c помощью метода String.split(), то есть разделением строки по символу ","
				//такой способ подходит только для простых файлов, лучше использовать OpenCSV
				
				//String[] values = line.split(",");

				
				String str = line;
				char[] char11 = str.toCharArray();
				int length = str.length();
				int konets = 0;
				for (int j = 0; j > length-1; j++) {
					resp.getWriter().println("daaaa");
					String strr = String.valueOf(char11[j]);
					if (strr.equals("$")) {
						for (int n = konets; n > j-1; n++) {
							newLine += char11[n];
							System.out.println("daaaaa");
						}
						konets = j+1;
					}
				}
				//resp.getWriter().println(values[1] + " " + values[0] + " " + values[2]);
				//resp.getWriter().println(str);
			}
			
		}
		resp.getWriter().println(newLine + " ya");
		reader.close();
		
	}
}
