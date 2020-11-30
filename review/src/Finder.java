/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14342
 * Date: 2020-11-30
 * Time: 20:45
 **/
public class Finder {
    public static void qSort(int[] array){
        qSortHelper(array,0,array.length-1);
    }
    public static void qSortHelper(int[] array,int lowIndex,int highIndex){
        int size = highIndex-lowIndex+1;
        if (size <= 1){
            return;
        }
        int keyIndex = partition(array,lowIndex,highIndex);
        qSortHelper(array,lowIndex,keyIndex-1);
        qSortHelper(array,keyIndex+1,highIndex);

    }
    private static void swap(int[] array,int x,int y){
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
    public static int partition(int[] array,int lowIndex,int highIndex){
        int key = array[lowIndex];
        int leftIndex = lowIndex;
        int rightIndex = highIndex;
        while(leftIndex < rightIndex){
            while(leftIndex < rightIndex && array[rightIndex] <= key){
                rightIndex--;
            }
            while(leftIndex < rightIndex && array[leftIndex] >= key){
                leftIndex++;
            }
            swap(array,leftIndex,rightIndex);
        }
        swap(array,lowIndex,leftIndex);
        return leftIndex;
    }
    public static int findKth(int[] a, int n, int K) {
        if (K >= n){
            return -1;
        }
        if (n == 0){
            return -1;
        }
        qSort(a);
        return a[K-1];
    }

}
