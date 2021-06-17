package searchTest;

import java.util.HashMap;

/*
该类是关键字搜索算法的具体实现类，但是还无法实现关键字搜索功能
使用该类前要先修改init的方法 把对应的数据加载到 indexSearch类的成员变量中
在使用时 ，要new 一个indexSearch 类出来，然后使用使用 getGoalString()方法
该方法 会返回与之匹配的在数据库中的字符串，并且将数据库中的cid 存放在该类的 indexKey变量中
如果返回字符串为空表未找到



 */

public class indexSearch {
    String str; //关键字
    String  commodityList[]; //从数据库中获取的商品名称数组
    static  int indexKey=0;  //用来存放匹配的商品的cid
    static String goalString="";
    public void init(){
        //该方法用于获取 str 和 commmodityList的值 暂时未写
    }

    public  String getGoalString() {
        //先初始化
        //如果未找到匹配的数会返回空字符串 ""
        init();


        HashMap<String,String> map = new HashMap<>();
        //初始化hash表
        for(int i=1;i<=commodityList.length;i++)
        {
            map.put(commodityList[i-1],String.valueOf(i));
        }
        //如果找到了 直接返回结果
        if(map.get(str)!=null){
            indexKey= Integer.parseInt(map.get(str));
            goalString = str;
            return goalString;
        }

        //如果没有找到
        for(int i = 0;i<commodityList.length;i++)
        {
            if(commodityList[i].length()>=str.length())
            {
                if(match(commodityList[i],str)!=-1){
                    indexKey = i+1;
                    goalString = commodityList[i];
                    return goalString;
                }
            }
            else
            {
                if(match(str,commodityList[i])!=-1){
                    indexKey = i+1;
                    goalString = commodityList[i];
                    return goalString;
                }

            }





        }

        goalString="";
        return goalString;

    }
    //source 较长
    public static int match(String source, String pattern) {
        int index = -1;
        boolean match = true;
        for (int i = 0, len = source.length() - pattern.length(); i <= len; i++) {
            match = true;
            for (int j = 0; j < pattern.length(); j++) {
                if (source.charAt(i + j) != pattern.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                index = i;
                break;
            }
        }
        return index;
    }





}