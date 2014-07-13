package com.pluralsight.orderfulfillment.customer;

import static org.junit.Assert.*;

import java.util.*;

import javax.inject.*;

import org.junit.*;

import com.pluralsight.orderfulfillment.order.OrderEntity;
import com.pluralsight.orderfulfillment.test.*;

public class CustomerRepositoryTest extends BaseJpaRepositoryTest {

   @Inject
   private CustomerRepository customerRepository;

   @Before
   public void setUp() throws Exception {
   }

   @After
   public void tearDown() throws Exception {
   }

   @Test
   public void test_findAllCustomersSuccess() throws Exception {
      List<CustomerEntity> customers = customerRepository.findAll();
      assertNotNull(customers);
      assertFalse(customers.isEmpty());
   }
   
   @Test
   public void test_findCustomerOrdersSuccess() throws Exception {
      List<CustomerEntity> customers = customerRepository.findAll();
      assertNotNull(customers);
      assertFalse(customers.isEmpty());
      CustomerEntity customer = customers.get(0);
      Set<OrderEntity> orders = customer.getOrders();
      assertNotNull(orders);
      assertFalse(orders.isEmpty());
   }

}
