package googleBeat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String queryStr = sc.nextLine();
			GoogleSearch qSearch = new GoogleSearch(queryStr);
			HashMap<String, String> results = qSearch.getResults();
			for (Entry<String, String> entry : results.entrySet()) {
				String title = entry.getKey();
				String url = entry.getValue();
				System.out.println(title + "\n " + url);
				try {
					KeywordCounter xCounter = new KeywordCounter(url);
					System.out.println(xCounter.getPage());
				} catch (FileNotFoundException ex) {
					ex.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Done");
		sc.close();
	}
}
