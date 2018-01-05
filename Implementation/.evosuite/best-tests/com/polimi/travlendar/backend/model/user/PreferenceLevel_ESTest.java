/*
 * This file was automatically generated by EvoSuite
 * Fri Jan 05 22:21:59 GMT 2018
 */

package com.polimi.travlendar.backend.model.user;

import org.junit.Test;
import static org.junit.Assert.*;
import com.polimi.travlendar.backend.model.user.PreferenceLevel;
import java.util.ArrayList;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class PreferenceLevel_ESTest extends PreferenceLevel_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      PreferenceLevel[] preferenceLevelArray0 = PreferenceLevel.values();
      assertNotNull(preferenceLevelArray0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      PreferenceLevel preferenceLevel0 = PreferenceLevel.valueOf("MEDIUM");
      assertEquals("MEDIUM", preferenceLevel0.getPreference());
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      PreferenceLevel preferenceLevel0 = PreferenceLevel.valueOf("HIGH");
      assertEquals("High", preferenceLevel0.getPreference());
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      PreferenceLevel preferenceLevel0 = PreferenceLevel.valueOf("LOW");
      int int0 = preferenceLevel0.getLevel();
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      PreferenceLevel preferenceLevel0 = PreferenceLevel.MEDIUM;
      preferenceLevel0.setPreference("MEDIUM");
      assertEquals(902, preferenceLevel0.getLevel());
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      PreferenceLevel preferenceLevel0 = PreferenceLevel.MEDIUM;
      String string0 = preferenceLevel0.getPreference();
      assertEquals("Medium", string0);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      ArrayList<String> arrayList0 = PreferenceLevel.getAsList();
      assertFalse(arrayList0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      PreferenceLevel preferenceLevel0 = PreferenceLevel.MEDIUM;
      int int0 = preferenceLevel0.getLevel();
      assertEquals(902, int0);
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      PreferenceLevel preferenceLevel0 = PreferenceLevel.MEDIUM;
      preferenceLevel0.setLevel(901);
      assertEquals(901, preferenceLevel0.getLevel());
  }
}
