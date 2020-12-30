package com.dateFormat.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ResultDate {
	@ApiModelProperty(name = "resultDate",required = true,value = "17-10-1998")
	  private String resultDate;

	    public String getResultDate() {
	        return resultDate;
	    }

	    public ResultDate(){
	        super();
	    }

	    public void setResultDate(String resultDate) {
	        this.resultDate = resultDate;
	    }

	    public ResultDate(String resultDate) {
	        this.resultDate = resultDate;
	    }
}
