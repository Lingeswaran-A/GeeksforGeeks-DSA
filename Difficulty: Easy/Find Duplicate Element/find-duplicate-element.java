// User function Template for Java
class Solution {

    public int findDuplicate(int arr[]) {
        // Your code goes here
        Set<Integer> set=new HashSet<>();
        for(int num: arr){
            if(!set.add(num)) return num;
            else set.add(num);
        }
        return -1;
    }
}