package entity;

import util.CommodityCategory;

import java.awt.*;

public class Commodity {
    /*
    Definitions：商品id 商品名称 商品图片 商品描述 商品种类
     */
    private int cid;
    private String commodity;
    private Image image;
    private String description;
    private CommodityCategory category;

    /*
    Constructors
     */
    public Commodity() {
    }

    public Commodity(int cid, String commodity, Image image, String description, CommodityCategory category) {
        this.cid = cid;
        this.commodity = commodity;
        this.image = image;
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

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CommodityCategory getCategory() {
        return category;
    }

    public void setCategory(CommodityCategory category) {
        this.category = category;
    }
}
