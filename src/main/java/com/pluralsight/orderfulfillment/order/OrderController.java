package com.pluralsight.orderfulfillment.order;

import java.util.*;

import javax.inject.*;

import org.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for order-related requests
 * 
 * @author Michael Hoffman, Pluralsight
 * 
 */
@Controller
public class OrderController {

   private static final Logger log = LoggerFactory
         .getLogger(OrderController.class);

   @Inject
   private OrderService orderService;

   /**
    * Render the home page for order fulfillment.
    * 
    * @return String
    */
   @RequestMapping(value = "/orderHome")
   public String orderHome() {
      return "orderHome";
   }

   /**
    * Render the page that supports running the order fulfillment processor
    * 
    * @return String
    */
   @RequestMapping(value = "/processOrders", method = RequestMethod.GET)
   public String processOrdersRender() {
      return "processOrders";
   }

   /**
    * Execute order processing, than show the list of orders on the view orders
    * page.
    * 
    * @param model
    * @return String
    */
   @RequestMapping(value = "/processOrders", method = RequestMethod.POST)
   public String processOrders(Model model) {
      orderService.processOrderFulfillment();
      model.addAttribute("orders", orderService.getOrderDetails());
      return "viewOrders";
   }

   /**
    * Render the page that supports resetting the order status of orders that
    * ran through fulfillment.
    * 
    * @return String
    */
   @RequestMapping(value = "/resetOrders", method = RequestMethod.GET)
   public String resetOrdersRender() {
      return "resetOrders";
   }

   /**
    * Processes the resetting of orders fulfilled by order fulfillment.
    * 
    * @param model
    * @return
    */
   @RequestMapping(value = "/resetOrders", method = RequestMethod.POST)
   public String resetOrders(Model model) {
      List<Order> orders = orderService.getOrderDetails(OrderStatus.PROCESSING,
            100);
      try {
         orderService.processOrderStatusUpdate(orders, OrderStatus.NEW);
      } catch (Exception e) {
         log.error(
               "An error occurred while resetting orders: " + e.getMessage(), e);
      }
      model.addAttribute("orders", orderService.getOrderDetails());
      return "viewOrders";
   }

   /**
    * Builds the list of order details in the database to present in the view.
    * 
    * @param model
    * @return String
    */
   @RequestMapping(value = "/viewOrders", method = RequestMethod.GET)
   public String viewOrders(Model model) {
      model.addAttribute("orders", orderService.getOrderDetails());
      return "viewOrders";
   }
}
