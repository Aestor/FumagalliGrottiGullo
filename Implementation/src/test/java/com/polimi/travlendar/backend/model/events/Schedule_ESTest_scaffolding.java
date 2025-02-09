/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Fri Jan 05 22:29:49 GMT 2018
 */

package com.polimi.travlendar.backend.model.events;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class Schedule_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "com.polimi.travlendar.backend.model.events.Schedule"; 
    org.evosuite.runtime.GuiSupport.initialize(); 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
    org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED; 
    org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.init();
    setSystemProperties();
    initializeClasses();
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
  } 

  @AfterClass 
  public static void clearEvoSuiteFramework(){ 
    Sandbox.resetDefaultSecurityManager(); 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
  } 

  @Before 
  public void initTestCase(){ 
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler(); 
    org.evosuite.runtime.sandbox.Sandbox.goingToExecuteSUTCode(); 
    setSystemProperties(); 
    org.evosuite.runtime.GuiSupport.setHeadless(); 
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
  } 

  @After 
  public void doneWithTestCase(){ 
    threadStopper.killAndJoinClientThreads();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.reset(); 
    resetClasses(); 
    org.evosuite.runtime.sandbox.Sandbox.doneWithExecutingSUTCode(); 
    org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
    org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
  } 

  public static void setSystemProperties() {
 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
    java.lang.System.setProperty("file.encoding", "UTF-8"); 
    java.lang.System.setProperty("java.awt.headless", "true"); 
    java.lang.System.setProperty("user.country", "US"); 
    java.lang.System.setProperty("user.language", "en"); 
    java.lang.System.setProperty("user.timezone", "Europe/Rome"); 
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(Schedule_ESTest_scaffolding.class.getClassLoader() ,
      "com.vaadin.ui.CustomComponent",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$ItemResizeEvent",
      "com.vaadin.server.Responsive",
      "com.vaadin.server.Sizeable$Unit",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$WeekClick",
      "com.vaadin.ui.HasComponents",
      "com.vaadin.shared.AbstractComponentState",
      "com.vaadin.data.provider.DataKeyMapper",
      "com.vaadin.ui.Component$ErrorEvent",
      "com.vaadin.server.AbstractExtension",
      "com.vaadin.server.ErrorHandler",
      "elemental.json.JsonValue",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$ItemResizeNotifier",
      "org.vaadin.addon.calendar.ui.WeeklyCaptionProvider",
      "org.vaadin.addon.calendar.handler.BasicBackwardHandler",
      "org.vaadin.addon.calendar.client.CalendarServerRpc",
      "org.jsoup.nodes.Element",
      "org.vaadin.addon.calendar.item.CalendarItemProvider$ItemSetChangedEvent",
      "org.vaadin.addon.calendar.Calendar",
      "com.vaadin.ui.UIDetachedException",
      "com.vaadin.event.ShortcutAction",
      "com.vaadin.shared.extension.responsive.ResponsiveState",
      "com.vaadin.shared.ui.ui.UIServerRpc",
      "com.vaadin.event.ContextClickEvent$ContextClickNotifier",
      "com.vaadin.server.VaadinResponse",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$ItemMoveHandler",
      "com.vaadin.server.Extension",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$ItemMoveNotifier",
      "org.vaadin.addon.calendar.item.EditableCalendarItem$ItemChangeListener",
      "com.vaadin.server.ClientConnector$AttachEvent",
      "org.vaadin.addon.calendar.item.CalendarItemProvider$ItemSetChangedListener",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$ItemClickHandler",
      "org.vaadin.addon.calendar.item.BasicItemProvider",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$ItemClickEvent",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$BackwardHandler",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$WeekClickHandler",
      "com.polimi.travlendar.backend.model.events.Schedule$Edit",
      "com.vaadin.shared.ui.ComponentStateUtil",
      "com.vaadin.ui.Component$Event",
      "com.vaadin.event.FieldEvents$BlurNotifier",
      "com.vaadin.event.dd.DropTarget",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$NavigationNotifier",
      "com.polimi.travlendar.backend.model.events.Schedule$MeetingDataProvider",
      "com.vaadin.event.EventRouter",
      "com.vaadin.shared.ui.ui.UIState",
      "org.vaadin.addon.calendar.handler.BasicItemResizeHandler",
      "com.vaadin.server.ClientConnector$DetachEvent",
      "com.vaadin.ui.TooltipConfiguration",
      "com.vaadin.event.ConnectorActionManager",
      "com.vaadin.util.ReflectTools",
      "com.vaadin.server.AbstractClientConnector",
      "com.polimi.travlendar.backend.model.events.Meeting",
      "com.vaadin.server.Resource",
      "com.vaadin.shared.ui.AbstractSingleComponentContainerState",
      "com.vaadin.server.VariableOwner",
      "org.vaadin.addon.calendar.handler.BasicWeekClickHandler",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$DateClickHandler",
      "com.vaadin.event.ActionManager",
      "com.vaadin.shared.ui.ContentMode",
      "org.vaadin.addon.calendar.item.CalendarEditableItemProvider",
      "org.vaadin.addon.calendar.client.CalendarState$ItemSortOrder",
      "com.vaadin.shared.communication.ServerRpc",
      "com.vaadin.event.ConnectorEventListener",
      "com.vaadin.ui.AbstractSingleComponentContainer",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$ItemMoveEvent",
      "com.vaadin.ui.LoadingIndicatorConfiguration",
      "com.vaadin.server.ServerRpcManager$RpcInvocationException",
      "com.vaadin.ui.SingleComponentContainer",
      "com.vaadin.ui.HasComponents$ComponentDetachEvent",
      "com.vaadin.shared.customcomponent.CustomComponentState",
      "com.vaadin.server.ClientConnector$AttachListener",
      "elemental.json.JsonObject",
      "com.vaadin.event.Action$Notifier",
      "com.vaadin.event.Action$Container",
      "com.vaadin.event.FieldEvents$FocusNotifier",
      "org.vaadin.addon.calendar.Calendar$CalendarServerRpcImpl",
      "com.vaadin.ui.Panel",
      "com.polimi.travlendar.backend.model.user.User",
      "com.vaadin.event.Action$Listener",
      "com.vaadin.ui.UI",
      "com.vaadin.ui.Window",
      "com.vaadin.event.ConnectorEvent",
      "com.vaadin.shared.ui.ClickRpc",
      "com.vaadin.server.VaadinRequest",
      "com.vaadin.event.MethodEventSource",
      "org.vaadin.addon.calendar.item.BasicItem",
      "com.vaadin.event.Action$Handler",
      "com.vaadin.ui.NotificationConfiguration",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$DateClickEvent",
      "org.vaadin.addon.calendar.item.CalendarItem",
      "com.vaadin.ui.declarative.DesignContext",
      "com.vaadin.event.ContextClickEvent",
      "com.vaadin.ui.HasComponents$ComponentAttachEvent",
      "com.vaadin.shared.Connector",
      "com.vaadin.ui.HasComponents$ComponentAttachDetachNotifier",
      "com.polimi.travlendar.backend.model.events.MeetingItem",
      "com.vaadin.shared.MouseEventDetails",
      "com.vaadin.event.Action",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$ForwardEvent",
      "org.vaadin.addon.calendar.item.EditableCalendarItem",
      "com.vaadin.ui.UI$WindowOrderUpdateEvent",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$RangeSelectHandler",
      "com.vaadin.util.CurrentInstance",
      "org.jsoup.nodes.Node",
      "org.vaadin.addon.calendar.handler.BasicForwardHandler",
      "com.vaadin.shared.ui.WindowOrderRpc",
      "com.vaadin.ui.AbstractComponent",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$RangeSelectEvent",
      "com.vaadin.event.dd.DropHandler",
      "com.vaadin.event.ListenerMethod$MethodException",
      "org.vaadin.addon.calendar.item.CalendarItemProvider",
      "com.vaadin.shared.communication.ClientRpc",
      "org.vaadin.addon.calendar.Calendar$TimeFormat",
      "com.vaadin.server.ClientConnector$DetachListener",
      "org.jsoup.nodes.Attributes",
      "com.vaadin.ui.Component$Listener",
      "org.vaadin.addon.calendar.handler.BasicDateClickHandler",
      "com.vaadin.shared.ui.ui.DebugWindowServerRpc",
      "com.vaadin.server.Scrollable",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvent",
      "com.polimi.travlendar.backend.beans.EventService",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$ForwardHandler",
      "com.vaadin.shared.Registration",
      "com.vaadin.event.ListenerMethod",
      "com.vaadin.event.MouseEvents$ClickEvent",
      "com.vaadin.ui.ReconnectDialogConfiguration",
      "com.vaadin.server.ClientConnector",
      "com.vaadin.server.KeyMapper",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$RangeSelectNotifier",
      "com.vaadin.ui.PushConfiguration",
      "org.vaadin.addon.calendar.handler.BasicItemMoveHandler",
      "com.vaadin.ui.declarative.DesignException",
      "com.vaadin.shared.communication.SharedState",
      "org.vaadin.addon.calendar.item.CalendarItemProvider$ItemSetChangedNotifier",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$BackwardEvent",
      "com.vaadin.server.ServerRpcManager",
      "com.vaadin.ui.LegacyComponent",
      "com.vaadin.event.dd.TargetDetails",
      "com.vaadin.server.ErrorMessage",
      "com.vaadin.server.Sizeable",
      "com.vaadin.event.ContextClickEvent$ContextClickListener",
      "com.vaadin.server.VaadinSession",
      "com.polimi.travlendar.backend.model.events.Schedule",
      "com.vaadin.event.UIEvents$PollNotifier",
      "com.vaadin.event.ShortcutListener",
      "com.vaadin.ui.Component$Focusable",
      "org.vaadin.addon.calendar.client.CalendarState",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$EventResizeHandler",
      "com.vaadin.event.SerializableEventListener",
      "com.vaadin.ui.Component"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(Schedule_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "com.vaadin.server.AbstractClientConnector",
      "com.vaadin.util.ReflectTools",
      "com.vaadin.ui.AbstractComponent",
      "com.vaadin.ui.CustomComponent",
      "com.polimi.travlendar.backend.model.events.Schedule",
      "org.vaadin.addon.calendar.item.BasicItemProvider",
      "com.polimi.travlendar.backend.model.events.Schedule$MeetingDataProvider",
      "com.vaadin.ui.AbstractSingleComponentContainer",
      "com.vaadin.ui.Panel",
      "com.vaadin.ui.Window",
      "com.polimi.travlendar.backend.model.events.Schedule$Edit",
      "org.springframework.context.annotation.ScopedProxyMode",
      "com.vaadin.server.Sizeable$Unit",
      "com.vaadin.util.CurrentInstance",
      "com.vaadin.shared.ui.ContentMode",
      "com.vaadin.shared.communication.SharedState",
      "com.vaadin.shared.AbstractComponentState",
      "com.vaadin.shared.customcomponent.CustomComponentState",
      "org.vaadin.addon.calendar.Calendar",
      "org.vaadin.addon.calendar.Calendar$CalendarServerRpcImpl",
      "com.vaadin.server.ServerRpcManager",
      "org.vaadin.addon.calendar.client.CalendarState",
      "org.vaadin.addon.calendar.client.CalendarState$ItemSortOrder",
      "org.vaadin.addon.calendar.handler.BasicBackwardHandler",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$BackwardHandler",
      "com.vaadin.event.EventRouter",
      "com.vaadin.event.ListenerMethod",
      "com.vaadin.shared.ui.ComponentStateUtil",
      "org.vaadin.addon.calendar.handler.BasicForwardHandler",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$ForwardHandler",
      "org.vaadin.addon.calendar.handler.BasicWeekClickHandler",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$WeekClickHandler",
      "org.vaadin.addon.calendar.handler.BasicDateClickHandler",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$DateClickHandler",
      "org.vaadin.addon.calendar.handler.BasicItemMoveHandler",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$ItemMoveHandler",
      "org.vaadin.addon.calendar.handler.BasicItemResizeHandler",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$EventResizeHandler",
      "com.vaadin.server.AbstractExtension",
      "com.vaadin.server.Responsive",
      "org.vaadin.addon.calendar.ui.CalendarComponentEvents$ItemClickHandler",
      "com.vaadin.ui.UI",
      "com.vaadin.ui.declarative.DesignContext",
      "com.vaadin.server.ClientConnector$AttachListener",
      "com.vaadin.ui.AbstractComponentContainer",
      "com.vaadin.ui.TabSheet",
      "com.vaadin.server.KeyMapper",
      "com.vaadin.ui.TabSheet$TabsheetServerRpcImpl",
      "com.vaadin.event.FieldEvents$FocusAndBlurServerRpcImpl",
      "com.vaadin.event.FieldEvents$FocusAndBlurServerRpcDecorator",
      "com.vaadin.server.Sizeable",
      "org.jsoup.nodes.Node",
      "org.jsoup.nodes.Element",
      "org.jsoup.parser.Tag",
      "org.jsoup.nodes.Attributes",
      "org.jsoup.nodes.Entities",
      "org.jsoup.nodes.Entities$EscapeMode",
      "org.jsoup.nodes.Document$OutputSettings$Syntax",
      "org.jsoup.helper.StringUtil",
      "org.jsoup.nodes.Attribute",
      "org.jsoup.nodes.TextNode",
      "com.vaadin.server.VaadinServletRequest",
      "com.vaadin.server.AbstractErrorMessage",
      "com.vaadin.server.UserError"
    );
  }
}
