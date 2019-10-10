package es.kairosds.analizadordetextoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.kairosds.analizadordetextoservice.model.RespuestaAnalisis;
import es.kairosds.analizadordetextoservice.model.Texto;
import es.kairosds.analizadordetextoservice.service.AnalizadorService;

@RestController
@RequestMapping("/analizador")
public class AnalizadorDeTextoController {

	@Autowired
	AnalizadorService analizadorService;

	@PostMapping("/")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<RespuestaAnalisis> analizarComentario(@RequestBody Texto texto){
		
		RespuestaAnalisis analisis = RespuestaAnalisis.builder().lenguajeOfensivo(analizadorService.analizarTexto(texto.getContenido())).build();
		
		return ResponseEntity.ok().body(analisis);	
	}
}
