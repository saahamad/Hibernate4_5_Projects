package com.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEEONE")
public class EmployeeOne {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "EMP_ID")
		private int empId;
		@Column(name = "EMP_NAME")
		private String empName;
		
		@OneToOne
		private LaptopOne laptop;
		
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
		public LaptopOne getLaptop() {
			return laptop;
		}
		public void setLaptop(LaptopOne laptop) {
			this.laptop = laptop;
		}	
}
