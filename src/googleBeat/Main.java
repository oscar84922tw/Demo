package googleBeat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class Main {
	int[] total = new int[100];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String queryStr = sc.nextLine();
			GoogleSearch qSearch = new GoogleSearch(queryStr);
			HashMap<String, String> results = qSearch.getResults();

			for (Entry<String, String> entry : results.entrySet()) {
				String title = entry.getKey();
				String url = entry.getValue();
				// System.out.println(title + "\n" + url);
				try {
					WebNode rootNode = new WebNode(new WebPage(title, url));
					Crawler node = new Crawler(url);
					ArrayList<String> resultNode = node.getResults();
					try {
						for (int i = 0; i < resultNode.size(); i++) {
							// System.out.println("hi");
							// String titleString = entry2.getKey();
							String urlString = resultNode.get(i);
							// System.out.println(" " + titleString + "\n "
							// + urlString);
							System.out.println(urlString);
						}
					} catch (Exception exception) {
						exception.printStackTrace();
					}
				} catch (Exception e) {
					// e.printStackTrace();
				}
				// }

			}
			System.out.println("Done");
			// sc.close();
		}
		sc.close();
	}

}