package com.fsts.mediatech.Dao;
//chaimaa

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsts.mediatech.models.ClientEntity;
@Repository
public interface ClientDao extends JpaRepository<ClientEntity, Integer> {
	ClientEntity findByNom(String nom);
	 

}
