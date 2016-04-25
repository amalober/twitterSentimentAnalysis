package com.itba.sentiment.analysis;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.IOUtils;

import com.itba.sentiment.utils.MessageCleaner;
import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.font.scale.LinearFontScalar;
import com.kennycason.kumo.palette.ColorPalette;

public class WordCloudGenerator {
	private static final Random RANDOM = new Random();

	public void simpleCircle() throws IOException {
		final List<WordFrequency> wordFrequencies = buildWordFrequencies().subList(0, 150);
		final Dimension dimension = new Dimension(600, 600);
		final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.RECTANGLE);
		wordCloud.setPadding(0);
		wordCloud.setBackground(new CircleBackground(300));
		wordCloud.setColorPalette(buildRandomColorPalette(20));
		wordCloud.setFontScalar(new LinearFontScalar(10, 40));
		wordCloud.build(wordFrequencies);
		wordCloud.writeToFile("C:\\Users\\amalober\\workspace\\sentimentAnalysis\\src\\main\\java\\wordcloud_circle.png");
	}

	private static ColorPalette buildRandomColorPalette(int n) {
		final Color[] colors = new Color[n];
		for (int i = 0; i < colors.length; i++) {
			colors[i] = new Color(RANDOM.nextInt(230) + 25, RANDOM.nextInt(230) + 25, RANDOM.nextInt(230) + 25);
		}
		return new ColorPalette(colors);
	}

	private static List<WordFrequency> buildWordFrequencies() throws IOException {
		MessageService ms = new MessageService();
		List<Message> messages = ms.retrieveAllMessages();
		String appendedMsgs = "";
		String wordsString;
	//	String cleanMessages = "";
		ArrayList<String> words=null;
		if (messages != null) {
			for (Message message : messages) {
				appendedMsgs += message.getMessage().toLowerCase() + " ";
			}
			System.out.println(appendedMsgs);
			wordsString= MessageCleaner.removeStopwords(appendedMsgs);
			//String[] words = words.split("\\s+").;

		}
		final List<WordFrequency> wordFrequencies = new ArrayList<>();
		for (String word : words) {
			wordFrequencies.add(new WordFrequency(word, RANDOM.nextInt(100) + 1));
		}
		return wordFrequencies;
	}

	@SuppressWarnings("unused")
	private static Set<String> loadStopWords() {
		try {
			final List<String> lines = IOUtils.readLines(getInputStream("text/stop_words.txt"));
			return new HashSet<>(lines);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptySet();
	}

	private static InputStream getInputStream(final String path) {
		return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
	}

}