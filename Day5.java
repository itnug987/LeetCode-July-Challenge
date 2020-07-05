/**
	Problem: The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.
*/

class Solution {
    public int hammingDistance(int n1, int n2) {
		int x = n1 ^ n2; 
		int setBits = 0; 
	  
		while (x > 0)  
		{ 
			setBits += x & 1; 
			x >>= 1; 
		} 
	  
		return setBits; 
    }
}