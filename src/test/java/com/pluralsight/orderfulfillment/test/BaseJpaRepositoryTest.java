package com.pluralsight.orderfulfillment.test;

import javax.persistence.*;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.support.*;
import org.springframework.test.context.transaction.*;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.*;

import com.pluralsight.orderfulfillment.config.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class })
@WebAppConfiguration
@TransactionConfiguration(transactionManager = "transactionManager")
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class,
      DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class })
@Transactional
@Ignore
public class BaseJpaRepositoryTest {

   @PersistenceContext
   protected EntityManager entityManager;

}
