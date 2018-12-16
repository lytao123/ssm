package com.ssm.service;

import java.util.List;

import com.ssm.po.ItemsCustom;
import com.ssm.po.ItemsQueryVo;

/**
* @Description 商品管理service
* @author 欧阳
* @since 2018年11月18日 上午12:07:16
* @version V1.0
*/

public interface ItemService {
	//商品查询列表
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) 
    		throws Exception;
    
  //根据id查询商品信息
  public ItemsCustom findItemsById(Integer id) throws Exception;
}
