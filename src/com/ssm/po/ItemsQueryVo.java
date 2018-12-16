package com.ssm.po;

public class ItemsQueryVo {
	
	private Items items;				//商品类
	
	//自定义用户扩展类,提高系统的可扩展性
	private ItemsCustom itemsCustom;	//自定义用户扩展类
	
	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}

	@Override
	public String toString() {
		return "ItemsQueryVo [items=" + items + ", itemsCustom=" + itemsCustom + "]";
	}
	
}
