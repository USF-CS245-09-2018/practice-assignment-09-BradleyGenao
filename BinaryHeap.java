public class BinaryHeap {

    public int DEFAULT_SIZE=10;
    private int[] heap = new int[DEFAULT_SIZE];
    private int sizeOfHeap=0;

    public void add(int n) {

        if(sizeOfHeap >= heap.length)
            doubleSize();
        heap[sizeOfHeap] = n;
        sizeOfHeap++;

        int index = sizeOfHeap-1;
        while(index>0){
            int parent = (index - 1) / 2;
            if(heap[index]<heap[parent]){
                swap(heap, index, parent);
                index = parent;
            }


            else return;
        }
    }

    public int remove(){


        int min = heap[0];
        heap[0] = heap[sizeOfHeap-1];
        sizeOfHeap--;
        bubDown(0);
        return min;
    }

    public void swap(int[] arr, int i, int parent){
        int temp = arr[i];
        arr[i] = arr[parent];
        arr[parent] = temp;
    }

    public void bubDown(int parent){

        int child = parent * 2 + 1;
        if(child >= sizeOfHeap)
            return;
        if(heap[child+1] < heap[child])
            child++;
        if(heap[parent] > heap[child]){
            swap(heap, parent, child);
            bubDown(child);
        }
    }

    public void doubleSize(){


        int[] new_heap = new int[heap.length * 2];
        for(int i=0; i<heap.length; i++)
            new_heap[i] = heap[i];
        heap = new_heap;

    }

}
