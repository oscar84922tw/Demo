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
<<<<<<< HEAD
<<<<<<< HEAD
	private ArrayList<Keyword> keywords;
	public ArrayList<Website> roots;

	public static void main(String[] args) throws IOException {
		ArrayList<Keyword> keywords = new ArrayList<>();
		keywords.add(new Keyword("shoe", 3));
		keywords.add(new Keyword("footwear", 3));
		keywords.add(new Keyword("sport", 3));
		keywords.add(new Keyword("sneakers", 3));
		keywords.add(new Keyword("Converse", 10));
		keywords.add(new Keyword("Nike", 10));
		keywords.add(new Keyword("Under Armour", 10));
		keywords.add(new Keyword("DADASUPREME", 10));
		keywords.add(new Keyword("New Balance", 10));
		keywords.add(new Keyword("Vans", 10));
		keywords.add(new Keyword("TOMS", 10));
		keywords.add(new Keyword("SKECHERS", 10));
		keywords.add(new Keyword("Pony", 10));
		keywords.add(new Keyword("SWISS", 10));
		keywords.add(new Keyword("Timberland", 10));
		keywords.add(new Keyword("Native Shoes", 10));
		keywords.add(new Keyword("Playboy", 10));
		keywords.add(new Keyword("Soludos", 10));
		Resort beatGoogle = new Resort(keywords);
		ArrayList<Website> resultWebs = beatGoogle.query("Fallout");
		// Scanner sc = new Scanner(System.in);
		// while (sc.hasNextLine()) {
		// String queryStr = sc.nextLine();
		// GoogleSearch qSearch = new GoogleSearch(queryStr);
		// HashMap<String, String> results = qSearch.getResults();
		//
		// for (Entry<String, String> entry : results.entrySet()) {
		// String title = entry.getKey();
		// String url = entry.getValue();
		// System.out.println(title + "\n" + url);
		// try {
		// Crawler node = new Crawler(url);
		// HashMap<String, String> resultNode = node.getResults();
		// for (Entry<String, String> entry2 : resultNode.entrySet()) {
		// System.out.println("hi");
		// String titleString = entry2.getKey();
		// String urlString = entry2.getValue();
		// System.out.println(" " + titleString + "\n "
		// + urlString);
		// }
		// } catch (Exception e) {
		//
		// }
		//
		// }
		// System.out.println("Done");
		// // sc.close();
		// }
		// sc.close();
=======
	int[] total = new int[100];

	public static void main(String[] args) throws IOException {
=======
	public static void main(String[] args) throws IOException {
>>>>>>> parent of d13f6cd... try
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String queryStr = sc.nextLine();
			GoogleSearch qSearch = new GoogleSearch(queryStr);
			HashMap<String, String> results = qSearch.getResults();
<<<<<<< HEAD

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
>>>>>>> origin/master
=======
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
>>>>>>> parent of d13f6cd... try
	}
}
