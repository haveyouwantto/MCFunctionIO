package hywt.mc.FunctionIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MCFunction {
	private List<String> commands;

	public MCFunction() {
		this.commands = new ArrayList<String>();
	}

	public MCFunction(ArrayList<String> commands) {
		this.commands = commands;
	}

	public MCFunction(String[] array) {
		this.commands = Arrays.asList(array);
	}

	public void add(String command) {
		commands.add(command);
	}

	public void append(MCFunction mcf) {
		commands.addAll(mcf.commands);
	}

	public void remove(String command) {
		commands.remove(command);
	}

	public void remove(int index) {
		commands.remove(index);
	}

	public void removeLast() {
		commands.remove(commands.size() - 1);
	}

	public List<String> asList() {
		return commands;
	}

	public static void write(MCFunction mcf, File file) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		byte[] wrap = "\n".getBytes();
		for (int i = 0; i < mcf.commands.size(); i++) {
			String cmd = mcf.commands.get(i);
			byte[] out = cmd.getBytes("UTF-8");
			fos.write(out);
			fos.write(wrap);
		}
		fos.close();
	}

	public static MCFunction read(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		byte[] content = new byte[(int) file.length()];
		fis.read(content);
		fis.close();
		String str = new String(content, "UTF-8");
		return new MCFunction(str.split("\n"));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commands == null) ? 0 : commands.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MCFunction other = (MCFunction) obj;
		if (commands == null) {
			if (other.commands != null)
				return false;
		} else if (!commands.equals(other.commands))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MCFunction [size=");
		builder.append(commands.size());
		builder.append(", content=");
		builder.append(commands);
		builder.append("]");
		return builder.toString();
	}
}
