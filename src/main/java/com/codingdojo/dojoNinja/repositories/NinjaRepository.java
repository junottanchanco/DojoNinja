package com.codingdojo.dojoNinja.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.dojoNinja.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	
	List<Ninja> findDistinctNinjasByDojoId(Long id);
}
