package com.example.integerlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.integerlist.Constanty.*;
import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {

    IntegerList out = new IntegerListImpl(6);
    IntegerList empty = new IntegerListImpl(6);
    Integer[] mas = {ZERO,FIRST,SECOND, THIRD, FORTH, FIFTH};

    @BeforeEach
    public void init() {
        out.add(ZERO);
        out.add(FIRST);
        out.add(SECOND);
        out.add(THIRD);
        out.add(FORTH);
        out.add(FIFTH);
    }

    @Test
    public void shouldReturn1WhenAddFirst() {
        Integer result = 1;
        assertEquals(result, out.add(FIRST));
    }
    @Test
    public void shouldReturnThrowWhenAddNull() {
        assertThrows(ItemNullException.class, () -> out.add(null));
    }
    @Test
    public void shouldReturn2WhenAddSecond() {
        Integer result = 2;
        assertEquals(result, out.add(0,SECOND));
    }
    @Test
    public void shouldReturnThrowWhenAddWrongeIndex() {
        assertThrows(wroneIndexException.class, () -> out.add(-4,ZERO));
    }
    @Test
    public void shouldReturnThrowWhenAddWrongeIndex2() {
        assertThrows(wroneIndexException.class, () -> out.add(100,ZERO));
    }

    @Test
    public void shouldReturn2WhenSetSecond() {
        Integer result = 2;
        assertEquals(result, out.set(0,SECOND));
    }
    @Test
    public void shouldReturnThrowWhenSetNull() {
        assertThrows(ItemNullException.class, () -> out.set(3,null));
    }
    @Test
    public void shouldReturnThrowWhenSetWrongeIndex() {
        assertThrows(wroneIndexException.class, () -> out.set(-4,ZERO));
    }
    @Test
    public void shouldReturnThrowWhenSetWrongeIndex2() {
        assertThrows(wroneIndexException.class, () -> out.set(100,ZERO));
    }


    @Test
    public void shouldReturnSecondWhenRemoveSecond() {
        Integer result = 2;
        assertEquals(result, out.remove(SECOND));
    }
    @Test
    public void shouldReturnThrowWhenRemoveNotFound() {
        assertThrows(wroneIndexException.class, () -> out.remove(100));
    }
    @Test
    public void shouldReturnThrowWhenRemoveNull() {
        assertThrows(ItemNullException.class, () -> out.remove(null));
    }
    @Test
    public void shouldReturn2WhenRemoveSecond2() {
        Integer result = 2;
        assertEquals(result, out.remove(SECOND));
    }

    @Test
    public void shouldReturnThrowWhenRemoveWrongeIndex() {
        assertThrows(wroneIndexException.class, () -> out.remove(-4));
    }
    @Test
    public void shouldReturnThrowWhenRemoveWrongeIndex2() {
        assertThrows(wroneIndexException.class, () -> out.remove(100));
    }


    @Test
    public void shouldReturnTrueWhenContainsFirst() {
        assertTrue(out.contains(FIRST));
    }
    @Test
    public void shouldReturnFalseWhenContainsNotFound() {
        assertFalse(out.contains(NOT_FOUND));
    }


    @Test
    public void shouldReturn1WhenIndexOfFirst() {
        int result = 1;
        assertEquals(result, out.indexOf(FIRST));
    }
    @Test
    public void shouldReturn_1WhenIndexOfNotFound() {
        int result = -1;
        assertEquals(result, out.indexOf(null));
    }

    @Test
    public void shouldReturn4WhenLastIndexOfFirst() {
        out.add(4, FIRST);
        int result = 4;
        assertEquals(result, out.lastIndexOf(FIRST));
    }
    @Test
    public void shouldReturn_1WhenLastIndexOfNotFound() {
        int result = -1;
        assertEquals(result, out.lastIndexOf(null));
    }

    @Test
    public void shouldReturnForthWhenGetForth() {
        Integer result = FORTH;
        assertEquals(result, out.get(4));
    }
    @Test
    public void shouldReturnThrowWhenGetWrongeIndex() {
        assertThrows(wroneIndexException.class, () -> out.get(-4));
    }
    @Test
    public void shouldReturnThrowWhenGetWrongeIndex2() {
        assertThrows(wroneIndexException.class, () -> out.get(100));
    }

    @Test
    public void shouldReturnTrueWhenEqualsMas() {
        IntegerList result = new IntegerListImpl(mas);
        assertTrue(out.equals(result));
    }
    @Test
    public void shouldReturnFalseWhenEqualsMas() {
        IntegerList result = new IntegerListImpl(mas);
        result.remove(3);
        assertFalse(out.equals(result));
    }

    @Test
    public void shouldReturn6WhenSize() {
        int result = SIZE;
        assertEquals(result, out.size());
    }

    @Test
    public void shouldReturnTrueWhenIsEmpty() {
        assertTrue(empty.isEmpty());
    }
    @Test
    public void shouldReturnFalseWhenIsEmpty() {
        assertFalse(out.isEmpty());
    }

    @Test
    public void shouldReturnSize0WhenClear() {
        out.clear();
        int result = 0;
        assertEquals(result, out.size());
    }


    @Test
    public void shouldReturnMasWhenToArray() {
        Integer[] result = mas;
        assertArrayEquals(result, out.toArray());
    }


}