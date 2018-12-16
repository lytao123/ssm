package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.mapper.ItemsMapperCustom;
import com.ssm.po.Items;
import com.ssm.po.ItemsCustom;
import com.ssm.po.ItemsQueryVo;
import com.ssm.service.ItemService;

/**
* @Description 商品的管理
* @author 欧阳
* @since 2018年11月18日 上午12:09:42
* @version V1.0
*/

public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		
		//通过ItemsMapperCustom 查询数据库
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		Items items = itemsMapperCustom.selectByPrimaryKey(id);
		
		ItemsCustom itemsCustom = null;
		if(items != null) {
			itemsCustom = new ItemsCustom();
			BeanUtils.copyProperties(items, itemsCustom);
		} else {
			throw new Exception("商品信息不存在！");
		}
		return itemsCustom;
	}

}
