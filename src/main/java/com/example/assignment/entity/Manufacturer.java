package com.example.assignment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Manufacturer {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String name;
		private String origin;
		private String userRatings;
		private int noOfProductAvailable;
		private double annualRevenue;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getOrigin() {
			return origin;
		}
		public void setOrigin(String origin) {
			this.origin = origin;
		}
		public String getUserRatings() {
			return userRatings;
		}
		public void setUserRatings(String userRatings) {
			this.userRatings = userRatings;
		}
		public int getNoOfProductAvailable() {
			return noOfProductAvailable;
		}
		public void setNoOfProductAvailable(int noOfProductAvailable) {
			this.noOfProductAvailable = noOfProductAvailable;
		}
		public double getAnnualRevenue() {
			return annualRevenue;
		}
		public void setAnnualRevenue(double annualRevenue) {
			this.annualRevenue = annualRevenue;
		}


	}