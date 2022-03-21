package com.samsungds.codereview.teamd.command;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.repo.IRepository;
import com.samsungds.codereview.teamd.vo.Employee;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SchCommand implements ICommand{
    private IRepository irepo;

    public SchCommand(IRepository irepo){
        setRepository(irepo);
    }

    @Override
    public Boolean execute(String inputStr) {
        ArrayList<String> itemList = inputStringToArrayList(inputStr);

        if(!(itemList.get(Constants.INPUT_STR_COMMAND_POS).equals(Constants.COMMAND_SEARCH))) return false;

        Map<Integer, Employee> map = irepo.search(itemList.get(Constants.INPUT_STR_KEY1), itemList.get(Constants.INPUT_STR_VALUE1));



        return null;
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
