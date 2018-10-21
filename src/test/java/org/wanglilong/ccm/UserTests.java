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
import org.wanglilong.ccm.po.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class UserTests {

	private final static String RESOURCE_URI = "/users";
	private final static String SUB_RESOURCE_URI = RESOURCE_URI+"/%s";
	
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void contextLoads() {
		restTemplate.withBasicAuth("wanglilong", "123");
	}
	
	@Test
	public void testAddAndDelete(){
		User user = createOne("wanglilong", "1", "1", "1234");
		String id = addOne(user);
		assertThat(id).isNotBlank();
		deleteOne(id);
	}
	
	@Test
	public void testUpdateAndGet(){
		User user = createOne("lisha","1","1", "1234");
		String id  = addOne(user);
		assertThat(id).isNotBlank();
		user.setPassword("1235");
		updateOne(id, user);
		deleteOne(id);
	}
	
	@Test
	public void testFindAll(){
		User user = createOne("123","1","1", "sdfsd");
		String id  = addOne(user);
		List<User> users = findAll();
		assertThat(users.size()).isEqualTo(1);
		deleteOne(id);
	}
	
	private String addOne(User user){
		return restTemplate.postForObject(RESOURCE_URI, user, String.class, new HashMap<>());
	}
	
	private void deleteOne(String id){
		restTemplate.delete(String.format(SUB_RESOURCE_URI, id));
	}
	
	private void updateOne(String id, User user){
		restTemplate.put(String.format(SUB_RESOURCE_URI, id), user, new HashMap<>());
	}
	
	private User findOne(String id){
		return restTemplate.getForObject(String.format(SUB_RESOURCE_URI, id), User.class, new HashMap<>());
	}
	
	private List<User> findAll(){
		return restTemplate.getForObject(RESOURCE_URI, List.class, new HashMap<>());
	}
	
	private User createOne(String name, String phone, String email, String password){
		User user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);
		user.setPhone(phone);
		return user;
	}
}
