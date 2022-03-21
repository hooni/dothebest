package com.samsungds.codereview.teamd.command;

import com.samsungds.codereview.teamd.repo.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddTest {
    private AddCommand add;
    private String inputStr1;

    @BeforeEach
    void setUp() {
        add = new AddCommand(new Repository());
        inputStr1 = "ADD, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO";
    }

    @Test
    void constructorTest(){
        assertThrows(NullPointerException.class, () -> {add = new AddCommand(null);} );
    }

    @Test
    void wrongInputData(){
        String wrongInput = "SCH,-p,-d, ,birthday,04";

        assertFalse(add.execute(wrongInput));
    }

    @Test
    void addExecuteTest(){
        assertTrue(add.execute(inputStr1));
    }

    @Test
    void sameInputStringTest(){
        String inputStr2 = "ADD, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO";

        assertTrue(add.execute(inputStr1));
        assertFalse(add.execute(inputStr2));
    }

    @Test
    void haveSameEmployeeNumTest(){
        String inputStr2 = "ADD, , , ,18050301,DAVID KIM,CL3,010-1234-5678,19880516,EXP";

        assertTrue(add.execute(inputStr1));
        assertFalse(add.execute(inputStr2));
    }
}
