package com.pluralsight.orderfulfillment.customer;

import org.springframework.data.jpa.repository.*;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

}
