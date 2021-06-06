package entity;

import java.util.List;

/**
 * 提供商品种类实体类
 */
public class Category {
    /*
    Definitions：种类名 种类id （所属种类）商品列表
     */
    private String name;
    private int id;
    List<Commodity> commodity;

    /*
    Getters and Setters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Commodity> getCommodity() {
        return commodity;
    }

    public void setCommodity(List<Commodity> commodity) {
        this.commodity = commodity;
    }

    /*
    toString()
     */
    @Override
    public String toString() {
        return "Category [name=" + name + "]";
    }
}