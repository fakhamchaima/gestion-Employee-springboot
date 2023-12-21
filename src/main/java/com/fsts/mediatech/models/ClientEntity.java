package com.fsts.mediatech.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity implements Serializable {
	@Id()
	@GeneratedValue
	private Integer id;
	@Column(nullable = false)
	private String nom;
	//le champs est oblegatoire de le faire
	@Column(nullable = false)
	private String prenom;
	private String telephone;
	//pour dire que un client admet un ou plusieurs factures
	//lazy pour reccupere seulement les champs de la class
	 @OneToMany(mappedBy ="client",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	 //pour nom le cle etranger de la table factures qui vient de la table client
	
	 private List<FactureEntity>factures;



}
