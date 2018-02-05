package api_builder.app;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.maven.cli.MavenCli;

public class Runner {

	private static final String OUTPUT_FOLDER = "maven";
	private static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {
		
		MavenCli cli = new MavenCli();
		int result = cli.doMain(new String[]{"clean"," antrun:run@hbm2java"},
		        "C:\\Users\\remi_\\git\\api_builder\\hibernate_tools_test",
		        System.out, System.out);
		System.out.println("result: " + result);

//		try {
//			unzip("maven.zip",OUTPUT_FOLDER);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		System.out.println("Yolo");
//
//		InvocationRequest request = new DefaultInvocationRequest();
//		request.setPomFile( new File( Runner.class.getClassLoader().getResource("pom.xml").getFile()) );
//		//request.setGoals( Arrays.asList( "clean"," antrun:run@hbm2java" ) );
//		request.setGoals( Arrays.asList("antrun:run@hbm2java -X"));
////		InvocationRequest requestTwo = new DefaultInvocationRequest();
////		requestTwo.setPomFile( new File( "pom.xml" ) );
//		//		requestTwo.setGoals( Arrays.asList( "repackage" ) );
//
//		Invoker invoker = new DefaultInvoker();
//		invoker.setMavenHome(new File("maven"));
//		invoker.setMavenExecutable(new File("mvn.cmd"));
//
//		try {
//			invoker.execute( request );
//			System.out.println("yolo2");
//			//			invoker.execute( requestTwo );
//		} catch (MavenInvocationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	/**
	 * Extracts a zip file specified by the zipFilePath to a directory specified by
	 * destDirectory (will be created if does not exists)
	 * @param zipFilePath
	 * @param destDirectory
	 * @throws IOException
	 */
	public static void unzip(String zipFilePath, String destDirectory) throws IOException {
		File destDir = new File(destDirectory);
		if (!destDir.exists()) {
			destDir.mkdir();
		}
		ZipInputStream zipIn = new ZipInputStream(Runner.class.getClassLoader().getResourceAsStream(zipFilePath));
		ZipEntry entry = zipIn.getNextEntry();
		// iterates over entries in the zip file
		while (entry != null) {
			String filePath = destDirectory + File.separator + entry.getName();
			if (!entry.isDirectory()) {
				// if the entry is a file, extracts it
				extractFile(zipIn, filePath);
			} else {
				// if the entry is a directory, make the directory
				File dir = new File(filePath);
				dir.mkdir();
			}
			zipIn.closeEntry();
			entry = zipIn.getNextEntry();
		}
		zipIn.close();
	}
	/**
	 * Extracts a zip entry (file entry)
	 * @param zipIn
	 * @param filePath
	 * @throws IOException
	 */
	private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
		byte[] bytesIn = new byte[BUFFER_SIZE];
		int read = 0;
		while ((read = zipIn.read(bytesIn)) != -1) {
			bos.write(bytesIn, 0, read);
		}
		bos.close();
	}
}

