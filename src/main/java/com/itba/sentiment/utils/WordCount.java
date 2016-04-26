package com.itba.sentiment.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class WordCount {

	public static Map<String, Integer> wordFrequencyCount(String s) {
		ConcurrentMap<String, Integer> m = new ConcurrentHashMap<>();
		String[] words = s.split("\\s+");
		for (String w : words) {
			m.compute(w.toLowerCase(), (k, v) -> v == null ? 1 : v + 1);
		}
		return m;
	}

	

}
