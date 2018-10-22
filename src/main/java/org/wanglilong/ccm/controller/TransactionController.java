package org.wanglilong.ccm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wanglilong.ccm.dto.request.TransactionAddOneRequest;
import org.wanglilong.ccm.dto.request.TransactionUpdateOneRequest;
import org.wanglilong.ccm.dto.response.TransactionResponse;
import org.wanglilong.ccm.exception.NotFoundException;
import org.wanglilong.ccm.service.api.ITransactionService;

@RestController
@RequestMapping("/credits/{creditCardId}/transactions")
public class TransactionController {
	@Autowired
	private ITransactionService transactionService;
	
	@GetMapping("/{id}")
	public TransactionResponse findOne(@PathVariable String creditCardId, @PathVariable String id) throws NotFoundException{
		return transactionService.findOne(creditCardId, id);
	}
	
	@GetMapping
	public List<TransactionResponse> findAll(@PathVariable String creditCardId){
		return transactionService.findAll(creditCardId);
	}
	
	@PostMapping
	public String addOne(@PathVariable String creditCardId,
			@Valid @RequestBody TransactionAddOneRequest transactionAddOneRequest){
		return transactionService.addOne(creditCardId, transactionAddOneRequest);
	}
	
	@PutMapping("/{id}")
	public int updateOne(@PathVariable String creditCardId, @PathVariable String id,
			@Valid @RequestBody TransactionUpdateOneRequest transactionUpdateOneRequest){
		return transactionService.updateOne(creditCardId, id, transactionUpdateOneRequest);
	}
	
	@DeleteMapping("/{id}")
	public int deleteOne(@PathVariable String creditCardId, @PathVariable String id){
		return transactionService.deleteOne(creditCardId, id);
	}
}
