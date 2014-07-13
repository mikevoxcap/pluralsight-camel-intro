package com.pluralsight.orderfulfillment.order.fulfillment;

/**
 * Interface for all commands that handle order fulfillment processing.
 * 
 * @author Michael Hoffman, Pluralsight
 */
public interface FulfillmentCommand {

   void execute(FulfillmentContext context);
}
