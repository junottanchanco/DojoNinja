package com.codingdojo.dojoNinja.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojoNinja.models.Dojo;
import com.codingdojo.dojoNinja.repositories.DojoRepository;

@Service
public class DojoService {

		private DojoRepository dojoRepository;
		
		public DojoService(DojoRepository dojoRepository) {
			this.dojoRepository = dojoRepository;
		}
		
		public void addDojo(Dojo dojo) {
			dojoRepository.save(dojo);
		}
		
		public List<Dojo> allDojos(){
			return (List<Dojo>) dojoRepository.findAll();
		}
		
		public Dojo findDojoById(Long id) {
			return dojoRepository.findOne(id);
		}
}
