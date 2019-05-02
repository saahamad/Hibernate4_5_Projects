package com.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEEMANY")
public class EmployeeMany {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "EMP_ID")
		private int empId;
		@Column(name = "EMP_NAME")
		private String empName;
		
		@OneToMany(mappedBy = "employee")
		private List<LaptopMany> laptops;
		
		public int getEmpId() {
			return empId;
		}
		public void setEmpId(int empId) {
			this.empId = empId;
		}
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		}
		public List<LaptopMany> getLaptop() {
			return laptops;
		}
		public void setLaptop(List<LaptopMany> laptops) {
			this.laptops = laptops;
		}	
}
