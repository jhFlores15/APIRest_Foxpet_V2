package com.example.foxpet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foxpet.model.VeterinarioEstablecimiento;
import com.example.foxpet.repository.VeterinarioEstablecimientoRepository;


@Service
public class VeterinarioEstablecimientoDAO {

	@Autowired
	VeterinarioEstablecimientoRepository veterinarioestablecimientoRepository;
	
	
	public VeterinarioEstablecimiento save(VeterinarioEstablecimiento alr) {
		return veterinarioestablecimientoRepository.save(alr);
	}
	

	public List<VeterinarioEstablecimiento> findAll(){
		return veterinarioestablecimientoRepository.findAll();
	}
	

	public VeterinarioEstablecimiento findOne(int alr) {
	    return veterinarioestablecimientoRepository.findById(alr).orElse(null);
	}
	

	public void delete(VeterinarioEstablecimiento alr) {
		veterinarioestablecimientoRepository.delete(alr);
	}
}
