import java.util.*;
public class testerz {

    public static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int middle = (left+right)/2;
            mergeSort(arr,left,middle);
            mergeSort(arr,middle+1,right);
            merge(arr,left,middle,right);
        }
    }

    public static void merge(int[] arr, int left, int middle, int right) {
        int halveOneSize = middle - left + 1;
        int halveTwoSize = right - middle;

        //Create temp arrays
        int[] leftArr = new int[halveOneSize];
        int[] rightArr = new int[halveTwoSize];

        //Copy data to temp arrays
        for (int i = 0; i < halveOneSize; i++)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < halveTwoSize; j++)
            rightArr[j] = arr[middle + 1 + j];

        //Merge the temp arrays
        int i = 0, j = 0;
        int k = left;
        while (i < halveOneSize && j < halveTwoSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        //Copy remaining elements of leftArr[]
        while (i < halveOneSize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        //Copy remaining elements of rightArr[]
        while (j < halveTwoSize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args){
        int[] arr = {5,6,3,9,3,4,5,9};
        mergeSort(arr,0,arr.length-1);
        for(int arrInt: arr)
            System.out.print(arrInt + ",");
    }
}



