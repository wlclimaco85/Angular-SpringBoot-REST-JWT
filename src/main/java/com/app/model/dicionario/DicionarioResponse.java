package com.app.model.dicionario;

import java.util.List;

import com.app.model.response.PageResponse;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class DicionarioResponse extends PageResponse {
  @ApiModelProperty(required = true, value = "")
  private List<Tela> items;

public List<Tela> getItems() {
	return items;
}

public void setItems(List<Tela> items) {
	this.items = items;
}
  
  
}
