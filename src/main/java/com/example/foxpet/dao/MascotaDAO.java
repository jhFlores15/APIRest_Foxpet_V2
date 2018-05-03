package com.example.foxpet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foxpet.model.Mascota;
import com.example.foxpet.repository.MascotaRepository;



@Service
public class MascotaDAO {
	
	@Autowired
	MascotaRepository mascotaRepository;
	
	
	public Mascota save(Mascota pro) {
		return mascotaRepository.save(pro);
	}

	public List<Mascota> findAll(){
		return mascotaRepository.findAll();
	}
	
	public Mascota findOne(int proId) {
	    return mascotaRepository.findById(proId).orElse(null);
	}
	
	public void delete(Mascota pro) {
		mascotaRepository.delete(pro);
	}

}
