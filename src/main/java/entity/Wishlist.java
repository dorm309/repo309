package entity;

import java.util.List;

public class Wishlist {

    private int id;
    private int uid;
    List<Commodity> commodity;

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