package shionn.blog.content.formatter;

import org.commonmark.node.Block;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockParserFactory;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

public class GalleryBlockParser implements BlockParser {

	public static class Factory implements BlockParserFactory {

		@Override
		public BlockStart tryStart(ParserState state, MatchedBlockParser matchedBlockParser) {
			if ("[gallery]".equals(state.getLine().toString())) {
				return BlockStart.of(new GalleryBlockParser()).atIndex(state.getIndex());
			}
			return BlockStart.none();
		}

	}

	@Override
	public boolean isContainer() {
		return false;
	}

	@Override
	public boolean canContain(Block block) {
		return !(block instanceof GalleryBlock);
	}

	@Override
	public Block getBlock() {
		return new GalleryBlock();
	}

	@Override
	public BlockContinue tryContinue(ParserState parserState) {
		if ("[/gallery]".equals(parserState.getLine().toString())) {
			return BlockContinue.finished();
		}
		return BlockContinue.atIndex(parserState.getIndex());
	}

	@Override
	public void addLine(CharSequence line) {
		System.out.println("addLine : " + line);
	}

	@Override
	public void closeBlock() {
		System.out.println("closeBlock");

	}

	@Override
	public void parseInlines(InlineParser inlineParser) {
		System.out.println(inlineParser);

	}

}
