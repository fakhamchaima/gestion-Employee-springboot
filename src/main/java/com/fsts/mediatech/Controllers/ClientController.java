package com.fsts.mediatech.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsts.mediatech.dto.ClientRequestDto;
import com.fsts.mediatech.dto.ClientResponseDto;
import com.fsts.mediatech.services.ClientService;

//chaimaa
@RestController
@RequestMapping("clients")
public class ClientController {
	@Autowired //constructor
	//@Qualifier("impl1")
	private ClientService clientService;
	
	@GetMapping("")
	public List<ClientResponseDto> getClient(){
		return clientService.findAll();
	}
	
	@PostMapping("")
	public ClientResponseDto save(@RequestBody() ClientRequestDto clientRequestDto) {
		return clientService.save(clientRequestDto);
	}
}


