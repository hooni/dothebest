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
public class SchTest {

    @Mock
    Print filePrint;

    @InjectMocks
    SchCommand sch;

    @BeforeEach
    void setUp() throws IOException {
        IRepository irepo = new MemoryRepository();
        AddCommand add = new AddCommand();
        add.setRepository(irepo);
        add.setFilePrint(filePrint);
        sch = new SchCommand();
        sch.setRepository(irepo);
        sch.setFilePrint(filePrint);

        String addStr1 = "ADD, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO";
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
    void wrongInputData(){
        String wrongInput = "MOD,-p, , ,birthday,19980906,birthday,20000906";

        assertThrows(Exception.class,() -> sch.execute(wrongInput), "");
    }

    @Test
    void schExecuteByEmpNumTest() throws IOException {
        String inputStr1 = "SCH, , , ,employeeNum,18050301";
        assertTrue(sch.execute(inputStr1));
    }

    @Test
    void schExecuteByEmpNumAndPrintOptionTest() throws IOException {
        String inputStr1 = "SCH,-p, , ,employeeNum,18050301";

        assertTrue(sch.execute(inputStr1));
    }

    @Test
    void schExecuteByNameTest() throws IOException {
        String inputStr1 = "SCH, ,-l, ,name,JHOP";

        assertTrue(sch.execute(inputStr1));
    }

    @Test
    void schExecuteByCLTest() throws IOException {
        String inputStr1 = "SCH, , , ,cl,CL4";

        assertTrue(sch.execute(inputStr1));
    }

    @Test
    void schExecuteByPhoneNumTest() throws IOException {
        String inputStr1 = "SCH, ,-l, ,phoneNum,3153";

        assertTrue(sch.execute(inputStr1));
    }

    @Test
    void schExecuteByBirthdayTest() throws IOException {
        String inputStr1 = "SCH, ,-y, ,birthday,1998";

        assertTrue(sch.execute(inputStr1));
    }

    @Test
    void schExecuteByCertiTest() throws IOException {
        String inputStr1 = "SCH, , , ,certi,PRO";

        assertTrue(sch.execute(inputStr1));
    }
}
