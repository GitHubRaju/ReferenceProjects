package com.springApp.mappertest;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.springApp.mapper.OrderDTOMapper;
import com.springApp.model.Address;
import com.springApp.model.Order;
import com.springApp.model.OrderVO;



public class MapperTest {
	Order r=null;
	Address a=new Address();

	/*@Before
	public void before()
	{
		OrderVO rvo=new OrderVO();
		rvo.setRdate(new Date());
		rvo.setRid(100L);
		rvo.setServices("Truck");
		
		r=(Order) OrderDTOMapper.INSTANCE.map(rvo);
	}*/
	@Test
	public void MapperTest()
	{
		OrderVO rvo=new OrderVO();
		rvo.setRdate(new Date());
		rvo.setRid(100L);
		rvo.setServices("Truck");
		
		r=(Order) OrderDTOMapper.INSTANCE.map(rvo);

		
		System.out.println("----------------"+r.getServices());
	}

}
