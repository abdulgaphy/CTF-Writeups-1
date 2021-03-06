package lasaCTF.Postman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Postman{
	
	public static void main(String args[]) throws IOException{
			System.out.println(getUrlSource("http://web.lasactf.com:45025/"));
	}
	
	 private static String getUrlSource(String url) throws IOException {
         URL yahoo = new URL(url);
         URLConnection yc = yahoo.openConnection();
         //common examples of user-agents
         //IE: Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0)
         //FF: Mozilla/5.0 (Windows NT 6.3; rv:36.0) Gecko/20100101 Firefox/36.0
         yc.setRequestProperty("user-agent", "Google Ultron");
         yc.addRequestProperty("SpecialAuth", "Kyle");
         yc.setRequestProperty("referer", "kyleisacoolguy.org");
         BufferedReader in = new BufferedReader(new InputStreamReader(
                 yc.getInputStream(), "UTF-8"));
         String inputLine;
         StringBuilder a = new StringBuilder();
         while ((inputLine = in.readLine()) != null)
             a.append(inputLine);
         in.close();

         return a.toString();
     }
}