class Solution {
    public boolean arraySortedOrNot(int[] arr) {
        // code here
        if(arr.length==1 || arr.length==0) return true;
        for(int j=1;j<arr.length;j++){
            if(arr[j]>=arr[j-1]) continue;
            else{
                return false;
            }
        }
        return true;
    }
}