package org.runner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class TestResultClass {
  public static void main(String[] args) {
	
	  Result runClasses = JUnitCore.runClasses(TestRunnerClass.class);
	  System.out.println(runClasses.getRunCount());
	  System.out.println(runClasses.getRunTime());
	  System.out.println(runClasses.getFailures());
	  System.out.println(runClasses.hashCode());
	  
	  
	  
	  
}
}
