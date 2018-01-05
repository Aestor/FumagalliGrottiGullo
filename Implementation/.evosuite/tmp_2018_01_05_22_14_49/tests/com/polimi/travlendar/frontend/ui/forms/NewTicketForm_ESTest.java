/*
 * This file was automatically generated by EvoSuite
 * Fri Jan 05 21:42:38 GMT 2018
 */

package com.polimi.travlendar.frontend.ui.forms;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.MockitoExtension.*;
import com.polimi.travlendar.backend.beans.TicketService;
import com.polimi.travlendar.backend.beans.UserService;
import com.polimi.travlendar.backend.model.user.User;
import com.polimi.travlendar.frontend.ui.forms.NewTicketForm;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.javaee.injection.Injector;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class NewTicketForm_ESTest extends NewTicketForm_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      NewTicketForm newTicketForm0 = new NewTicketForm();
      TicketService ticketService0 = new TicketService();
      JdbcTemplate jdbcTemplate0 = mock(JdbcTemplate.class, new ViolatedAssumptionAnswer());
      Injector.inject(ticketService0, (Class<?>) TicketService.class, "jdbcTemplate", (Object) jdbcTemplate0);
      User user0 = new User();
      UserService userService0 = mock(UserService.class, new ViolatedAssumptionAnswer());
      Injector.inject(user0, (Class<?>) User.class, "service", (Object) userService0);
      Injector.validateBean(user0, (Class<?>) User.class);
      Injector.inject(ticketService0, (Class<?>) TicketService.class, "user", (Object) user0);
      Injector.validateBean(ticketService0, (Class<?>) TicketService.class);
      Injector.inject(newTicketForm0, (Class<?>) NewTicketForm.class, "service", (Object) ticketService0);
      Injector.inject(newTicketForm0, (Class<?>) NewTicketForm.class, "user", (Object) user0);
      Injector.validateBean(newTicketForm0, (Class<?>) NewTicketForm.class);
      TicketService ticketService1 = newTicketForm0.getService();
      assertSame(ticketService1, ticketService0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      NewTicketForm newTicketForm0 = new NewTicketForm();
      TicketService ticketService0 = newTicketForm0.getService();
      assertNull(ticketService0);
  }
}
