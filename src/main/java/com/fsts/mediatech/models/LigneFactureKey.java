package com.fsts.mediatech.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
//pour dire que on bva utilise ce cle dans une autre class
@Embeddable
public class LigneFactureKey implements Serializable {

@Column(name="facture_id")
private Integer factureId;

@Column(name="produit_id")
private Integer produitId;
}
