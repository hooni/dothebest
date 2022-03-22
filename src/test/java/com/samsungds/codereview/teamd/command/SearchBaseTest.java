package com.samsungds.codereview.teamd.command;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.repo.IRepository;
import com.samsungds.codereview.teamd.repo.MemoryRepository;
import com.samsungds.codereview.teamd.vo.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class SearchBaseTest {
    private SearchBaseCommand searchBase;

    @BeforeEach
    void setUp(){
        searchBase = spy(SearchBaseCommand.class);
    }

    @Test
    void getRepositoryTest(){
        IRepository irepo = new MemoryRepository();
        searchBase.setRepository(irepo);

        assertEquals(irepo, searchBase.getRepository());
    }

    @Test
    void inputStringToArrayListTest(){
        String inputStr1 = "ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV";
        String [] strArr = inputStr1.split(Constants.SEPARATOR_EMPLOYEE);

        ArrayList<String> strList1 = new ArrayList<>(Arrays.asList(strArr));
        ArrayList<String> resultList1 = searchBase.inputStringToArrayList(inputStr1);

        assertEquals(strList1, resultList1);
        assertEquals(strList1.get(Constants.INPUT_STR_COMMAND_POS), resultList1.get(Constants.INPUT_STR_COMMAND_POS));
        assertEquals(strList1.get(Constants.INPUT_STR_OPTION1_POS), resultList1.get(Constants.INPUT_STR_OPTION1_POS));
        assertEquals(strList1.get(Constants.INPUT_STR_OPTION2_POS), resultList1.get(Constants.INPUT_STR_OPTION2_POS));
        assertEquals(strList1.get(Constants.INPUT_STR_OPTION3_POS), resultList1.get(Constants.INPUT_STR_OPTION3_POS));
        assertEquals(strList1.get(Constants.INPUT_STR_KEY1), resultList1.get(Constants.INPUT_STR_KEY1));
        assertEquals(strList1.get(Constants.INPUT_STR_VALUE1), resultList1.get(Constants.INPUT_STR_VALUE1));
        assertEquals(strList1.get(Constants.INPUT_STR_KEY2), resultList1.get(Constants.INPUT_STR_KEY2));
        assertEquals(strList1.get(Constants.INPUT_STR_EMP_PHONENUM_POS), resultList1.get(Constants.INPUT_STR_EMP_PHONENUM_POS));
        assertEquals(strList1.get(Constants.INPUT_STR_EMP_BIRTHDAY_POS), resultList1.get(Constants.INPUT_STR_EMP_BIRTHDAY_POS));
        assertEquals(strList1.get(Constants.INPUT_STR_EMP_CERTI_POS), resultList1.get(Constants.INPUT_STR_EMP_CERTI_POS));
    }

    @Test
    void checkSearchKeyTest(){
        assertEquals(Constants.EMPLOYEE_NAME, searchBase.checkSearchKey(Constants.OPTION2_PHONENUM_MID, Constants.EMPLOYEE_NAME));
        assertEquals(Constants.EMPLOYEE_PHONENUM, searchBase.checkSearchKey(Constants.OPTION2_NAME_FIRST, Constants.EMPLOYEE_PHONENUM));

        assertEquals(Constants.OPTION2_PHONENUM_MID_FIELDNAME, searchBase.checkSearchKey(Constants.OPTION2_PHONENUM_MID, Constants.EMPLOYEE_PHONENUM));
        assertEquals(Constants.OPTION2_BIRTHDAY_YEAR_FIELDNAME, searchBase.checkSearchKey(Constants.OPTION2_BIRTHDAY_YEAR, Constants.EMPLOYEE_BIRTHDAY));

    }

   @Test
   void transMaptoListTest(){
       Employee emp1 =new Employee("18050301", "KYUMOK KIM", "CL2", "010-9777-6055", "19980906", "PRO");
       Employee emp2 =new Employee("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211", "ADV");

       Map<Integer, Employee> map = new TreeMap<>();
       map.put(emp1.getEmployeeNumForSort(), emp1);
       map.put(emp2.getEmployeeNumForSort(), emp2);

       searchBase.transMaptoList(map);
   }

   @Test
    void executeTest() throws IOException {
        when(searchBase.execute(anyString())).thenReturn(Boolean.TRUE);

        assertTrue(searchBase.execute("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV"));
   }

}
