package com.samsungds.codereview.teamd.command;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.repo.IRepository;
import com.samsungds.codereview.teamd.vo.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DelCommand implements ICommand{
    private IRepository irepo;

    public DelCommand(IRepository irepo){
        setRepository(irepo);
    }

    @Override
    public Boolean execute(String inputStr) {
        ArrayList<String> itemList = inputStringToArrayList(inputStr);

        if(!(itemList.get(Constants.INPUT_STR_COMMAND_POS).equals(Constants.COMMAND_DEL))) return false;

        if(itemList.get(Constants.INPUT_STR_KEY1).equals("employeeNum")){
            String temp;
            if((int) itemList.get(Constants.INPUT_STR_VALUE1).charAt(0) > 5){
                temp = Constants.EMPLOYEE_NUM_PREFIX_BEFORE_MILLENIUM + itemList.get(Constants.INPUT_STR_VALUE1);
            } else {
                temp = Constants.EMPLOYEE_NUM_PREFIX_AFTER_MILLENIUM + itemList.get(Constants.INPUT_STR_VALUE1);
            }
            itemList.set(Constants.INPUT_STR_VALUE1, temp);
        }

        Map<Integer, Employee> map = irepo.delete(itemList.get(Constants.INPUT_STR_KEY1), itemList.get(Constants.INPUT_STR_VALUE1));

        if(map.isEmpty()) {
            // 추후 파일 출력으로 변경 예정
            System.out.println("DEL,NONE");
            return true;
        }

        if(itemList.get(Constants.INPUT_STR_OPTION1_POS).equals(Constants.OPTION1_PRINT)){
            for(Integer key: map.keySet()){
                System.out.println("DEL,"+map.get(key).toString());
            }
        }
        else {
            // 추후 파일 출력으로 변경 예정
            System.out.println("DEL," + map.size());
        }

        return true;
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
}
