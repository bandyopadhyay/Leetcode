package Subsets;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/subsets/
78. Subsets
 Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		backtrack(result, temp, nums, 0);
		return result;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {

		result.add(new ArrayList<Integer>(temp));

		for (int i = start; i < nums.length; i++) {
			// if(temp.contains(nums[i])) continue;
			temp.add(nums[i]); // choose
			backtrack(result, temp, nums, i + 1);
			temp.remove(temp.size() - 1); //do not choose
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int arr[] = { 1, 2, 3, 4 };
		print(s.subsets(arr));
	}

	private static void print(List<List<Integer>> result) {
		for (List<Integer> a : result) {
			for (Integer b : a) {
				System.out.print(b + ", ");
			}
			System.out.println();
		}

	}
}
