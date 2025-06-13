package com.ohgiraffers.section03.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/* 쇠막대기 백준(10799)
* https://www.acmicpc.net/problem/10799
* */
class Practice2Tests {

    Practice2 practice2;

    @BeforeEach
    void setUp() {
        practice2 = new Practice2();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments("()(((()())(())()))(())", 17),
                arguments("(((()(()()))(())()))(()())", 24)
        );
    }

    @DisplayName("쇠막대기 문제 테스트")
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testSolution(String input, int expected) {
        int result = practice2.solution(input);
        Assertions.assertEquals(expected, result);
    }
}