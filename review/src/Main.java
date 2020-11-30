import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14342
 * Date: 2020-11-30
 * Time: 20:23
 **/
public class Main {
    public static  boolean isHuiWen(String str){
        int left = 0;
        int right = str.length()-1;
        while(left < right){
            if (str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            int count = 0;
            for (int i = 0; i < str1.length(); i++) {
                StringBuilder stringBuilder = new StringBuilder(str1);
                stringBuilder.insert(i,str2);
                if (isHuiWen(stringBuilder.toString())){
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while(scanner.hasNext()){
            String[] ret = scanner.nextLine().split(" ");

            for (int i = 0; i < ret.length; i++) {
                set.add(ret[i]);
            }

        }
        System.out.println(set.size());
    }
}*/
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int n1 = 1;
        int n2 = 1;
        int n3 = 0;
        while(n2 < n){
            n3 = n1+n2;
            n1 = n2;
            n2 = n3;
        }
        int ret1 = Math.abs(n2-n);
        int ret2 = Math.abs(n1-n);
        if (ret1 > ret2){
            System.out.println(ret2);
        }else {
            System.out.println(ret1);
        }
    }
}
*/