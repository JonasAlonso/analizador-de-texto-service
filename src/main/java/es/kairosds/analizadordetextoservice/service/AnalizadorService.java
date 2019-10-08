package es.kairosds.analizadordetextoservice.service;

import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import es.kairosds.analizadordetextoservice.util.LectorDeArchivos;

@Service
public class AnalizadorService {
	
	public List<String> analizarTexto(String texto){
		
		List<String> listaNegra = getTokensWithCollection(LectorDeArchivos.obtenerListaNegra());
		List<String> palabras = getTokensWithCollection(texto);
		
		return obtenerPalabrasCensuradas(palabras, listaNegra);
	}
	
	private static List<String> obtenerPalabrasCensuradas(List<String> palabras, List<String> listaNegra) {
		return palabras.stream().filter(listaNegra::contains).collect(Collectors.toList());
	}

	private static List<String> getTokensWithCollection(String str) {
		return Collections.list(new StringTokenizer(str, " ,-&")).stream().map(token -> (String) token)
				.map(String::toUpperCase).collect(Collectors.toList());
	}


}
