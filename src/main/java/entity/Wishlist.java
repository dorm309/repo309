package entity;

/**
 * 提供愿望单实体类
 */
public class Wishlist {
    /*
    Definitions：愿望单所属用户id 商品列表
     */
    private int id;
    Commodity commodity;

    /*
    Constructors
     */
    public Wishlist() {
    }

    public Wishlist(int id, Commodity commodity) {
        this.id = id;
        this.commodity = commodity;
    }

    /*
            Getters and Setters
        */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Commodity getProducts() {
        return commodity;
    }

    public void setProducts(Commodity commodity) {
        this.commodity = commodity;
    }
}