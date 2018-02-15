package api_builder.app;

import java.io.File;

import org.apache.tools.ant.DefaultLogger;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;

public class ApiRunner {

	public static void main(String[] args) {
		Project beanGen = new Project();
        ProjectHelper.configureProject(beanGen, new File("build.xml"));
        DefaultLogger consoleLogger = new DefaultLogger();
        consoleLogger.setErrorPrintStream(System.err);
        consoleLogger.setOutputPrintStream(System.out);
        consoleLogger.setMessageOutputLevel(Project.MSG_ERR);
        beanGen.addBuildListener(consoleLogger);
        beanGen.init();
        beanGen.executeTarget("gen_hibernate");
//        System.out.println("End of Bean generation process");
//		Project springGen = new Project();
//        ProjectHelper.configureProject(springGen, new File("spring_build.xml"));
//        springGen.addBuildListener(consoleLogger);
//        springGen.init();
//        springGen.executeTarget("build");
//        System.out.println("End of Spring jar generation process");
//        System.exit(0);

	}

}
