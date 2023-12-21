package com.fsts.mediatech.services;

import java.util.List;

import com.fsts.mediatech.dto.ClientRequestDto;
import com.fsts.mediatech.dto.ClientResponseDto;

public interface ClientService {
	
	ClientResponseDto save(ClientRequestDto c);
	
	ClientResponseDto findByNom(String nom);
	
	ClientResponseDto findById(Integer id);
	
    void delete(Integer id);
    
    
    ClientResponseDto update(ClientRequestDto c,Integer id);
    List<ClientResponseDto> findAll();
     
	
	
	
	
}
