package com.xoriant.banking.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.xoriant.banking.repository.PersonalInfoDao;
@ExtendWith(SpringExtension.class)
@DataJpaTest
@RunWith(SpringRunner.class)
public class TestClass {
	
	@MockBean
	 PersonalInfoDao personalInfoDao;
	@Autowired
    ApplicationContext context;
	@Test
	void authAccount_GivenAccountNumber_ShouldReturnTrue() {
		//PersonalInfoDao personalInfoDao = Mockito.mock(PersonalInfoDao.class);
	    Mockito.when(personalInfoDao.count()).thenReturn((long) 21);

	    PersonalInfoDao userRepoFromContext = context.getBean(PersonalInfoDao.class);
        long userCount = userRepoFromContext.count();

	   

	    Assert.assertEquals(21, userCount);
	    Mockito.verify(personalInfoDao).count();
		
	}
}
