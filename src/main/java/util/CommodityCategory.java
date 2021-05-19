package util;

public enum CommodityCategory {
    /*
    暂定商品种类，可动态变化
     */
    digit("数码", 1),
    clothing("服饰", 2),
    ornament("饰品", 3),
    book("图书", 4),
    dailyNecessity("日用", 5),
    makeup("美妆", 6);

    private String name;
    private int index;

    CommodityCategory(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
