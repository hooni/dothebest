package com.samsungds.codereview.teamd.command;

import com.samsungds.codereview.teamd.print.FilePrint;
import com.samsungds.codereview.teamd.repo.IRepository;

public interface ICommand {
    public Boolean execute(String inputStr);
    public void setFilePrinter(FilePrint filePrint);
    public void setRepository(IRepository irepo);
}
