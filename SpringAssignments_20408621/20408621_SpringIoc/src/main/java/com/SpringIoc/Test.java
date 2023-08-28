package com.SpringIoc;

public class Test {
	private String testId;
	private String testName;
	private String testMarks;
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTestMarks() {
		return testMarks;
	}
	public void setTestMarks(String testMarks) {
		this.testMarks = testMarks;
	}
	public Test(String testId, String testName, String testMarks) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.testMarks = testMarks;
	}

}
