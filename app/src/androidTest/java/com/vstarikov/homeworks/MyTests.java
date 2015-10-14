package com.vstarikov.homeworks;

import com.vstarikov.homeworks.second.SecondActivity;

import junit.framework.TestCase;

/**
 * Created by vladstarikov on 15.10.15.
 */
public class MyTests extends TestCase {
    public void testFibonacci() throws Exception {
        assertEquals(1,  SecondActivity.fibonachi(1));
        assertEquals(1,  SecondActivity.fibonachi(2));
        assertEquals(2,  SecondActivity.fibonachi(3));
        assertEquals(3,  SecondActivity.fibonachi(4));
        assertEquals(5,  SecondActivity.fibonachi(5));
        assertEquals(8,  SecondActivity.fibonachi(6));
        assertEquals(13, SecondActivity.fibonachi(7));
        assertEquals(21, SecondActivity.fibonachi(8));
        assertEquals(34, SecondActivity.fibonachi(9));
        assertEquals(55, SecondActivity.fibonachi(10));
        assertEquals(89, SecondActivity.fibonachi(11));
    }

    public void testFactorial() throws Exception {
        assertEquals(1,        SecondActivity.factorial(1));
        assertEquals(2,        SecondActivity.factorial(2));
        assertEquals(6,        SecondActivity.factorial(3));
        assertEquals(24,       SecondActivity.factorial(4));
        assertEquals(120,      SecondActivity.factorial(5));
        assertEquals(720,      SecondActivity.factorial(6));
        assertEquals(5040,     SecondActivity.factorial(7));
        assertEquals(40320,    SecondActivity.factorial(8));
        assertEquals(362880,   SecondActivity.factorial(9));
        assertEquals(3628800,  SecondActivity.factorial(10));
        assertEquals(39916800, SecondActivity.factorial(11));
    }
}
