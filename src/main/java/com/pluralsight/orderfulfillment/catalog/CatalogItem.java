package com.pluralsight.orderfulfillment.catalog;

import java.io.*;

public class CatalogItem implements Serializable {

   private static final long serialVersionUID = -3048858539620507612L;

   private long id;
   private String itemNumber;
   private String itemName;
   private String itemType;

   public CatalogItem() {

   }

   public CatalogItem(long id, String itemNumber, String itemName, String itemType) {
      this.id = id;
      this.itemNumber = itemNumber;
      this.itemName = itemName;
      this.itemType = itemType;
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
    * @return the itemNumber
    */
   public String getItemNumber() {
      return itemNumber;
   }

   /**
    * @param itemNumber
    *           the itemNumber to set
    */
   public void setItemNumber(String itemNumber) {
      this.itemNumber = itemNumber;
   }

   /**
    * @return the itemName
    */
   public String getItemName() {
      return itemName;
   }

   /**
    * @param itemName
    *           the itemName to set
    */
   public void setItemName(String itemName) {
      this.itemName = itemName;
   }

   /**
    * @return the itemType
    */
   public String getItemType() {
      return itemType;
   }

   /**
    * @param itemType
    *           the itemType to set
    */
   public void setItemType(String itemType) {
      this.itemType = itemType;
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("CatalogItem [id=");
      builder.append(id);
      builder.append(", ");
      if (itemNumber != null) {
         builder.append("itemNumber=");
         builder.append(itemNumber);
         builder.append(", ");
      }
      if (itemName != null) {
         builder.append("itemName=");
         builder.append(itemName);
         builder.append(", ");
      }
      if (itemType != null) {
         builder.append("itemType=");
         builder.append(itemType);
      }
      builder.append("]");
      return builder.toString();
   }

}
