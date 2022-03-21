package com.samsungds.codereview.teamd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class MainTest {

	String[] args = {
			new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath()).getAbsolutePath()
					+ "./input_20_20.txt",
			new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath()).getAbsolutePath()
					+ "./output_temp.txt" };

	@Test
	void validTest() throws IOException {

		Main.main(args);
		File outFile = new File(args[1]);
		assertEquals(true, outFile.exists());
		outFile.delete();
	}

	@Test
	void argumentNullTest() {
		assertThrows(IllegalArgumentException.class, () -> Main.main(null));
	}

	@Test
	void argumentEmptyTest() {
		assertThrows(IllegalArgumentException.class, () -> Main.main(new String[] {}));
	}

	@Test
	void argumentEmptyTest1() {
		args[0] = "";
		assertThrows(IllegalArgumentException.class, () -> Main.main(args));
	}

	@Test
	void argumentEmptyTest2() {
		args[1] = "";
		assertThrows(IllegalArgumentException.class, () -> Main.main(args));
	}

	@Test
	void argumentEmptyTest3() {
		args[0] = "";
		args[1] = "";
		assertThrows(IllegalArgumentException.class, () -> Main.main(args));
	}
}
