package com.fsts.mediatech.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="factures")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FactureEntity implements Serializable{
	@Id

	private Integer id;
	@Column(nullable=false)
	private String ref;
	@Column(nullable=false,name="date_facture")
	private Date date;
	@ManyToOne
    private ClientEntity client;
	@OneToMany(mappedBy="facture",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<LigneFactureEntity> factureEntities;

}
