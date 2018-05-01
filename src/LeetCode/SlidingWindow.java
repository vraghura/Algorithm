package LeetCode;

public class SlidingWindow {


    public static void main(String[] args) {

            int max_sum =0;

            int arr[] = new int[]{100,200,1000,300,400,600};

            int k=2;

        for(int i = 0; i < arr.length-k+1; i++){
            int current_sum = 0;

            for(int j = 0; j < k; j++){
                current_sum = current_sum + arr[i+j];
            }
            max_sum = Math.max(current_sum, max_sum);    // pick maximum sum
        }




        System.out.println(max_sum);

        int window_sum =0;
        int max_sum1 = 0;

        for(int i=0; i<k; i++){
            window_sum = window_sum + arr[i];
        }

        for(int j=k; j<arr.length; j++){
            window_sum = window_sum - arr[j-k] + arr[j];
            max_sum1 = Math.max(max_sum1, window_sum);
        }
        System.out.println(max_sum1);

    }
}
