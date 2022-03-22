package com.samsungds.codereview.teamd.validator;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.validator.command.AddCommandValidator;
import com.samsungds.codereview.teamd.validator.command.DelCommandValidator;
import com.samsungds.codereview.teamd.validator.command.ModCommandValidator;
import com.samsungds.codereview.teamd.validator.command.SchCommandValidator;

public class CommandValidator {

	public static final CommandValidator ADD = new CommandValidator(Constants.COMMAND_ADD, new AddCommandValidator());
	public static final CommandValidator MOD = new CommandValidator(Constants.COMMAND_MODIFY, new ModCommandValidator());
	public static final CommandValidator DEL = new CommandValidator(Constants.COMMAND_DEL, new DelCommandValidator());
	public static final CommandValidator SCH = new CommandValidator(Constants.COMMAND_SEARCH, new SchCommandValidator());

	private Validator validator;
	private String name;

	private CommandValidator(String name, Validator validator) {
		this.name = name;
		this.validator = validator;
	}

	public boolean validate(String value) {
		if (validator.isValid(value) == false) {
			throw new IllegalArgumentException(name + " : " + value);
		}
		return true;
	}
	
	public static CommandValidator getValidator(String column) {
		if(column == null) throw new IllegalArgumentException(column);
		switch (column) {
			case Constants.COMMAND_ADD: return ADD;
			case Constants.COMMAND_MODIFY: return MOD;
			case Constants.COMMAND_DEL: return DEL;
			case Constants.COMMAND_SEARCH: return SCH;
			default : throw new IllegalArgumentException(column);
		}
	}
}
