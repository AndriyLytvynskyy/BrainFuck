package com.booking.interviewbit.bit;

/**
Write a function that takes an unsigned integer and returns the number of 1 bits it has.

        Example:

        The 32-bit integer 11 has binary representation

        00000000000000000000000000001011
        so the function should return 3.
 */
public class Num1Bits {

    public int numSetBits(long a) {
        int count = 0;
        long value = a;
        while (value >0){
            if ((value & 1) == 1){
                count++;
            }
            value=value>>1;
        }
        return count;

    }
}
