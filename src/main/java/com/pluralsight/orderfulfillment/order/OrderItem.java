package com.pluralsight.orderfulfillment.order;

import java.io.*;
import java.math.*;
import java.util.*;

import com.pluralsight.orderfulfillment.catalog.*;

public class OrderItem implements Serializable {

   private static final long serialVersionUID = 8218385047375857766L;

   private long id;
   private CatalogItem catalogItem;
   private String status;
   private BigDecimal price;
   private Date lastUpdate;
   private int quantity;

   public OrderItem() {

   }

   public OrderItem(long id, CatalogItem catalogItem, String status, BigDecimal price,
         Date lastUpdate, int quantity) {
      super();
      this.id = id;
      this.catalogItem = catalogItem;
      this.status = status;
      this.price = price;
      this.lastUpdate = lastUpdate;
      this.quantity = quantity;
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
    * @return the catalogItem
    */
   public CatalogItem getCatalogItem() {
      return catalogItem;
   }

   /**
    * @param catalogItem
    *           the catalogItem to set
    */
   public void setCatalogItem(CatalogItem catalogItem) {
      this.catalogItem = catalogItem;
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

   /**
    * @return the price
    */
   public BigDecimal getPrice() {
      return price;
   }

   /**
    * @param price
    *           the price to set
    */
   public void setPrice(BigDecimal price) {
      this.price = price;
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
    * @return the quantity
    */
   public int getQuantity() {
      return quantity;
   }

   /**
    * @param quantity
    *           the quantity to set
    */
   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("OrderItem [id=");
      builder.append(id);
      builder.append(", ");
      if (catalogItem != null) {
         builder.append("catalogItem=");
         builder.append(catalogItem);
         builder.append(", ");
      }
      if (status != null) {
         builder.append("status=");
         builder.append(status);
         builder.append(", ");
      }
      if (price != null) {
         builder.append("price=");
         builder.append(price);
         builder.append(", ");
      }
      if (lastUpdate != null) {
         builder.append("lastUpdate=");
         builder.append(lastUpdate);
         builder.append(", ");
      }
      builder.append("quantity=");
      builder.append(quantity);
      builder.append("]");
      return builder.toString();
   }

}
