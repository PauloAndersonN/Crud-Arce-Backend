package com.arce.agenda_series.controllers;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.arce.agenda_series.entities.SerieEntity;
import com.arce.agenda_series.repositories.SerieRepository;

public class AtualizacaoSerieForm {
	
	@NotNull @NotEmpty @Length(min = 3)
    private String nome;
	@NotNull @NotEmpty @Length(min = 3)
    private String genero;
	@NotNull @NotEmpty @Length(min = 3)
    private String descricao;
	@NotNull @NotEmpty @Length(min = 3)
    private String imagen;
	@NotNull @NotEmpty
    private int temporadas;
	@NotNull @NotEmpty
    private int capitulos;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public int getTemporadas() {
		return temporadas;
	}
	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}
	public int getCapitulos() {
		return capitulos;
	}
	public void setCapitulos(int capitulos) {
		this.capitulos = capitulos;
	}
	
	
	public SerieEntity atualizar(Long id, SerieRepository serieRepository) {
		SerieEntity serie = serieRepository.getOne(id);
		serie.setNome(this.nome);
		serie.setGenero(this.genero);
		serie.setDescricao(this.descricao);
		serie.setImagen(this.imagen);
		serie.setTemporadas(this.temporadas);
		serie.setCapitulos(this.capitulos);
		return serie;
	}
	

}
