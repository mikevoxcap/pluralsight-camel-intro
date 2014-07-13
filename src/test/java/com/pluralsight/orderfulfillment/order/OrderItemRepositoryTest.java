package com.pluralsight.orderfulfillment.order;

import static org.junit.Assert.*;

import java.util.*;

import javax.inject.*;

import org.junit.*;

import com.pluralsight.orderfulfillment.test.*;

public class OrderItemRepositoryTest extends BaseJpaRepositoryTest {

   @Inject
   private OrderItemRepository orderItemRepository;

   @Before
   public void setUp() throws Exception {
   }

   @After
   public void tearDown() throws Exception {
   }

   @Test
   public void test_findAllOrderItemsSuccess() throws Exception {
      List<OrderItemEntity> orderItems = orderItemRepository.findAll();
      assertNotNull(orderItems);
      assertFalse(orderItems.isEmpty());
   }

   @Test
   public void test_findOrderItemOrderCatalogItemSuccess() throws Exception {
      List<OrderItemEntity> orderItems = orderItemRepository.findAll();
      assertNotNull(orderItems);
      assertFalse(orderItems.isEmpty());
      OrderItemEntity orderItem = orderItems.get(0);
      assertNotNull(orderItem.getOrder());
      assertNotNull(orderItem.getCatalogItem());
   }

   @Test
   public void test_findByOrderIdSuccess() throws Exception {
      List<OrderItemEntity> orderItems = orderItemRepository.findByOrderId(1L);
      assertNotNull(orderItems);
      assertFalse(orderItems.isEmpty());
   }

   @Test
   public void test_() throws Exception {
      List<Long> orderIds = new ArrayList<Long>();
      orderIds.add(1L);
      orderIds.add(2L);
      orderIds.add(3L);
      orderIds.add(4L);
      int updateCount = orderItemRepository.updateStatus(
            OrderStatus.PROCESSING.getCode(),
            new Date(System.currentTimeMillis()), orderIds);
      assertTrue(updateCount == 8);
   }
}
