package com.fsts.mediatech.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable{
	@Id
	private Integer userId;
	
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String password;
	//assosciation son attribue ManyToMany
	@ManyToMany
	@JoinTable(name = "user_roles",joinColumns = @JoinColumn(name="userId"),
	inverseJoinColumns = @JoinColumn(name="roleId"))
	private  List<RoleEntity>roles;
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private UserProfile profile;
}
