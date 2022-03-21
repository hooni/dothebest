package com.samsungds.codereview.teamd.command;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.print.Print;
import com.samsungds.codereview.teamd.repo.IRepository;
import com.samsungds.codereview.teamd.vo.Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SchCommand implements ICommand{
    private IRepository irepo;
    private Print filePrint;
//    private FilePrint filePrint;

    @Override
    public Boolean execute(String inputStr) throws IOException {
        System.out.println("======================");
        if(irepo == null) throw new NullPointerException("Error : Repository Link");
        System.out.println("Repository Null Check OK");

        ArrayList<String> itemList = inputStringToArrayList(inputStr);
        System.out.println("itemList Creation OK");

        if(!(itemList.get(Constants.INPUT_STR_COMMAND_POS).equals(Constants.COMMAND_SEARCH)))
            throw new IllegalArgumentException();

        System.out.println("Input String Check OK");

        Map<Integer, Employee> map = irepo.search(itemList.get(Constants.INPUT_STR_KEY1),
                itemList.get(Constants.INPUT_STR_VALUE1));

        System.out.println("Get Map Data OK");

        ArrayList<Employee> empList = new ArrayList<>();

        if(map != null) {
            for (Integer key : map.keySet()) {
                empList.add(map.get(key));
            }
        }

        System.out.println("Make Employee List OK");

        printResult(empList, isPrintOptionEnable(itemList.get(Constants.INPUT_STR_OPTION1_POS)));

        System.out.println("Print Result");
        System.out.println("COMMAND : " + Constants.COMMAND_SEARCH);
        System.out.println("Total Cnt : " + empList.size());
        System.out.println("========================");

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
