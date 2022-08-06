package com.example.integerlist;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList{

    private Integer[] storage;
    private int size = 0;

    public IntegerListImpl(Integer[] storage) {
        this.storage = storage;
        this.size = storage.length;
    }
    public IntegerListImpl(int amount) {
        storage = new Integer[amount];
    }
    public IntegerListImpl() {
        storage = new Integer[10];
    }

    @Override
    public Integer add(Integer item) {
        if (size == storage.length) {
            biggerMas();
        }
        validateItem(item);
        storage[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (size == storage.length) {
            biggerMas();
        }
        validateItem(item);
        validateIndex(index);
        for (int i = index; i < size-1; i++) {
            storage[index + 1] = storage[i];
        }
        storage[index] = item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateItem(item);
        validateIndex(index);
        storage[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = this.indexOf(item);
        if (index == -1) {
            throw new itemNotFoundException("Item is not found");
        }
        for (int i = index; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
        size--;
        return item;
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        for (int i = index; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
        size--;
        return storage[index];
    }

    @Override
    public boolean contains(Integer item) {
        sortSelection(storage);
        return binarContains(item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

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
        validateIndex(index);
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
    private void biggerMas() {
        Integer[] newMas = new Integer[storage.length * 2];
        System.arraycopy(storage, 0, newMas, 0, size);
        storage = newMas;
    }

    public static void sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
    private boolean binarContains(Integer item) {
        int min = 0;
        int max = size - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item.equals(mid)) {
                return true;
            }

            if (item < storage[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
