package fr.aboucorp;

public class RunnerTest {

	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				javafx.application.Application.launch(MainApp.class);
			}
		}.start();
	}

}
