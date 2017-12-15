package api_builder.app;

import java.io.File;
import java.util.Arrays;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;

public class Runner {

	public static void main(String[] args) {
		InvocationRequest request = new DefaultInvocationRequest();
		request.setPomFile( new File( "pom.xml" ) );
		request.setGoals( Arrays.asList( "clean"," antrun:run@hbm2java -X" ) );
		
		Invoker invoker = new DefaultInvoker();
		invoker.setMavenExecutable(new File("mvn.cmd"));
		invoker.setMavenHome(new File("maven"));
		try {
			invoker.execute( request );
		} catch (MavenInvocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
