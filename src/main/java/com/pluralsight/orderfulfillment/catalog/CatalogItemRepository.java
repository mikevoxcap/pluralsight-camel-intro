package com.pluralsight.orderfulfillment.catalog;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository access for CatalogItemEntity data.
 * 
 * @author Michael Hoffman, Pluralsight
 *
 */
public interface CatalogItemRepository extends JpaRepository<CatalogItemEntity, Integer> {
   
}
