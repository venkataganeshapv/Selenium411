package com.programs;

import java.util.Arrays;
import java.util.Comparator;

public class Array_Sort {
	
	
	public static void main(String[] args) {
		
		
		//Sorting single dimensional array
		int[] nums = new int[] {9, 1,3,7,5, 10, 2};
		
		Arrays.sort(nums);
		
		System.out.println("Sorting Single Dimensional Array:"+Arrays.toString(nums));
		
		//Sorting two dimensional array based on row
		
		int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		
		//Increasing Order		
		Arrays.sort(people, (a,b) -> (a[0]-b[0])); // Increasing Order  -- Here 		
		
		System.out.println("Sorting 2D based on Rows (increasing):"+Arrays.deepToString(people));
		
		
		Arrays.sort(people, (a,b) -> Integer.compare(a[0], b[0])); // Increasing Order  -- Here 		
		
		System.out.println("Sorting 2D based on Rows (increasing):"+Arrays.deepToString(people));
		
		
		//Decreasing Order
		Arrays.sort(people, (a,b) -> (b[0]-a[0])); // Decreasing order Order  -- Here 		
		
		System.out.println("Sorting 2D based on Rows (Decreasing):"+Arrays.deepToString(people));
		
		
		//Sorting two dimensional array based on column
		//Increasing Order		
		Arrays.sort(people, (a,b) -> (a[1]-b[1])); // Increasing Order  -- Here 		
		System.out.println("Sorting 2D based on Columns (increasing):"+Arrays.deepToString(people));
		
		
		//************ Sorting based on Row and Column 
		
		//Rows in decreasing order,Columns in increasing order
		//Sorting two dimensional array based on Row & column
		Arrays.sort(people, new Comparator<int[]>() {
		      @Override
		      public int compare(int[] o1, int[] o2) {
		        // if the heights are equal, compare k-values
		        return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
		      }
		    });
		
		
	}
	
	
	
}
