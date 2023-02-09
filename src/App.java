import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int arrayLength = scanner.nextInt();
        scanner.close();

        int[] a = createRandomArray(arrayLength);
        mergeSort(a, 0, a.length);
        long start_time = System.currentTimeMillis() /1000;
        long end_time = System.currentTimeMillis() /1000 - start_time;
        //System.out.println("Merge Sort:\n" + Arrays.toString(a));
        System.out.println("Sorted: " + isSorted(a));
        System.out.println("Merge Sort time to complete: " + end_time + " seconds");
       
        start_time = System.currentTimeMillis() /1000;
        bubbleSort(a);
        end_time = System.currentTimeMillis() /1000 - start_time;
        //System.out.println("Bubble Sort:\n" + Arrays.toString(a));
        System.out.println("Sorted: " + isSorted(a));
        System.out.println("Bubble Sort time to complete: " + end_time + " seconds");
    }
    public static int[] createRandomArray(int length){
        Random random = new Random();
        int [] a = new int[length];

        for (int i=0; i < a.length; i++){
            a[i] = random.nextInt(100);
        }
        return a;
    }

    public static boolean isSorted(int[] array){
        for (int i=0; i < array.length - 1; i++){
            if (array[i] > array[i + 1])
            return false;
        }
        return true;
    }

    public static void mergeSort(int[] a, int start, int end){
        if (end - start <= 1){
            return;
        }   
        
        int middle = (start + end) / 2;
        mergeSort(a, start, middle);
        mergeSort(a, middle, end);
        merge(a, start, middle, end);
        
    }

    public static void merge(int[] a, int start, int middle, int end){
        int i = start;
        int j = middle;
        int k = 0;
        int [] tempArray = new int[end - start + 1];

        while (i < middle && j < end) {
            if (a[i] > a[j]){
                tempArray[k] = a[j];
                j++;
                k++;
            } else {
                tempArray[k] = a[i];
                i++;
                k++;
            }
        }
        while ( i < middle){
            tempArray[k] = a[i];
            i++;
            k++;
        }
        while (j < end){
            tempArray[k] = a[j];
            j++;
            k++;
        }

        for (i = start; i < end; i++){
            a[i] = tempArray[i - start];
        }
    }
    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void bubbleSort(int[] array){
        for (int j = array.length - 1; j >= 1; j--){
            for (int i=0; i < j; i++){
                if (array[i] > array[i+1]){
                swap(array, i, i+1);
                }
            }
        }
    }
}
