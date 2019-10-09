package es.kairosds.analizadordetextoservice.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RespuestaAnalisis {
	
	private List<String> lenguajeOfensivo;

}
