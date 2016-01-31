package history.value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.http.*;

import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.appengine.labs.repackaged.org.json.JSONTokener;
import com.google.appengine.repackaged.com.google.api.client.util.IOUtils;
import com.opencsv.CSVParser;
import com.opencsv.CSVReader;

import classes.HistoricalValuess;

@SuppressWarnings("serial")
public class HistoricalValueServlet extends HttpServlet {
	
	double lat;
	double lng;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		
		String var1 =  req.getParameter("var1");
		String var2 =  req.getParameter("var2");
		char dol = '$';
		char fig = '}';
		
		
		URL url = new URL("http://localhost:8888/csv/1.csv");
		//TODO URL url = new URL("http://examples-web.appspot.com/io/districts.csv");
		
		
		//обязательно укажите кодировку иначе на сервере AppEngine будут проблемы с кодировкой
		CSVReader reader = new CSVReader(
				new InputStreamReader(url.openStream()),
				dol, CSVParser.DEFAULT_QUOTE_CHARACTER,
				1);

		String[] nextLine;

		// Создание пустого массива bridges с объектами класса BridgeClass
		ArrayList<HistoricalValuess> bridges = new ArrayList<HistoricalValuess>();
		// Заполнение массива данными из файла
		while ((nextLine = reader.readNext()) != null) {
			bridges.add(new HistoricalValuess(nextLine));	
		}
		
		boolean bool = true;
		for (int k = 0; k < 367; k++) {
			//resp.getWriter().println(bridges.get(k).getWho());
			if (bridges.get(k).getWho().contains(var1) && bridges.get(k).getWho().contains(var2)) {
				resp.getWriter().println(bridges.get(k).getWho() + " " + bridges.get(k).getWhen());
				bool = false;
			} 
		}
		if (bool) {
			String addres = "Санкт-Петербург, " + var1 + " " + var2;
			try {
				geocoding(addres);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.getWriter().println("Адреса нет в списке объектов культуного наследия: " + var1 + ", " + var2 + "; широта: " + lat + 
					"; долгота: " + lng);
		} else {
			String address = "Санкт-Петербург, " + var1 + " " + var2;
			try {
				geocoding(address);
				resp.getWriter().println("широта: " + lat + "; долгота: " + lng);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*resp.getWriter().println("<script>");
		resp.getWriter().println("function initialize() {");
		resp.getWriter().println("var myLatlng = new google.maps.LatLng(" + lat + ", " + lng + ");");
		resp.getWriter().println("var mapOptions = {");
		resp.getWriter().println("zoom : 11,");
		resp.getWriter().println("center : myLatlng");
		resp.getWriter().println("};");
		resp.getWriter().println("map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);");
		resp.getWriter().println("var contentString = '<div id=\"content\">'");
		resp.getWriter().println("+ '<div id=\"siteNotice\">'");
		resp.getWriter().println("+ '</div>'");
		resp.getWriter().println("+ '<h1 id=\"firstHeading\" class=\"firstHeading\">Сургут</h1>'");
		resp.getWriter().println("+ '<div id=\"bodyContent\">'");
		resp.getWriter().println("+ '<p><b>Сургут</b>, мой дом.</p>' + '</div>' + '</div>';");	
		resp.getWriter().println("var contentString2 = 'TEST';");
		resp.getWriter().println("var infowindow = new google.maps.InfoWindow({");
		resp.getWriter().println("content : contentString");
		resp.getWriter().println("});");
		resp.getWriter().println("var marker = new google.maps.Marker({");
		resp.getWriter().println("position : myLatlng,");
		resp.getWriter().println("map : map,");
		resp.getWriter().println("title : 'Сургут (мой дом)'");
		resp.getWriter().println("});");
		resp.getWriter().println("google.maps.event.addListener(marker, 'click', function() {");
		resp.getWriter().println("infowindow.open(map, marker);");
		resp.getWriter().println("});");
		resp.getWriter().println("}");
		resp.getWriter().println("function createMarker(myLatlng, contentString, mytitle) {");
		resp.getWriter().println("marker = new google.maps.Marker({");
		resp.getWriter().println("position : myLatlng,");
		resp.getWriter().println("map : map,");
		resp.getWriter().println("title : mytitle");
		resp.getWriter().println("});");
		resp.getWriter().println("infowindow = new google.maps.InfoWindow({");
		resp.getWriter().println("content : contentString");
		resp.getWriter().println("});");
		resp.getWriter().println("google.maps.event.addListener(marker, 'click', function() {");
		resp.getWriter().println("infowindow.open(map, marker);");
		resp.getWriter().println("});");
		resp.getWriter().println("}");
		resp.getWriter().println("google.maps.event.addDomListener(window, 'load', initialize);");
		resp.getWriter().println("</script>");*/
		//resp.getWriter().println("<div id=\"map-canvas\"></div>");

		//resp.getWriter().println(bridges.get(0).getWho());
		//resp.getWriter().println(bridges.get(2).getWho());
		
		
		reader.close();
		
	}
	public void geocoding(String addr) throws Exception
	{
	    // build a URL
	    String s = "http://maps.google.com/maps/api/geocode/json?" +
	                    "sensor=false&address=";
	    s += URLEncoder.encode(addr, "UTF-8");
	    URL url = new URL(s);
	 
	    // read from the URL
	    Scanner scan = new Scanner(url.openStream());
	    String str = new String();
	    while (scan.hasNext())
	        str += scan.nextLine();
	    scan.close();
	 
	    // build a JSON object
	    JSONObject obj = new JSONObject(str);
	    //if (! obj.getString("status").equals("OK"))
	    //    return;
	 
	    // get the first result
	    JSONObject res = obj.getJSONArray("results").getJSONObject(0);
	    System.out.println(res.getString("formatted_address"));
	    JSONObject loc =
	        res.getJSONObject("geometry").getJSONObject("location");
	    System.out.println("lat: " + loc.getDouble("lat") +
	                        ", lng: " + loc.getDouble("lng"));
	    lat = loc.getDouble("lat");
	    lng =  loc.getDouble("lng");
	}
}
