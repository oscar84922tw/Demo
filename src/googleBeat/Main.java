package googleBeat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class Main {
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
	}

}