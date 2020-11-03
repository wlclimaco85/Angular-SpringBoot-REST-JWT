package com.app.model.employee;

import java.util.List;

import com.app.model.response.PageResponse;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class EmployeeResponse extends PageResponse {
  @ApiModelProperty(required = true, value = "")
  private List<Employee> items;

public List<Employee> getItems() {
	return items;
}

public void setItems(List<Employee> items) {
	this.items = items;
}
  
}
