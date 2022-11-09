package com.example.integerlist;

import java.util.Arrays;
import java.util.Objects;

public class IntegerListImpl implements IntegerList{

    private Integer[] storage; //massiv for save objects
    private int size = 0; // inicial size of massiv

    // Constructor
    public IntegerListImpl(Integer[] storage) {
        this.storage = storage;
        this.size = storage.length;
    }

    // Constructor
    public IntegerListImpl(int amount) {
        storage = new Integer[amount];
    }

    // Constructor without parametres
    public IntegerListImpl() {
        storage = new Integer[10];
    }

    @Override
    public Integer add(Integer item) {
        if (size == storage.length) {
            grow(); // method for grow size of massive
        }
        validateItem(item); // valifade object
        storage[size++] = item; // add item to massiv to the end
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (size == storage.length) {
            grow(); // method for grow size of massive
        }
        validateItem(item); // valifade object
        validateIndex(index); // valifade index
        // right shift of array elements starting from index
        for (int i = index; i < size-1; i++) {
            storage[index + 1] = storage[i];
        }
        storage[index] = item; // adding an element to the array in the freed space at the index number
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateItem(item); // valifade object
        validateIndex(index); // valifade index
        storage[index] = item; //setting array value by index
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item); // valifade object
        int index = this.indexOf(item);
        if (index == -1) {
            throw new itemNotFoundException("Item is not found");
        }
        //removing an element by shifting elements in an array to the left
        for (int i = index; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
        size--; // decrease the number of elements in the array by 1
        return item;
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index); // valifade index
        //removing an element by shifting elements in an array to the left
        for (int i = index; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
        size--; // decrease the number of elements in the array by 1
        return storage[index];
    }

    @Override
    public boolean contains(Integer item) {
        validateItem(item); // // valifade object
        Integer[] storageCopy = this.toArray(); // create copy of storage
        quickSort(storageCopy, 0,size-1); // method sorting quickSort
        return binarContains(storageCopy, item); // binary find
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            // if an element in the array is found, then return its index
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1; // else return -1
    }

    // as in the indexof method, but the element is searched from the end of the array
    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size-1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index); // valifade index
        return storage[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.storage, otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size-1) {
            throw new wroneIndexException("Index is Wrone");
        }
    }
    private void validateItem(Integer item) {
        if (item == null) {
            throw new ItemNullException("Item is Null");
        }
    }
    private void grow() {
        // create new array with length*1.5
        Integer[] newMas = new Integer[(int) (storage.length * 1.5)];
        // copy elements from old array to new array
        System.arraycopy(storage, 0, newMas, 0, size);
        storage = newMas;
    }

//    public static void sortSelection(Integer[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            int minElementIndex = i;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[minElementIndex]) {
//                    minElementIndex = j;
//                }
//            }
//            swapElements(arr, i, minElementIndex);
//        }
//    }

    // sort method algorithm
    public static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    // method that swaps elements
    private static void swapElements(Integer [] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    // method that performs a binary search
    private boolean binarContains(Integer[] arr,Integer item) {
        int min = 0;
        int max = size - 1;

        while (min <= max) {
            int mid = (min + max) / 2; // find middle between min and max

            if (Objects.equals(item, arr[mid])) { // object is found
                return true;
            }
            // if the required element is less than the central element.
            // narrowing the scope for finding an element
            if (item < storage[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false; // // object is not found
    }
}
