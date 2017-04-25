/*package com.springApp.mapper;

import java.util.Date;

import org.mapstruct.Mapper;

import com.springApp.model.Order;
import com.springApp.model.OrderVO;


public class OrderDTOMapperDecorator implements OrderDTOMapper{

	@Override
	public Order map(OrderVO rv) {
		
		Order r=new Order();
		r.setOrderDate(rv.getRdate());
		r.setOrderId(rv.getRid());
		r.setServices(rv.getServices());
		
	//Order order=OrderDTOMapper.INSTANCE.map(rv);
	
		return r;
	}

}
*/