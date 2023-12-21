package com.fsts.mediatech.models;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;
@Entity
@Table(name="ligne_facture")
@Data
@ToString
public class LigneFactureEntity  implements Serializable {
	@EmbeddedId
	private LigneFactureKey id;

	
	@ManyToOne
	//ue le champs de factures une partie de la  cle primaire
	@MapsId("factureId") 
	@JoinColumn(name="facture_id")
	private FactureEntity facture;
	
	@ManyToOne()
	@MapsId("produitId") 
	@JoinColumn(name="produit_id")
	private ProduitEntity produit;
	private double Quantite;
}
     
	
	
