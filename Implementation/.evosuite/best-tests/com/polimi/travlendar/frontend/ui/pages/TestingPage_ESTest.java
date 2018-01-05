/*
 * This file was automatically generated by EvoSuite
 * Thu Jan 04 11:19:25 GMT 2018
 */

package com.polimi.travlendar.frontend.ui.pages;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.polimi.travlendar.frontend.ui.pages.TestingPage;
import com.vaadin.navigator.ViewChangeListener;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class TestingPage_ESTest extends TestingPage_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      TestingPage testingPage0 = new TestingPage();
      // Undeclared exception!
      try { 
        testingPage0.enter((ViewChangeListener.ViewChangeEvent) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("com.polimi.travlendar.frontend.ui.pages.TestingPage", e);
      }
  }
}
