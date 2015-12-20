package googleBeat;


import java.io.IOException;
import java.util.ArrayList;

public class WebPage {
	public String name;
	public String url;
	public KeywordCounter counter;
	public double score;

	public WebPage(String name, String url) {
		this.name = name;
		this.url = url;
		this.counter = new KeywordCounter(url);
	}

	public double calcScore(ArrayList<Keyword> keywords) throws IOException {
		score = 0;
		for (Keyword k : keywords) {
			score += k.weight * counter.countKeyword(k.name);
		}
		return score;
	}
}