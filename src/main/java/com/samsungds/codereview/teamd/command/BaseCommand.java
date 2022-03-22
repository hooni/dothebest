package com.samsungds.codereview.teamd.command;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.print.Print;
import com.samsungds.codereview.teamd.repo.IRepository;
import com.samsungds.codereview.teamd.validator.CommandValidator;
import com.samsungds.codereview.teamd.vo.Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class BaseCommand implements ICommand{
    private IRepository irepo;
    private Print filePrint;

    @Override
    public abstract Boolean execute(String inputStr) throws IOException;

    @Override
    public void setFilePrint(Print filePrint) {
        this.filePrint = filePrint;
    }

    @Override
    public void setRepository(IRepository iRepository) {
        this.irepo = iRepository;
    }

    protected String checkSearchKey(String strOpt, String key){
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

    protected ArrayList<String> inputStringToArrayList(String inputStr){
        ArrayList<String> inputStrList;
        inputStrList = Stream.of(inputStr.split(Constants.SEPARATOR_EMPLOYEE)).collect(Collectors.toCollection(ArrayList<String>::new));
        return inputStrList;
    }

    protected ArrayList<Employee> transMaptoList(Map<Integer, Employee> map) {
        ArrayList<Employee> empList = new ArrayList<>();
        for(Integer key : map.keySet()){
            empList.add(map.get(key));
        }
        return empList;
    }

    protected void printResult(String cmd, ArrayList<Employee> empList) throws IOException {
        filePrint.print(cmd, empList);
    }

    protected void printResult(String cmd, int cnt) throws IOException {
        filePrint.print(cmd, cnt);
    }

    protected IRepository getRepository(){
        return this.irepo;
    }
}
