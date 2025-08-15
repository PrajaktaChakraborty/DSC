import java.util.Scanner;
class SubArray 
{
    //method to count continuous subarrays with sum=k
    public static int countSubarrays(int[] arr, int k) 
    {
        int count=0;
        for(int i=0;i<arr.length;i++) 
        {
            int sum=0;
            for (int j=i;j<arr.length;j++) 
            {
                // add the current element
                sum+=arr[j];
                // If sum matches k, increase count
                if (sum==k) 
                {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        //input array size from user
        System.out.print("Enter number of elements: ");
        int n=sc.nextInt();int[]arr=new int[n];
        System.out.println("Enter "+n+" integers:");
        for(int i=0;i<n;i++) 
        {
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter target sum k: ");
        int k=sc.nextInt();
        int result=countSubarrays(arr,k);
        System.out.println("Count of valid subarrays: " +result);
    }
}