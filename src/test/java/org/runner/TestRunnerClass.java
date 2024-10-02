package org.runner;

import org.execution.JUnitHomePageExecution;
import org.execution.JUnitKurtiSetPageExecution;
import org.execution.JUnitLogOutPageExecution;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
//		JUnitHomePageExecution.class,
//		JUnitKurtiSetPageExecution.class,
		JUnitLogOutPageExecution.class,
		
 })
public class TestRunnerClass {

}
