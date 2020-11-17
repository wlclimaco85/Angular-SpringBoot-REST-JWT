package com.app.api.dynaform;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.customer.Customer;
import com.app.model.customer.CustomerResponse;
import com.app.model.response.OperationResponse;
import com.app.model.response.OperationResponse.ResponseStatusEnum;
import com.app.repo.CustomerRepo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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
  public OperationResponse getDynaformInitProperties(@RequestBody Customer customer, HttpServletRequest req) {
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
  
 

   
}
