package com.istea.integrador.RSImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.istea.integrador.Coordenadas;
import com.istea.integrador.ResponseApi;


@RestController
public class RSFarmaciaImpl  {
	
	@Value( "${mapquestapi.key}" )
	private String KEY;
	
	@Value( "${mapquestapi.url}" )
	private String URL;
	
	@GetMapping("/cordenadas")
	public Coordenadas getCordendas(@RequestParam String nombre) {
		ResponseApi json = new ResponseApi();
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			json = restTemplate.getForObject(URL + KEY + "&location=" + nombre, ResponseApi.class);
		} catch (HttpClientErrorException e) {
			System.out.println("Error llamando a mapquestapi " + e);
		} catch (Exception e) {
			System.out.println("Error generico " + e);
		}
	
		return json.getResults().get(0).getLocations().get(0).getLatLng();
	}
	
	private ArrayList<Coordenadas> farmaciasDeTurno(Coordenadas coordenadas) {
		ArrayList<Coordenadas> response = new ArrayList<>();
		response.add(coordenadas);
		response.add(coordenadas);
		response.add(coordenadas);
		return response;
		
	}

}
