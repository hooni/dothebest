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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AddTest {
    private String inputStr1;

    @Mock
    Print filePrint;

    @InjectMocks
    AddCommand add;


    @BeforeEach
    void setUp() throws IOException {
        add = new AddCommand();
        IRepository irepo = new MemoryRepository();
        inputStr1 = "ADD, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO";

        add.setFilePrint(filePrint);
        add.setRepository(irepo);

        Mockito.lenient().doNothing().when(filePrint).print(anyString(), anyCollection());
    }

    @Test
    void wrongInputData() {
        String wrongInput = "SCH,-p,-d, ,birthday,19980906";

        assertThrows(Exception.class,() -> add.execute(wrongInput), "");
    }

    @Test
    void addExecuteTest() {
        assertTrue(add.execute(inputStr1));
    }

    @Test
    void sameInputStringTest() {
        String inputStr2 = "ADD, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO";

        assertTrue(add.execute(inputStr1));
        assertFalse(add.execute(inputStr2));
    }

    @Test
    void haveSameEmployeeNumTest() {
        String inputStr2 = "ADD, , , ,18050301,DAVID KIM,CL3,010-1234-5678,19880516,EX";

        assertTrue(add.execute(inputStr1));
        assertFalse(add.execute(inputStr2));
    }
}
