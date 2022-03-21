package com.samsungds.codereview.teamd.command;

import com.samsungds.codereview.teamd.print.Print;
import com.samsungds.codereview.teamd.repo.IRepository;

import java.io.IOException;

public interface ICommand {
    public Boolean execute(String inputStr) throws IOException;
    public void setFilePrint(Print filePrint);
    public void setRepository(IRepository iRepository);
}
