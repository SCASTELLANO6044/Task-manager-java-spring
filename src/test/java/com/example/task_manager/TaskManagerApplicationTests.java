package com.example.task_manager;

import org.junit.platform.suite.api.ExcludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("All task-manager tests")
@SelectPackages("com.example.task_manager")
@ExcludeClassNamePatterns(".*TaskManagerApplicationTests")
public class TaskManagerApplicationTests {
}
