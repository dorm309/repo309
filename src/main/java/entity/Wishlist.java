package entity;

public class Wishlist {
    /*
    Definitions：愿望单所属用户id 卖家用户id 商品列表
     */
    private int id;
    private int uid;
    private int cid;

    /*
    Constructors
     */
    public Wishlist() {
    }

    public Wishlist(int id, int uid, int cid) {
        this.id = id;
        this.uid = uid;
        this.cid = cid;
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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}