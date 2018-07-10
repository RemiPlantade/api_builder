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

        
    	// Clean previously created database
//		InvocationRequest request = new DefaultInvocationRequest();
//		request.setPomFile( new File( "pom.xml" ) );
//		request.setGoals( Arrays.asList("install"));
//		Invoker invoker = new DefaultInvoker();
//		invoker.setMavenExecutable(new File("mvn.cmd"));
//		invoker.setMavenHome(new File("maven"));
//		try {
//			InvocationResult result = invoker.execute( request );
//			// Create SQLIte Database to store User preferences.
//			String databaseUrl = "jdbc:sqlite:src/main/resources/sample.db";
//			// create a connection source to our database
//			ConnectionSource connectionSource;
//
//			connectionSource = new JdbcConnectionSource(databaseUrl);
//			TableUtils.createTable(connectionSource, ApiBean.class);
//			TableUtils.createTable(connectionSource, ApiConf.class);
//			TableUtils.createTable(connectionSource, ApiGroup.class);
//			TableUtils.createTable(connectionSource, ApiGroupPerm.class);
//			TableUtils.createTable(connectionSource, ApiUser.class);
//			//			TableUtils.createTable(connectionSource, ApiUserPerm.class);
//
//		} catch (MavenInvocationException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//
//		// Invoque Retro-engineering / configuration / generation process.
//		try {
//			request.setGoals( Arrays.asList("antrun:run@hbm2java -X" ) );
//			InvocationResult result = invoker.execute( request );
//		} catch (MavenInvocationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
