package com.ssm.po;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.ssm.validators.ValidGroup1;

public class Items {
 
    private Integer id;			//主键
    @NotEmpty(message="{items.name.notEmpty}",groups= {ValidGroup1.class})
    private String name;		//商品名称
    @Min(value=0,message="{items.price.error}")
    private Float price;		//价格
    private String pic;			//商品图片
    @Past(message="{items.createtime.error}")
    private Date createtime;	//创建时间
    @NotBlank(message="{items.detail.length.error}")
    private String detail;		//描述
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public String getPic() {
        return pic;
    }
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }
    public Date getCreatetime() {
        return createtime;
    }
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
    
	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", price=" + price + ", pic=" + pic + ", createtime=" + createtime
				+ ", detail=" + detail + "]";
	}
    
}