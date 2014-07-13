package com.pluralsight.orderfulfillment.order.fulfillment;

import java.io.*;
import java.text.*;
import java.util.*;

import javax.inject.*;

import org.slf4j.*;
import org.springframework.stereotype.*;

import au.com.bytecode.opencsv.*;

import com.pluralsight.orderfulfillment.order.*;

/**
 * Command that fulfills the new orders in context by sending them as an SSH
 * file.
 * 
 * @author Michael Hoffman
 * 
 */
@Component("newOrderSendToFulfillmentCenterOneCommand")
public class NewOrderSendToFulfillmentCenterOneCommand implements
      FulfillmentCommand {

   private static final Logger log = LoggerFactory
         .getLogger(NewOrderSendToFulfillmentCenterOneCommand.class);

   @Inject
   private OrderService orderService;

   @Override
   public void execute(FulfillmentContext context) {
      final List<String[]> orderFulfillmentLines = new ArrayList<String[]>();

      // 1 - Build the content to send for fulfillment using the orders in
      // context
      buildOrderFulfillmentLines(orderFulfillmentLines,
            context.getOrderDetails());

      // 2 - Write the lines out to the file
      writeOrderFulfillmentLines(orderFulfillmentLines,
            context.getFulfillmentCenter1OutboundFolder(),
            context.getFulfillmentCenter1FileName());
   }

   private void buildOrderFulfillmentLines(
         List<String[]> orderFulfillmentLines, List<Order> orderDetails) {
      // 1 - Iterate the orders
      for (Order order : orderDetails) {
         // 2 - Get the order items for the order
         List<OrderItem> orderItems = orderService.getOrderItems(order.getId());

         // 3 - Build the order fulfillment line
         for (OrderItem orderItem : orderItems) {
            orderFulfillmentLines.add(buildOrderFulfillmentLine(order,
                  orderItem));
         }
      }
   }

   /**
    * Builds a string array of the contents for an order fulfillment line. The
    * schema is as follows:
    * 
    * <ul>
    * <li>[0] = order number from order (not unique ID from database)</li>
    * <li>[1] = time the order was placed in the format yyyy.MM.dd HH:mm:ss z</li>
    * <li>[2] = the catalog item number, usually the SKU</li>
    * <li>[3] = the price</li>
    * <li>[4] = the quantity</li>
    * 
    * @param order
    * @param orderItem
    * @return
    */
   private String[] buildOrderFulfillmentLine(Order order, OrderItem orderItem) {
      // 1 - Build the array of data needed for the fulfillment center 1 schema
      final String[] line = new String[5];
      line[0] = order.getOrderNumber();
      line[1] = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss z").format(order
            .getTimeOrderPlaced());
      line[2] = orderItem.getCatalogItem().getItemNumber();
      line[3] = NumberFormat.getCurrencyInstance(Locale.US).format(
            orderItem.getPrice().doubleValue());
      line[4] = Integer.toString(orderItem.getQuantity());
      return line;
   }

   /**
    * Writes the orders out to a file.
    * 
    * @param orderFulfillmentLines
    * @param fulfillmentCenter1OutboundFolder
    * @param fulfillmentCenter1FileName
    */
   private void writeOrderFulfillmentLines(
         List<String[]> orderFulfillmentLines,
         String fulfillmentCenter1OutboundFolder,
         String fulfillmentCenter1FileName) {
      CSVWriter writer = null;
      try {
         String filePath = fulfillmentCenter1OutboundFolder
               + "/"
               + fulfillmentCenter1FileName
               + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System
                     .currentTimeMillis())) + ".csv";
         File file = new File(filePath);
         if (!file.exists()) {
            file.createNewFile();
         }
         writer = new CSVWriter(new FileWriter(file));
         writer.writeAll(orderFulfillmentLines);
      } catch (Exception e) {
         log.error(
               "An error occurred while writing out to a file for fulfillment center 1: "
                     + e.getMessage(), e);
      } finally {
         if (writer != null) {
            try {
               writer.close();
            } catch (Exception e) {
            }
         }
      }
   }

}
