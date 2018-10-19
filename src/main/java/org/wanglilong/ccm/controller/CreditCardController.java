package org.wanglilong.ccm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wanglilong.ccm.dao.api.CreditCardDao;
import org.wanglilong.ccm.po.CreditCard;

@RestController
public class CreditCardController {

	@Autowired
	private CreditCardDao creditCardDao;
	
	@GetMapping("/credit/1")
	public CreditCard findOne(){
		return creditCardDao.findOne("1");
	}
}
