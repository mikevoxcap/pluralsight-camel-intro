package com.pluralsight.orderfulfillment.order;

import java.io.*;
import java.util.*;

import javax.persistence.*;

import com.pluralsight.orderfulfillment.customer.*;

/**
 * Order entity
 * 
 * @author Michael Hoffman, Pluralsight
 * 
 */
@Entity
@Table(name = "order")
@SequenceGenerator(name = "order_id_seq", sequenceName = "order_id_seq")
public class OrderEntity implements Serializable {

   private static final long serialVersionUID = -8239299025198163223L;

   private long id;
   private CustomerEntity customer;
   private String orderNumber;
   private Date timeOrderPlaced;
   private Date lastUpdate;
   private String status;
   private Set<OrderItemEntity> orderItems = new HashSet<OrderItemEntity>(0);

   public OrderEntity() {

   }

   public OrderEntity(long id, CustomerEntity customer, String orderNumber,
         Date timeOrderPlaced, Date lastUpdate, String status) {
      this.id = id;
      this.customer = customer;
      this.orderNumber = orderNumber;
      this.timeOrderPlaced = timeOrderPlaced;
      this.lastUpdate = lastUpdate;
      this.status = status;
   }

   public OrderEntity(long id, CustomerEntity customer, String orderNumber,
         Date timeOrderPlaced, Date lastUpdate, String status, Set<OrderItemEntity> orderItems) {
      this.id = id;
      this.customer = customer;
      this.orderNumber = orderNumber;
      this.timeOrderPlaced = timeOrderPlaced;
      this.lastUpdate = lastUpdate;
      this.status = status;
      this.orderItems = orderItems;
   }

   /**
    * @return the id
    */
   @Id
   @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_seq")
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
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "customer_id", nullable = false)
   public CustomerEntity getCustomer() {
      return customer;
   }

   /**
    * @param customer
    *           the customer to set
    */
   public void setCustomer(CustomerEntity customer) {
      this.customer = customer;
   }

   /**
    * @return the orderNumber
    */
   @Column(name = "orderNumber", nullable = false)
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
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "timeOrderPlaced", nullable = false, length = 29)
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
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "lastUpdate", nullable = false, length = 29)
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
   @Column(name = "status", nullable = false)
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
    * @return the orderItems
    */
   @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
   public Set<OrderItemEntity> getOrderItems() {
      return orderItems;
   }

   /**
    * @param orderItems
    *           the orderItems to set
    */
   public void setOrderItems(Set<OrderItemEntity> orderItems) {
      this.orderItems = orderItems;
   }

}
