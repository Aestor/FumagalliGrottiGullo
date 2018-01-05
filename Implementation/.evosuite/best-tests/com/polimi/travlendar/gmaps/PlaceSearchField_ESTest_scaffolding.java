/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Fri Jan 05 21:57:46 GMT 2018
 */

package com.polimi.travlendar.gmaps;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class PlaceSearchField_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "com.polimi.travlendar.gmaps.PlaceSearchField"; 
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
    java.lang.System.setProperty("sun.jnu.encoding", "UTF-8"); 
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(PlaceSearchField_ESTest_scaffolding.class.getClassLoader() ,
      "com.google.maps.GeoApiContext$RequestHandler$Builder",
      "com.polimi.travlendar.gmaps.GoogleMapsService",
      "okhttp3.RequestBody$1",
      "com.vaadin.shared.ui.button.ButtonServerRpc",
      "com.google.maps.model.AutocompletePrediction$Term",
      "com.vaadin.shared.AbstractComponentState",
      "com.vaadin.ui.Button$ClickEvent",
      "com.google.maps.model.TravelMode",
      "com.vaadin.ui.Component$ErrorEvent",
      "com.vaadin.shared.ui.TabIndexState",
      "okhttp3.internal.platform.AndroidPlatform$AndroidCertificateChainCleaner",
      "okhttp3.OkHttpClient$1",
      "com.vaadin.data.HasValue",
      "com.vaadin.server.Page$PopStateListener",
      "okio.BufferedSink",
      "org.jsoup.nodes.Element",
      "com.vaadin.server.Page",
      "com.vaadin.ui.UIDetachedException",
      "com.vaadin.event.ShortcutAction",
      "okhttp3.MediaType",
      "okhttp3.CookieJar",
      "com.vaadin.shared.ui.ui.UIServerRpc",
      "com.vaadin.event.ContextClickEvent$ContextClickNotifier",
      "com.vaadin.server.VaadinResponse",
      "okhttp3.Request",
      "com.vaadin.shared.ui.AbstractLayoutState",
      "okhttp3.internal.http.HttpMethod",
      "com.google.maps.errors.ApiException",
      "com.vaadin.server.ComponentSizeValidator",
      "com.vaadin.shared.ui.orderedlayout.AbstractOrderedLayoutState$ChildComponentData",
      "com.vaadin.shared.ui.LayoutClickRpc",
      "com.vaadin.event.MouseEvents$ClickListener",
      "com.google.maps.OkHttpRequestHandler$Builder",
      "com.google.maps.internal.ratelimiter.RateLimiter",
      "okio.SegmentedByteString",
      "com.vaadin.server.ClientConnector$AttachEvent",
      "okio.BufferedSource",
      "com.google.maps.internal.ratelimiter.Platform",
      "com.vaadin.tapio.googlemaps.client.rpcs.MapMovedRpc",
      "okhttp3.RequestBody$2",
      "com.google.maps.model.LocationType",
      "okhttp3.RequestBody$3",
      "okhttp3.Call$Factory",
      "com.vaadin.shared.ui.tabsheet.TabsheetState",
      "com.vaadin.tapio.googlemaps.client.rpcs.MarkerDraggedRpc",
      "com.vaadin.event.FieldEvents$BlurNotifier",
      "com.vaadin.ui.HasComponents$ComponentDetachListener",
      "com.vaadin.ui.TabSheet$SelectedTabChangeEvent",
      "okio.Source",
      "okhttp3.CipherSuite$1",
      "com.vaadin.shared.ui.textfield.TextFieldState",
      "com.vaadin.ui.TabSheet$CloseHandler",
      "com.vaadin.shared.ui.ui.UIState",
      "okio.Sink",
      "com.vaadin.ui.TooltipConfiguration",
      "com.vaadin.ui.Layout$AlignmentHandler",
      "com.vaadin.event.ConnectorActionManager",
      "okhttp3.CookieJar$1",
      "com.vaadin.server.AbstractClientConnector",
      "com.google.maps.internal.ratelimiter.SmoothRateLimiter",
      "okhttp3.EventListener$1",
      "okhttp3.EventListener",
      "okhttp3.EventListener$2",
      "com.google.maps.model.AutocompletePrediction",
      "com.vaadin.shared.communication.URLReference",
      "okhttp3.Response$Builder",
      "com.vaadin.server.VariableOwner",
      "okhttp3.Call",
      "okhttp3.Callback",
      "okhttp3.Authenticator$1",
      "com.vaadin.ui.Button$1",
      "com.google.maps.internal.RateLimitExecutorService$1",
      "com.vaadin.shared.communication.ServerRpc",
      "com.google.maps.GeoApiContext",
      "okhttp3.internal.tls.TrustRootIndex$BasicTrustRootIndex",
      "com.vaadin.ui.AbstractSingleComponentContainer",
      "com.vaadin.ui.LoadingIndicatorConfiguration",
      "com.vaadin.server.ServerRpcManager$RpcInvocationException",
      "okhttp3.OkHttpClient",
      "okhttp3.ConnectionSpec$Builder",
      "com.vaadin.ui.HorizontalLayout",
      "com.vaadin.tapio.googlemaps.client.events.MapClickListener",
      "com.vaadin.event.LayoutEvents$LayoutClickListener",
      "okhttp3.internal.platform.JdkWithJettyBootPlatform",
      "okio.Buffer$2",
      "com.vaadin.data.HasValue$ValueChangeListener",
      "com.polimi.travlendar.gmaps.PlaceSearchFieldClient",
      "okio.Buffer$1",
      "com.vaadin.tapio.googlemaps.client.events.InfoWindowClosedListener",
      "com.vaadin.event.Action$Notifier",
      "com.vaadin.event.Action$Container",
      "com.vaadin.event.FieldEvents$FocusNotifier",
      "com.vaadin.ui.TextField",
      "okhttp3.Authenticator",
      "com.vaadin.event.Action$Listener",
      "com.vaadin.ui.UI",
      "okhttp3.CertificatePinner",
      "com.google.maps.internal.ratelimiter.Stopwatch",
      "com.vaadin.ui.Window",
      "com.polimi.travlendar.gmaps.SelectionListener",
      "com.vaadin.ui.ComponentContainer",
      "com.vaadin.event.ConnectorEvent",
      "com.google.maps.model.PlaceDetails$Review$AspectRating$RatingType",
      "com.vaadin.server.VaadinRequest",
      "com.vaadin.shared.ui.button.ButtonState",
      "com.vaadin.event.MethodEventSource",
      "com.vaadin.shared.ui.AlignmentInfo",
      "com.vaadin.event.Action$Handler",
      "okhttp3.CipherSuite",
      "okhttp3.internal.Util",
      "com.vaadin.icons.VaadinIcons",
      "com.vaadin.ui.HasComponents$ComponentAttachEvent",
      "com.vaadin.server.FontIcon",
      "com.vaadin.ui.HasComponents$ComponentAttachDetachNotifier",
      "com.vaadin.ui.TabSheet$Tab",
      "com.google.maps.internal.RateLimitExecutorService",
      "com.vaadin.shared.MouseEventDetails",
      "okhttp3.Interceptor",
      "com.vaadin.data.ValueProvider",
      "com.vaadin.ui.Layout$MarginHandler",
      "com.vaadin.tapio.googlemaps.client.rpcs.MapTypeChangedRpc",
      "com.vaadin.shared.Position",
      "com.vaadin.ui.UI$WindowOrderUpdateEvent",
      "com.vaadin.server.Page$UriFragmentChangedListener",
      "com.vaadin.tapio.googlemaps.GoogleMap$MapType",
      "okhttp3.ConnectionPool$1",
      "okhttp3.WebSocket",
      "com.vaadin.server.AbstractErrorMessage",
      "com.google.maps.internal.ratelimiter.SmoothRateLimiter$SmoothWarmingUp",
      "com.vaadin.shared.ui.MarginInfo",
      "com.vaadin.event.FieldEvents$FocusAndBlurServerRpcImpl",
      "com.vaadin.server.Page$UriFragmentChangedEvent",
      "okhttp3.CertificatePinner$Builder",
      "org.jsoup.nodes.Node",
      "com.vaadin.tapio.googlemaps.client.overlays.GoogleMapMarker",
      "com.vaadin.shared.ui.WindowOrderRpc",
      "com.google.maps.PendingResult$Callback",
      "okhttp3.EventListener$Factory",
      "com.vaadin.ui.TabSheet",
      "okhttp3.HttpUrl$Builder",
      "com.vaadin.shared.ui.orderedlayout.AbstractOrderedLayoutState",
      "okhttp3.OkHttpClient$Builder",
      "okhttp3.internal.platform.Platform",
      "org.jsoup.nodes.Attributes",
      "com.vaadin.shared.ui.ValueChangeMode",
      "okhttp3.internal.connection.RouteDatabase",
      "com.vaadin.shared.ui.ui.DebugWindowServerRpc",
      "com.vaadin.ui.CssLayout",
      "okhttp3.Headers",
      "com.vaadin.server.Scrollable",
      "okhttp3.RequestBody",
      "com.vaadin.ui.Notification$1",
      "com.vaadin.ui.Notification$Type",
      "com.google.gson.FieldNamingPolicy",
      "com.google.maps.errors.OverQueryLimitException",
      "com.vaadin.shared.Registration",
      "com.google.maps.internal.ratelimiter.SmoothRateLimiter$SmoothBursty",
      "com.vaadin.event.ListenerMethod",
      "com.vaadin.ui.Label",
      "com.vaadin.ui.ReconnectDialogConfiguration",
      "com.vaadin.tapio.googlemaps.client.layers.GoogleMapKmlLayer",
      "com.vaadin.shared.ui.AbstractComponentContainerState",
      "com.vaadin.event.Action$ShortcutNotifier",
      "com.vaadin.ui.PushConfiguration",
      "com.polimi.travlendar.gmaps.AutocompleteClient",
      "okio.Buffer",
      "com.vaadin.tapio.googlemaps.client.events.MarkerClickListener",
      "com.vaadin.ui.declarative.DesignException",
      "okhttp3.Dns$1",
      "com.vaadin.server.PaintException",
      "okhttp3.internal.Util$1",
      "com.google.gson.JsonSyntaxException",
      "com.vaadin.server.ServerRpcManager",
      "okhttp3.internal.Util$2",
      "com.vaadin.server.ErrorMessage",
      "com.vaadin.server.Sizeable",
      "okhttp3.Dns",
      "com.vaadin.shared.ui.label.LabelState",
      "com.vaadin.event.ContextClickEvent$ContextClickListener",
      "okhttp3.internal.platform.Jdk9Platform",
      "com.vaadin.event.UIEvents$PollNotifier",
      "com.vaadin.tapio.googlemaps.client.rpcs.MapClickedRpc",
      "com.vaadin.event.ShortcutListener",
      "com.vaadin.ui.Component$Focusable",
      "com.vaadin.shared.ui.orderedlayout.VerticalLayoutState",
      "com.vaadin.ui.AbstractLayout",
      "com.vaadin.tapio.googlemaps.client.GoogleMapState",
      "com.vaadin.server.ErrorMessage$ErrorLevel",
      "com.google.maps.model.AutocompleteStructuredFormatting",
      "com.google.maps.internal.ratelimiter.RateLimiter$SleepingStopwatch",
      "com.vaadin.tapio.googlemaps.GoogleMap$1",
      "com.vaadin.shared.communication.FieldRpc$FocusServerRpc",
      "com.vaadin.tapio.googlemaps.GoogleMap$2",
      "com.vaadin.tapio.googlemaps.GoogleMap$3",
      "okhttp3.Request$Builder",
      "com.vaadin.tapio.googlemaps.GoogleMap",
      "com.polimi.travlendar.gmaps.PlaceSearchField",
      "com.vaadin.ui.Alignment",
      "com.vaadin.server.Sizeable$Unit",
      "com.vaadin.ui.HasComponents",
      "com.vaadin.tapio.googlemaps.GoogleMap$4",
      "com.vaadin.tapio.googlemaps.GoogleMap$5",
      "com.vaadin.data.provider.DataKeyMapper",
      "com.vaadin.tapio.googlemaps.GoogleMap$6",
      "com.vaadin.server.ErrorHandler",
      "okhttp3.Dispatcher",
      "okhttp3.Address",
      "com.vaadin.event.FieldEvents$BlurListener",
      "okhttp3.Route",
      "elemental.json.JsonValue",
      "com.vaadin.tapio.googlemaps.client.rpcs.InfoWindowClosedRpc",
      "com.google.gson.FieldNamingStrategy",
      "okhttp3.internal.tls.TrustRootIndex$AndroidTrustRootIndex",
      "okhttp3.Headers$Builder",
      "com.vaadin.server.Page$BrowserWindowResizeListener",
      "okhttp3.ResponseBody",
      "com.vaadin.tapio.googlemaps.client.overlays.GoogleMapInfoWindow",
      "com.google.maps.model.DirectionsResult",
      "com.vaadin.ui.Button$ClickShortcut",
      "okhttp3.internal.tls.CertificateChainCleaner",
      "com.google.maps.model.AddressComponentType",
      "com.vaadin.event.LayoutEvents$LayoutClickNotifier",
      "com.vaadin.ui.TabSheet$SelectedTabChangeListener",
      "com.google.maps.OkHttpRequestHandler",
      "com.vaadin.server.Extension",
      "com.vaadin.event.FieldEvents$FocusListener",
      "com.vaadin.shared.ui.panel.PanelState",
      "okhttp3.Connection",
      "com.vaadin.ui.Layout$SpacingHandler",
      "com.vaadin.ui.AbstractTextField",
      "com.vaadin.server.AbstractErrorMessage$ContentMode",
      "com.polimi.travlendar.gmaps.VaadinMap",
      "com.vaadin.shared.ui.textfield.AbstractTextFieldState",
      "okhttp3.internal.cache.InternalCache",
      "com.google.maps.internal.ApiResponse",
      "com.google.maps.internal.OkHttpPendingResult",
      "com.vaadin.ui.Component$Event",
      "com.vaadin.ui.VerticalLayout",
      "okhttp3.internal.tls.BasicCertificateChainCleaner",
      "okhttp3.internal.http.RetryAndFollowUpInterceptor",
      "com.vaadin.event.EventRouter",
      "com.vaadin.server.ClientConnector$DetachEvent",
      "com.vaadin.util.ReflectTools",
      "com.vaadin.server.SizeWithUnit",
      "com.vaadin.server.Resource",
      "com.vaadin.shared.ui.AbstractSingleComponentContainerState",
      "okhttp3.internal.Internal",
      "com.google.maps.internal.ratelimiter.Ticker$1",
      "com.polimi.travlendar.gmaps.LocationForm",
      "com.vaadin.shared.communication.FieldRpc$BlurServerRpc",
      "com.google.maps.PendingResult",
      "com.vaadin.tapio.googlemaps.client.events.MarkerDragListener",
      "com.vaadin.ui.AbstractOrderedLayout",
      "com.vaadin.event.ActionManager",
      "com.vaadin.server.Page$BrowserWindowResizeEvent",
      "com.vaadin.shared.communication.FieldRpc$FocusAndBlurServerRpc",
      "com.vaadin.shared.ui.ContentMode",
      "com.google.maps.internal.OkHttpPendingResult$1",
      "com.vaadin.event.FieldEvents$FocusAndBlurServerRpcDecorator",
      "com.vaadin.event.ConnectorEventListener",
      "okhttp3.ResponseBody$1",
      "com.vaadin.ui.SingleComponentContainer",
      "com.vaadin.ui.HasComponents$ComponentDetachEvent",
      "com.vaadin.data.HasValue$ValueChangeEvent",
      "com.vaadin.ui.HasValueChangeMode",
      "com.vaadin.ui.Button",
      "com.vaadin.ui.Layout",
      "com.vaadin.server.ClientConnector$AttachListener",
      "okhttp3.internal.connection.RouteException",
      "okhttp3.ConnectionPool",
      "com.google.maps.model.AddressType",
      "okhttp3.internal.NamedRunnable",
      "elemental.json.JsonObject",
      "okhttp3.HttpUrl$Builder$ParseResult",
      "com.vaadin.ui.AbstractComponentContainer",
      "com.google.maps.model.PlacesSearchResult",
      "com.vaadin.ui.Panel",
      "okhttp3.WebSocket$Factory",
      "com.vaadin.tapio.googlemaps.client.overlays.GoogleMapPolygon",
      "com.vaadin.shared.AbstractFieldState",
      "com.vaadin.ui.AbstractTextField$AbstractTextFieldFocusAndBlurRpcImpl",
      "com.google.maps.internal.ratelimiter.Preconditions",
      "com.vaadin.shared.ui.ClickRpc",
      "com.vaadin.shared.ui.csslayout.CssLayoutServerRpc",
      "okhttp3.RealCall",
      "com.vaadin.ui.NotificationConfiguration",
      "okhttp3.internal.connection.StreamAllocation",
      "com.google.maps.internal.ExceptionsAllowedToRetry",
      "com.google.maps.internal.ratelimiter.Ticker",
      "com.vaadin.ui.declarative.DesignContext",
      "com.vaadin.event.ContextClickEvent",
      "okhttp3.ConnectionSpec",
      "com.vaadin.tapio.googlemaps.client.LatLon",
      "com.vaadin.shared.Connector",
      "okhttp3.internal.platform.AndroidPlatform",
      "com.vaadin.shared.ui.orderedlayout.HorizontalLayoutState",
      "com.vaadin.server.SerializableConsumer",
      "com.polimi.travlendar.gmaps.DynamicList",
      "com.vaadin.event.Action",
      "okhttp3.internal.http2.Http2Connection$Listener",
      "com.vaadin.event.FieldEvents$FocusEvent",
      "com.google.maps.GeoApiContext$Builder",
      "com.vaadin.shared.ui.textfield.AbstractTextFieldServerRpc",
      "com.google.maps.GeoApiContext$RequestHandler",
      "com.vaadin.server.PaintTarget",
      "com.vaadin.util.CurrentInstance",
      "com.vaadin.ui.TabSheet$TabsheetServerRpcImpl",
      "com.vaadin.ui.AbstractComponent",
      "com.vaadin.ui.AbstractField",
      "com.google.maps.TextSearchRequest",
      "com.vaadin.event.ListenerMethod$MethodException",
      "com.google.maps.model.LatLng",
      "com.vaadin.shared.communication.ClientRpc",
      "com.vaadin.server.UserError",
      "okhttp3.Protocol",
      "com.vaadin.shared.ui.panel.PanelServerRpc",
      "com.vaadin.ui.AbstractTextField$AbstractTextFieldServerRpcImpl",
      "okhttp3.HttpUrl",
      "okhttp3.internal.connection.RealConnection",
      "com.vaadin.server.ClientConnector$DetachListener",
      "com.vaadin.tapio.googlemaps.client.events.MapMoveListener",
      "com.vaadin.server.SerializableFunction",
      "com.vaadin.ui.AbstractFocusable",
      "com.polimi.travlendar.gmaps.PredictionCaptionGenerator",
      "com.google.gson.JsonParseException",
      "okhttp3.ResponseBody$BomAwareReader",
      "com.vaadin.ui.Component$Listener",
      "com.vaadin.ui.Button$ClickListener",
      "com.vaadin.event.HasUserOriginated",
      "com.polimi.travlendar.gmaps.ResultNotFoundException",
      "com.vaadin.event.FieldEvents$BlurEvent",
      "com.vaadin.event.LayoutEvents$LayoutClickEvent",
      "com.google.maps.TextSearchRequest$Response",
      "com.vaadin.shared.ui.orderedlayout.AbstractOrderedLayoutServerRpc",
      "com.vaadin.ui.Notification",
      "com.vaadin.event.MouseEvents$ClickEvent",
      "okio.ByteString",
      "com.google.maps.internal.StringJoin$UrlValue",
      "com.vaadin.tapio.googlemaps.client.rpcs.MarkerClickedRpc",
      "com.google.maps.internal.ratelimiter.RateLimiter$SleepingStopwatch$1",
      "com.vaadin.server.ClientConnector",
      "com.vaadin.tapio.googlemaps.client.overlays.GoogleMapPolyline",
      "okio.Util",
      "okhttp3.internal.tls.OkHostnameVerifier",
      "okhttp3.internal.tls.TrustRootIndex",
      "com.vaadin.server.KeyMapper",
      "com.vaadin.ui.ItemCaptionGenerator",
      "com.vaadin.shared.communication.SharedState",
      "com.google.maps.internal.ApiConfig",
      "com.vaadin.ui.LegacyComponent",
      "okhttp3.Interceptor$Chain",
      "com.vaadin.ui.HasComponents$ComponentAttachListener",
      "com.vaadin.shared.ui.BorderStyle",
      "com.google.gson.FieldNamingPolicy$4",
      "com.google.gson.FieldNamingPolicy$3",
      "com.google.gson.FieldNamingPolicy$5",
      "com.vaadin.tapio.googlemaps.client.GoogleMapControl",
      "com.google.maps.model.AutocompletePrediction$MatchedSubstring",
      "com.vaadin.server.VaadinSession",
      "okhttp3.TlsVersion",
      "com.vaadin.shared.ui.csslayout.CssLayoutState",
      "com.vaadin.shared.ui.tabsheet.TabsheetServerRpc",
      "com.google.maps.PendingResultBase",
      "com.vaadin.ui.SelectiveRenderer",
      "com.vaadin.server.ResourceReference",
      "com.vaadin.event.SerializableEventListener",
      "com.vaadin.server.Page$PopStateEvent",
      "com.google.gson.FieldNamingPolicy$2",
      "com.vaadin.ui.Component",
      "com.google.gson.FieldNamingPolicy$1",
      "okhttp3.RealCall$AsyncCall"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(PlaceSearchField_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "com.vaadin.server.AbstractClientConnector",
      "com.vaadin.util.ReflectTools",
      "com.vaadin.ui.AbstractComponent",
      "com.vaadin.ui.AbstractComponentContainer",
      "com.vaadin.ui.AbstractLayout",
      "com.vaadin.ui.Alignment",
      "com.vaadin.ui.AbstractOrderedLayout",
      "com.vaadin.ui.VerticalLayout",
      "com.polimi.travlendar.gmaps.PlaceSearchField",
      "com.vaadin.icons.VaadinIcons",
      "com.vaadin.shared.ui.ValueChangeMode",
      "com.vaadin.ui.Notification$Type",
      "com.vaadin.shared.Position",
      "com.vaadin.shared.ui.BorderStyle",
      "com.vaadin.util.CurrentInstance",
      "com.vaadin.server.ServerRpcManager",
      "com.vaadin.server.SizeWithUnit",
      "com.vaadin.shared.communication.SharedState",
      "com.vaadin.shared.AbstractComponentState",
      "com.vaadin.shared.ui.AbstractComponentContainerState",
      "com.vaadin.shared.ui.AbstractLayoutState",
      "com.vaadin.shared.ui.orderedlayout.AbstractOrderedLayoutState",
      "com.vaadin.shared.ui.orderedlayout.VerticalLayoutState",
      "com.vaadin.shared.ui.MarginInfo",
      "com.polimi.travlendar.gmaps.GoogleMapsService",
      "com.google.maps.internal.ExceptionsAllowedToRetry",
      "okhttp3.Protocol",
      "okio.Buffer",
      "okio.Util",
      "okio.ByteString",
      "okhttp3.internal.Util",
      "okhttp3.CipherSuite",
      "okhttp3.TlsVersion",
      "okhttp3.ConnectionSpec",
      "okhttp3.internal.Internal",
      "okhttp3.OkHttpClient",
      "okhttp3.EventListener",
      "okhttp3.CookieJar",
      "okhttp3.internal.tls.OkHostnameVerifier",
      "okhttp3.CertificatePinner",
      "okhttp3.Authenticator",
      "okhttp3.ConnectionPool",
      "okhttp3.Dns",
      "com.google.maps.internal.RateLimitExecutorService",
      "com.google.maps.internal.ratelimiter.Ticker",
      "com.google.maps.GeoApiContext",
      "okhttp3.internal.platform.AndroidPlatform",
      "okhttp3.internal.platform.Platform",
      "okhttp3.internal.tls.BasicCertificateChainCleaner",
      "okhttp3.MediaType",
      "com.google.maps.OkHttpRequestHandler",
      "com.vaadin.ui.Label",
      "com.vaadin.shared.ui.label.LabelState",
      "com.vaadin.ui.AbstractField",
      "com.vaadin.ui.AbstractTextField",
      "com.vaadin.ui.TextField",
      "com.vaadin.ui.AbstractTextField$AbstractTextFieldServerRpcImpl",
      "com.vaadin.ui.AbstractTextField$AbstractTextFieldFocusAndBlurRpcImpl",
      "com.vaadin.shared.ui.TabIndexState",
      "com.vaadin.shared.AbstractFieldState",
      "com.vaadin.shared.ui.textfield.AbstractTextFieldState",
      "com.vaadin.shared.ui.textfield.TextFieldState",
      "com.vaadin.ui.AbstractFocusable",
      "com.vaadin.ui.Button",
      "com.vaadin.event.FieldEvents$FocusAndBlurServerRpcImpl",
      "com.vaadin.event.FieldEvents$FocusAndBlurServerRpcDecorator",
      "com.vaadin.ui.Button$1",
      "com.vaadin.shared.communication.URLReference",
      "com.vaadin.server.ResourceReference",
      "com.vaadin.shared.ui.button.ButtonState",
      "com.vaadin.ui.Button$ClickListener",
      "com.vaadin.event.EventRouter",
      "com.vaadin.event.ListenerMethod",
      "com.vaadin.ui.HorizontalLayout",
      "com.vaadin.shared.ui.orderedlayout.HorizontalLayoutState",
      "com.vaadin.event.ConnectorEvent",
      "com.vaadin.ui.Component$Event",
      "com.vaadin.ui.HasComponents$ComponentAttachEvent",
      "com.vaadin.shared.ui.orderedlayout.AbstractOrderedLayoutState$ChildComponentData",
      "com.vaadin.shared.ui.AlignmentInfo",
      "com.vaadin.ui.AbstractSingleComponentContainer",
      "com.vaadin.ui.Panel",
      "com.polimi.travlendar.gmaps.DynamicList",
      "com.polimi.travlendar.gmaps.PredictionCaptionGenerator",
      "com.vaadin.shared.ui.AbstractSingleComponentContainerState",
      "com.vaadin.shared.ui.panel.PanelState",
      "com.vaadin.data.HasValue$ValueChangeListener",
      "com.vaadin.server.Sizeable",
      "com.vaadin.server.ComponentSizeValidator",
      "com.google.maps.model.AutocompletePrediction",
      "com.vaadin.ui.HasComponents$ComponentDetachEvent",
      "com.vaadin.server.AbstractErrorMessage",
      "com.vaadin.server.AbstractErrorMessage$ContentMode",
      "com.vaadin.server.UserError",
      "com.vaadin.server.ErrorMessage$ErrorLevel",
      "com.vaadin.ui.Component$ErrorEvent",
      "com.vaadin.server.AbstractExtension",
      "com.vaadin.ui.JavaScript",
      "com.polimi.travlendar.gmaps.LocationForm",
      "com.polimi.travlendar.gmaps.VaadinMap",
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
      "com.vaadin.ui.Notification",
      "com.vaadin.ui.Notification$1",
      "com.vaadin.server.Page",
      "com.vaadin.ui.UI",
      "com.vaadin.ui.AbstractDateField",
      "com.vaadin.ui.AbstractLocalDateTimeField",
      "com.vaadin.ui.DateTimeField",
      "com.vaadin.shared.ui.datefield.DateTimeResolution",
      "com.vaadin.ui.TabSheet",
      "com.vaadin.ui.Accordion",
      "com.vaadin.server.KeyMapper",
      "com.vaadin.ui.TabSheet$TabsheetServerRpcImpl",
      "com.vaadin.ui.TabSheet$TabSheetTabImpl",
      "com.vaadin.shared.ui.tabsheet.TabState",
      "com.vaadin.shared.ui.tabsheet.TabsheetState",
      "com.vaadin.shared.ui.accordion.AccordionState",
      "com.vaadin.ui.TabSheet$SelectedTabChangeEvent",
      "com.vaadin.shared.ui.datefield.AbstractDateFieldState",
      "com.vaadin.shared.ui.datefield.AbstractTextualDateFieldState",
      "com.vaadin.shared.ui.datefield.TextualDateFieldState",
      "com.vaadin.shared.ui.datefield.LocalDateTimeFieldState",
      "com.vaadin.server.DefaultErrorHandler",
      "com.google.maps.model.PlacesSearchResult",
      "com.vaadin.navigator.Navigator$EmptyView",
      "com.vaadin.shared.ui.ComponentStateUtil",
      "com.vaadin.server.VaadinServlet",
      "com.vaadin.ui.AbstractEmbedded",
      "com.vaadin.ui.Image",
      "com.vaadin.shared.ui.AbstractEmbeddedState",
      "com.vaadin.shared.ui.image.ImageState",
      "com.vaadin.shared.MouseEventDetails$MouseButton",
      "com.vaadin.event.MouseEvents$ClickEvent",
      "com.vaadin.event.ContextClickEvent",
      "com.vaadin.server.ClientConnector$DetachListener",
      "org.jsoup.nodes.Node",
      "org.jsoup.nodes.Element",
      "org.jsoup.parser.Tag",
      "org.jsoup.nodes.Attributes",
      "org.jsoup.nodes.Entities",
      "org.jsoup.nodes.Entities$EscapeMode",
      "org.jsoup.nodes.Document$OutputSettings$Syntax",
      "com.vaadin.ui.declarative.DesignContext",
      "com.vaadin.ui.declarative.ShouldWriteDataDelegate",
      "com.vaadin.server.VaadinService",
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
      "com.vaadin.ui.TextArea",
      "com.vaadin.ui.TextArea$1",
      "com.vaadin.shared.ui.textarea.TextAreaState",
      "com.google.gson.FieldNamingPolicy$1",
      "com.google.gson.FieldNamingPolicy$2",
      "com.google.gson.FieldNamingPolicy$3",
      "com.google.gson.FieldNamingPolicy$4",
      "com.google.gson.FieldNamingPolicy$5",
      "com.google.gson.FieldNamingPolicy",
      "com.google.maps.TextSearchRequest",
      "com.vaadin.ui.Window",
      "com.vaadin.shared.ui.window.WindowState",
      "com.vaadin.shared.ui.window.WindowMode",
      "com.vaadin.shared.ui.window.WindowRole",
      "com.vaadin.ui.Window$1",
      "com.vaadin.event.Action",
      "com.vaadin.event.ShortcutAction",
      "com.vaadin.event.ShortcutListener",
      "com.vaadin.ui.Window$CloseShortcut",
      "com.vaadin.event.ActionManager",
      "com.vaadin.ui.MenuBar",
      "com.vaadin.ui.MenuBar$MenuItem",
      "com.vaadin.shared.ui.menubar.MenuBarState",
      "com.vaadin.ui.Slider",
      "com.vaadin.shared.ui.slider.SliderState",
      "com.vaadin.shared.ui.slider.SliderOrientation",
      "com.vaadin.data.HasValue$ValueChangeEvent",
      "com.vaadin.ui.PopupView",
      "com.vaadin.shared.ui.popupview.PopupViewState",
      "com.vaadin.ui.PopupView$1",
      "com.google.maps.model.Photo",
      "com.vaadin.ui.renderers.AbstractRenderer",
      "com.vaadin.ui.renderers.ClickableRenderer",
      "com.vaadin.ui.renderers.ImageRenderer",
      "com.vaadin.ui.AbstractListing",
      "com.vaadin.ui.AbstractMultiSelect",
      "com.vaadin.ui.CheckBoxGroup",
      "com.vaadin.data.provider.DataProvider$3",
      "com.vaadin.data.provider.DataProvider",
      "com.vaadin.data.provider.AbstractDataProvider",
      "com.vaadin.data.provider.ListDataProvider",
      "com.vaadin.data.provider.DataCommunicator",
      "com.vaadin.data.provider.DataCommunicator$ActiveDataHandler",
      "com.vaadin.data.provider.AbstractBackEndDataProvider",
      "com.vaadin.data.provider.CallbackDataProvider",
      "com.vaadin.shared.Range",
      "com.vaadin.server.AbstractClientConnector$RpcInvocationHandler",
      "com.vaadin.data.provider.DataCommunicator$SimpleDataRequestRpc",
      "com.vaadin.ui.AbstractMultiSelect$MultiSelectServerRpcImpl",
      "com.vaadin.ui.AbstractMultiSelect$MultiSelectDataGenerator",
      "com.vaadin.shared.ui.abstractlisting.AbstractListingState",
      "com.vaadin.shared.ui.abstractmultiselect.AbstractMultiSelectState",
      "com.vaadin.shared.ui.optiongroup.CheckBoxGroupState",
      "com.vaadin.ui.AbstractSingleSelect",
      "com.vaadin.ui.NativeSelect",
      "com.vaadin.ui.AbstractSingleSelect$1",
      "com.vaadin.shared.ui.AbstractSingleSelectState",
      "com.vaadin.shared.ui.nativeselect.NativeSelectState",
      "org.jsoup.select.Elements",
      "okhttp3.HttpUrl",
      "okhttp3.HttpUrl$Builder$ParseResult",
      "com.google.maps.internal.OkHttpPendingResult",
      "okhttp3.internal.http.RetryAndFollowUpInterceptor",
      "com.vaadin.server.ClassResource",
      "com.vaadin.ui.Button$ClickShortcut",
      "com.vaadin.event.ConnectorActionManager",
      "okio.SegmentPool",
      "okio.Segment",
      "com.vaadin.ui.CheckBox",
      "com.vaadin.shared.ui.checkbox.CheckBoxState",
      "com.vaadin.ui.Composite",
      "com.vaadin.ui.renderers.ButtonRenderer",
      "com.vaadin.ui.CustomComponent",
      "com.vaadin.ui.dnd.DragSourceExtension",
      "com.vaadin.ui.dnd.event.DragStartListener",
      "com.vaadin.shared.ui.dnd.DragSourceState",
      "com.vaadin.shared.ui.dnd.EffectAllowed",
      "com.vaadin.ui.dnd.event.DragEndListener",
      "com.google.maps.DirectionsApi",
      "com.google.maps.PlaceAutocompleteRequest",
      "com.vaadin.ui.declarative.Design$DefaultComponentFactory",
      "com.vaadin.ui.declarative.Design$DefaultComponentMapper",
      "com.vaadin.ui.declarative.Design",
      "com.google.maps.model.Geometry",
      "com.vaadin.ui.GridLayout",
      "com.vaadin.shared.ui.gridlayout.GridLayoutState",
      "com.google.maps.model.AutocompleteStructuredFormatting",
      "com.vaadin.server.LegacyCommunicationManager",
      "com.vaadin.ui.BrowserFrame",
      "com.vaadin.shared.ui.browserframe.BrowserFrameState",
      "com.vaadin.server.ClientConnector$AttachListener",
      "com.vaadin.ui.AbstractLocalDateField",
      "com.vaadin.ui.DateField",
      "com.vaadin.shared.ui.datefield.DateResolution",
      "com.vaadin.shared.ui.datefield.LocalDateFieldState",
      "com.vaadin.ui.HasComponents$ComponentAttachListener",
      "com.vaadin.ui.Window$WindowModeChangeListener",
      "com.vaadin.server.ErrorEvent",
      "com.vaadin.server.ClientConnector$DetachEvent",
      "com.vaadin.server.ExternalResource",
      "com.vaadin.ui.Embedded",
      "com.vaadin.shared.ui.embedded.EmbeddedState",
      "com.vaadin.server.ThemeResource",
      "com.vaadin.util.FileTypeResolver",
      "com.vaadin.server.Responsive",
      "com.vaadin.ui.CustomLayout",
      "com.vaadin.shared.ui.customlayout.CustomLayoutState",
      "com.vaadin.ui.renderers.ClickableRenderer$RendererClickListener",
      "com.vaadin.data.provider.Query",
      "com.vaadin.ui.AbstractColorPicker",
      "com.vaadin.ui.ColorPicker",
      "com.vaadin.shared.ui.colorpicker.Color",
      "com.vaadin.ui.AbstractColorPicker$PopupStyle",
      "com.vaadin.shared.ui.colorpicker.AbstractColorPickerState",
      "com.vaadin.shared.ui.colorpicker.ColorPickerState",
      "com.vaadin.ui.NativeButton",
      "com.vaadin.ui.InlineDateTimeField",
      "org.jsoup.helper.StringUtil",
      "com.vaadin.ui.AbsoluteLayout",
      "com.vaadin.external.org.slf4j.LoggerFactory",
      "com.vaadin.external.org.slf4j.impl.StaticLoggerBinder",
      "com.vaadin.external.org.slf4j.helpers.NamedLoggerBase",
      "com.vaadin.external.org.slf4j.helpers.MarkerIgnoringBase",
      "com.vaadin.external.org.slf4j.impl.JDK14LoggerAdapter",
      "org.atmosphere.cpr.AtmosphereResourceImpl",
      "org.atmosphere.cpr.Action$TYPE",
      "org.atmosphere.cpr.Action",
      "org.atmosphere.websocket.WebSocket",
      "com.vaadin.server.VaadinServletRequest",
      "com.vaadin.ui.Tree",
      "com.vaadin.ui.Grid",
      "com.vaadin.ui.TreeGrid",
      "com.vaadin.data.provider.HierarchicalDataCommunicator",
      "com.vaadin.data.provider.AbstractHierarchicalDataProvider",
      "com.vaadin.data.provider.TreeDataProvider",
      "com.vaadin.data.TreeData",
      "com.vaadin.data.TreeData$HierarchyWrapper",
      "com.vaadin.data.provider.HierarchyMapper",
      "com.vaadin.ui.TreeGrid$1",
      "com.vaadin.ui.components.grid.StaticSection",
      "com.vaadin.ui.components.grid.Header",
      "com.vaadin.ui.Grid$HeaderImpl",
      "com.vaadin.ui.components.grid.Footer",
      "com.vaadin.ui.Grid$FooterImpl",
      "com.vaadin.ui.Grid$GridServerRpcImpl",
      "com.vaadin.ui.components.grid.StaticSection$StaticRow",
      "com.vaadin.ui.components.grid.Header$Row",
      "com.vaadin.shared.ui.grid.SectionState$RowState",
      "com.vaadin.shared.ui.grid.GridState",
      "com.vaadin.shared.ui.treegrid.TreeGridState",
      "com.vaadin.shared.ui.grid.ColumnResizeMode",
      "com.vaadin.shared.ui.grid.SectionState",
      "com.vaadin.shared.ui.grid.HeightMode",
      "com.vaadin.ui.AbstractListing$AbstractListingExtension",
      "com.vaadin.ui.Grid$AbstractGridExtension",
      "com.vaadin.ui.components.grid.AbstractSelectionModel",
      "com.vaadin.ui.components.grid.SingleSelectionModelImpl",
      "com.vaadin.ui.components.grid.SingleSelectionModelImpl$1",
      "com.vaadin.ui.Grid$DetailsManager",
      "com.vaadin.ui.components.grid.EditorImpl",
      "com.vaadin.ui.components.grid.EditorImpl$1",
      "com.vaadin.data.Binder",
      "com.vaadin.ui.components.grid.EditorImpl$EditorStatusHandler",
      "com.vaadin.ui.Tree$TreeRenderer",
      "com.vaadin.ui.Grid$Column",
      "com.vaadin.ui.Grid$Column$1",
      "com.vaadin.shared.extension.abstractlisting.AbstractListingExtensionState",
      "com.vaadin.shared.ui.grid.AbstractGridExtensionState",
      "com.vaadin.shared.ui.grid.ColumnState",
      "com.vaadin.ui.components.grid.StaticSection$StaticCell",
      "com.vaadin.ui.components.grid.Header$Row$Cell",
      "com.vaadin.shared.ui.grid.SectionState$CellState",
      "com.vaadin.shared.ui.grid.GridStaticCellType",
      "com.vaadin.event.ExpandEvent$ExpandListener",
      "com.vaadin.event.CollapseEvent$CollapseListener",
      "com.vaadin.shared.ui.composite.CompositeState",
      "org.apache.tomcat.util.res.StringManager",
      "org.apache.tomcat.util.res.StringManager$1",
      "org.apache.catalina.webresources.ClasspathURLStreamHandler",
      "org.jsoup.nodes.TextNode",
      "com.vaadin.server.VaadinSession",
      "com.vaadin.server.WebBrowser",
      "com.vaadin.server.VaadinSession$State",
      "com.vaadin.ui.AbstractSplitPanel",
      "com.vaadin.ui.VerticalSplitPanel",
      "com.vaadin.ui.AbstractSplitPanel$1",
      "com.vaadin.shared.ui.splitpanel.AbstractSplitPanelState",
      "com.vaadin.shared.ui.splitpanel.VerticalSplitPanelState",
      "com.vaadin.shared.ui.splitpanel.AbstractSplitPanelState$SplitterState",
      "com.vaadin.ui.AbstractSplitPanel$SplitPositionChangeEvent",
      "com.vaadin.ui.AbstractSplitPanel$ComponentIterator",
      "com.vaadin.shared.communication.PushMode",
      "com.vaadin.server.Constants",
      "com.vaadin.server.VaadinServletService",
      "com.vaadin.server.VaadinServletResponse",
      "com.vaadin.ui.ColorPickerArea",
      "com.vaadin.shared.ui.colorpicker.ColorPickerAreaState",
      "com.vaadin.ui.renderers.LocalDateTimeRenderer",
      "com.vaadin.ui.FormLayout",
      "com.vaadin.shared.ui.orderedlayout.FormLayoutState",
      "com.vaadin.server.Sizeable$Unit",
      "com.vaadin.shared.ui.ContentMode"
    );
  }
}
