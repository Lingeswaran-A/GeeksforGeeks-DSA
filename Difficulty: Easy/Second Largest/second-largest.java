class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int largest=arr[0];
        int slargest=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                slargest=largest;
                largest=arr[i];
            }
            else if(arr[i]>slargest && arr[i]<largest){
                slargest=arr[i];
            }
        }
        if(largest==slargest) return -1;
        else return slargest;
    }
}