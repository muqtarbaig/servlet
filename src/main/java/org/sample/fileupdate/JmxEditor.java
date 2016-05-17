package org.sample.fileupdate;

import java.io.File;

public class JmxEditor {
//	private static final Logger LOGG = LoggerFactory.getLogger(JmxEditor.class);
	private void update(){
		System.out.println("Start file update ");
		File file = new File("D:\\project\\servlet\\src\\main\\resources\\PGAuth_testplan_v3_vm.jmx");
		System.out.println(file.length());
	}

	public static void main(String[] args) {
		JmxEditor jme = new JmxEditor();
		jme.update();
	}
}
