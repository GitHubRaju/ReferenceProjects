package com.springApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springApp.model.Order;
@Repository
@Transactional
@RepositoryRestResource(collectionResourceRel="order",path="order")
public interface OrderRepository extends PagingAndSortingRepository<Order,Long>
{
	
	@Query(value="select b.orderDate from Order b where b.services=:services")
	List<Order> findByServices(@Param(value = "services") String services);
	

}
