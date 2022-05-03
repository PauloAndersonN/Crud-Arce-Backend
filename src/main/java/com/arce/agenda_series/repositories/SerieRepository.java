package com.arce.agenda_series.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arce.agenda_series.entities.SerieEntity;


public interface SerieRepository extends JpaRepository<SerieEntity,Long>{

	List<SerieEntity> findByNome(String nome);
	

	
}
