package googleBeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class GoogleSearch {
	private String queryStr;
	private String content;

	public GoogleSearch(String queryStr) {
		this.queryStr = queryStr;
	}

	private String fetchCountent() throws IOException {
		URL url = new URL("http://www.google.com/search?q=" + queryStr
				+ "&num=50&oe=utf-8");
		URLConnection conn = url.openConnection(); // URLConnection���URL�隞嗥���
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
		Elements divGs = doc.select("li.g");
		for (Element divG : divGs) {
			try {
				Element h3R = divG.select("h3.r").get(0);
				Element aTag = h3R.select("a[href]").get(0);
				String title = aTag.text();
				String url = aTag.attr("href");

				retVal.put(title, url.substring(7, url.indexOf("&sa")));

			} catch (IndexOutOfBoundsException ex) {

			}

		}

		return retVal;

	}

}
