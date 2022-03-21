package com.samsungds.codereview.teamd.command;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.print.Print;
import com.samsungds.codereview.teamd.repo.IRepository;
import com.samsungds.codereview.teamd.vo.Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModCommand implements ICommand {
    private IRepository irepo;
    private Print filePrint;

    @Override
    public Boolean execute(String inputStr) throws IOException {
        if(irepo == null) throw new NullPointerException("Error : Repository Link");
        ArrayList<String> itemList = inputStringToArrayList(inputStr);

        if(!(itemList.get(Constants.INPUT_STR_COMMAND_POS).equals(Constants.COMMAND_MODIFY)))
            throw new IllegalArgumentException("Error : Command");

        if(itemList.size() != 8) throw new IllegalArgumentException("Error : Argument Count");

        if(itemList.get(Constants.INPUT_STR_KEY2).equals(Constants.EMPLOYEE_NUM))
            throw new IllegalArgumentException("Error : Can't Modify Employee Number");

        Map<Integer, Employee> map = irepo.modify(checkSearchKey(itemList.get(Constants.INPUT_STR_OPTION2_POS),
                        itemList.get(Constants.INPUT_STR_KEY1)), itemList.get(Constants.INPUT_STR_VALUE1),
                itemList.get(Constants.INPUT_STR_KEY2),
                itemList.get(Constants.INPUT_STR_VALUE2));

        ArrayList<Employee> empList = new ArrayList<>();

        if(map != null) {
            for (Integer key : map.keySet()) {
                empList.add(map.get(key));
            }
        }

        printResult(empList, isPrintOptionEnable(itemList.get(Constants.INPUT_STR_OPTION1_POS)));

        return true;
    }

    @Override
    public void setFilePrint(Print filePrint){
        this.filePrint = filePrint;
    }

    @Override
    public void setRepository(IRepository irepo){
        if(irepo == null) throw new NullPointerException("Error : Repository Link");
        this.irepo = irepo;
    }

    private String checkSearchKey(String strOpt, String key){
        switch (strOpt){
            case Constants.OPTION2_NAME_FIRST:
                return Constants.OPTION2_NAME_FIRST_FIELDNAME;
            case Constants.OPTION2_NAME_LAST:
                return key.equals(Constants.EMPLOYEE_NAME) ? Constants.OPTION2_NAME_LAST_FIELDNAME
                        : Constants.OPTION2_PHONENUM_LAST_FIELDNAME;
            case Constants.OPTION2_PHONENUM_MID:
                return key.equals(Constants.EMPLOYEE_PHONENUM) ? Constants.OPTION2_PHONENUM_MID_FIELDNAME
                        : Constants.OPTION2_BIRTHDAY_MONTH_FIELDNAME;
            case Constants.OPTION2_BIRTHDAY_YEAR:
                return Constants.OPTION2_BIRTHDAY_YEAR_FIELDNAME;
            case Constants.OPTION2_BIRTHDAY_DAY:
                return Constants.OPTION2_BIRTHDAY_DAY_FIELDNAME;
            default:
                break;
        }
        return key;
    }

    private ArrayList<String> inputStringToArrayList(String inputStr){
        ArrayList<String> inputStrList;
        inputStrList = Stream.of(inputStr.split(",")).collect(Collectors.toCollection(ArrayList<String>::new));
        return inputStrList;
    }

    private Employee empMaker(String empNum, String name, String cl, String phoneNum, String birtday, String certi){
        return new Employee(empNum, name, cl, phoneNum, birtday, certi);
    }

    private void printResult(ArrayList<Employee> empList, Boolean isEnable) throws IOException {
        filePrint.print(Constants.COMMAND_DEL, empList, isEnable);
    }

    private Boolean isPrintOptionEnable(String inputStr){
        return Constants.OPTION1_PRINT.equals(inputStr);
    }
}
