import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*Print all pairs in an array whose sum is x
  Implemented using two methods
  Method 1: Using hash table. TC=O(n) and SC=O(range)
  Method 2: Using two pointers one from start and another from end. TC=O(nlogn) SC=O(1)
  Note: In java, an array is automatically initialized to 0.
   */ 
public class GivenSum_1 {
	public static void main(String[]args)
	{
		
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the size of array.");
		int size=input.nextInt();
		int arr[]=new int[size];
		System.out.println("Enter the numbers in the array.");
		for(int x=0;x<size;x++)
		{
			arr[x]=input.nextInt();
		}
		System.out.println("Enter the sum.");
		int sum=input.nextInt();
		System.out.println("Method 1: Using hash table. TC=O(n) and SC=O(range)");
		findSum_method1(arr,sum);
		System.out.println("Method 2: Using two ptrs one from start & other from end. TC=O(nlogn), SC=O(1)");
		findSum_method2(arr,sum);
	}

	private static void findSum_method2(int[] arr, int sum) {
		int i=0,j=arr.length-1,temp_sum;
		Arrays.sort(arr);
		while(i<arr.length && j>=0)
		{
			temp_sum=arr[i]+arr[j];
			if(temp_sum>sum)
			{
				j--;
			}
			else if(temp_sum<sum)
			{
				i++;
			}
			else
			{
				System.out.println("The pair is: "+ arr[i]+", " + arr[j]);
				i++;
				j--;
			}
			if(i>j)
				break;
		}
		
	}

	private static void findSum_method1(int[] arr,int sum) {
		int max = findRange(arr);
		int hash_arr[]=new int[max+1];
		int result[]=new int[2];
		int flag=0;
		
		for(int j=0;j<arr.length;j++)
		{
			int remaining = sum-arr[j];
//			System.out.println("remaining is: "+remaining);
//			System.out.println("hash array length is: "+hash_arr.length);
			if(hash_arr.length>=remaining && hash_arr[remaining]==1)
			{
				System.out.println("The pair is: "+ arr[j]+", " + remaining);
				flag=1;
			}
			hash_arr[arr[j]]=1;
		}
		
		if(flag==0)
		{
			System.out.println("OOPS! No pairs with given sum exist!");
		}
	}

	private static int findRange(int[] arr) {
		int max=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>max)
				max=arr[i];
		}
		return max;
	}
}
