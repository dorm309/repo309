import java.util.Date;

public class test {
    public static void main(String[] args) {
        //测试执行时间
        Date startDate = new Date();

        //..do

        Date endDate = new Date();

        System.out.println("执行消耗时间 = " + (endDate.getTime() -
                startDate.getTime()) + "ms");
    }
}
