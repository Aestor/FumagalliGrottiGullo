/*
 * This file was automatically generated by EvoSuite
 * Thu Jan 04 11:27:53 GMT 2018
 */

package com.polimi.travlendar.backend.database;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.polimi.travlendar.backend.database.UserRowMapper;
import java.sql.ResultSet;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class UserRowMapper_ESTest extends UserRowMapper_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      UserRowMapper userRowMapper0 = new UserRowMapper();
      // Undeclared exception!
      try { 
        userRowMapper0.mapRow((ResultSet) null, (-3));
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("com.polimi.travlendar.backend.database.UserRowMapper", e);
      }
  }
}
