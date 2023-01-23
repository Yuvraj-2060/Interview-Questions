// Approach-1  ****************  Time Complexity: O(n2) | Auxiliary space: O(1) ***************

public class MaxRepeatedElement
{
public static int mostFrequent(int[] arr, int n)
{
	int maxcount = 0;
	int element_having_max_freq = 0;
	for (int i = 0; i < n; i++) {
	int count = 0;
	for (int j = 0; j < n; j++) {
		if (arr[i] == arr[j]) {
		count++;
		}
	}

	if (count > maxcount) {
		maxcount = count;
		element_having_max_freq = arr[i];
	}
	}

	return element_having_max_freq;
}


public static void main(String[] args)
{
	int[] arr = { 40, 50, 30, 40, 50, 30, 30 };
	int n = arr.length;
	System.out.print(mostFrequent(arr, n));
}
}

// Approach -2 : Time Complexity: O(nlog(n)) 
//               Auxiliary Space: O(1)

import java.util.*;

class MaxRepeatedElement {

	static int mostFrequent(int arr[], int n)
	{
		Arrays.sort(arr);

		// find the max frequency using linear traversal
		int max_count = 1, res = arr[0];
		int curr_count = 1;

		for (int i = 1; i < n; i++) {
			if (arr[i] == arr[i - 1])
				curr_count++;
			else
				curr_count = 1;

			if (curr_count > max_count) {
				max_count = curr_count;
				res = arr[i - 1];
			}
		}
		return res;
	}

	// Driver program
	public static void main(String[] args)
	{
		int arr[] = { 40,50,30,40,50,30,30};
		int n = arr.length;
		System.out.println(mostFrequent(arr, n));
	}
}

// Approach -3 : Time Complexity: O(n) 
//               Auxiliary Space: O(n)


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class MaxRepeatedElement {
	
	static int mostFrequent(int arr[], int n)
	{
		Map<Integer, Integer> hp = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < n; i++)
		{
			int key = arr[i];
			if(hp.containsKey(key))
			{
				int freq = hp.get(key);
				freq++;
				hp.put(key, freq);
			}
			else
			{
				hp.put(key, 1);
			}
		}
		
		// find max frequency.
		int max_count = 0, res = -1;
		
		for(Entry<Integer, Integer> val : hp.entrySet())
		{
			if (max_count < val.getValue())
			{
				res = val.getKey();
				max_count = val.getValue();
			}
		}
		
		return res;
	}
	
	// Driver code
	public static void main (String[] args) {
		
		int arr[] = {40,50,30,40,50,30,30};
		int n = arr.length;
		
		System.out.println(mostFrequent(arr, n));
	}
}


// Approac-4  Time Complexity: O(n)
//            Auxiliary Space: O(1)

import java.io.*;
class MaxRepeatedElement
{
static int maxFreq(int []arr, int n)
{
	
	// using moore's voting algorithm
	int res = 0;
	int count = 1;
	for(int i = 1; i < n; i++) {
		if(arr[i] == arr[res]) {
			count++;
		} else {
			count--;
		}
		
		if(count == 0) {
			res = i;
			count = 1;
		}
		
	}
	
	return arr[res];
}

// Driver code
public static void main (String[] args) {
	int arr[] = {40,50,30,40,50,30,30};
	int n = arr.length;
	int freq = maxFreq(arr , n);
	int count = 0;
	for(int i = 0; i < n; i++) {
		if(arr[i] == freq) {
			count++;
		}
	}
	System.out.println("Element " +maxFreq(arr , n) +" occurs " +count +" times" );
}
	
}
// This code is contributed by Mr Singh
