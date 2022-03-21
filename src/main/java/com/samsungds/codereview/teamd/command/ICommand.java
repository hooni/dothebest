package com.samsungds.codereview.teamd.command;

import com.samsungds.codereview.teamd.print.FilePrint;
import com.samsungds.codereview.teamd.repo.IRepository;

public interface ICommand {
    public Boolean execute(String inputStr);
    // Interface 변경
    public void setFilePrint(FilePrint filePrint);
    public void setRepository(IRepository iRepository);
}
