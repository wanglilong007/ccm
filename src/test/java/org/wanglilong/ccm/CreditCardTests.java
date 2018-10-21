package org.wanglilong.ccm;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.wanglilong.ccm.dao.api.CreditCardDao;
import org.wanglilong.ccm.po.CreditCard;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CreditCardTests {

	private final static String RESOURCE_URI = "/credits";
	private final static String SUB_RESOURCE_URI = RESOURCE_URI+"/%s";
	
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private CreditCardDao creditCardDao;
	
	@Test
	public void contextLoads() {
		restTemplate.withBasicAuth("wanglilong", "123");
	}
	
	@Test
	public void testAddAndDelete(){
		CreditCard creditCard = createOne("123","1","1");
		String id = addOne(creditCard);
		assertThat(id).isNotBlank();
		deleteOne(id);
	}
	
	@Test
	public void testUpdateAndGet(){
		CreditCard creditCard = createOne("1234","1","1");
		String id = addOne(creditCard);
		assertThat(id).isNotBlank();
		creditCard.setNumber("4567");
		updateOne(id, creditCard);
		CreditCard card = findOne(id);
		assertThat(card.getNumber()).isEqualTo("4567");
		deleteOne(id);
	}
	
	@Test
	public void testFindAll(){
		CreditCard creditCard = createOne("123","1","1");
		addOne(creditCard);
		List<CreditCard> cards = findAll();
		assertThat(cards.size()).isEqualTo(1);
		deleteOne(creditCard.getId());
	}
	
	private String addOne(CreditCard creditCard){
		return restTemplate.postForObject(RESOURCE_URI, creditCard, String.class, new HashMap<>());
	}
	
	private void deleteOne(String id){
		restTemplate.delete(String.format(SUB_RESOURCE_URI, id));
	}
	
	private void updateOne(String id, CreditCard creditCard){
		restTemplate.put(String.format(SUB_RESOURCE_URI, id), creditCard, new HashMap<>());
	}
	
	private CreditCard findOne(String id){
		return restTemplate.getForObject(String.format(SUB_RESOURCE_URI, id), CreditCard.class, new HashMap<>());
	}
	
	private List<CreditCard> findAll(){
		return restTemplate.getForObject(RESOURCE_URI, List.class, new HashMap<>());
	}
	
	private CreditCard createOne(String number, String bankId, String creator){
		CreditCard creditCard = new CreditCard();
		creditCard.setNumber(number);
		creditCard.setBankId(bankId);
		creditCard.setCreator(creator);
		return creditCard;
	}
}
