import java.util.*;
class LCS
{
    public static int findLCS(int[] arr) 
    {
        //sorting the array in ascending order
        Arrays.sort(arr);
        int longest=1;
        int currentLength=1;
        for(int i=1;i<arr.length;i++) 
        {
            //if consecutive number found
            if(arr[i] == arr[i - 1] + 1) 
            {
                currentLength++;
            }
            //if same number, skip
            else if(arr[i] != arr[i - 1]) 
            {
                currentLength = 1;
            }
            if(currentLength > longest) 
            {
                longest = currentLength;
            }
        }
        return longest;
    }
    public static void main(String args[]) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n=sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i=0;i<n;i++) 
        {
            arr[i] = sc.nextInt();
        }
        int result = findLCS(arr);
        System.out.println("Length of the longest consecutive subsequence: " + result);
    }
}
