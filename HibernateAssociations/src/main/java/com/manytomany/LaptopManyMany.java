package com.manytomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LAPTOPMANYMANY")
public class LaptopManyMany {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LP_ID")
	private int lpId;
	@Column(name = "LP_NAME")
	private String lpName;
	
	@ManyToMany
	private List<EmployeeManyMany> employees;
	
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
	public List<EmployeeManyMany> getEmployee() {
		return employees;
	}
	public void setEmployee(List<EmployeeManyMany> employees) {
		this.employees = employees;
	}
	
}
