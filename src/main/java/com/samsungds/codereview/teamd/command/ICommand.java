package com.samsungds.codereview.teamd.command;

import com.samsungds.codereview.teamd.repo.IRepository;

public interface ICommand {
    public Boolean execute(String inputStr);
//    public void setRepository(IRepository irepo);
}
