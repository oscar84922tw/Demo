package googleBeat;

//import edu.nccu.misdu.stu103306037.hw6.Main;
import java.io.IOException;
import java.util.ArrayList;

public class WebTree {
	public WebNode root;

	public WebTree(WebNode root) {
		this.root = root;

	}

	public void postOrderNodeScore(ArrayList<Keyword> keywords)
			throws IOException {
		root.calcNodeScore(keywords);
	}

	public void eulerTourPoint() {
		preorderPrinter(root, 0);
	}

	private void preorderPrinter(WebNode webNode, int tabCounter) {
		// print tree
		System.out.print("(" + webNode.webPage.name + "," + webNode.NodeScore);
		if (webNode.children.size() > 0) {
			tabCounter++;
			for (WebNode child : webNode.children) {
				System.out.println("");
				for (int i = 0; i < tabCounter; i++) {
					System.out.print("\t");
				}
				preorderPrinter(child, tabCounter);
			}
		} else {
			System.out.print(")");
			return;
		}
		System.out.println("");
		for (int i = 0; i < tabCounter - 1; i++) {
			System.out.print("\t");
		}
		System.out.print(")");
	}
}