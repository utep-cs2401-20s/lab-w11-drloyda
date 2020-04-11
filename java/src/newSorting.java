public class newSorting{
    public static void newSorting(int [] A, int size){
        //base case
        if(A.length < size){
            quickSort(A,0,A.length-1);
        }else{
            //RECURSIVE CASE
            int mid = A.length/2;
            //splitting the array into two halves
            //left half is the size from the first element to before the pivot
            int [] leftHalf = new int[mid];
            //right half is the size from after the array to the end of the array
            int [] rightHalf = new int [A.length - mid];

            //populate leftHalf array before the pivot from the original array
            for (int i = 0; i <leftHalf.length ; i++) {
                leftHalf[i]= A[i];
            }
            //populate right half array after the pivot of the original array
            int i = 0;
            while( i < rightHalf.length) {
                for (int k = A.length-mid-1; i <rightHalf.length ; k++) {
                    rightHalf[i]= A[k];
                    i++;
                }

            }
            //sort the leftHalf
            newSorting(leftHalf,size);
            //sort the right half
            newSorting(rightHalf,size);
            //merge halves into one array
            mergeSortedHalves(leftHalf,rightHalf,A);

        }
    }
    /**************************************************************/
    public static void quickSort(int[] a, int start, int last) {
        //getting the index of the pivot
        int pivot = partition(a, start, last);
        if(start < pivot-1) {
            //sorting the left side of pivot
            quickSort(a, start, pivot-1);
        }
        if(last > pivot) {
            //sorting the right side of pivot
            quickSort(a, pivot, last);
        }
    }
    /**************************************************************/
    public static int partition(int[] a, int start, int last) {
        //sets first element as the pivot
        int pivot = a[start];

        while(start<=last) {
            //checks if the element at the index start (left of array)is less than the pivot
            while(a[start] < pivot)
                start++;
            //checks if the element at the index last(right of array) is less than the pivot
            while(a[last] > pivot)
                last--;
            if(start<=last) {
                //swapping the elements
                int tmp = a[start];
                a[start] = a[last];
                a[last] = tmp;
                start++;
                last--;
            }
        }
        return start;
    }
    /**************************************************************/
    public static void mergeSortedHalves(int[] leftHalf, int[] rightHalf, int[] A) {
        int i = 0;
        int j = 0;
        int k = 0;

        // travers through both arrays
        while (i<leftHalf.length && j <rightHalf.length)
        {
            //if the first element of the first array is less
            //than the second array, then put it the original array,
            //then move to the next element
            if (leftHalf[i] < rightHalf[j]){
                A[k++] = leftHalf[i++];
            }else{
                A[k++] = rightHalf[j++];
            }
        }

        // once theres no more to compare, then insert the
        //remaining elements of thr first array
        while (i < leftHalf.length)
            A[k++] = leftHalf[i++];

        // once theres no more to compare, then insert the
        //remaining elements of thr second array
        while (j < rightHalf.length)
            A[k++] = rightHalf[j++];
    }
}
