package com.ohgiraffers.section01.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class A_BubbleSortTests {

    private static int input1, input2;
    private static int[] act1, act2;
    private static int[] exp1, exp2;

    @BeforeAll
    public static void set() {
        input1 = 7;
        act1 = new int[]{34, 23, 5, 24, 1, 9, 12};
        exp1 = new int[]{1, 5, 9, 12, 23, 24, 34};

        input2 = 6;
        act2 = new int[]{40, 47, 38, 8, 33, 35};
        exp2 = new int[]{8, 33, 35, 38, 40, 47};
    }

    public static Stream<Arguments> provideAscendingSource() {
        return Stream.of(
                Arguments.of(input1, act1, exp1),
                Arguments.of(input2, act2, exp2)
        );
    }

    @DisplayName("버블 정렬 테스트")
    @Timeout(value=1000, unit= TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideAscendingSource")
    public void bubbleSortTest(int length, int[] actual, int[] expected) {
        A_BubbleSort.solution(length, actual);
        Assertions.assertArrayEquals(expected, actual);
    }
}