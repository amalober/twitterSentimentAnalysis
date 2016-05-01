package com.itba.sentiment.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class MessageCleaner {

	public static String removeStopwords(String message) {
		final String SPANISH_STOP_WORDS[] = { "él", "ésta", "éstas", "éste", "éstos", "última", "últimas", "último",
				"últimos", "a", "añadió", "aún", "actualmente", "adelante", "además", "afirmó", "agregó", "ahí",
				"ahora", "al", "algún", "algo", "alguna", "algunas", "alguno", "algunos", "alrededor", "ambos", "ante",
				"anterior", "antes", "apenas", "aproximadamente", "aquí", "así", "aseguró", "aunque", "ayer", "bajo",
				"bien", "buen", "buena", "buenas", "bueno", "buenos", "cómo", "cada", "casi", "cerca", "cierto",
				"cinco", "comentó", "como", "con", "conocer", "consideró", "considera", "contra", "cosas", "creo",
				"cual", "cuales", "cualquier", "cuando", "cuanto", "cuatro", "cuenta", "da", "dado", "dan", "dar", "de",
				"debe", "deben", "debido", "decir", "dejo","dejo", "del", "demás", "dentro", "desde", "después", "dice",
				"dicen", "dicho", "dieron", "diferente", "diferentes", "dijeron", "dijo", "dio", "donde", "dos",
				"durante", "e", "ejemplo", "el", "ella", "ellas", "ello", "ellos", "embargo", "en", "encuentra",
				"entonces", "entre", "era", "eran", "es", "esa", "esas", "ese", "eso", "esos", "está", "están", "esta",
				"estaba", "estaban", "estamos", "estar", "estará", "estas", "este", "esto", "estos", "estoy", "estuvo",
				"ex", "existe", "existen", "explicó", "expresó", "fin", "fue", "fuera", "fueron", "gran", "grandes",
				"ha", "había", "habían", "haber", "habrá", "hace", "hacen", "hacer", "hacerlo", "hacia", "haciendo",
				"han", "hasta", "hay", "haya", "he", "hecho", "hemos", "hicieron", "hizo", "hoy", "hubo", "igual",
				"incluso", "indicó", "informó", "junto", "la", "lado", "las", "le", "les", "llegó", "lleva", "llevar",
				"lo", "los", "luego", "lugar", "más", "manera", "manifestó", "mayor", "me", "mediante", "mejor",
				"mencionó", "menos", "mi", "mientras", "mis", "misma", "mismas", "mismo", "mismos", "momento", "mucha",
				"muchas", "mucho", "muchos", "muy", "nada", "nadie", "ni", "ningún", "ninguna", "ningunas", "ninguno",
				"ningunos", "no", "nos", "nosotras", "nosotros", "nuestra", "nuestras", "nuestro", "nuestros", "nueva",
				"nuevas", "nuevo", "nuevos", "nunca", "o", "ocho", "otra", "otras", "otro", "otros", "para", "parece",
				"parte", "partir", "pasada", "pasado", "pero", "pesar", "poca", "pocas", "poco", "pocos", "podemos",
				"podrá", "podrán", "podría", "podrían", "poner", "por", "porque", "posible", "próximo", "próximos",
				"primer", "primera", "primero", "primeros", "principalmente", "propia", "propias", "propio", "propios",
				"pudo", "pueda", "puede", "pueden", "pues", "qué", "que", "quedó", "queremos", "quién", "quien",
				"quienes", "quiere", "realizó", "realizado", "realizar", "respecto", "rt", "sí", "sólo", "se", "señaló",
				"sea", "sean", "según", "segunda", "segundo", "seis", "ser", "será", "serán", "sería", "si", "sido",
				"siempre", "siendo", "siete", "sigue", "siguiente", "sin", "sino", "sobre", "sola", "solamente",
				"solas", "solo", "solos", "son", "su", "sus", "tal", "también", "tampoco", "tan", "tanta", "tanto","te",
				"tenía", "tendrá", "tendrán", "tenemos", "tener", "tenga", "tengo", "tenido", "tercera", "tiene",
				"tienen", "toda", "todas", "todavía", "todo", "todos", "total", "tras", "trata", "través", "tres",
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
			message = message.replaceAll("á", "a").replaceAll("é", "e").replaceAll("í", "i").replaceAll("ó", "o")
					.replaceAll("ú", "u");
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
