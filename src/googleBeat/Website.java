package googleBeat;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Website {
	public Website parent;
	public ArrayList<Website> children;
	public String title;
	public String urlStr;
	public int localScore;
	public int globalScore;
	public KeywordCounter counter;

	public Website(String title, String urlStr) {
		this.title = title;
		this.urlStr = urlStr;
		this.children = new ArrayList<>();
		counter = new KeywordCounter(urlStr);
	}

	public void appendChild(Website child) {
		this.children.add(child);
		child.parent = this;
	}

	public void evaluate() {
		for (Website child : children) {
			child.evaluate();
			this.globalScore += child.globalScore;
		}

		this.globalScore += this.localScore;
	}

	public void grows(ArrayList<Keyword> keywords) {
		// calculate localScore of this website
		for (Keyword k : keywords) {
			try {
				this.localScore += counter.countKeyword(k.name) * k.weight;
			} catch (IOException ex) {
				break;
			}
		}

		if (getDepth() == 2) {
			return;
		}

		Document doc = Jsoup.parse(counter.getContent());
		Elements links = doc.select("a[href]");

		for (Element link : links) {
			String href = link.attr("href");
			String title = "__Unknown__";
			if (link.text() != null) {
				title = link.text();
			}
			if (href.startsWith("http")) {
				Website childWebsite = new Website(title, href);
				this.appendChild(childWebsite);
				childWebsite.grows(keywords);
				if (this.children.size() == 3) {
					break;
				}
			}
		}

	}

	public int getDepth() {
		int retVal = 0;
		Website curr = this;
		while (curr.parent != null) {
			retVal++;
			curr = curr.parent;
		}
		return retVal;
	}
}
