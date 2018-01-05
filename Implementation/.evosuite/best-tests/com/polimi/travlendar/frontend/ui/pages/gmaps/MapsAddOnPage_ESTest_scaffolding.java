/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Fri Jan 05 22:25:22 GMT 2018
 */

package com.polimi.travlendar.frontend.ui.pages.gmaps;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

import static org.evosuite.shaded.org.mockito.Mockito.*;
@EvoSuiteClassExclude
public class MapsAddOnPage_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "com.polimi.travlendar.frontend.ui.pages.gmaps.MapsAddOnPage"; 
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
    try { initMocksToAvoidTimeoutsInTheTests(); } catch(ClassNotFoundException e) {} 
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
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(MapsAddOnPage_ESTest_scaffolding.class.getClassLoader() ,
      "com.vaadin.tapio.googlemaps.GoogleMap$1",
      "com.vaadin.tapio.googlemaps.GoogleMap$2",
      "com.vaadin.tapio.googlemaps.GoogleMap$3",
      "com.vaadin.tapio.googlemaps.GoogleMap",
      "com.vaadin.ui.Alignment",
      "com.vaadin.server.Sizeable$Unit",
      "com.vaadin.ui.HasComponents",
      "com.vaadin.shared.AbstractComponentState",
      "com.vaadin.tapio.googlemaps.GoogleMap$4",
      "com.vaadin.tapio.googlemaps.GoogleMap$5",
      "com.vaadin.tapio.googlemaps.GoogleMap$6",
      "com.vaadin.ui.Component$ErrorEvent",
      "com.vaadin.server.ErrorHandler",
      "elemental.json.JsonValue",
      "com.vaadin.tapio.googlemaps.client.rpcs.InfoWindowClosedRpc",
      "org.jsoup.nodes.Element",
      "com.vaadin.event.ShortcutAction",
      "com.vaadin.tapio.googlemaps.client.overlays.GoogleMapInfoWindow",
      "com.vaadin.event.ContextClickEvent$ContextClickNotifier",
      "com.vaadin.server.VaadinResponse",
      "com.vaadin.shared.ui.AbstractLayoutState",
      "com.vaadin.event.LayoutEvents$LayoutClickNotifier",
      "com.vaadin.server.Extension",
      "com.vaadin.shared.ui.orderedlayout.AbstractOrderedLayoutState$ChildComponentData",
      "com.vaadin.shared.ui.LayoutClickRpc",
      "com.vaadin.server.ClientConnector$AttachEvent",
      "com.vaadin.ui.Layout$SpacingHandler",
      "com.vaadin.tapio.googlemaps.client.rpcs.MapMovedRpc",
      "com.vaadin.navigator.ViewBeforeLeaveEvent",
      "com.vaadin.navigator.View",
      "com.vaadin.ui.Component$Event",
      "com.vaadin.tapio.googlemaps.client.rpcs.MarkerDraggedRpc",
      "com.vaadin.ui.HasComponents$ComponentDetachListener",
      "com.vaadin.ui.VerticalLayout",
      "com.vaadin.server.ClientConnector$DetachEvent",
      "com.vaadin.ui.Layout$AlignmentHandler",
      "com.vaadin.event.ConnectorActionManager",
      "com.vaadin.util.ReflectTools",
      "com.vaadin.server.AbstractClientConnector",
      "com.vaadin.server.SizeWithUnit",
      "com.vaadin.server.Resource",
      "com.vaadin.spring.annotation.ViewScope",
      "com.polimi.travlendar.frontend.ui.pages.gmaps.MapsAddOnPage",
      "com.vaadin.server.VariableOwner",
      "com.vaadin.tapio.googlemaps.client.events.MarkerDragListener",
      "com.vaadin.ui.AbstractOrderedLayout",
      "com.vaadin.event.ActionManager",
      "com.vaadin.shared.ui.ContentMode",
      "com.vaadin.shared.communication.ServerRpc",
      "com.vaadin.event.ConnectorEventListener",
      "com.vaadin.ui.AbstractSingleComponentContainer",
      "com.vaadin.server.ServerRpcManager$RpcInvocationException",
      "com.vaadin.ui.SingleComponentContainer",
      "com.vaadin.ui.HasComponents$ComponentDetachEvent",
      "com.vaadin.ui.Layout",
      "com.vaadin.server.ClientConnector$AttachListener",
      "com.vaadin.tapio.googlemaps.client.events.MapClickListener",
      "com.vaadin.event.LayoutEvents$LayoutClickListener",
      "elemental.json.JsonObject",
      "com.vaadin.tapio.googlemaps.client.events.InfoWindowClosedListener",
      "com.vaadin.event.Action$Notifier",
      "com.vaadin.ui.AbstractComponentContainer",
      "com.vaadin.event.Action$Container",
      "com.vaadin.tapio.googlemaps.client.overlays.GoogleMapPolygon",
      "com.vaadin.event.Action$Listener",
      "com.vaadin.ui.UI",
      "com.vaadin.ui.ComponentContainer",
      "com.vaadin.event.ConnectorEvent",
      "com.vaadin.server.VaadinRequest",
      "com.vaadin.shared.ui.csslayout.CssLayoutServerRpc",
      "com.github.appreciated.app.layout.annotations.MenuIcon",
      "com.vaadin.event.MethodEventSource",
      "com.vaadin.shared.ui.AlignmentInfo",
      "com.vaadin.event.Action$Handler",
      "com.vaadin.ui.declarative.DesignContext",
      "com.vaadin.event.ContextClickEvent",
      "com.vaadin.icons.VaadinIcons",
      "com.vaadin.tapio.googlemaps.client.LatLon",
      "com.vaadin.ui.HasComponents$ComponentAttachEvent",
      "com.vaadin.server.FontIcon",
      "com.vaadin.shared.Connector",
      "com.vaadin.ui.HasComponents$ComponentAttachDetachNotifier",
      "com.vaadin.shared.MouseEventDetails",
      "com.vaadin.event.Action",
      "com.vaadin.ui.Layout$MarginHandler",
      "com.vaadin.tapio.googlemaps.client.rpcs.MapTypeChangedRpc",
      "com.vaadin.tapio.googlemaps.GoogleMap$MapType",
      "com.vaadin.shared.ui.MarginInfo",
      "org.jsoup.nodes.Node",
      "com.vaadin.tapio.googlemaps.client.overlays.GoogleMapMarker",
      "com.vaadin.ui.AbstractComponent",
      "com.vaadin.shared.communication.ClientRpc",
      "com.vaadin.shared.ui.orderedlayout.AbstractOrderedLayoutState",
      "com.vaadin.server.ClientConnector$DetachListener",
      "com.vaadin.tapio.googlemaps.client.events.MapMoveListener",
      "org.jsoup.nodes.Attributes",
      "com.vaadin.ui.Component$Listener",
      "com.vaadin.ui.CssLayout",
      "com.vaadin.spring.annotation.SpringComponent",
      "com.vaadin.event.LayoutEvents$LayoutClickEvent",
      "com.vaadin.shared.Registration",
      "com.vaadin.shared.ui.orderedlayout.AbstractOrderedLayoutServerRpc",
      "com.vaadin.event.MouseEvents$ClickEvent",
      "com.vaadin.tapio.googlemaps.client.rpcs.MarkerClickedRpc",
      "com.vaadin.ui.Label",
      "com.vaadin.tapio.googlemaps.client.layers.GoogleMapKmlLayer",
      "com.vaadin.server.ClientConnector",
      "com.vaadin.shared.ui.AbstractComponentContainerState",
      "com.vaadin.tapio.googlemaps.client.overlays.GoogleMapPolyline",
      "com.vaadin.navigator.ViewChangeListener",
      "com.vaadin.spring.annotation.SpringView",
      "com.vaadin.tapio.googlemaps.client.events.MarkerClickListener",
      "com.github.appreciated.app.layout.annotations.MenuCaption",
      "com.vaadin.shared.communication.SharedState",
      "com.vaadin.navigator.ViewChangeListener$ViewChangeEvent",
      "com.vaadin.server.ServerRpcManager",
      "com.vaadin.ui.LegacyComponent",
      "com.vaadin.server.ErrorMessage",
      "com.vaadin.server.Sizeable",
      "com.vaadin.ui.HasComponents$ComponentAttachListener",
      "com.vaadin.shared.ui.label.LabelState",
      "com.vaadin.event.ContextClickEvent$ContextClickListener",
      "com.vaadin.navigator.Navigator",
      "com.vaadin.tapio.googlemaps.client.GoogleMapControl",
      "com.vaadin.server.VaadinSession",
      "com.vaadin.shared.ui.csslayout.CssLayoutState",
      "com.vaadin.event.UIEvents$PollNotifier",
      "com.vaadin.tapio.googlemaps.client.rpcs.MapClickedRpc",
      "com.vaadin.event.ShortcutListener",
      "com.vaadin.ui.Component$Focusable",
      "com.vaadin.shared.ui.orderedlayout.VerticalLayoutState",
      "com.vaadin.ui.AbstractLayout",
      "com.vaadin.tapio.googlemaps.client.GoogleMapState",
      "com.vaadin.event.SerializableEventListener",
      "com.vaadin.ui.Component"
    );
  } 
  private static void initMocksToAvoidTimeoutsInTheTests() throws ClassNotFoundException { 
    mock(Class.forName("com.vaadin.navigator.ViewChangeListener$ViewChangeEvent", false, MapsAddOnPage_ESTest_scaffolding.class.getClassLoader()));
  }

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(MapsAddOnPage_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "com.vaadin.server.AbstractClientConnector",
      "com.vaadin.util.ReflectTools",
      "com.vaadin.ui.AbstractComponent",
      "com.vaadin.ui.AbstractComponentContainer",
      "com.vaadin.ui.AbstractLayout",
      "com.vaadin.ui.Alignment",
      "com.vaadin.ui.AbstractOrderedLayout",
      "com.vaadin.ui.VerticalLayout",
      "com.polimi.travlendar.frontend.ui.pages.gmaps.MapsAddOnPage",
      "com.vaadin.icons.VaadinIcons",
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
      "com.vaadin.tapio.googlemaps.GoogleMap",
      "com.vaadin.tapio.googlemaps.GoogleMap$1",
      "com.vaadin.tapio.googlemaps.GoogleMap$2",
      "com.vaadin.tapio.googlemaps.GoogleMap$3",
      "com.vaadin.tapio.googlemaps.GoogleMap$4",
      "com.vaadin.tapio.googlemaps.GoogleMap$5",
      "com.vaadin.tapio.googlemaps.GoogleMap$6",
      "com.vaadin.ui.CssLayout",
      "com.vaadin.shared.ui.csslayout.CssLayoutState",
      "com.vaadin.tapio.googlemaps.client.GoogleMapState",
      "com.vaadin.tapio.googlemaps.client.LatLon",
      "com.vaadin.tapio.googlemaps.client.GoogleMapControl",
      "com.vaadin.tapio.googlemaps.client.overlays.GoogleMapMarker",
      "com.vaadin.ui.Label",
      "com.vaadin.shared.ui.label.LabelState",
      "com.vaadin.event.ConnectorEvent",
      "com.vaadin.ui.Component$Event",
      "com.vaadin.ui.HasComponents$ComponentAttachEvent",
      "com.vaadin.shared.ui.orderedlayout.AbstractOrderedLayoutState$ChildComponentData",
      "com.vaadin.shared.ui.AlignmentInfo",
      "com.vaadin.server.Sizeable",
      "com.vaadin.server.ComponentSizeValidator",
      "com.vaadin.event.Action",
      "com.vaadin.event.ShortcutAction",
      "com.vaadin.event.ShortcutListener",
      "com.vaadin.event.ActionManager",
      "com.vaadin.event.ConnectorActionManager",
      "com.vaadin.shared.ui.ComponentStateUtil",
      "com.vaadin.event.EventRouter",
      "com.vaadin.event.ListenerMethod",
      "com.vaadin.event.LayoutEvents$LayoutClickListener",
      "com.vaadin.ui.HasComponents$ComponentDetachListener",
      "com.vaadin.shared.communication.URLReference",
      "com.vaadin.server.ResourceReference",
      "com.vaadin.ui.HasComponents$ComponentAttachListener",
      "com.vaadin.shared.MouseEventDetails$MouseButton",
      "com.vaadin.event.MouseEvents$ClickEvent",
      "com.vaadin.event.ContextClickEvent",
      "com.vaadin.ui.Component$ErrorEvent",
      "org.jsoup.nodes.Node",
      "org.jsoup.nodes.Element",
      "org.jsoup.parser.Tag",
      "org.jsoup.nodes.Attributes",
      "org.jsoup.nodes.Entities",
      "org.jsoup.nodes.Entities$EscapeMode",
      "org.jsoup.nodes.TextNode",
      "com.vaadin.server.LegacyCommunicationManager",
      "org.jsoup.select.Elements",
      "org.jsoup.helper.StringUtil",
      "org.jsoup.nodes.Attribute",
      "com.vaadin.server.ClientConnector$AttachListener",
      "com.vaadin.navigator.ViewBeforeLeaveEvent",
      "org.jsoup.parser.Parser",
      "org.jsoup.parser.Tokeniser",
      "org.jsoup.parser.CharacterReader",
      "org.jsoup.parser.ParseErrorList",
      "org.jsoup.parser.TokeniserState$1",
      "org.jsoup.parser.TokeniserState$2",
      "org.jsoup.parser.TokeniserState$3",
      "org.jsoup.parser.TokeniserState$4",
      "org.jsoup.parser.TokeniserState$5",
      "org.jsoup.parser.TokeniserState$6",
      "org.jsoup.parser.TokeniserState$7",
      "org.jsoup.parser.TokeniserState$8",
      "org.jsoup.parser.TokeniserState$9",
      "org.jsoup.parser.TokeniserState$10",
      "org.jsoup.parser.TokeniserState$11",
      "org.jsoup.parser.TokeniserState$12",
      "org.jsoup.parser.TokeniserState$13",
      "org.jsoup.parser.TokeniserState$14",
      "org.jsoup.parser.TokeniserState$15",
      "org.jsoup.parser.TokeniserState$16",
      "org.jsoup.parser.TokeniserState$17",
      "org.jsoup.parser.TokeniserState$18",
      "org.jsoup.parser.TokeniserState$19",
      "org.jsoup.parser.TokeniserState$20",
      "org.jsoup.parser.TokeniserState$21",
      "org.jsoup.parser.TokeniserState$22",
      "org.jsoup.parser.TokeniserState$23",
      "org.jsoup.parser.TokeniserState$24",
      "org.jsoup.parser.TokeniserState$25",
      "org.jsoup.parser.TokeniserState$26",
      "org.jsoup.parser.TokeniserState$27",
      "org.jsoup.parser.TokeniserState$28",
      "org.jsoup.parser.TokeniserState$29",
      "org.jsoup.parser.TokeniserState$30",
      "org.jsoup.parser.TokeniserState$31",
      "org.jsoup.parser.TokeniserState$32",
      "org.jsoup.parser.TokeniserState$33",
      "org.jsoup.parser.TokeniserState$34",
      "org.jsoup.parser.TokeniserState$35",
      "org.jsoup.parser.TokeniserState$36",
      "org.jsoup.parser.TokeniserState$37",
      "org.jsoup.parser.TokeniserState$38",
      "org.jsoup.parser.TokeniserState$39",
      "org.jsoup.parser.TokeniserState$40",
      "org.jsoup.parser.TokeniserState$41",
      "org.jsoup.parser.TokeniserState$42",
      "org.jsoup.parser.TokeniserState$43",
      "org.jsoup.parser.TokeniserState$44",
      "org.jsoup.parser.TokeniserState$45",
      "org.jsoup.parser.TokeniserState$46",
      "org.jsoup.parser.TokeniserState$47",
      "org.jsoup.parser.TokeniserState$48",
      "org.jsoup.parser.TokeniserState$49",
      "org.jsoup.parser.TokeniserState$50",
      "org.jsoup.parser.TokeniserState$51",
      "org.jsoup.parser.TokeniserState$52",
      "org.jsoup.parser.TokeniserState$53",
      "org.jsoup.parser.TokeniserState$54",
      "org.jsoup.parser.TokeniserState$55",
      "org.jsoup.parser.TokeniserState$56",
      "org.jsoup.parser.TokeniserState$57",
      "org.jsoup.parser.TokeniserState$58",
      "org.jsoup.parser.TokeniserState$59",
      "org.jsoup.parser.TokeniserState$60",
      "org.jsoup.parser.TokeniserState$61",
      "org.jsoup.parser.TokeniserState$62",
      "org.jsoup.parser.TokeniserState$63",
      "org.jsoup.parser.TokeniserState$64",
      "org.jsoup.parser.TokeniserState$65",
      "org.jsoup.parser.TokeniserState$66",
      "org.jsoup.parser.TokeniserState$67",
      "org.jsoup.parser.TokeniserState",
      "org.jsoup.parser.Token$TokenType",
      "com.vaadin.ui.HasComponents$ComponentDetachEvent",
      "com.vaadin.server.ClientConnector$DetachEvent",
      "com.vaadin.ui.declarative.DesignContext",
      "com.vaadin.ui.declarative.DesignFormatter",
      "com.vaadin.ui.declarative.converters.DesignObjectConverter",
      "com.vaadin.ui.declarative.converters.DesignToStringConverter",
      "com.vaadin.ui.declarative.DesignFormatter$1",
      "com.vaadin.data.converter.AbstractStringToNumberConverter",
      "com.vaadin.data.converter.StringToFloatConverter",
      "com.vaadin.ui.declarative.DesignFormatter$2",
      "com.vaadin.data.converter.StringToDoubleConverter",
      "com.vaadin.ui.declarative.DesignFormatter$3",
      "com.vaadin.data.converter.StringToBigDecimalConverter",
      "com.vaadin.ui.declarative.DesignFormatter$4",
      "com.vaadin.ui.declarative.DesignFormatter$5",
      "com.vaadin.ui.declarative.DesignFormatter$6",
      "com.vaadin.ui.declarative.converters.DesignDateConverter",
      "com.vaadin.ui.declarative.converters.DesignLocalDateConverter",
      "com.vaadin.ui.declarative.converters.DesignLocalDateTimeConverter",
      "com.vaadin.ui.declarative.converters.DesignShortcutActionConverter",
      "com.vaadin.ui.declarative.DesignAttributeHandler",
      "com.vaadin.server.ClientConnector$DetachListener",
      "org.jsoup.parser.HtmlTreeBuilder",
      "org.jsoup.parser.HtmlTreeBuilderState$1",
      "org.jsoup.parser.HtmlTreeBuilderState$2",
      "org.jsoup.parser.HtmlTreeBuilderState$3",
      "org.jsoup.parser.HtmlTreeBuilderState$4",
      "org.jsoup.parser.HtmlTreeBuilderState$5",
      "org.jsoup.parser.HtmlTreeBuilderState$6",
      "org.jsoup.parser.HtmlTreeBuilderState$7",
      "org.jsoup.parser.HtmlTreeBuilderState$8",
      "org.jsoup.parser.HtmlTreeBuilderState$9",
      "org.jsoup.parser.HtmlTreeBuilderState$10",
      "org.jsoup.parser.HtmlTreeBuilderState$11",
      "org.jsoup.parser.HtmlTreeBuilderState$12",
      "org.jsoup.parser.HtmlTreeBuilderState$13",
      "org.jsoup.parser.HtmlTreeBuilderState$14",
      "org.jsoup.parser.HtmlTreeBuilderState$15",
      "org.jsoup.parser.HtmlTreeBuilderState$16",
      "org.jsoup.parser.HtmlTreeBuilderState$17",
      "org.jsoup.parser.HtmlTreeBuilderState$18",
      "org.jsoup.parser.HtmlTreeBuilderState$19",
      "org.jsoup.parser.HtmlTreeBuilderState$20",
      "org.jsoup.parser.HtmlTreeBuilderState$21",
      "org.jsoup.parser.HtmlTreeBuilderState$22",
      "org.jsoup.parser.HtmlTreeBuilderState$23",
      "org.jsoup.parser.HtmlTreeBuilderState",
      "org.jsoup.parser.HtmlTreeBuilderState$24",
      "com.vaadin.server.AbstractExtension",
      "com.vaadin.server.Responsive",
      "com.vaadin.server.Sizeable$Unit",
      "com.vaadin.shared.ui.ContentMode"
    );
  }
}
