package com.pluralsight.orderfulfillment.order.fulfillment;

import java.util.*;

import javax.inject.*;

import org.slf4j.*;
import org.springframework.core.env.*;
import org.springframework.stereotype.*;

import com.pluralsight.orderfulfillment.order.*;

/**
 * Command to retrieve the next set of orders for processing. This includes
 * selecting the orders, updating their status and putting them into the
 * context.
 * 
 * @author Michael Hoffman, Pluralsight
 * 
 */
@Component("newOrderRetrievalCommand")
public class NewOrderRetrievalCommand implements FulfillmentCommand {

   private static final Logger log = LoggerFactory
         .getLogger(NewOrderRetrievalCommand.class);

   @Inject
   private Environment environment;

   @Inject
   private OrderService orderService;

   /*
    * (non-Javadoc)
    * 
    * @see
    * com.pluralsight.orderfulfillment.order.FulfillmentCommand#execute(com.
    * pluralsight.orderfulfillment.order.FulfillmentContext)
    */
   @Override
   public void execute(FulfillmentContext context) {
      // 1 - Load the context
      try {
         loadContext(context);
      } catch (Exception e) {
         log.error(
               "An error occurred while retrieving new orders: "
                     + e.getMessage(), e);
      }
   }

   /**
    * Populate the context for this run of order fulfillment
    * 
    * @param context
    */
   private void loadContext(FulfillmentContext context) throws Exception {
      // 1 - Determine how many orders we process at a time
      int fetchSize = Integer.parseInt(environment
            .getProperty("neworderretrievalcommand.fetchsize"));

      // 2 - Get the order details for new orders. This will retrieve the next
      // five order entries in order of the time it was placed.
      List<Order> newOrders = orderService.getOrderDetails(OrderStatus.NEW,
            fetchSize);

      // 3 - Mark the orders as in progress so they are not retrieved again by a
      // new processor.
      orderService.processOrderStatusUpdate(newOrders, OrderStatus.PROCESSING);

      // 4 - Now update the context
      context.setOrderDetails(newOrders);
      context.setFulfillmentCenter1OutboundFolder(environment
            .getProperty("order.fulfillment.center.1.outbound.folder"));
      context.setFulfillmentCenter1FileName(environment
            .getProperty("order.fulfillment.center.1.filename"));
   }

}
