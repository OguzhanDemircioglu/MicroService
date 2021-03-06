package com.rentacar.api.user.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "users")
public class UserEntity {
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name = "password")
	private String encryptedPassword;
	
	@Column(name = "email", nullable = false, length = 100, unique = true)
	private String email;
	
}
