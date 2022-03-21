package com.samsungds.codereview.teamd.command;

import com.samsungds.codereview.teamd.repo.IRepository;
import com.samsungds.codereview.teamd.repo.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SchTest {
    private IRepository irepo;
    private SchCommand sch;

    @BeforeEach
    void setUp(){
        irepo = new Repository();
        AddCommand add = new AddCommand(irepo);
        sch = new SchCommand(irepo);

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
    void constructorTest(){
        assertThrows(NullPointerException.class, () -> {SchCommand sch = new SchCommand(null);} );
    }

    @Test
    void wrongInputData(){
        String wrongInput = "MOD,-p, , ,birthday,19980906,20000906";

        assertFalse(sch.execute(wrongInput));
    }
}
