package com.geekshirt.orderservice.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class CommonEntity implements Serializable {

	@Column(name = "CREATE_DATE")
	@CreatedDate
	private Date createDate;
	@Column(name = "LASTA_UPDATE_DATE")
	@LastModifiedDate
	private Date lastUpdateDate;

}
