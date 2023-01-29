# Approach-1
//Complexity Analysis:
//Time Complexity : O(n2)    Auxiliary Space : O(n)

package Array_Matrix;

import java.util.Arrays;

public class Freq_count {

	public static void count_Freq(int A[],int n) {
		int []visited = new int[n];
		Arrays.fill(visited,0);
		
		for(int i=0;i<n;i++) {
			int cnt=1;
			if(visited[i]==1)
				continue;
			for(int j=i+1;j<n;j++) {
				if(A[i]==A[j]) {
					cnt++;
					visited[j]=1;
				}
			}System.out.println("Number : "+A[i]+" appears "+cnt+" times..!");
		}
	}
	public static void main(String[] args) {
		int arr[] = {10,20,20,10,10,20,5,20};
		int len = arr.length;
		count_Freq(arr,len);

	}

}

