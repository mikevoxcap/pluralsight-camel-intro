package com.pluralsight.orderfulfillment.order;

import java.util.*;

import com.pluralsight.orderfulfillment.customer.*;

/**
 * Domain object for an Order
 * 
 * @author Michael Hoffman, Pluralsight
 * 
 */
public class Order {
   private long id;
   private Customer customer;
   private String orderNumber;
   private Date timeOrderPlaced;
   private Date lastUpdate;
   private String status;

   public Order() {

   }

   public Order(long id, Customer customer, String orderNumber,
         Date timeOrderPlaced, Date lastUpdate, String status) {
      super();
      this.id = id;
      this.customer = customer;
      this.orderNumber = orderNumber;
      this.timeOrderPlaced = timeOrderPlaced;
      this.lastUpdate = lastUpdate;
      this.status = status;
   }

   /**
    * @return the id
    */
   public long getId() {
      return id;
   }

   /**
    * @param id
    *           the id to set
    */
   public void setId(long id) {
      this.id = id;
   }

   /**
    * @return the customer
    */
   public Customer getCustomer() {
      return customer;
   }

   /**
    * @param customer
    *           the customer to set
    */
   public void setCustomer(Customer customer) {
      this.customer = customer;
   }

   /**
    * @return the orderNumber
    */
   public String getOrderNumber() {
      return orderNumber;
   }

   /**
    * @param orderNumber
    *           the orderNumber to set
    */
   public void setOrderNumber(String orderNumber) {
      this.orderNumber = orderNumber;
   }

   /**
    * @return the timeOrderPlaced
    */
   public Date getTimeOrderPlaced() {
      return timeOrderPlaced;
   }

   /**
    * @param timeOrderPlaced
    *           the timeOrderPlaced to set
    */
   public void setTimeOrderPlaced(Date timeOrderPlaced) {
      this.timeOrderPlaced = timeOrderPlaced;
   }

   /**
    * @return the lastUpdate
    */
   public Date getLastUpdate() {
      return lastUpdate;
   }

   /**
    * @param lastUpdate
    *           the lastUpdate to set
    */
   public void setLastUpdate(Date lastUpdate) {
      this.lastUpdate = lastUpdate;
   }

   /**
    * @return the status
    */
   public String getStatus() {
      return status;
   }

   /**
    * @param status
    *           the status to set
    */
   public void setStatus(String status) {
      this.status = status;
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Order [id=");
      builder.append(id);
      builder.append(", ");
      if (customer != null) {
         builder.append("customer=");
         builder.append(customer);
         builder.append(", ");
      }
      if (orderNumber != null) {
         builder.append("orderNumber=");
         builder.append(orderNumber);
         builder.append(", ");
      }
      if (timeOrderPlaced != null) {
         builder.append("timeOrderPlaced=");
         builder.append(timeOrderPlaced);
         builder.append(", ");
      }
      if (lastUpdate != null) {
         builder.append("lastUpdate=");
         builder.append(lastUpdate);
         builder.append(", ");
      }
      if (status != null) {
         builder.append("status=");
         builder.append(status);
         builder.append(", ");
      }
      builder.append("]");
      return builder.toString();
   }

}
