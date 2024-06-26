package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Items;
import com.example.demo.mapper.ItemsMapper;

@Service
public class ItemsServiceImpl implements ItemsService {
	
	@Autowired
	private ItemsMapper itemsMapper;
	
	public ItemsServiceImpl(ItemsMapper itemsMapper){
		this.itemsMapper = itemsMapper;
	}

	@Override
	public List<Items> getItems() {
		return this.itemsMapper.findAll();
	}

}
