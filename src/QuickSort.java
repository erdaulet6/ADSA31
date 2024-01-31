import java.util.Scanner;

public class QuickSort {

    public void quickSort(int[] x) {
        quickSort(x, 0, x.length - 1);
    }

    private void quickSort(int[] x, int start, int end) {
        if (start < end) {
            int pi = partition(x, start, end);
            quickSort(x, start, pi - 1);
            quickSort(x, pi + 1, end);
        }
    }

    private int partition(int[] x, int start, int end) {
        int pivot = x[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (x[j] <= pivot) {
                i++;
                int temp = x[i];
                x[i] = x[j];
                x[j] = temp;
            }
        }

        int temp = x[i + 1];
        x[i + 1] = x[end];
        x[end] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuickSort sorter = new QuickSort();

        int size = scanner.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        sorter.quickSort(array);

        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}