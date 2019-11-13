import java.util.Arrays;

public class MyHeap {
    public void shiftDown (int[] arr, int size, int index) {
        int left = 2 * index + 1;
        while (left < size) {
            int min = left;
            int right = 2 * index + 2;
            if (right < size) {
                if (arr[right] < arr[left]) {
                    min = right;
                }
            }
            if (arr[index] <= arr[min]) {
                break;
            }
            int temp = arr[index];
            arr[index] = arr[min];
            arr[min] = temp;
            index = min;
            left = 2 * index + 1;
        }
    }
    public void creatHeap (int[] arr, int size) {
        for (int i = 0; i < size; i ++) {
            shiftDown(arr, size, i);
        }
    }

    public void shiftUp (int[] arr,int index) {
        while(index > 0) {
            int par = (index - 1) / 2;
            if (arr[index] <= arr[par]) {
                break;
            }
            int temp = arr[index];
            arr[index] = arr[par];
            arr[par] = temp;
            index = par;
        }
    }

    public void main(String[] args) {
        int[] arr = {27,15,19,18,28,34,65,49,25,37};
        creatHeap(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
class MyPriorityQueue {
    private int[] arr = new int[100];
    private int size = 0;
    public void offer(int a) {
        arr[size] = a;
        size++;
        MyHeap myHeap = new MyHeap();
        myHeap.shiftUp(arr, size - 1);
    }
    public int poll() {
        int temp = arr[0];
        arr[0] = arr[size - 1];
        MyHeap myHeap = new MyHeap();
        myHeap.shiftDown(arr, size, 0);
        size--;
        return temp;
    }
    public int peek() {
        return arr[0];
    }

}