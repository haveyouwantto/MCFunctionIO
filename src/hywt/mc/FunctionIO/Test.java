package hywt.mc.FunctionIO;

import java.io.File;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		MCFunction mcf=new MCFunction();
		mcf.add("say 1");
		mcf.add("summon creeper");
		try {
			MCFunction.write(mcf,new File("test.mcfunction"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
