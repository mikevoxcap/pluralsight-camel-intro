package com.pluralsight.orderfulfillment.customer;

/**
 * Domain object for a Customer
 * 
 * @author Michael Hoffman, Pluralsight
 * 
 */
public class Customer {
   private long id;
   private String firstName;
   private String lastName;
   private String email;

   public Customer() {

   }

   public Customer(long id, String firstName, String lastName, String email) {
      super();
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
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
    * @return the firstName
    */
   public String getFirstName() {
      return firstName;
   }

   /**
    * @param firstName
    *           the firstName to set
    */
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   /**
    * @return the lastName
    */
   public String getLastName() {
      return lastName;
   }

   /**
    * @param lastName
    *           the lastName to set
    */
   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   /**
    * @return the email
    */
   public String getEmail() {
      return email;
   }

   /**
    * @param email
    *           the email to set
    */
   public void setEmail(String email) {
      this.email = email;
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Customer [id=");
      builder.append(id);
      builder.append(", ");
      if (firstName != null) {
         builder.append("firstName=");
         builder.append(firstName);
         builder.append(", ");
      }
      if (lastName != null) {
         builder.append("lastName=");
         builder.append(lastName);
         builder.append(", ");
      }
      if (email != null) {
         builder.append("email=");
         builder.append(email);
      }
      builder.append("]");
      return builder.toString();
   }

}
