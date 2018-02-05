package api_builder.app;

import java.io.File;

import org.apache.tools.ant.DefaultLogger;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;

public class Runner {

	public static void main(String[] args) {
		Project project = new Project();
        ProjectHelper.configureProject(project, new File("build.xml"));
        DefaultLogger consoleLogger = new DefaultLogger();
        consoleLogger.setErrorPrintStream(System.err);
        consoleLogger.setOutputPrintStream(System.out);
        consoleLogger.setMessageOutputLevel(Project.MSG_INFO);
        project.addBuildListener(consoleLogger);
        project.init();
        project.executeTarget("gen_hibernate");

	}

}
