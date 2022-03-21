package com.samsungds.codereview.teamd.command;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.print.FilePrint;
import com.samsungds.codereview.teamd.print.Print;
import com.samsungds.codereview.teamd.repo.IRepository;
import com.samsungds.codereview.teamd.vo.Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddCommand implements ICommand {
    private IRepository irepo;
    private Print filePrint;

    @Override
    public Boolean execute(String inputStr) throws IOException {
        if(irepo == null) throw new NullPointerException("Error : Repository Link");

        ArrayList<String> itemList = inputStringToArrayList(inputStr);

        if(!(itemList.get(Constants.INPUT_STR_COMMAND_POS).equals(Constants.COMMAND_ADD)))
            throw new IllegalArgumentException();

        Employee emp = empMaker(itemList.get(Constants.INPUT_STR_EMP_NUM_POS),
                itemList.get(Constants.INPUT_STR_EMP_NAME_POS),
                itemList.get(Constants.INPUT_STR_EMP_CAREER_LEVEL_POS),
                itemList.get(Constants.INPUT_STR_EMP_PHONENUM_POS),
                itemList.get(Constants.INPUT_STR_EMP_BIRTHDAY_POS),
                itemList.get(Constants.INPUT_STR_EMP_CERTI_POS));

        ArrayList<Employee> empList = new ArrayList<>();
        empList.add(emp);

        filePrint.print(Constants.COMMAND_ADD, empList, false);

        return irepo.add(emp) != 0;
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

    private Employee empMaker(String empNum, String name, String cl, String phoneNum, String birtday, String certi) {
        return new Employee(empNum, name, cl, phoneNum, birtday, certi);
    }
}
