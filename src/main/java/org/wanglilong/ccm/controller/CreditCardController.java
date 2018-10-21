package org.wanglilong.ccm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wanglilong.ccm.dto.request.CreditCardAddOneRequest;
import org.wanglilong.ccm.dto.request.CreditCardUpdateOneRequest;
import org.wanglilong.ccm.dto.response.CreditCardResponse;
import org.wanglilong.ccm.exception.NotFoundException;
import org.wanglilong.ccm.service.api.ICreditCardService;

@RestController
@RequestMapping("/credits")
public class CreditCardController {

	@Autowired
	private ICreditCardService creditCardService;
	
	@GetMapping("/{id}")
	public CreditCardResponse findOne(@PathVariable String id) throws NotFoundException{
		return creditCardService.findOne(id);
	}
	
	@GetMapping
	public List<CreditCardResponse> findAll(@RequestParam(required=false) String bankId, 
			@RequestParam(required=false) String number){
		return creditCardService.findAll(bankId, number);
	}
	
	@PostMapping
	public String addOne(@RequestBody CreditCardAddOneRequest creditCard){
		return creditCardService.addOne(creditCard);
	}
	
	@PutMapping("/{id}")
	public int updateOne(@PathVariable String id, @RequestBody CreditCardUpdateOneRequest creditCard){
		return creditCardService.updateOne(id, creditCard);
	}
	
	@DeleteMapping("/{id}")
	public int deleteOne(@PathVariable String id){
		return creditCardService.deleteOne(id);
	}
}
