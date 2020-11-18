import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14342
 * Date: 2020-11-18
 * Time: 23:50
 **/
public class Main {

    public static void main(String[] args) throws IOException {
       /* BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String[] ret = s.split(" ");
        int n = Integer.parseInt(ret[0]);
        int h = Integer.parseInt(ret[1]);
        int m = Integer.parseInt(ret[2]);
        int tmp = 0;
        //当剩余时间以喝酸奶的时间的余数为0，那么证明恰好可以喝完整数瓶酸奶，否则哪怕是喝了一口瓶数也应该-1
        if (m/h == 0){
            tmp = n-m/h;
        }else {
            tmp = n-m/h -1;
        }
        System.out.println(tmp);*/
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.next();
            char c = 0;
            for (int i = 0; i < s.length(); i++) {
                 c = s.charAt(i);
            }
            if (c > 'a' && c < 'z' || c >'A' && c < 'Z'){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }

        }

    }
}
