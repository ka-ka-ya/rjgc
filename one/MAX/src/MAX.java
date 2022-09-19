import java.util.Scanner;

public class MAX{
public  static int findMaxArray(int[] array){
    if (array == null || array.length == 0) {
        return Integer.MIN_VALUE;
    }
    int maxSum = Integer.MIN_VALUE;
    int currentSum = 0;
    for (int i = 0; i < array.length; i++) {
        if (currentSum < 0) {
            currentSum = array[i];
        }else {
            currentSum += array[i];
        }
        maxSum = Math.max(maxSum, currentSum);
    }
    return maxSum;
}
public static void main(String[] args){
    Scanner a = new Scanner(System.in);
    int len = Integer.parseInt(a.next());
    int[] array = new int[len];
    for(int i=0;i<len;i++){
        array[i]=a.nextInt();
    }
    System.out.println(findMaxArray(array));
}
}