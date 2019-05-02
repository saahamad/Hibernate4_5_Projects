package com.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LAPTOPONE")
public class LaptopOne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LP_ID")
	private int lpId;
	@Column(name = "LP_NAME")
	private String lpName;
	
	
	public int getLpId() {
		return lpId;
	}
	public void setLpId(int lpId) {
		this.lpId = lpId;
	}
	public String getLpName() {
		return lpName;
	}
	public void setLpName(String lpName) {
		this.lpName = lpName;
	}
	
}
