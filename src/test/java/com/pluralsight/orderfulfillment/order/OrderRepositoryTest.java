package com.pluralsight.orderfulfillment.order;

import static org.junit.Assert.*;

import java.util.*;

import javax.inject.*;

import org.junit.*;
import org.springframework.data.domain.*;

import com.pluralsight.orderfulfillment.test.*;

public class OrderRepositoryTest extends BaseJpaRepositoryTest {

   @Inject
   private OrderRepository orderRepository;

   @Before
   public void setUp() throws Exception {
   }

   @After
   public void tearDown() throws Exception {
   }

   @Test
   public void test_findAllOrdersSuccess() throws Exception {
      Iterable<OrderEntity> orders = orderRepository.findAll();
      assertNotNull(orders);
      assertTrue(orders.iterator().hasNext());
   }

   @Test
   public void test_findOrderCustomerAndOrderItemsSuccess() throws Exception {
      Iterable<OrderEntity> orders = orderRepository.findAll();
      assertNotNull(orders);
      Iterator<OrderEntity> iterator = orders.iterator();
      assertTrue(iterator.hasNext());
      OrderEntity order = iterator.next();
      assertNotNull(order.getCustomer());
      Set<OrderItemEntity> orderItems = order.getOrderItems();
      assertNotNull(orderItems);
      assertFalse(orderItems.isEmpty());
   }

   @Test
   public void test_findOrdersByOrderStatusOrderByTimeOrderPlacedAscSuccess()
         throws Exception {
      Iterable<OrderEntity> orders = orderRepository.findByStatus(
            OrderStatus.NEW.getCode(), new PageRequest(0, 5));
      assertNotNull(orders);
      assertTrue(orders.iterator().hasNext());
   }

   @Test
   public void test_findOrdersByOrderStatusOrderByTimeOrderPlacedAscFailInvalidStatus()
         throws Exception {
      Iterable<OrderEntity> orders = orderRepository.findByStatus("whefiehwi",
            new PageRequest(0, 5));
      assertNotNull(orders);
      assertFalse(orders.iterator().hasNext());
   }

   @Test
   public void test_updateStatusSuccess() throws Exception {
      List<Long> orderIds = new ArrayList<Long>();
      orderIds.add(1L);
      orderIds.add(2L);
      orderIds.add(3L);
      orderIds.add(4L);
      int count = orderRepository.updateStatus(
            OrderStatus.PROCESSING.getCode(),
            new Date(System.currentTimeMillis()), orderIds);
      assertTrue(count == 4);
   }
}
