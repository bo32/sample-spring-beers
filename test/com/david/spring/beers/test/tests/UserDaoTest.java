package com.david.spring.beers.test.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { 
		"classpath:com/david/spring/beers/config/dao-context.xml",
		"classpath:com/david/spring/beers/config/security-context.xml",
		"classpath:com/david/spring/beers/test/config/datasource-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {

	@Test
	public void testCreateUser() {
		Assert.fail("expected failure");
	}
}
