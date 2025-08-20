import java.util.Scanner;
class RainWater 
{
    public static int trapWater(int[] height) 
    {
        int n=height.length;
        int[] leftMax=new int[n];
        int[] rightMax=new int[n];
        //storing the highest level in th left half   
        leftMax[0]=height[0];
        for (int i=1;i<n;i++) 
        {
            leftMax[i]=Math.max(leftMax[i - 1], height[i]);
        }
        //storing the highest level in the right half
        rightMax[n-1]=height[n-1];
        for (int i=n-2;i>=0;i--) 
        {
            rightMax[i]=Math.max(rightMax[i+1], height[i]);
        }
        //calculating trapped water
        int trappedWater = 0;
        for (int i=0;i<n;i++) 
        {
            trappedWater+=Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return trappedWater;
    }

    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n=sc.nextInt();
        int[] height=new int[n];

        System.out.println("Array:");
        for (int i=0;i<n;i++) 
        {
            height[i]=sc.nextInt();
        }

        // Calculate and print result
        int result=trapWater(height);
        System.out.println("Units of trapped water: " + result);
    }
}
