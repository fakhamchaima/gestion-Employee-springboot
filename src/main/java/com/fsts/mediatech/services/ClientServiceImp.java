package com.fsts.mediatech.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;


import org.modelmapper.Converters.Collection;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.fsts.mediatech.Dao.ClientDao;
import com.fsts.mediatech.dto.ClientRequestDto;
import com.fsts.mediatech.dto.ClientResponseDto;
import com.fsts.mediatech.models.ClientEntity;

@Service()
public class ClientServiceImp implements ClientService{
	private ClientDao clientDao;
	private ModelMapper modelMapper;
	
	public ClientServiceImp(ClientDao clientDao, ModelMapper modelMapper) {
		this.clientDao = clientDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public ClientResponseDto save(ClientRequestDto clientRequestDto) {
		ClientEntity clientEntity = modelMapper.map(clientRequestDto, ClientEntity.class);
		ClientEntity saved = clientDao.save(clientEntity);
		return modelMapper.map(saved, ClientResponseDto.class);
	}

	@Override
	public ClientResponseDto findById(Integer id) {
		ClientEntity clientEntity =clientDao.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
		return modelMapper.map(clientEntity, ClientResponseDto.class);
	}

	@Override
	public ClientResponseDto findByNom(String nom) {
		ClientEntity clientEntity =clientDao.findByNom(nom);
		return modelMapper.map(clientEntity, ClientResponseDto.class);

	}

	@Override
	public void delete(Integer id) {
		clientDao.deleteById(id);
		/*
		 * ClientEntity clientEntity =clientDao.findById(id).get();
		clientDao.delete(clientEntity);
		 */
	}

	@Override
	public ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id) {
		Optional<ClientEntity> clientEntityOptional = clientDao.findById(id);
		if(clientEntityOptional.isPresent()) {
			ClientEntity clientEntity = modelMapper.map(clientRequestDto, ClientEntity.class);
			clientEntity.setId(id);
			ClientEntity updated = clientDao.save(clientEntity);
			return modelMapper.map(updated, ClientResponseDto.class);
		}else {
			return null;
			//throw new NotFoundException("client not found");
		}
	}

	@Override
	public List<ClientResponseDto> findAll() {
		// TODO Auto-generated method stub
		return clientDao.findAll()
				.stream().map(el -> modelMapper.map(el, ClientResponseDto.class))
				.collect(Collectors.toList());
	}
	

}