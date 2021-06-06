package entity;

/**
 * 提供商品图片实体类
 */
public class CommodityImages {
    /*
    Definitions：商品 图片id
     */
    private Commodity commodity;
    private int id;

    /*
    Getters and Setters
     */
    public int getId() {
        return id;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public void setId(int id) {
        this.id = id;
    }

}
