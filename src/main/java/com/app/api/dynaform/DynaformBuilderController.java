package com.app.api.dynaform;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.customer.Customer;
import com.app.model.response.DynaformResponse;
import com.app.model.response.DynaformResponse.DynaformResponseStatusEnum;
import com.app.model.response.OperationResponse;
import com.app.model.response.OperationResponse.ResponseStatusEnum;
import com.app.model.session.DynaformAcess;
import com.app.model.session.DynaformModel;
import com.app.model.session.DynaformValues;
import com.app.repo.CustomerRepo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Transactional
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = {"DynaformBuilder"})
public class DynaformBuilderController {

  @Autowired private JdbcTemplate jdbcTemplate;
  @Autowired private CustomerRepo customerRepo;

  
  @ApiOperation(value = "buildFromInstance", response = OperationResponse.class)
  @RequestMapping(value = "/buildFromInstance", method = RequestMethod.POST, produces = {"application/json"})
  public OperationResponse buildFromInstance(@RequestBody Customer customer, HttpServletRequest req) {
      OperationResponse resp = new OperationResponse();
      if (this.customerRepo.exists(customer.getId()) ){
          resp.setOperationStatus(ResponseStatusEnum.ERROR);
          resp.setOperationMessage("Unable to add Customer - Customer allready exist ");
      }
      else{
          Customer addedCustomer = this.customerRepo.save(customer);
          resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
          resp.setOperationMessage("Customer Added");
      }
      return resp;
  }
  
  @ApiOperation(value = "getDynaformInitProperties", response = OperationResponse.class)
  @RequestMapping(value = "/getDynaformInitProperties", method = RequestMethod.POST, produces = {"application/json"})
  public DynaformResponse getDynaformInitProperties(@RequestBody Customer customer, HttpServletRequest req) {
	  DynaformResponse resp = new DynaformResponse();
	  
	  DynaformModel configs = new DynaformModel();
	  configs.setHasActionButtons(false);
	  configs.setView(false);
	  configs.setValues(new DynaformValues(0,0,0,null));
	  configs.setInvisibleReferences("");
	  configs.setTourversion("1");
	  configs.setTour(false);
	  configs.setHierarchy(false);
	  configs.setVersion(4);
	  configs.setVariation(false);
	  configs.setResourceid(new DynaformAcess("O14GE+PR0gPRZDWSYdVgCCWNNU9kWQYGCH1YBCoV"));
	  
	  resp.setConfig(configs);
	  
          resp.setStatus(DynaformResponseStatusEnum.SUCCESS);
          resp.setStatusMessage("Customer Added");
      return resp;
  }
  
}
