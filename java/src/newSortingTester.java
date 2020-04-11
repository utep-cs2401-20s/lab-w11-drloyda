import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class newSortingTester extends newSorting {
    //TEST CASE 1: Testing an unsorted array
    @Test
    public void newSorting1(){
        //3 would be the first pivot of the array and split it into
        //{1,2,3,7,6,8,4}

        int [] test = {3,6,4,7,8,2,1};
        //the array i expect
        int [] result = {1,2,3,4,6,7,8};
        //the algorithm should first split the array in since
        // its not less than the size to call quicksort
        newSorting(test,test.length);

        //the test passed which means it was successfully able
        //to split the array, call quick sort on the halves, and
        //merge the sorted halves together
        assertArrayEquals(result,test);
    }
    /**********************************************/
    //TEST CASE 2: Testing with an array that has negative values
    @Test
    public void newSorting2(){
        //the array has two negative values
        int [] test = {-7,1,3,-3,6,4,10};
        //the array i expect
        int [] result = {-7,-3,1,3,4,6,10};
        //the algorithm should first split the array in since
        // its not less than the size to call quicksort
        newSorting(test,test.length);

        //the test passed, meaning it was able to appropriately compare the negative values
        //as less than the positive integers and sort them on the left side
        assertArrayEquals(result,test);
    }
    /**********************************************/
    //TEST CASE 3: Testing with an already sorted array
    @Test
    public void newSorting3(){
        int [] test = {1,2,3,4,5,6,7};
        //the array i expect
        int [] result = {1,2,3,4,5,6,7};
        //the algorithm will first split the array in since
        // its not less than the size to call quicksort
        newSorting(test,test.length);

        //the test passed and returned the same array, a suggestion would be to have another
        //base case that check if the array is already sorted, however that would
        //add more to the time cost of the method since it would have to traverse the array
        assertArrayEquals(result,test);
    }
    /**********************************************/
    //TEST CASE 4: Testing with an array that has duplicate elements
    @Test
    public void newSorting4(){
        int [] test = {9,4,4,7,5,9,11,15,9};
        //the array i expect
        int [] result = {4,4,5,7,9,9,9,11,15};
        //the algorithm should first split the array in since
        // its not less than the size to call quicksort
        newSorting(test,test.length);

        //the test passed, meaning it was able to group the duplicates next to
        //eachother since they are not greater nor less than eachother
        assertArrayEquals(result,test);
    }
    /**********************************************/
    //Test case five
    @Test
    public void newSorting5(){
        int [] test = {0,0,0,0,0};
        //the array i expect
        int [] result = {0,0,0,0,0};
        //the algorithm should first split the array in since
        // its not less than the size to call quicksort
        newSorting(test,test.length);

        //the test passed, however the algorithm is still moving
        //around elements within the array, a suggestion would be to have
        //another if statement that checks if they're the same that way it
        //wouldn't have to swap them around
        assertArrayEquals(result,test);
    }

}
