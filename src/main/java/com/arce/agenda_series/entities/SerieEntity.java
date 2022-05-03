package com.arce.agenda_series.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Entity
public class SerieEntity {
        
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
        private String nome;
        private String genero;
        @Column(length=512)
        private String descricao;
        private String imagen;
        private int temporadas;
        private int capitulos;
        
        public SerieEntity(){
        	
        }
        
		public SerieEntity(String nome, String genero, String descricao, String imagen, int temporadas, int capitulos) {
			
			this.nome = nome;
			this.genero = genero;
			this.descricao = descricao;
			this.imagen = imagen;
			this.temporadas = temporadas;
			this.capitulos = capitulos;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
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
        
        
        
        

		
	
	
	

}
