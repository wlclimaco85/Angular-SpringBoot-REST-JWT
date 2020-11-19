package com.app.api.dicionario;

//import springfox.documentation.annotations.*;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
//import static org.springframework.http.MediaType.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.customer.Customer;
import com.app.model.customer.CustomerResponse;
import com.app.model.dicionario.DicionarioResponse;
import com.app.model.dicionario.Tela;
import com.app.model.response.OperationResponse;
import com.app.model.response.OperationResponse.ResponseStatusEnum;
import com.app.repo.DicionarioRepo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Transactional
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = {"Dicionario"})
public class DicionarioController {

  @Autowired private JdbcTemplate jdbcTemplate;
  @Autowired private DicionarioRepo dicionarioRepo;

  @ApiOperation(value = "List of customers", response = CustomerResponse.class)
  @RequestMapping(value = "/dicionario", method = RequestMethod.GET)
  public DicionarioResponse getCustomersByPage(
    @ApiParam(value = ""    )               @RequestParam(value = "page"  ,  defaultValue="1"   ,  required = false) Integer page,
    @ApiParam(value = "between 1 to 1000" ) @RequestParam(value = "size"  ,  defaultValue="20"  ,  required = false) Integer size,
    @RequestParam(value = "customerid"  , required = false) Integer customerId,
    @RequestParam(value = "company"  , required = false) String company,
    @RequestParam(value = "country"  , required = false) String country,
    Pageable pageable
  ) {
      DicionarioResponse resp = new DicionarioResponse();
      Customer qry = new Customer();
      if (customerId != null) { qry.setId(customerId); }
      if (company != null)    { qry.setCompany(company); }
      if (country != null)    { qry.setCountry(country); }

      Page<Tela> pg = dicionarioRepo.findAll(pageable);
      resp.setPageStats(pg, true);
      resp.setItems(pg.getContent());
      return resp;
  }

    @ApiOperation(value = "Add new customer", response = OperationResponse.class)
    @RequestMapping(value = "/dicionario", method = RequestMethod.POST, produces = {"application/json"})
    public OperationResponse addNewCustomer(@RequestBody Tela customer, HttpServletRequest req) {
        OperationResponse resp = new OperationResponse();
        if (this.dicionarioRepo.exists(customer.getTelaId()) ){
            resp.setOperationStatus(ResponseStatusEnum.ERROR);
            resp.setOperationMessage("Unable to add Customer - Customer allready exist ");
        }
        else{
        	Tela addedCustomer = this.dicionarioRepo.save(customer);
            resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
            resp.setOperationMessage("Customer Added");
        }
        return resp;
    }


    @ApiOperation(value = "Delete a customer", response = OperationResponse.class)
    @RequestMapping(value = "/dicionario/{customerId}", method = RequestMethod.DELETE, produces = {"application/json"})
    public OperationResponse deleteCustomer(@PathVariable("customerId") Integer customerId, HttpServletRequest req) {
        OperationResponse resp = new OperationResponse();
        try {
            if (this.dicionarioRepo.exists(customerId) ){
                this.dicionarioRepo.delete(customerId);
                resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
                resp.setOperationMessage("Customer Deleted");
            }
            else{
                resp.setOperationStatus(ResponseStatusEnum.ERROR);
                resp.setOperationMessage("No Customer Exist");
            }
        }
        catch ( Exception ge ){
            System.out.println("========= MRIN GENERIC EXCEPTION ============");
            resp.setOperationStatus(ResponseStatusEnum.ERROR);
            resp.setOperationMessage(ge.getMessage());
        }

        return resp;
    }
    
}
