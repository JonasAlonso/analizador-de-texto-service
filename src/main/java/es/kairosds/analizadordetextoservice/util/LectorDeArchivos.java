package es.kairosds.analizadordetextoservice.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class LectorDeArchivos {
	
	public static String obtenerListaNegra() {
		

		StringBuilder sb = new StringBuilder();

		try (BufferedReader br = Files.newBufferedReader(Paths.get("listanegra.txt"))) {

			// read line by line
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}

		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}

		return sb.toString();

	}

}
