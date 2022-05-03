package com.arce.agenda_series.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.arce.agenda_series.entities.SerieEntity;


public class SerieDto {
	
	private Long id;
    private String nome;
    private String genero;
    private String descricao;
    private String imagen;
    private int temporadas;
    private int capitulos;
    
    
    
    
	public SerieDto(SerieEntity serie) {
		this.id = serie.getId();
		this.nome = serie.getNome();
		this.genero = serie.getGenero();
		this.descricao = serie.getDescricao();
		this.imagen = serie.getImagen();
		this.temporadas = serie.getTemporadas();
		this.capitulos = serie.getCapitulos();
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getGenero() {
		return genero;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getImagen() {
		return imagen;
	}
	public int getTemporadas() {
		return temporadas;
	}
	public int getCapitulos() {
		return capitulos;
	}
	
	public static List<SerieDto> converter(List<SerieEntity> series) {
		return series.stream().map(SerieDto::new).collect(Collectors.toList());
	}
    
    

}
