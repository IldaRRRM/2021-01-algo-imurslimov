package ru.otus.algo.testframe.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
public class TestData {

    private final List<String> inputData;
    private final List<String> expectedResult;

}
