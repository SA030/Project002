import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

public class GetHtml {
    String urlToRead;
	String html;

	GetHtml(String urlToRead){
		this.urlToRead = urlToRead;
		this.html = getHttpHTML(this.urlToRead);
	}

    private static String getHttpHTML(String urlToRead) {
        URL url;
        HttpURLConnection conn;
        BufferedReader rd;
        String line;
        String result = "";
        try {
            url = new URL(urlToRead);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = rd.readLine()) != null) {
                result += line + "\n";
            }
            rd.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
