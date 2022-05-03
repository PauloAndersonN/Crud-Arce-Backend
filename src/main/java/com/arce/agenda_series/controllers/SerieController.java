package com.arce.agenda_series.controllers;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.arce.agenda_series.entities.SerieEntity;
import com.arce.agenda_series.repositories.SerieRepository;

@RestController
@RequestMapping("/series")
public class SerieController {
	
	@Autowired
	private SerieRepository serieRepository;
	
	@GetMapping
	public List<SerieDto> lista(String nome){
		if(nome == null) {
			List<SerieEntity> series = serieRepository.findAll();
			return SerieDto.converter(series);
		}else {
			List<SerieEntity> series = serieRepository.findByNome(nome);
			return SerieDto.converter(series);
		}
	
	}
	
	@PostMapping
	public ResponseEntity<SerieDto> cadastrar(@RequestBody @Valid SerieForm form,UriComponentsBuilder uriBuilder){
	  SerieEntity serie = form.converter();
	  serieRepository.save(serie);
	  URI uri = uriBuilder.path("/series/{id}").buildAndExpand(serie.getId()).toUri();
	  return ResponseEntity.created(uri).body(new SerieDto(serie));
	}
	
	@GetMapping("/{id}")
	public SerieDto detalhar(@PathVariable Long id){
		SerieEntity serie = serieRepository.getOne(id);
		return new SerieDto(serie);
	}


	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<SerieDto> atualizar(@PathVariable Long id,@RequestBody @Valid AtualizacaoSerieForm form){
		SerieEntity serie = form.atualizar(id, serieRepository);
		return ResponseEntity.ok(new SerieDto(serie));
		

	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		serieRepository.deleteById(id);
		return ResponseEntity.ok().build();
		
	}
	
	


}
