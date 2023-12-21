package com.fsts.mediatech.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="produits")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitEntity implements Serializable{
	
	@Id
	private Integer id;
	@Column(nullable=false)
	private String libelle;
	@Column(nullable=false)
	private BigDecimal prix;
	@Column(nullable=false)
	private double quantite_stock;
	@OneToMany(mappedBy="produit",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<LigneFactureEntity> factureEntities;

}
