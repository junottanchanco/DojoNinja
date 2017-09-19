package com.codingdojo.dojoNinja.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojoNinja.models.Ninja;
import com.codingdojo.dojoNinja.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	private NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public void addNinja(Ninja ninja) {
		ninjaRepository.save(ninja);
	}
	
	public List<Ninja> findNinjaByDojo(Long id){
		return ninjaRepository.findDistinctNinjasByDojoId(id);
	}

}
