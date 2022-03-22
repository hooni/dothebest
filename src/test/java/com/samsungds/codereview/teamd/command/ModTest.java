package com.samsungds.codereview.teamd.command;

import com.samsungds.codereview.teamd.print.Print;
import com.samsungds.codereview.teamd.repo.IRepository;
import com.samsungds.codereview.teamd.repo.MemoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class ModTest {

    @Mock
    Print filePrint;

    @InjectMocks
    ModCommand mod;

    @BeforeEach
    void setUp() throws IOException {
        IRepository irepo = new MemoryRepository();
        AddCommand add = new AddCommand();
        add.setRepository(irepo);
        add.setFilePrint(filePrint);
        mod = new ModCommand();
        mod.setRepository(irepo);
        mod.setFilePrint(filePrint);

        String addStr1 = "ADD, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,EX";
        String addStr2 = "ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV";
        String addStr3 = "ADD, , , ,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO";
        String addStr4 = "ADD, , , ,08117441,BMU MPOSXU,CL3,010-2703-3153,20010215,ADV";

        add.execute(addStr1);
        add.execute(addStr2);
        add.execute(addStr3);
        add.execute(addStr4);

        Mockito.lenient().doNothing().when(filePrint).print(anyString(), anyCollection());
    }

    @Test
    void wrongCommandDataTest(){
        String wrongInput = "SCH,-p,-d, ,birthday,04";

        assertThrows(Exception.class,() -> mod.execute(wrongInput), "");
    }

    @Test
    void wrongInputDataTest(){
        String wrongInput = "MOD,-p,-d, ,birthday,19980906";

        assertThrows(Exception.class,() -> mod.execute(wrongInput), "");
    }

    @Test
    void employeeNumModifyTest() {
        String wrongInput = "MOD, , , ,employeeNum,18050301,employeeNum,18050317";

        assertThrows(Exception.class,() -> mod.execute(wrongInput), "");
    }

    @Test
    void nameModifyByAllMethodTest() throws IOException {
        String inputData1 = "MOD, , , ,name,KYUMOK KIM,name,KYUMOOK KIM";
        String inputData2 = "MOD, , , ,employeeNum,18050301,name,KIMOOK KIM";
        String inputData3 = "MOD, , , ,cl,CL2,name,KUKMIN KIM";
        String inputData4 = "MOD, , , ,phoneNum,010-9777-6055,name,KUNGMIN KIM";
        String inputData5 = "MOD, , , ,birthday,19980906,name,KUNGMIN LIM";
        String inputData6 = "MOD, , , ,certi,EX,name,MUNMIN MIM";

        assertTrue(mod.execute(inputData1));
        assertTrue(mod.execute(inputData2));
        assertTrue(mod.execute(inputData3));
        assertTrue(mod.execute(inputData4));
        assertTrue(mod.execute(inputData5));
        assertTrue(mod.execute(inputData6));
    }

    @Test
    void clModifyTest() throws IOException {
        String inputData = "MOD, , , ,cl,CL3,cl,CL2";

        assertTrue(mod.execute(inputData));
    }

    @Test
    void phoneNumModifyTest() throws IOException {
        String inputData = "MOD, ,-m, ,phoneNum,9777,phoneNum,010-9777-5560";

        assertTrue(mod.execute(inputData));
    }

    @Test
    void birthdayModifyTest() throws IOException {
        String inputData = "MOD, ,-d, ,birthday,06,birthday,20000906";

        assertTrue(mod.execute(inputData));
    }

    @Test
    void certiModifyTest() throws IOException {
        String inputData = "MOD, , , ,certi,ADV,certi,PRO";

        assertTrue(mod.execute(inputData));
    }
}
