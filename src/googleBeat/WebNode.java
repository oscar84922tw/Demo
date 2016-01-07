package googleBeat;


import java.io.IOException;
import java.util.ArrayList;

public class WebNode {
	public WebNode parent;
	public ArrayList<WebNode> children;
	public WebPage webPage;
	public double NodeScore;

	public WebNode(WebPage webpage) {
		this.webPage = webpage;
		children = new ArrayList<>();

	}

	public void appendChild(WebNode childNode) {
		childNode.parent = this;
		children.add(childNode);

	}

	public double calcNodeScore(ArrayList<Keyword> keywords) throws IOException {
		NodeScore = 0;
		for (WebNode child : children) {
			NodeScore += child.calcNodeScore(keywords);
		}
		NodeScore += webPage.calcScore(keywords);
		return NodeScore;
	}
}
