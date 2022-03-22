package com.samsungds.codereview.teamd.command;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.validator.CommandValidator;
import com.samsungds.codereview.teamd.vo.Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class ModCommand extends SearchBaseCommand {
    private final String commandName;

    public ModCommand(){
        this.commandName = Constants.COMMAND_MODIFY;
    }

    @Override
    public Boolean execute(String inputStr) throws IOException {
        if(getRepository() == null) throw new NullPointerException("Error : Repository Link");
        CommandValidator.MOD.validate(inputStr);
        ArrayList<String> itemList = inputStringToArrayList(inputStr);
        printSelect(itemList);
        return true;
    }

    @Override
    protected void printSelect(ArrayList<String> itemList) throws IOException {
        if(itemList.get(Constants.INPUT_STR_OPTION1_POS).equals(Constants.OPTION1_PRINT)) {
            Map<Integer, Employee> map = getRepository().modify(checkSearchKey(itemList.get(Constants.INPUT_STR_OPTION2_POS),
                            itemList.get(Constants.INPUT_STR_KEY1)), itemList.get(Constants.INPUT_STR_VALUE1),
                    itemList.get(Constants.INPUT_STR_KEY2),
                    itemList.get(Constants.INPUT_STR_VALUE2));
            printResult(commandName, transMaptoList(map));
        }

        printResult(commandName, getRepository().modifyCnt(checkSearchKey(itemList.get(Constants.INPUT_STR_OPTION2_POS),
                        itemList.get(Constants.INPUT_STR_KEY1)), itemList.get(Constants.INPUT_STR_VALUE1),
                itemList.get(Constants.INPUT_STR_KEY2),
                itemList.get(Constants.INPUT_STR_VALUE2)));
    }
}
