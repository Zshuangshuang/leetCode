import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * Description:学号以及3科成绩，学号和成绩之间用英文分号隔开，成绩之间用英文逗号隔开。
 * User: 14342
 * Date: 2020-11-09
 * Time: 9:29
 **/
public class Main {
    public static void main(String[] args) throws IOException {
        //理解输入输出流：(1)System.in表示向屏幕输入一些数据
        //(2)new InputStreamReader():表示输入流，用来读数据
        //(3)new InputStreamReader(System.in):以system.in作为参数，使用InputStreamReader意思就是读取屏幕上输入的数据,不具有缓冲功能，所以用了BufferReader这个类

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //创建一个字符数组来放从屏幕读取的字符按照;,分割后的字符
        String[] split = bufferedReader.readLine().split("[;,]]");
        String a = String.format("%.2f",Double.parseDouble((split[1])));
        String b = String.format("%.2f",Double.parseDouble((split[2])));
        String c = String.format("%.2f",Double.parseDouble((split[3])));
        System.out.println("The each subject score of No."+split[0]+"is"+a+","+b+","+c+".");
    }


}
