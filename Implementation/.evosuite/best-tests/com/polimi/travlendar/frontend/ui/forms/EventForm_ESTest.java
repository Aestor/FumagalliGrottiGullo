/*
 * This file was automatically generated by EvoSuite
 * Fri Jan 05 22:05:25 GMT 2018
 */

package com.polimi.travlendar.frontend.ui.forms;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.polimi.travlendar.frontend.ui.forms.EventForm;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class EventForm_ESTest extends EventForm_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      EventForm eventForm0 = null;
      try {
        eventForm0 = new EventForm();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.polimi.travlendar.frontend.ui.forms.EventForm", e);
      }
  }
}
