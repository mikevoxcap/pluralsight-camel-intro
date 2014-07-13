package com.pluralsight.orderfulfillment.order;

import java.util.*;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;

/**
 * Repository for OrderEntity data.
 * 
 * @author Michael Hoffman, Pluralsight
 * 
 */
public interface OrderRepository extends
      PagingAndSortingRepository<OrderEntity, Integer> {

   /**
    * Select all orders for the page ordered by the timeOrderPlaced value in
    * ascending order.
    * 
    * @param status
    * @param pageable
    * @return
    */
   @Query(value = "select o from OrderEntity o where o.status = ?1 order by o.timeOrderPlaced")
   Page<OrderEntity> findByStatus(String status, Pageable pageable);

   /**
    * Update the status of all order IDs passed.
    * 
    * @param code
    * @param orderIds
    * @return
    */
   @Modifying
   @Query("update OrderEntity o set o.status = ?1, o.lastUpdate = ?2 where o.id in (?3)")
   int updateStatus(String code, Date lastUpdate, List<Long> orderIds);

}
