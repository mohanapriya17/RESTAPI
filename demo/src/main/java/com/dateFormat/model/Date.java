package com.dateFormat.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Date {
	@ApiModelProperty(name = "date",required = true,value = "17-10-1998")
	 private String date;
	    private String slo;
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getSlo() {
			return slo;
		}
		public void setSlo(String slo) {
			this.slo = slo;
		}
		public Date(String date, String slo) {
			super();
			this.date = date;
			this.slo = slo;
		}
		public Date() {
			super();
			// TODO Auto-generated constructor stub
		}
		
}
