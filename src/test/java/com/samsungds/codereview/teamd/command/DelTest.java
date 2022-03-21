package com.samsungds.codereview.teamd.command;

import com.samsungds.codereview.teamd.repo.IRepository;
import com.samsungds.codereview.teamd.repo.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DelTest {
    private IRepository irepo;
    private DelCommand del;

    @BeforeEach
    void setUp(){
        irepo = new Repository();
        AddCommand add = new AddCommand();
        add.setRepository(irepo);
        del = new DelCommand();
        del.setRepository(irepo);

        String addStr1 = "ADD, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO";
        String addStr2 = "ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV";
        String addStr3 = "ADD, , , ,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO";
        String addStr4 = "ADD, , , ,08117441,BMU MPOSXU,CL3,010-2703-3153,20010215,ADV";

        add.execute(addStr1);
        add.execute(addStr2);
        add.execute(addStr3);
        add.execute(addStr4);
    }

    @Test
    void wrongInputData(){
        String wrongInput = "SCH,-p,-d, ,birthday,04";

        assertFalse(del.execute(wrongInput));
    }

    @Test
    void delExecuteByEmpNumTest(){
        String inputStr1 = "DEL, , , ,employeeNum,18050301";
        assertTrue(del.execute(inputStr1));
        assertTrue(del.execute(inputStr1));
    }

    @Test
    void delExecuteByEmpNumAndPrintOptionTest(){
        String inputStr1 = "DEL,-p, , ,employeeNum,18050301";

        assertTrue(del.execute(inputStr1));
        assertTrue(del.execute(inputStr1));
    }

    @Test
    void delExecuteByNameTest(){
        String inputStr1 = "DEL, , , ,name,KYUMOK KIM";

        assertTrue(del.execute(inputStr1));
        assertTrue(del.execute(inputStr1));
    }

    @Test
    void delExecuteByCLTest(){
        String inputStr1 = "DEL, , , ,cl,CL2";

        assertTrue(del.execute(inputStr1));
        assertTrue(del.execute(inputStr1));
    }

    @Test
    void delExecuteByPhoneNumTest(){
        String inputStr1 = "DEL, , , ,phoneNum,010-9777-6055";

        assertTrue(del.execute(inputStr1));
        assertFalse(del.execute(inputStr1));
    }

    @Test
    void delExecuteByBirthdayTest(){
        String inputStr1 = "DEL, , , ,birthday,19980906";

        assertTrue(del.execute(inputStr1));
        assertFalse(del.execute(inputStr1));
    }

    @Test
    void delExecuteByCertiTest(){
        String inputStr1 = "DEL, , , ,certi,PRO";

        assertTrue(del.execute(inputStr1));
        assertFalse(del.execute(inputStr1));
    }
}
