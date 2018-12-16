package com.ssm.po;

import java.util.List;
import java.util.Map;

public class ItemsCustom extends Items{

	//这里添加扩展字段
	private List<Items> itemss;
	
	private Map<String, Object> map;
	
	public List<Items> getItemss() {
		return itemss;
	}

	public void setItemss(List<Items> itemss) {
		this.itemss = itemss;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "ItemsCustom [toString()=" + super.toString() + "]";
	}
}
