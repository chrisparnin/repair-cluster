import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class LANG552Test {

	@Test
	public void replaceEach(){
		String original = "Hello World!";
		String[] searchList = {"Hello", "World"};
		String[] replacementList = {"Greetings", null};
		String result = StringUtils.replaceEach(original, searchList, replacementList);
		assertEquals("Greetings !", result);
	}

	
}
