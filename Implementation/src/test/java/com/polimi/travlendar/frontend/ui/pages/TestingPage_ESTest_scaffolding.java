/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Thu Jan 04 11:19:25 GMT 2018
 */

package com.polimi.travlendar.frontend.ui.pages;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class TestingPage_ESTest_scaffolding {

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);

  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "com.polimi.travlendar.frontend.ui.pages.TestingPage"; 
    org.evosuite.runtime.GuiSupport.initialize(); 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
    org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED; 
    org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.init(); 
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

  public void setSystemProperties() {
 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
    java.lang.System.setProperty("java.vm.vendor", "Oracle Corporation"); 
    java.lang.System.setProperty("java.specification.version", "1.8"); 
            java.lang.System.setProperty("java.home", "/usr/lib/jvm/java-8-oracle/jre"); 
    java.lang.System.setProperty("java.awt.headless", "true"); 
    java.lang.System.setProperty("user.home", "/home/jaycaves"); 
                                        java.lang.System.setProperty("user.dir", "/home/jaycaves/Desktop/FumagalliGrottiGullo/Implementation"); 
    java.lang.System.setProperty("java.io.tmpdir", "/tmp"); 
    java.lang.System.setProperty("awt.toolkit", "sun.awt.X11.XToolkit"); 
    java.lang.System.setProperty("file.encoding", "UTF-8"); 
    java.lang.System.setProperty("file.separator", "/"); 
        java.lang.System.setProperty("java.awt.graphicsenv", "sun.awt.X11GraphicsEnvironment"); 
    java.lang.System.setProperty("java.awt.printerjob", "sun.print.PSPrinterJob"); 
    java.lang.System.setProperty("java.class.path", "/tmp/EvoSuite_pathingJar4675856095114984597.jar"); 
    java.lang.System.setProperty("java.class.version", "52.0"); 
        java.lang.System.setProperty("java.endorsed.dirs", "/usr/lib/jvm/java-8-oracle/jre/lib/endorsed"); 
    java.lang.System.setProperty("java.ext.dirs", "/usr/lib/jvm/java-8-oracle/jre/lib/ext:/usr/java/packages/lib/ext"); 
    java.lang.System.setProperty("java.library.path", "lib"); 
    java.lang.System.setProperty("java.runtime.name", "Java(TM) SE Runtime Environment"); 
    java.lang.System.setProperty("java.runtime.version", "1.8.0_131-b11"); 
    java.lang.System.setProperty("java.specification.name", "Java Platform API Specification"); 
    java.lang.System.setProperty("java.specification.vendor", "Oracle Corporation"); 
        java.lang.System.setProperty("java.vendor", "Oracle Corporation"); 
    java.lang.System.setProperty("java.vendor.url", "http://java.oracle.com/"); 
    java.lang.System.setProperty("java.version", "1.8.0_131"); 
    java.lang.System.setProperty("java.vm.info", "mixed mode"); 
    java.lang.System.setProperty("java.vm.name", "Java HotSpot(TM) 64-Bit Server VM"); 
    java.lang.System.setProperty("java.vm.specification.name", "Java Virtual Machine Specification"); 
    java.lang.System.setProperty("java.vm.specification.vendor", "Oracle Corporation"); 
    java.lang.System.setProperty("java.vm.specification.version", "1.8"); 
    java.lang.System.setProperty("java.vm.version", "25.131-b11"); 
    java.lang.System.setProperty("line.separator", "\n"); 
    java.lang.System.setProperty("os.arch", "amd64"); 
    java.lang.System.setProperty("os.name", "Linux"); 
    java.lang.System.setProperty("os.version", "4.10.0-42-generic"); 
    java.lang.System.setProperty("path.separator", ":"); 
    java.lang.System.setProperty("user.country", "US"); 
    java.lang.System.setProperty("user.language", "en"); 
    java.lang.System.setProperty("user.name", "jaycaves"); 
    java.lang.System.setProperty("user.timezone", "Europe/Rome"); 
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(TestingPage_ESTest_scaffolding.class.getClassLoader() ,
      "com.vaadin.server.UIProvider",
      "com.vaadin.event.Transferable",
      "com.vaadin.shared.communication.FieldRpc$FocusServerRpc",
      "com.vaadin.server.ServerRpcMethodInvocation",
      "com.vaadin.server.Responsive",
      "com.vaadin.shared.ui.button.ButtonServerRpc",
      "com.vaadin.ui.Alignment",
      "com.vaadin.server.Sizeable$Unit",
      "com.vaadin.server.WidgetsetInfo",
      "com.vaadin.ui.HasComponents",
      "com.vaadin.shared.AbstractComponentState",
      "com.vaadin.ui.Button$ClickEvent",
      "com.vaadin.data.provider.DataKeyMapper",
      "com.vaadin.ui.Component$ErrorEvent",
      "com.vaadin.server.ErrorHandler",
      "com.vaadin.server.AbstractExtension",
      "com.vaadin.event.FieldEvents$BlurListener",
      "com.vaadin.shared.ui.TabIndexState",
      "elemental.json.JsonValue",
      "com.vaadin.data.HasValue",
      "org.jsoup.nodes.Element",
      "com.vaadin.event.ShortcutAction",
      "com.vaadin.shared.extension.responsive.ResponsiveState",
      "com.vaadin.ui.Button$ClickShortcut",
      "com.vaadin.event.ContextClickEvent$ContextClickNotifier",
      "com.vaadin.server.VaadinResponse",
      "com.vaadin.shared.ui.AbstractLayoutState",
      "com.vaadin.event.LayoutEvents$LayoutClickNotifier",
      "com.vaadin.server.ComponentSizeValidator",
      "com.vaadin.server.Extension",
      "com.vaadin.shared.ui.orderedlayout.AbstractOrderedLayoutState$ChildComponentData",
      "com.vaadin.event.FieldEvents$FocusListener",
      "com.vaadin.shared.ui.LayoutClickRpc",
      "com.vaadin.event.MouseEvents$ClickListener",
      "com.vaadin.server.ClientConnector$AttachEvent",
      "com.vaadin.ui.Layout$SpacingHandler",
      "com.vaadin.ui.AbstractTextField",
      "com.polimi.travlendar.frontend.ui.pages.TestingPage",
      "com.vaadin.navigator.ViewBeforeLeaveEvent",
      "com.vaadin.navigator.View",
      "com.vaadin.shared.communication.MethodInvocation",
      "com.vaadin.shared.ui.ComponentStateUtil",
      "com.vaadin.ui.Component$Event",
      "com.vaadin.ui.HasComponents$ComponentDetachListener",
      "com.vaadin.event.FieldEvents$BlurNotifier",
      "com.vaadin.ui.VerticalLayout",
      "com.vaadin.server.WrappedSession",
      "com.vaadin.event.EventRouter",
      "com.vaadin.server.ClientConnector$DetachEvent",
      "org.springframework.context.annotation.Scope",
      "com.vaadin.server.DragAndDropService",
      "com.vaadin.ui.Layout$AlignmentHandler",
      "com.vaadin.event.ConnectorActionManager",
      "com.vaadin.util.ReflectTools",
      "com.vaadin.server.AbstractClientConnector",
      "com.vaadin.server.SizeWithUnit",
      "com.vaadin.server.Resource",
      "com.vaadin.spring.annotation.ViewScope",
      "com.vaadin.event.MouseEvents",
      "com.vaadin.shared.ui.AbstractSingleComponentContainerState",
      "com.vaadin.shared.communication.FieldRpc$BlurServerRpc",
      "com.vaadin.server.StreamVariable",
      "com.vaadin.shared.communication.URLReference",
      "com.vaadin.server.VariableOwner",
      "com.vaadin.ui.AbstractOrderedLayout",
      "com.vaadin.event.ActionManager",
      "com.vaadin.ui.Button$1",
      "com.vaadin.server.GlobalResourceHandler",
      "com.vaadin.shared.communication.FieldRpc$FocusAndBlurServerRpc",
      "com.vaadin.shared.ui.ContentMode",
      "com.vaadin.navigator.ViewDisplay",
      "com.vaadin.shared.communication.ServerRpc",
      "com.vaadin.event.FieldEvents$FocusAndBlurServerRpcDecorator",
      "com.vaadin.event.ConnectorEventListener",
      "com.vaadin.ui.AbstractSingleComponentContainer",
      "com.vaadin.server.ServerRpcManager$RpcInvocationException",
      "com.vaadin.ui.SingleComponentContainer",
      "com.vaadin.ui.HasComponents$ComponentDetachEvent",
      "com.vaadin.ui.HasValueChangeMode",
      "com.vaadin.ui.Button",
      "com.vaadin.ui.Layout",
      "com.vaadin.server.ClientConnector$AttachListener",
      "com.vaadin.event.LayoutEvents$LayoutClickListener",
      "elemental.json.JsonObject",
      "com.vaadin.event.Action$Notifier",
      "com.vaadin.ui.AbstractComponentContainer",
      "com.vaadin.event.Action$Container",
      "com.vaadin.event.FieldEvents$FocusNotifier",
      "com.vaadin.ui.Panel",
      "org.jsoup.select.NodeVisitor",
      "com.vaadin.ui.TextField",
      "com.vaadin.server.RequestHandler",
      "com.vaadin.event.Action$Listener",
      "com.vaadin.ui.UI",
      "com.vaadin.ui.Window",
      "com.vaadin.ui.ComponentContainer",
      "com.vaadin.event.ConnectorEvent",
      "com.vaadin.server.VaadinRequest",
      "com.github.appreciated.app.layout.annotations.MenuIcon",
      "com.vaadin.shared.ui.button.ButtonState",
      "com.vaadin.event.MethodEventSource",
      "com.vaadin.shared.ui.AlignmentInfo",
      "com.vaadin.event.Action$Handler",
      "com.vaadin.ui.declarative.DesignContext",
      "com.vaadin.event.ContextClickEvent",
      "com.vaadin.icons.VaadinIcons",
      "com.vaadin.event.MouseEvents$DoubleClickEvent",
      "com.vaadin.shared.MouseEventDetails$MouseButton",
      "com.vaadin.ui.HasComponents$ComponentAttachEvent",
      "com.vaadin.server.FontIcon",
      "com.vaadin.shared.Connector",
      "com.vaadin.ui.HasComponents$ComponentAttachDetachNotifier",
      "com.vaadin.shared.MouseEventDetails",
      "com.vaadin.server.SerializableConsumer",
      "com.vaadin.event.Action",
      "com.vaadin.ui.Layout$MarginHandler",
      "com.vaadin.event.FieldEvents$FocusEvent",
      "com.vaadin.util.CurrentInstance",
      "com.vaadin.server.PaintTarget",
      "com.vaadin.shared.ui.MarginInfo",
      "com.vaadin.event.FieldEvents$FocusAndBlurServerRpcImpl",
      "com.vaadin.server.BootstrapFragmentResponse",
      "org.jsoup.nodes.Node",
      "com.vaadin.ui.AbstractComponent",
      "com.vaadin.ui.AbstractField",
      "com.vaadin.server.BootstrapListener",
      "com.vaadin.event.ListenerMethod$MethodException",
      "com.vaadin.shared.communication.ClientRpc",
      "com.vaadin.server.BootstrapResponse",
      "com.vaadin.shared.ui.orderedlayout.AbstractOrderedLayoutState",
      "com.vaadin.navigator.ViewProvider",
      "com.vaadin.server.ClientConnector$DetachListener",
      "com.vaadin.ui.AbstractFocusable",
      "org.jsoup.nodes.Attributes",
      "com.vaadin.server.VaadinService",
      "com.vaadin.server.VaadinSession$State",
      "com.vaadin.server.LegacyCommunicationManager",
      "com.vaadin.server.DeploymentConfiguration",
      "com.vaadin.ui.Component$Listener",
      "com.vaadin.ui.Button$ClickListener",
      "com.vaadin.event.FieldEvents",
      "com.vaadin.server.Scrollable",
      "com.vaadin.server.WebBrowser",
      "com.vaadin.spring.annotation.SpringComponent",
      "com.vaadin.event.MouseEvents$DoubleClickListener",
      "com.vaadin.event.FieldEvents$BlurEvent",
      "com.vaadin.event.LayoutEvents$LayoutClickEvent",
      "com.vaadin.shared.Registration",
      "com.vaadin.shared.ui.orderedlayout.AbstractOrderedLayoutServerRpc",
      "com.vaadin.server.ClientConnector$ConnectorErrorEvent",
      "com.vaadin.event.ListenerMethod",
      "com.vaadin.event.MouseEvents$ClickEvent",
      "com.vaadin.ui.Label",
      "com.vaadin.server.ClientConnector",
      "com.vaadin.shared.ui.AbstractComponentContainerState",
      "com.vaadin.event.Action$ShortcutNotifier",
      "com.vaadin.navigator.ViewChangeListener",
      "com.vaadin.spring.annotation.SpringView",
      "com.github.appreciated.app.layout.annotations.MenuCaption",
      "com.vaadin.ui.declarative.DesignException",
      "com.vaadin.server.LegacyCommunicationManager$ClientCache",
      "com.vaadin.shared.communication.SharedState",
      "com.vaadin.navigator.ViewChangeListener$ViewChangeEvent",
      "com.vaadin.server.ServerRpcManager",
      "com.vaadin.server.ErrorEvent",
      "com.vaadin.navigator.NavigationStateManager",
      "org.springframework.context.annotation.ScopedProxyMode",
      "com.vaadin.ui.LegacyComponent",
      "com.vaadin.event.dd.TargetDetails",
      "com.vaadin.server.ErrorMessage",
      "com.vaadin.server.Sizeable",
      "com.vaadin.ui.HasComponents$ComponentAttachListener",
      "com.vaadin.shared.ui.label.LabelState",
      "com.vaadin.server.ComponentSizeValidator$InvalidLayout",
      "com.vaadin.event.ContextClickEvent$ContextClickListener",
      "com.vaadin.navigator.Navigator",
      "org.springframework.stereotype.Component",
      "com.vaadin.server.BootstrapPageResponse",
      "com.vaadin.server.VaadinSession",
      "com.vaadin.event.UIEvents$PollNotifier",
      "com.vaadin.event.ShortcutListener",
      "com.vaadin.ui.Component$Focusable",
      "com.vaadin.shared.ui.orderedlayout.VerticalLayoutState",
      "com.vaadin.ui.AbstractLayout",
      "com.vaadin.server.ResourceReference",
      "com.vaadin.event.SerializableEventListener",
      "com.vaadin.ui.Component"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(TestingPage_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "com.vaadin.icons.VaadinIcons",
      "com.vaadin.server.AbstractClientConnector",
      "com.vaadin.util.ReflectTools",
      "com.vaadin.ui.AbstractComponent",
      "com.vaadin.ui.AbstractComponentContainer",
      "com.vaadin.ui.AbstractLayout",
      "com.vaadin.ui.Alignment",
      "com.vaadin.ui.AbstractOrderedLayout",
      "com.vaadin.ui.VerticalLayout",
      "com.polimi.travlendar.frontend.ui.pages.TestingPage",
      "org.springframework.context.annotation.ScopedProxyMode",
      "com.vaadin.ui.Button$ClickListener",
      "com.vaadin.shared.ui.ContentMode",
      "com.vaadin.util.CurrentInstance",
      "com.vaadin.server.Sizeable$Unit",
      "com.vaadin.server.ServerRpcManager",
      "com.vaadin.server.SizeWithUnit",
      "com.vaadin.shared.communication.SharedState",
      "com.vaadin.shared.AbstractComponentState",
      "com.vaadin.shared.ui.AbstractComponentContainerState",
      "com.vaadin.shared.ui.AbstractLayoutState",
      "com.vaadin.shared.ui.orderedlayout.AbstractOrderedLayoutState",
      "com.vaadin.shared.ui.orderedlayout.VerticalLayoutState",
      "com.vaadin.shared.ui.MarginInfo",
      "com.vaadin.navigator.ViewChangeListener$ViewChangeEvent",
      "com.vaadin.server.Sizeable",
      "com.vaadin.event.ConnectorEvent",
      "com.vaadin.ui.Component$Event",
      "com.vaadin.ui.Button$ClickEvent",
      "com.vaadin.event.EventRouter",
      "com.vaadin.event.ListenerMethod",
      "com.vaadin.event.LayoutEvents$LayoutClickListener",
      "com.vaadin.ui.HasComponents$ComponentAttachListener",
      "com.vaadin.server.ClientConnector$DetachListener",
      "com.vaadin.ui.HasComponents$ComponentAttachEvent",
      "com.vaadin.shared.ui.orderedlayout.AbstractOrderedLayoutState$ChildComponentData",
      "com.vaadin.shared.ui.AlignmentInfo",
      "com.vaadin.server.AbstractExtension",
      "com.vaadin.server.Responsive",
      "com.vaadin.server.LegacyCommunicationManager",
      "com.vaadin.ui.HasComponents$ComponentDetachListener",
      "com.vaadin.server.ClientConnector$DetachEvent",
      "com.vaadin.ui.Component$ErrorEvent",
      "com.vaadin.server.ComponentSizeValidator",
      "com.vaadin.shared.ui.ComponentStateUtil",
      "com.vaadin.shared.communication.URLReference",
      "com.vaadin.server.ResourceReference",
      "com.vaadin.server.ClientConnector$AttachListener",
      "com.vaadin.ui.AbstractFocusable",
      "com.vaadin.ui.Button",
      "com.vaadin.event.FieldEvents$FocusAndBlurServerRpcImpl",
      "com.vaadin.event.FieldEvents$FocusAndBlurServerRpcDecorator",
      "com.vaadin.ui.Button$1",
      "com.vaadin.shared.ui.TabIndexState",
      "com.vaadin.shared.ui.button.ButtonState",
      "com.vaadin.ui.Label",
      "com.vaadin.shared.ui.label.LabelState",
      "com.vaadin.server.VaadinSession",
      "com.vaadin.shared.MouseEventDetails$MouseButton",
      "com.vaadin.event.MouseEvents$ClickEvent",
      "com.vaadin.event.ContextClickEvent"
    );
  }
}
