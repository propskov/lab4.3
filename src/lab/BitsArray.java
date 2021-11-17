package lab;

import java.util.stream.IntStream;

public class BitsArray implements FlagsSet {
    private int[] bits = new int[SIZE / 32];

    private void checkIndex(int index) {
        if (index < 0 || index >= SIZE)
            throw new IllegalArgumentException("Размер коллекции 1024");
    }

    @Override
    public boolean get(int index) {
        checkIndex(index);
        int bitsind = index / 32;
        int bitind = index % 32;
        return ((bits[bitsind] >> bitind) & 1) == 1;
    }


    @Override
    public void set(int index) {
        checkIndex(index);
        set(index, true);
    }

    @Override
    public void set(int index, boolean value) {
        checkIndex(index);
        int bitsind = index / 32;
        int bitind = index % 32;
        if (value)
            bits[bitsind] = bits[bitsind] | (1 << (bitind));
        else
            bits[bitsind] = bits[bitsind] & ~(1 << (bitind));
    }

    @Override
    public void clear(int index) {
        checkIndex(index);
        set(index, false);
    }

    @Override
    public void flip(int index) {
        checkIndex(index);

    }

    @Override
    public int count() {
        int res = 0;

        int i = 0;
        while (i < SIZE / 32) {
            int j = 0;
            while (j <= 31) {
                if (((bits[i] >> j) & 1) == 1) res++;
                j++;
            }
            i++;
        }
        return res;
    }

    @Override
    public String toString() {
        int counter = 0;
        char[] ac = new char[SIZE];
        int i = 0;
        while (i < SIZE / 32) {
            int j = 0;
            while (j < 32) {
                ac[counter] = (((bits[i] >> j) & 1) == 1) ? '1' : '0';
                counter++;
                j++;
            }
            i++;
        }
        return new String(ac);
    }
}