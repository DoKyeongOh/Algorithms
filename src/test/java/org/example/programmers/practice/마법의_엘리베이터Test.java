package org.example.programmers.practice;

import junit.framework.TestCase;

public class 마법의_엘리베이터Test extends TestCase {
    
    public void testSolution() {
        assertEquals(마법의_엘리베이터.solution(16), 6);
        assertEquals(마법의_엘리베이터.solution(2554), 16);
        assertEquals(마법의_엘리베이터.solution(155), 11);
        assertEquals(마법의_엘리베이터.solution(154), 10);
        assertEquals(마법의_엘리베이터.solution(646), 13);
        assertEquals(마법의_엘리베이터.solution(45), 9);
        assertEquals(마법의_엘리베이터.solution(55), 10);
        assertEquals(마법의_엘리베이터.solution(65), 9);
    }
}