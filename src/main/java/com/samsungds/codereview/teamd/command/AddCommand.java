package com.samsungds.codereview.teamd.command;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.repo.IRepository;
import com.samsungds.codereview.teamd.vo.Employee;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddCommand implements ICommand {
    private IRepository irepo;

    public AddCommand(IRepository irepo){
        setRepository(irepo);
    }

    @Override
    public Boolean execute(String inputStr){
        ArrayList<String> itemList = inputStringToArrayList(inputStr);

        if(!(itemList.get(Constants.INPUT_STR_COMMAND_POS).equals(Constants.COMMAND_ADD))) return false;

        Employee emp = empMaker(itemList.get(Constants.INPUT_STR_EMP_NUM_POS),
                itemList.get(Constants.INPUT_STR_EMP_NAME_POS),
                itemList.get(Constants.INPUT_STR_EMP_CAREER_LEVEL_POS),
                itemList.get(Constants.INPUT_STR_EMP_PHONENUM_POS),
                itemList.get(Constants.INPUT_STR_EMP_BIRTHDAY_POS),
                itemList.get(Constants.INPUT_STR_EMP_CERTI_POS));

        return irepo.add(emp) != 0;
    }

    private void setRepository(IRepository irepo){
        if(irepo == null) throw new NullPointerException("Error : Repository Link");
        this.irepo = irepo;
    }

    private ArrayList<String> inputStringToArrayList(String inputStr){
        ArrayList<String> inputStrList;
        inputStrList = Stream.of(inputStr.split(",")).collect(Collectors.toCollection(ArrayList<String>::new));
        return inputStrList;
    }

    private Employee empMaker(String empNum, String name, String cl, String phoneNum, String birtday, String certi){
        return new Employee(empNum, name, cl, phoneNum, birtday, certi);
    }
}
