package dataStructures;

public class SegmentTree {
  
    public void constructTreeForMinimumQuery(int[] input, int[] segmentTree, int low, int high, int position){
        if(low == high){
            segmentTree[position] = input[low];
            return; 
        }
        int mid = (low + high)/2;
        constructTreeForMinimumQuery(input, segmentTree, low, mid, 2*position+1);
        constructTreeForMinimumQuery(input, segmentTree, mid+1, high, 2*position+2);
        segmentTree[position] = Math.min(segmentTree[2*position+1], segmentTree[2*position+2]);
    }
}
