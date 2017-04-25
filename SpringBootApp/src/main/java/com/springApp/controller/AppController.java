package com.springApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springApp.model.Order;
import com.springApp.repository.OrderRepository;

@RestController
public class AppController {
	
	@Autowired
	private OrderRepository orderRepository;

		@RequestMapping(value="/",produces={"application/json"},consumes={"application/json"},method=RequestMethod.POST)
		public Order test(@RequestBody Order r){
			//Order r=new Order();
		//r.setOrderId(new Long(123));
		//r.setOrderDate(new Date());
	//	r.setServices("DCS");
		orderRepository.save(r);
			return r;
			
		}
	
		@RequestMapping(value="/orderList",produces={"application/json"})
		public List<Order> orderList()
		{
		List<Order>	orderlist=(List<Order>) orderRepository.findAll();
		return orderlist;
		}
		
		@RequestMapping(value="/findservice", produces={"application/json"})
		public List<Order> findOrderDate(@RequestParam String service)
		{
			return orderRepository.findByServices(service);
		}
}
