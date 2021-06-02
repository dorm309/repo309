package entity;

import java.util.List;

public class Wishlist {
    /*
    Definitions：愿望单id 用户id 商品列表
     */
    private int id;
    private int uid;
    List<Commodity> commodity;

    /*
    Getters and Setters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public List<Commodity> getProducts() {
        return commodity;
    }

    public void setProducts(List<Commodity> commodity) {
        this.commodity = commodity;
    }
}