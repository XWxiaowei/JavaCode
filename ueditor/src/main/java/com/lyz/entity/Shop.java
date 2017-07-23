package com.lyz.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	
/**
 * 实体类shop
 * @author liuyazhuang
 *
 */
@Entity
@Table(name="c_shop")
public class Shop implements Serializable {
	private static final long serialVersionUID = -6980546472329430674L;
	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	public Shop() {
		super();
	}
	
	public Shop(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Shop [id=" + id + "]";
	}
	
}
