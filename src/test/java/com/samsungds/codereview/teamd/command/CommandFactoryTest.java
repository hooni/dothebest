package com.samsungds.codereview.teamd.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.samsungds.codereview.teamd.constant.Constants;
import com.samsungds.codereview.teamd.print.FilePrint;
import com.samsungds.codereview.teamd.print.Print;
import com.samsungds.codereview.teamd.repo.IRepository;
import com.samsungds.codereview.teamd.repo.MemoryRepository;

public class CommandFactoryTest {

	IRepository repository;
	Print print;
	
	@BeforeEach
	void setUp()  {
		repository = new MemoryRepository();
		try {
			print = new FilePrint("./output_temp.txt");
		} catch (IOException e) {
		}
	}
	
	@Test
	void failTest() {
		assertThrows(IllegalArgumentException.class, ()-> CommandFactory.getCommand(Constants.COMMAND_ADD, null, print));
		assertThrows(IllegalArgumentException.class, ()-> CommandFactory.getCommand(Constants.COMMAND_ADD, repository, null));
		assertThrows(IllegalArgumentException.class, ()-> CommandFactory.getCommand(Constants.COMMAND_ADD, null, null));
	}
	
	@Test
	void addCommandTest() {
		ICommand command = CommandFactory.getCommand(Constants.COMMAND_ADD, repository, print);
		assertEquals(true, command instanceof AddCommand);
		
	}
	@Test
	void delCommandTest() {
		ICommand command = CommandFactory.getCommand(Constants.COMMAND_DEL, repository, print);
		assertEquals(true, command instanceof DelCommand);
		
	}
	@Test
	void schCommandTest() {
		ICommand command = CommandFactory.getCommand(Constants.COMMAND_SEARCH, repository, print);
		assertEquals(true, command instanceof SchCommand);
		
	}
	@Test
	void modCommandTest() {
		ICommand command = CommandFactory.getCommand(Constants.COMMAND_MODIFY, repository, print);
		assertEquals(true, command instanceof ModCommand);
		
	}
}
