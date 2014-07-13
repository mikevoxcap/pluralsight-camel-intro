package com.pluralsight.orderfulfillment.customer;

import java.io.*;
import java.util.*;

import javax.persistence.*;

import com.pluralsight.orderfulfillment.order.*;

/**
 * Customer entity
 * 
 * @author Michael Hoffman
 * 
 */
@Entity
@Table(name = "customer")
@SequenceGenerator(name = "customer_id_seq", sequenceName = "customer_id_seq")
public class CustomerEntity implements Serializable {

   private static final long serialVersionUID = -7602916426025960936L;

   private long id;
   private String firstName;
   private String lastName;
   private String email;
   private Set<OrderEntity> orders = new HashSet<OrderEntity>(0);

   public CustomerEntity() {

   }

   public CustomerEntity(long id, String firstName, String lastName, String email) {
      super();
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public CustomerEntity(long id, String firstName, String lastName, String email,
         Set<OrderEntity> orders) {
      super();
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.orders = orders;
   }

   /**
    * @return the id
    */
   @Id
   @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_seq")
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
   @Column(name = "firstName", nullable = false)
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
   @Column(name = "lastName", nullable = false)
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
   @Column(name = "email", nullable = false)
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

   @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
   public Set<OrderEntity> getOrders() {
      return this.orders;
   }

   public void setOrders(Set<OrderEntity> orders) {
      this.orders = orders;
   }

}
