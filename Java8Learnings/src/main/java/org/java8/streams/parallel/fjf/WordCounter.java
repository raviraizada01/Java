package main.java.org.java8.streams.parallel.fjf;

import com.sun.javafx.scene.layout.region.LayeredBorderStyleConverter;

public class WordCounter {

	private final int counter;
	private final boolean lastSpace;
	public WordCounter(int counter, boolean lastSpace) {
		super();
		this.counter = counter;
		this.lastSpace = lastSpace;
	}
	
	public WordCounter accumulate(Character c) {
		if(Character.isWhitespace(c)) {
			return lastSpace ? this : new WordCounter(counter, true);
		}
		else {
			return lastSpace ? new WordCounter(counter + 1, false): this;
		}
	}
	
	public WordCounter combine(WordCounter wordCounter){
		return new WordCounter(counter + wordCounter.counter , wordCounter.lastSpace);
	}
	
	public int getCounter() {
		return counter;
	}
}
