package entity;

import java.util.Date;
import java.util.List;

public class Commodity {
    /*
    Definitions：商品id 所属卖家 商品名称 创建日期 商品价格 商品图片 商品描述 商品种类
     */
    private int cid;
    private int uid;
    private String name;
    private Date createDate;
    private float price;
    private List<CommodityImages> commodityImages;
    private String description;
    private Category category;

    /*
    Constructors
     */
    public Commodity() {

    }

    public Commodity(String name, Date createDate, float price, List<CommodityImages> commodityImages, String description, Category category) {
        this.name = name;
        this.createDate = createDate;
        this.price = price;
        this.commodityImages = commodityImages;
        this.description = description;
        this.category = category;
    }

    /*
    Getters and Setters
     */
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<CommodityImages> getCommodityImages() {
        return commodityImages;
    }

    public void setCommodityImages(List<CommodityImages> commodityImages) {
        this.commodityImages = commodityImages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}