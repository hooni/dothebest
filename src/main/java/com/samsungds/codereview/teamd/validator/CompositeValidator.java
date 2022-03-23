package com.samsungds.codereview.teamd.validator;

import java.util.ArrayList;
import java.util.List;

public abstract class CompositeValidator implements Validator {

	private List<Validator> validatorList = new ArrayList<>();
	
	protected void addValidator(Validator validator) {
		validatorList.add(validator);
	}

	@Override
	public boolean isValid(String string) {
		return validatorList.stream().allMatch(v -> v.isValid(string));
	}

}
