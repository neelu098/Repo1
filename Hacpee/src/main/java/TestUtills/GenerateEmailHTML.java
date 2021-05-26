package TestUtills;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import hacpee.pages.TestExecutor;

public class GenerateEmailHTML extends TestExecutor {
	
	File file = null;
	Writer wr = null;
	
	public void SendMail() {
		
	}
	
	public void createHTMLFile() throws IOException
	{
		String path = userDir +"/resources/EmailHTML.html";
		file = new File(path);
		wr = new FileWriter(file, false);
	}
	
	public void writeHTML() throws IOException
	{
		createHTMLFile();
		wr.write("<html>");
		wr.write("<body bgcolor=\"#F8F2FF\">");
		wr.write("</br>");
		
		wr.write("<h1 align=\"center\"><span style=\"color: #00008b; font-family: Calibri;\">HACP EE Smoke Test Cases "+getEnvironment()+"</span></h1>");
		//wr.write("<h1 align=\"center\"><span style=\"color: #00008b; font-family: Calibri;\">HACP EE Smoke Test Cases "+"</span></h1>");
		
		wr.write("</br></br>");
		wr.write("<table border=0 cellSpacing=2 cellPadding=3 width='100%'>");
		wr.write("<tbody>");
		wr.write("<tr>");
		wr.write("<td style=\"text-align: center;\" bgcolor=\"#B284BE\" width=\"25%\"><span><font face='arial' color='#103357' size=3><strong><b>Scenario</b></strong></span></td>");
		wr.write("<td style=\"text-align: center;\" bgcolor=\"#B284BE\" width=\"10%\"><span><font face='arial' color='#103357' size=3><strong><b>Environment</b></strong></span></td>");
		wr.write("<td style=\"text-align: center;\" bgcolor=\"#B284BE\" width=\"20%\"><span><font face='arial' color='#103357' size=3><strong><b>URL</b></strong></span></td>");
		wr.write("<td style=\"text-align: center;\" bgcolor=\"#B284BE\" width=\"10%\"><span><font face='arial' color='#103357' size=3><strong><b>Status</b></strong></span></td>");
		wr.write("<td style=\"text-align: center;\" bgcolor=\"#B284BE\" width=\"35%\"><span><font face='arial' color='#103357' size=3><strong><b>Reason (if any)</b></strong></span></td>");
		wr.write("</tr>");
	}
	
	public void writeRow(String module, String reason) throws IOException{
		wr.write("<tr>");
		wr.write("<td style=\"text-align: center;\" bgcolor=\"#d8bfd8\" width=\"25%\"><font face='arial' color='#191757' size=2><b>"+module+"</b></td>");
		String str = getData("Environment");
		wr.write("<td style=\"text-align: center;\" bgcolor=\"#d8bfd8\" width=\"10%\"><font face='arial' color='#191757' size=2><b>"+str+"</b></td>");
		wr.write("<td style=\"text-align: center;\" bgcolor=\"#d8bfd8\" width=\"20%\"><font face='arial' color='#191757' size=2><b><a href=\""+getURL(str)+"\">"+getURL(str)+"</a></b></td>");
		if(logger.getRunStatus().toString().toUpperCase().equals("PASS")){
			wr.write("<td style=\"text-align: center;\" bgcolor=\"#84DE02\" width=\"10%\"><font face='arial' color='#191757' size=2><b>"+logger.getRunStatus().toString().toUpperCase()+"</b></td>");
			wr.write("<td style=\"text-align: center;\" bgcolor=\"#d8bfd8\" width=\"35%\">-</td>");
		}
		else{
			wr.write("<td style=\"text-align: center;\" bgcolor=\"#D3212D\" width=\"10%\"><font face='arial' color='#191757' size=2><b>"+logger.getRunStatus().toString().toUpperCase()+"</b></td>");
			wr.write("<td style=\"text-align: center;\" bgcolor=\"#d8bfd8\" width=\"35%\"><font face='arial' color='#191757' size=2>"+reason+"</td>");
		}
		
		wr.write("</tr>");		
	}
	
	public void save() throws IOException
	{
		wr.write("</tbody>");
		wr.write("</table>");
		wr.write("</body>");
		wr.write("</html>");
		wr.flush();
		wr.close();
	}
	
	public String getURL(String env)
	{
		String url = null;
		switch(env)
		{
		case "HACPEE 1.9":
			url =  "https://tetdemos.hclpnp.com/hex/phase1.html";
			break;
		case "HACPEE 1.10":
			url =  "https://tetdemos.hclpnp.com/hex/phase1.html";
			break;
		}
		return url;
	}
	
	public String getDayOfWeek()
	{
		Date now = new Date();
		SimpleDateFormat date = new SimpleDateFormat("E");
		return date.format(now);
	}
	
	public String getEnvironment()
	{
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		String day = getDayOfWeek();
		//return format.format(date).toString();
		if(day.equals("Tue"))
			return "(" + format.format(date).toString() + ")" ;
		else if(day.equals("Wed"))
			return "(" + format.format(date).toString() + ")" ;
		return "(" + format.format(date).toString() + ") ";
	}
}
