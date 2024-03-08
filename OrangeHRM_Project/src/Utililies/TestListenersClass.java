package Utililies;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.pages.BaseTest;

public class TestListenersClass extends BaseTest implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {

		ITestListener.super.onTestStart(result);

		System.out.println("***************** Test Execution Started " + result.getName() + "*****************");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ITestListener.super.onTestSuccess(result);
		System.out.println("***************** Test Execution Success " + result.getName() + "*****************");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ITestListener.super.onTestFailure(result);
		System.out.println("***************** Test Execution Failure " + result.getName() + "*****************");
		int i = 1;
		screenShotProgram ss = new screenShotProgram();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime now = LocalDateTime.now();
		String dateTimeString = now.format(formatter);
		ss.takeSS(result.getName() + "_Executions_SS_" +  dateTimeString);
		++i;
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);

		System.out.println("***************** Test Execution Skipped " + result.getName() + "*****************");

	}

	@Override
	public void onStart(ITestContext context) {

		ITestListener.super.onStart(context);
		System.out.println("***************** Suite Execution Started " + context.getName() + "*****************");
	}

	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
		System.out.println("***************** Suite Execution Ended " + context.getName() + "*****************");
	}

}
