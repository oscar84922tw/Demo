package googleBeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	private String strUrl;
	private String content;

	public Crawler(String strUrl) {
		this.strUrl = strUrl;
	}

	private String fetchCountent() throws IOException {
		URL url = new URL(strUrl);

		URLConnection conn = url.openConnection(); // URLConnection只能由URL物件生成
		conn.setRequestProperty("user-agent", "Chrome/47.0.2526.106");
		conn.setRequestProperty("accept-language",
				"zh-TW,zh;q=0.8,en-US;q=0.6,en;q=0.4");
		conn.setRequestProperty("accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String retVal = "";

		String line = null;
		while ((line = br.readLine()) != null) {
			retVal += (line + "\n");

		}
		return retVal;

	}

	public HashMap<String, String> getResults() throws IOException {

		HashMap<String, String> retVal = new HashMap<>();
		if (content == null) {
			content = fetchCountent();

		}
		Document doc = Jsoup.parse(content);
		Elements hrefs = doc.select("a");
		for (Element href : hrefs) {
			try {
				Element hr = href.select("href").get(0);
				String url = hr.attr("href");
				String title = href.select("href").get(0).text();
				System.out.println(title+"hi");
				retVal.put(title, url);
			} catch (IndexOutOfBoundsException ex) {

			}
		}
		return retVal;

	}

}
