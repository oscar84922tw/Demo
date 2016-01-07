package googleBeat;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class KeywordCounter {
	private String urlStr;
	private String content;

	public KeywordCounter(String urlStr) {
		this.urlStr = urlStr;

	}

	private String fetchCountent() throws IOException {
		URL url = new URL(this.urlStr);
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in,
				"UTF-8"));

		String retVal = "";
		String line = null;
		while ((line = br.readLine()) != null) {

<<<<<<< HEAD
<<<<<<< HEAD
		return retVal;
=======
	}
	public String pagesInfo() throws IOException{
		return fetchCountent();
>>>>>>> origin/master
=======
			retVal += (line + "\n");

		}
		return retVal;

	}

	public String getPage() throws IOException {
		return fetchCountent();
>>>>>>> parent of d13f6cd... try
	}
	public int countKeyword(String keyword) throws IOException {
		if (content == null) {
			content = fetchCountent();
		}
		int retVal = 0;
		int fromIdx = 0;
		int found = -1;
		while ((found = content.indexOf(keyword, fromIdx)) != -1) {
			// type type = (type) (found = content.nextElement();
			retVal++;
			fromIdx = found + keyword.length();
		}
		return retVal;
	}

}