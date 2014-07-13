package com.pluralsight.orderfulfillment.order.fulfillment;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * This is the entry point for order fulfillment processing. It provides a
 * single method for orchestrating the fulfillment process. Execution is started
 * by a scheduler or direct calls.
 * 
 * @author Michael Hoffman, Pluralsight
 * 
 */
@Component
public class FulfillmentProcessor {

   private static final Logger log = LoggerFactory
         .getLogger(FulfillmentProcessor.class);

   @Inject
   @Qualifier("newOrderRetrievalCommand")
   private FulfillmentCommand newOrderRetrievalCommand;

   @Inject
   @Qualifier("newOrderSendToFulfillmentCenterOneCommand")
   private FulfillmentCommand newOrderSendToFulfillmentCenterOneCommand;

   /**
    * Orchestrates order fulfillment.
    */
   public void run() {
      // 1 - Build a context to be passed into each of the commands
      FulfillmentContext context = new FulfillmentContext();

      // 2 - Call the order retrieval command to discover what orders need to be
      // fulfilled. New orders will be added to the context.
      newOrderRetrievalCommand.execute(context);

      // 3 - Call the order fulfill command to fulfill new orders through
      // fulfillment center 1.
      newOrderSendToFulfillmentCenterOneCommand.execute(context);
   }

   /**
    * @param newOrderRetrievalCommand
    *           the newOrderRetrievalCommand to set
    */
   public void setNewOrderRetrievalCommand(
         FulfillmentCommand newOrderRetrievalCommand) {
      this.newOrderRetrievalCommand = newOrderRetrievalCommand;
   }

   /**
    * @param newOrderSendToFulfillmentCenterOneCommand
    *           the newOrderSendToFulfillmentCenterOneCommand to set
    */
   public void setNewOrderSendToFulfillmentCenterOneCommand(
         FulfillmentCommand newOrderSendToFulfillmentCenterOneCommand) {
      this.newOrderSendToFulfillmentCenterOneCommand = newOrderSendToFulfillmentCenterOneCommand;
   }

}
