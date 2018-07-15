// Without MIn heap

class Solution 
{
    
    public int[] smallestRange(List<List<Integer>> nums) 
    {
		PriorityQueue<Element> pq = new PriorityQueue<Element>(new Comparator<Element>() {
			public int compare(Element a, Element b) 
            {
				return a.val - b.val;
			}
		});
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.size(); i++) 
        {
			Element e = new Element(i, 0, nums.get(i).get(0));
			pq.offer(e);
			max = Math.max(max, nums.get(i).get(0));
		}
		int range = Integer.MAX_VALUE;
		int start = -1, end = -1;
		while (pq.size() == nums.size()) 
        {

			Element curr = pq.poll();
			if (max - curr.val < range) 
            {
				range = max - curr.val;
				start = curr.val;
				end = max;
			}
			if (curr.idx + 1 < nums.get(curr.row).size()) 
            {
				curr.idx = curr.idx + 1;
				curr.val = nums.get(curr.row).get(curr.idx);
				pq.offer(curr);
				if (curr.val > max) 
                {
					max = curr.val;
				}
			}
		}

		return new int[] { start, end };
	}

	class Element
    {
		int val;
		int idx;
		int row;

		public Element(int r, int i, int v) 
        {
			val = v;
			idx = i;
			row = r;
		}
	}
}






import java.util.ArrayList;

class Element{
	int listIndex;
	int value;
	
	Element(int a, int b)
	{
		this.listIndex = a;
		this.value = b;
	}
}

public class ShortestRange {
	
	public static void shortestRange(int[][] intList)
	{
		int[] pointers =  new int[intList.length];
		Element[] minHeap = new Element[intList.length];
		int minRange  =  Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int finalMin = Integer.MAX_VALUE;
		int finalMax = Integer.MIN_VALUE;
		int iterationCount = 0;
		
		for(int i=0; i<intList.length; i++)
		{
		    int[] tempList = intList[i];
		
			if(tempList.length > 0)
			{         
				minHeap[i] = new Element(i, tempList[0]);
				if(tempList[0] > max)
				{
					max = tempList[0];
				}
					
			}
			else
			{
				//print the range
				System.out.println("One of the lists is empty");
				return;
			}
		}
		
		while(true)
		{
			buildMinHeap(minHeap, minHeap.length);
			Element minElement = minHeap[0];
			int listIndex = minElement.listIndex;
			min = minElement.value;
			
			
			if((max-min) < minRange)
			{
				finalMax = max;
				finalMin = min;
				minRange = max - min;
			}
			
			if((pointers[listIndex] + 1 ) < intList[listIndex].length)
			{
				pointers[listIndex]++;
				Element nextElement = new Element(listIndex, intList[listIndex][pointers[listIndex]]);
				
				if(nextElement.value > max)
				{
					max = nextElement.value;
				}
				
				minHeap[0] = nextElement;
			}
			else
			{
				System.out.println("{" + finalMin + "," + finalMax + "}");
				return;
			}
			
			
		}
		
	}
	
	 public static void minHeapify(Element[] array, int curIndex, int heapSize){
	        // Left child in heap
	        int left = 2*curIndex+1;
	        // Right child in heap
	        int right = 2*curIndex+2;
	        int smallest = curIndex;
	      
	        if(left < heapSize && array[left].value < array[curIndex].value) {
	            smallest = left;
	        }
	      
	        if(right < heapSize && array[right].value < array[smallest].value) {
	            smallest = right;
	        }
	      
	        if(smallest != curIndex){
	            swap(array, curIndex, smallest);
	            minHeapify(array, smallest, heapSize);
	        }
	    }
	     
	    public static void buildMinHeap(Element[] array, int heapSize){
	        // call maxHeapify on all internal nodes
	        int lastElementIndex = array.length - 1;
	        int parentIndex = (lastElementIndex - 1)/2;
	        for(int i = parentIndex; i >= 0; i--){
	            minHeapify(array, i, heapSize);
	        }
	    }
	    
	    private static void swap(Element[] array, int i, int j) {
	        Element tmp = array[i];
	        array[i] = array[j];
	        array[j] = tmp;     
	    }
	    
	    public static void main(String args[])
	    {
	    	
	    	int[][] A = new int[3][];
			A[0] = new int[] { 4, 10, 15, 24, 26};
			A[1] = new int[] { 0, 9, 12, 20 };
			A[2] = new int[] { 5, 18, 22, 30 };
			
			shortestRange(A);
	    }
	

}
