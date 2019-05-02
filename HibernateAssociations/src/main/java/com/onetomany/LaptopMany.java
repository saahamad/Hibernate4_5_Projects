package com.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "LAPTOPMANY")
public class LaptopMany {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LP_ID")
	private int lpId;
	@Column(name = "LP_NAME")
	private String lpName;
	
	@ManyToOne
	private EmployeeMany employee;
	
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
	public EmployeeMany getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeMany employee) {
		this.employee = employee;
	}
	
}
