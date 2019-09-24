package com.ppm.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "PROJECT")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Enter  Project Name")
	private String projectName;

	@NotBlank(message = "Enter  Project Identifier ")
	@Size(min = 4, max = 5, message = "Please use 4 to 5 character")
	@Column(updatable = false, unique = true)
	private String projectIdentifier;

	@NotBlank(message = "Cannot be blank")
	private String desciption;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date startDate;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date endDate;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date createdAt;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date updatedAt;

	@PrePersist
	protected void oncreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
