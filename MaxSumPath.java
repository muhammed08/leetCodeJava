
/*
You are given two sorted arrays of distinct integers nums1 and nums2.

A valid path is defined as follows:

Choose array nums1 or nums2 to traverse (from index-0).
Traverse the current array from left to right.
If you are reading any value that is present in nums1 and nums2 you are allowed to change your path to the other array. (Only one repeated value is considered in the valid path).
The score is defined as the sum of unique values in a valid path.

Return the maximum score you can obtain of all possible valid paths. Since the answer may be too large, return it modulo 109 + 7.
 */
public class MaxSumPath {
    public int maxSum(int[] nums1, int[] nums2) {
        int m= 1000000007;
        int n1=nums1.length;
        int n2=nums2.length;
        if (n1 == 0) {
            int sum=0;
            for(int i=0;i<n2;i++){
                sum+=nums2[i];
                sum = sum%m;
            }
        }
        if (n2 == 0) {
            int sum=0;
            for(int i=0;i<n1;i++){
                sum+=nums1[i];
                sum = sum%m;
            }
        }

        int i1=0,i2=0, sum1=0,sum2=0, main_sum=0, is_mod_1=0, is_mod_2=0;
        while(i1<n1 && i2< n2){
            if (nums1[i1] < nums2[i2]){
                sum1+=nums1[i1];
                int modSum = sum1%m;
                if (modSum != sum1){
                    is_mod_1+=1;
                    sum1=modSum;
                }
                i1+=1;
            } else if (nums2[i2] < nums1[i1]){
                sum2+=nums2[i2];
                int modSum = sum2%m;
                if (modSum != sum2){
                    is_mod_2+=1;
                    sum2=modSum;
                }
                i2+=1;
            } else{
                if(sum1<sum2 && is_mod_1 <= is_mod_2){
                    //System.out.println("1: sum1 :" + sum1 + " sum2 :"+ sum2);
                    main_sum+=sum2;
                    main_sum = main_sum%m;
                } else{
                    //System.out.println("2: sum1 :" + sum1 + " sum2 :"+ sum2);
                    main_sum+=sum1;
                    main_sum = main_sum%m;
                }
                main_sum+=nums1[i1];
                sum1=0;
                sum2=0;
                is_mod_1= 0;
                is_mod_2=0;
                i1+=1;
                i2+=1;
            }
        }

        if (i2<n2){
            while(i2<n2){
                sum2+=nums2[i2];
                int modSum = sum2%m;
                if (modSum != sum2){
                    is_mod_2+=1;
                    sum2=modSum;
                }
                i2+=1;
            }
        }
        if (i1<n1){
            while(i1<n1){
                sum1+=nums1[i1];
                int modSum = sum1%m;
                if (modSum != sum1){
                    is_mod_1+=1;
                    sum1=modSum;
                }
                i1+=1;
            }
        }
        //System.out.println("3: sum1 :" + sum1 + " sum2 :"+ sum2);
        if(sum2>sum1 && is_mod_1 <= is_mod_2){
            main_sum+=sum2;
            main_sum = main_sum%m;
        } else{
            main_sum+=sum1;
            main_sum = main_sum%m;
        }

        return main_sum;
    }

    public static void main(String[] args) {
        MaxSumPath path = new MaxSumPath();
        int[] n1 = {1,3,5,7,9};
        int[] n2 = {3,5,100};
        System.out.println(path.maxSum(n1,n2));
    }
}
