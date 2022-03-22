package com.samsungds.codereview.teamd.command;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.validator.CommandValidator;

import java.io.IOException;
import java.util.ArrayList;

public class DelCommand extends BaseCommand {
    private final String commandName;

    public DelCommand(){
        this.commandName = Constants.COMMAND_DEL;
    }

    @Override
    public Boolean execute(String inputStr) throws IOException {
        if(getRepository() == null) throw new NullPointerException("Error : Repository Link");

        CommandValidator.DEL.validate(inputStr);

        ArrayList<String> itemList = inputStringToArrayList(inputStr);

        if(itemList.get(Constants.INPUT_STR_OPTION1_POS).equals(Constants.OPTION1_PRINT)){
            printResult(commandName, transMaptoList(getRepository().delete(checkSearchKey(
                                    itemList.get(Constants.INPUT_STR_OPTION2_POS),
                                    itemList.get(Constants.INPUT_STR_KEY1)),
                            itemList.get(Constants.INPUT_STR_VALUE1))));
        }
        else {
            printResult(commandName, getRepository().deleteCnt(checkSearchKey(
                            itemList.get(Constants.INPUT_STR_OPTION2_POS), itemList.get(Constants.INPUT_STR_KEY1)),
                    itemList.get(Constants.INPUT_STR_VALUE1)));
        }

        return true;
    }
}
