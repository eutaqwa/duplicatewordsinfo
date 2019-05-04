

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import javax.servlet.RequestDispatcher;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.Set;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String removeDuplicate(String txt, String splitterRegex) {
		Pattern p = Pattern.compile(splitterRegex, Pattern.CASE_INSENSITIVE);
		 
        Matcher z = p.matcher(txt);
        while (z.find()) {
            txt = txt.replaceAll(z.group(), z.group(1));}
        return txt;
	}
	//public static Set <String> duplicateWords(String input) {
		//if(input==null||input.isEmpty()){
			//return Collections.emptySet();
		//}
		//Set <String> duplicates = new HashSet<>();
		//String[]words = input.split("\\.|\\s+");
		//Set <String> set = new HashSet<>();
		//for (String word : words){
			//if(!set.add(word)){
				//duplicates.add(word);
			//}
		//}
		//return duplicates;
	//}
	public static Map<String,List<Integer>> duplicateWords(String[] input) {
		Map<String, List<Integer>> mappedWord = new HashMap<String, List<Integer>>();
		for (int i = 0; i < input.length; i++) {

			List<Integer> count = mappedWord.get(input[i]);
			if (count == null) {
				count = new ArrayList<>();
			}
			count.add(i);
			mappedWord.put(input[i], count);
		}
		return mappedWord;
	
	}
	//public static Set<String> dwInfo(Map<String, List<Integer>> w){
	//for (Map.Entry<String, List<Integer>> entry : w.entrySet()) {
		//List<Integer> value = entry.getValue();
		//if (value.size() > 1) {
			//pw.println(" [" + entry.getKey() + ", " + value.size() +", "+ value.get(0) +"]" +"<br>");
		//}
	//}}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("input");
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("dd MMMMMMMMMM yyyy");
		String dates = date.format(today);
		PrintWriter pw = response.getWriter();
		
		//Set<String> duplicateWords = duplicateWords(name);
		String namelow = name.toLowerCase(); 
		String nameSplitted[] =  namelow.split("[\\s,;]+");
		name = removeDuplicate(name, "\\b(\\w+)(\\s+\\1\\b)+");
		Map<String, List<Integer>> duplicateWords = duplicateWords(nameSplitted);
		//request.setAttribute("nama", name);
		//request.setAttribute("masukan", request.getParameter("input"));
		//request.setAttribute("tanggal", dates);
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/index2.jsp");
		//dispatcher.forward(request,  response);
		pw.print("<body>");
		pw.print("<h1><font size ='7' face = 'Century,Arial' color='green'>T</font>ABLE</h1>");
		pw.print("<hr>");
		pw.print("<table border='1' cellpadding='24' cellspacing='3'>");
		pw.print("<tbody><tr bgcolor='silver'>");
		pw.print("<td><center>NO</center></td>");
		pw.print("<td><center>Input</center></td>");
		pw.print("<td><center>Output</center></td>");
		pw.print("<td><center>Tanggal</center></td>");
		pw.print("<td><center>Kata Berulang</center></td></tr>");
		pw.print("<tr><td>1</td>");
		pw.print("<td>" + request.getParameter("input") + "</td>");
		pw.print("<td>" + name  +"</td>");
		pw.print("<td>" + dates +"</td>");
		//pw.print("<td>" + duplicateWords + "</td>");
		pw.print("<td>");
		for (Map.Entry<String, List<Integer>> entry : duplicateWords.entrySet()) {
			List<Integer> value = entry.getValue();
			if (value.size() > 1) {
				pw.println(" [" + entry.getKey() + ", " + value.size() +", "+ value.get(0) +"]" +"<br>");
			}}
		pw.print("</td></tr>");
		pw.print("</tr></tbody></table>");
		pw.print("</form></body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
