package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Items;

@Mapper
public interface ItemsMapper {

	List<Items> findAll();
}
