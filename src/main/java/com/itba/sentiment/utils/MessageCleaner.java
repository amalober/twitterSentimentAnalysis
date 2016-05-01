package com.itba.sentiment.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class MessageCleaner {

	public static String removeStopwords(String message) {
		final String SPANISH_STOP_WORDS[] = { "�l", "�sta", "�stas", "�ste", "�stos", "�ltima", "�ltimas", "�ltimo",
				"�ltimos", "a", "a�adi�", "a�n", "actualmente", "adelante", "adem�s", "afirm�", "agreg�", "ah�",
				"ahora", "al", "alg�n", "algo", "alguna", "algunas", "alguno", "algunos", "alrededor", "ambos", "ante",
				"anterior", "antes", "apenas", "aproximadamente", "aqu�", "as�", "asegur�", "aunque", "ayer", "bajo",
				"bien", "buen", "buena", "buenas", "bueno", "buenos", "c�mo", "cada", "casi", "cerca", "cierto",
				"cinco", "coment�", "como", "con", "conocer", "consider�", "considera", "contra", "cosas", "creo",
				"cual", "cuales", "cualquier", "cuando", "cuanto", "cuatro", "cuenta", "da", "dado", "dan", "dar", "de",
				"debe", "deben", "debido", "decir", "dejo","dejo", "del", "dem�s", "dentro", "desde", "despu�s", "dice",
				"dicen", "dicho", "dieron", "diferente", "diferentes", "dijeron", "dijo", "dio", "donde", "dos",
				"durante", "e", "ejemplo", "el", "ella", "ellas", "ello", "ellos", "embargo", "en", "encuentra",
				"entonces", "entre", "era", "eran", "es", "esa", "esas", "ese", "eso", "esos", "est�", "est�n", "esta",
				"estaba", "estaban", "estamos", "estar", "estar�", "estas", "este", "esto", "estos", "estoy", "estuvo",
				"ex", "existe", "existen", "explic�", "expres�", "fin", "fue", "fuera", "fueron", "gran", "grandes",
				"ha", "hab�a", "hab�an", "haber", "habr�", "hace", "hacen", "hacer", "hacerlo", "hacia", "haciendo",
				"han", "hasta", "hay", "haya", "he", "hecho", "hemos", "hicieron", "hizo", "hoy", "hubo", "igual",
				"incluso", "indic�", "inform�", "junto", "la", "lado", "las", "le", "les", "lleg�", "lleva", "llevar",
				"lo", "los", "luego", "lugar", "m�s", "manera", "manifest�", "mayor", "me", "mediante", "mejor",
				"mencion�", "menos", "mi", "mientras", "mis", "misma", "mismas", "mismo", "mismos", "momento", "mucha",
				"muchas", "mucho", "muchos", "muy", "nada", "nadie", "ni", "ning�n", "ninguna", "ningunas", "ninguno",
				"ningunos", "no", "nos", "nosotras", "nosotros", "nuestra", "nuestras", "nuestro", "nuestros", "nueva",
				"nuevas", "nuevo", "nuevos", "nunca", "o", "ocho", "otra", "otras", "otro", "otros", "para", "parece",
				"parte", "partir", "pasada", "pasado", "pero", "pesar", "poca", "pocas", "poco", "pocos", "podemos",
				"podr�", "podr�n", "podr�a", "podr�an", "poner", "por", "porque", "posible", "pr�ximo", "pr�ximos",
				"primer", "primera", "primero", "primeros", "principalmente", "propia", "propias", "propio", "propios",
				"pudo", "pueda", "puede", "pueden", "pues", "qu�", "que", "qued�", "queremos", "qui�n", "quien",
				"quienes", "quiere", "realiz�", "realizado", "realizar", "respecto", "rt", "s�", "s�lo", "se", "se�al�",
				"sea", "sean", "seg�n", "segunda", "segundo", "seis", "ser", "ser�", "ser�n", "ser�a", "si", "sido",
				"siempre", "siendo", "siete", "sigue", "siguiente", "sin", "sino", "sobre", "sola", "solamente",
				"solas", "solo", "solos", "son", "su", "sus", "tal", "tambi�n", "tampoco", "tan", "tanta", "tanto","te",
				"ten�a", "tendr�", "tendr�n", "tenemos", "tener", "tenga", "tengo", "tenido", "tercera", "tiene",
				"tienen", "toda", "todas", "todav�a", "todo", "todos", "total", "tras", "trata", "trav�s", "tres",
				"tuvo", "un", "una", "unas", "uno", "unos", "uso", "usted", "va", "vamos", "van", "varias", "varios",
				"veces", "ver", "vez", "y", "ya", "yo" };

		int i = 0;
		ArrayList<String> wordsList = new ArrayList<String>();
		ArrayList<String> wordsListClean = new ArrayList<String>();
		String sCurrentLine;
		String cleanMessage = "";
		try {
			// FileReader fr = new FileReader("stopwords.txt");

			// InputStream is =
			// MessageCleaner.class.getResourceAsStream("./stopwords.txt");
			// InputStreamReader isr= new InputStreamReader(is);
			// BufferedReader br = new BufferedReader(isr);
			// message = message.replaceAll("\\p{Punct}+", "").replaceAll("'",
			// "").replaceAll("\"", "");
			message = message.replaceAll("�", "a").replaceAll("�", "e").replaceAll("�", "i").replaceAll("�", "o")
					.replaceAll("�", "u");
			StringBuilder builder = new StringBuilder(message);
			String[] words = builder.toString().split("\\s");
			for (String word : words) {
				String cleanword = word.replaceAll("[^a-z]","");//word.replaceAll("[^\\p{L}\\p{Nd}]+", "");
				if (!word.isEmpty() && !word.startsWith("htt")) {
					wordsList.add(cleanword);
				}
			}
			int wl = wordsList.size() - 1;
			for (i = 0; i < wl; i++) {
				if (!Arrays.asList(SPANISH_STOP_WORDS).contains(wordsList.get(i).toLowerCase())) {
					wordsListClean.add(wordsList.get(i).toLowerCase());
				}
			}

			for (String str : wordsListClean) {
				cleanMessage += " " + str;
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return cleanMessage; // wordsList; //wordsList.toArray(new
								// String[wordsList.size()]);
	}

}
