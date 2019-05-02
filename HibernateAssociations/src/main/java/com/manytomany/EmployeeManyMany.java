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
@Table(name = "EMPLOYEEMANYMANY")
public class EmployeeManyMany {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "EMP_ID")
		private int empId;
		@Column(name = "EMP_NAME")
		private String empName;
		
		@ManyToMany(mappedBy = "employees")
		private List<LaptopManyMany> laptops;
		
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
		public List<LaptopManyMany> getLaptop() {
			return laptops;
		}
		public void setLaptop(List<LaptopManyMany> laptops) {
			this.laptops = laptops;
		}	
}
