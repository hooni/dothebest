package com.samsungds.codereview.teamd.validator.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.samsungds.codereview.teamd.validator.Validator;

public class StringContainValidator implements Validator {

	private List<String> list = new ArrayList<>();

	public StringContainValidator(String[] arrays) {
		this.list.addAll(Arrays.asList(arrays));
	}

	public boolean isValid(String string) {
		return list.stream().anyMatch(s -> s.equals(string));
	}

}
