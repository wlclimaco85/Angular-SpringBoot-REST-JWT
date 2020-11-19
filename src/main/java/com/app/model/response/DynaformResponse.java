/**
    This is the common structure for all responses
    if the response contains a list(array) then it will have 'items' field
    if the response contains a single item then it will have 'item'  field
 */


package com.app.model.response;

import com.app.model.session.DynaformModel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data //for getters and setters
public class DynaformResponse {
	public enum DynaformResponseStatusEnum {
		SUCCESS, ERROR, WARNING, NO_ACCESS
	};

	@ApiModelProperty(required = true)
	private DynaformResponseStatusEnum status;
	private String statusMessage;
	private DynaformModel config;
	

	public DynaformResponse() {
		super();
	}



	public DynaformResponseStatusEnum getStatus() {
		return status;
	}



	public void setStatus(DynaformResponseStatusEnum status) {
		this.status = status;
	}



	public String getStatusMessage() {
		return statusMessage;
	}



	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}



	public DynaformModel getConfig() {
		return config;
	}

	public void setConfig(DynaformModel config) {
		this.config = config;
	}
	
	

}
