package googleBeat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

public class Resort {
	private ArrayList<Keyword> keywords;
	public ArrayList<Website> roots;

	public Resort(ArrayList<Keyword> keywords) {
		this.keywords = keywords;
	}

	public ArrayList<Website> query(String searchWord) throws IOException {
		GoogleSearch gSearch = new GoogleSearch(searchWord);
		Map<String, String> titleUrl = gSearch.getResults();

		roots = new ArrayList<>();
		for (Entry<String, String> entry : titleUrl.entrySet()) {
			String title = entry.getKey();
			String urlStr = entry.getValue();
			Website root = new Website(title, urlStr);
			roots.add(root);
			root.grows(keywords);
			root.evaluate();
		}

		Collections.sort(roots, new WebsiteComparator());

		return roots;
	}
}
