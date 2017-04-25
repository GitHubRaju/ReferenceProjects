package com.springApp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.springApp.model.Order;
import com.springApp.model.OrderVO;


@Mapper
public interface OrderDTOMapper {
	OrderDTOMapper INSTANCE=Mappers.getMapper(OrderDTOMapper.class);
	/*@Mappings({@Mapping(source="",target="")
	})*/

//public static	OrderDTOMapper INSTANCE=Mappers.getMapper(OrderDTOMapperDecorator.class);
	 Order map(OrderVO ordervo) ;
		// TODO Auto-generated method stub
		
	}


