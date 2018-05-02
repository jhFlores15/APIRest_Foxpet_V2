package com.example.foxpet.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foxpet.model.ComidaExtra;
import com.example.foxpet.repository.ComidaExtraRepository;

@Service
public class ComidaExtraDAO {
	@Autowired
	ComidaExtraRepository comidaextraRepository;
	
	
	public ComidaExtra save(ComidaExtra coex) {
		return comidaextraRepository.save(coex);
	}
	

	public List<ComidaExtra> findAll(){
		return comidaextraRepository.findAll();
	}
	

	public ComidaExtra findOne(int coex) {
	    return comidaextraRepository.findById(coex).orElse(null);
	}
	
		public void delete(ComidaExtra coex) {
		comidaextraRepository.delete(coex);
	}
}
