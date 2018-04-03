import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class UI {

	public static void main(String[] args) {
		JUnitCore junit = new JUnitCore();

		Result result = null;
		result = junit.run(RunTest.class);
		List<Failure> failure = result.getFailures();
		for(;failure.isEmpty();) {
			System.out.println(failure.toString());
			failure.iterator();
		}
		
	}

}
