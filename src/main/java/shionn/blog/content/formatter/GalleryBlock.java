package shionn.blog.content.formatter;

import java.util.ArrayList;
import java.util.List;

import org.commonmark.node.Block;
import org.commonmark.node.Visitor;

public class GalleryBlock extends Block {

	private List<String> imgs = new ArrayList<>();

	@Override
	public void accept(Visitor visitor) {
		System.out.println("accept");
	}

	public void addImage(String img) {
		this.imgs.add(img);
	}

}
