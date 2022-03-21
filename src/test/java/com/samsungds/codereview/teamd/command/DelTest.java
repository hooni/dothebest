package com.samsungds.codereview.teamd.command;

import com.samsungds.codereview.teamd.print.FilePrint;
import com.samsungds.codereview.teamd.print.Print;
import com.samsungds.codereview.teamd.repo.IRepository;
import com.samsungds.codereview.teamd.repo.Repository;
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
public class DelTest {
    private IRepository irepo;

    @Mock
    Print filePrint;

    @InjectMocks
    DelCommand del;

    @BeforeEach
    void setUp() throws IOException {
        irepo = new Repository();
        AddCommand add = new AddCommand();
        add.setRepository(irepo);
        add.setFilePrint(filePrint);
        del = new DelCommand();
        del.setRepository(irepo);
        del.setFilePrint(filePrint);

        String addStr1 = "ADD, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO";
        String addStr2 = "ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV";
        String addStr3 = "ADD, , , ,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO";
        String addStr4 = "ADD, , , ,08117441,BMU MPOSXU,CL3,010-2703-3153,20010215,ADV";

        add.execute(addStr1);
        add.execute(addStr2);
        add.execute(addStr3);
        add.execute(addStr4);

        Mockito.lenient().doNothing().when(filePrint).print(anyString(), anyCollection(), anyBoolean());
    }

    @Test
    void wrongInputData() throws IOException {
        String wrongInput = "SCH,-p,-d, ,birthday,19771211";

        assertThrows(Exception.class,() -> del.execute(wrongInput), "");
    }

    @Test
    void delExecuteByEmpNumTest() throws IOException {
        String inputStr1 = "DEL, , , ,employeeNum,18050301";
        assertTrue(del.execute(inputStr1));
        assertTrue(del.execute(inputStr1));
    }

    @Test
    void delExecuteByEmpNumAndPrintOptionTest() throws IOException {
        String inputStr1 = "DEL,-p, , ,employeeNum,18050301";

        assertTrue(del.execute(inputStr1));
        assertTrue(del.execute(inputStr1));
    }

    @Test
    void delExecuteByNameTest() throws IOException {
        String inputStr1 = "DEL, , , ,name,KYUMOK KIM";

        assertTrue(del.execute(inputStr1));
        assertTrue(del.execute(inputStr1));
    }

    @Test
    void delExecuteByCLTest() throws IOException {
        String inputStr1 = "DEL, , , ,cl,CL2";

        assertTrue(del.execute(inputStr1));
        assertTrue(del.execute(inputStr1));
    }

    @Test
    void delExecuteByPhoneNumTest() throws IOException {
        String inputStr1 = "DEL, , , ,phoneNum,010-9777-6055";

        assertTrue(del.execute(inputStr1));
        assertTrue(del.execute(inputStr1));
    }

    @Test
    void delExecuteByBirthdayTest() throws IOException {
        String inputStr1 = "DEL, , , ,birthday,19980906";

        assertTrue(del.execute(inputStr1));
        assertTrue(del.execute(inputStr1));
    }

    @Test
    void delExecuteByCertiTest() throws IOException {
        String inputStr1 = "DEL, , , ,certi,PRO";

        assertTrue(del.execute(inputStr1));
        assertTrue(del.execute(inputStr1));
    }
}
