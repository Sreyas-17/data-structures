package com.bridgelabz.searching;

import java.util.Scanner;

public class SearchIn2DMatrix {
    public static int[] binarySearch(int[][] matrix, int target,int rows,int columns) {

        int left=0;
        int right=rows*columns-1;

        while(left<=right) {

            int mid=(left+right)/2;
            int row=mid/columns;
            int col=mid%columns;

            if(matrix[row][col]==target) {
                return new int[]{row,col};
            }
            else if(matrix[row][col]>target) {
                right=mid-1;
            }
            else if(matrix[row][col]<target) {
                left=mid+1;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5},{7,10,11},{12,16,20}};
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter the target number");
        int target=scanner.nextInt();

        int[] result=binarySearch(matrix,target,3,3);
        System.out.println("Target found at row: "+result[0]+" column: "+result[1]);
    }
}