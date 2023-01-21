package org.example.programmers.practice;

import junit.framework.TestCase;

public class 유사_칸토어_비트열Test extends TestCase {

    public void testCountOne() {
    }

    public void testSolution() {
        int result = 유사_칸토어_비트열.countOne(2, 17) - 유사_칸토어_비트열.countOne(2, 4 - 1);
        System.out.println(result);
        assertEquals(8, result);

        result = 유사_칸토어_비트열.countOne(3, 17) - 유사_칸토어_비트열.countOne(3, 4 - 1);
        System.out.println(result);
        assertEquals(8, result);

        result = 유사_칸토어_비트열.countOne(4, 17) - 유사_칸토어_비트열.countOne(4, 4 - 1);
        System.out.println(result);
        assertEquals(8, result);

        result = 유사_칸토어_비트열.countOne(4, 118) - 유사_칸토어_비트열.countOne(4, 4 - 29);
        System.out.println(result);
        assertEquals(8, result);
    }
}