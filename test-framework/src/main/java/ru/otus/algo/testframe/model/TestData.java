package ru.otus.algo.testframe.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
public class TestData {

	private final Object inputData;
	private final Object expectedResult;

}
