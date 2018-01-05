/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Thu Jan 04 11:10:49 GMT 2018
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
public class MeetingItem_ESTest_scaffolding {

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);

  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "com.polimi.travlendar.backend.model.events.MeetingItem"; 
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
    java.lang.System.setProperty("java.class.path", "/tmp/EvoSuite_pathingJar8413397615903593307.jar"); 
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
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(MeetingItem_ESTest_scaffolding.class.getClassLoader() ,
      "com.vaadin.data.SelectionModel$Multi",
      "com.vaadin.data.HasDataProvider",
      "com.vaadin.event.selection.SelectionEvent",
      "com.vaadin.shared.AbstractComponentState",
      "com.vaadin.server.AbstractExtension",
      "com.vaadin.data.HasValue",
      "com.vaadin.shared.ui.grid.renderers.AbstractRendererState",
      "com.vaadin.shared.ui.combobox.ComboBoxServerRpc",
      "com.vaadin.server.Page",
      "com.vaadin.data.provider.TreeDataProvider",
      "com.vaadin.ui.components.grid.EditorOpenEvent",
      "com.vaadin.ui.components.colorpicker.ColorPickerPopup",
      "com.vaadin.ui.UIDetachedException",
      "com.vaadin.event.ShortcutAction",
      "com.vaadin.ui.TabSheet$TabSheetTabImpl",
      "com.vaadin.event.ContextClickEvent$ContextClickNotifier",
      "com.vaadin.ui.TextArea",
      "com.vaadin.ui.MenuBar$MenuItem",
      "com.vaadin.server.VaadinResponse",
      "com.vaadin.data.Binder$BindingBuilder",
      "com.vaadin.ui.Tree$ItemClickListener",
      "com.vaadin.ui.DeclarativeValueProvider",
      "com.vaadin.data.validator.RangeValidator",
      "com.vaadin.data.BeanPropertySet$NestedBeanPropertyDefinition",
      "com.vaadin.ui.Window$1",
      "com.vaadin.event.MouseEvents$ClickListener",
      "org.vaadin.addon.calendar.item.EditableCalendarItem$ItemChangeListener",
      "com.vaadin.data.HasFilterableDataProvider",
      "com.vaadin.shared.communication.MethodInvocation",
      "com.vaadin.shared.ui.slider.SliderState",
      "com.vaadin.data.provider.HierarchicalDataCommunicator",
      "com.vaadin.ui.TabSheet$CloseHandler",
      "com.vaadin.ui.AbstractDateField",
      "com.vaadin.shared.ui.nativeselect.NativeSelectState",
      "com.vaadin.data.provider.GridSortOrder",
      "com.vaadin.ui.Grid$SelectionMode",
      "com.vaadin.shared.communication.URLReference",
      "com.vaadin.data.provider.DataChangeEvent",
      "com.vaadin.ui.AbstractLocalDateField",
      "com.vaadin.data.provider.DataProvider",
      "com.vaadin.ui.TreeGrid$1",
      "com.vaadin.shared.communication.ServerRpc",
      "com.vaadin.server.ServerRpcManager$RpcInvocationException",
      "com.vaadin.data.util.BeanUtil",
      "com.vaadin.data.ValidationException",
      "com.vaadin.data.TreeData$HierarchyWrapper",
      "com.vaadin.ui.components.grid.ColumnResizeListener",
      "com.vaadin.data.HasValue$ValueChangeListener",
      "com.vaadin.ui.renderers.HtmlRenderer",
      "com.vaadin.event.FieldEvents$FocusNotifier",
      "com.vaadin.ui.TextField",
      "com.vaadin.ui.AbstractListing$AbstractListingExtension",
      "com.vaadin.ui.Window$WindowOrderChangeEvent",
      "com.vaadin.ui.renderers.Renderer",
      "com.vaadin.shared.ui.window.WindowMode",
      "com.vaadin.event.Action$Listener",
      "com.vaadin.ui.renderers.AbstractRenderer",
      "com.vaadin.server.VaadinRequest",
      "org.vaadin.addon.calendar.item.CalendarItem",
      "com.vaadin.server.AbstractClientConnector$RpcInvocationHandler",
      "com.vaadin.ui.HasComponents$ComponentAttachDetachNotifier",
      "com.vaadin.shared.MouseEventDetails",
      "com.vaadin.ui.components.grid.SingleSelectionModelImpl$1",
      "com.vaadin.data.ValueProvider",
      "com.vaadin.server.communication.PushConnection",
      "com.vaadin.ui.components.grid.AbstractSelectionModel",
      "com.vaadin.ui.RichTextArea",
      "com.vaadin.data.Binder$BindingImpl",
      "com.vaadin.event.FieldEvents$FocusAndBlurServerRpcImpl",
      "com.vaadin.data.provider.ConfigurableFilterDataProvider",
      "com.vaadin.shared.ui.datefield.LocalDateFieldState",
      "com.vaadin.shared.ui.WindowOrderRpc",
      "com.vaadin.ui.Window$CloseEvent",
      "com.vaadin.ui.renderers.ComponentRenderer",
      "com.vaadin.shared.ui.video.VideoState",
      "com.vaadin.shared.ui.checkbox.CheckBoxState",
      "com.vaadin.ui.RadioButtonGroup",
      "com.vaadin.data.BindingValidationStatusHandler",
      "com.vaadin.data.provider.AbstractHierarchicalDataProvider",
      "com.vaadin.ui.Video",
      "com.vaadin.ui.renderers.TextRenderer",
      "org.jsoup.nodes.Attributes",
      "com.vaadin.ui.Window$ResizeEvent",
      "com.vaadin.shared.ui.ValueChangeMode",
      "com.vaadin.event.ActionManager$ActionKeyMapper",
      "com.vaadin.ui.Grid$GridContextClickEvent",
      "com.vaadin.data.provider.Query",
      "com.vaadin.shared.ui.ui.DebugWindowServerRpc",
      "com.vaadin.event.FieldEvents",
      "com.polimi.travlendar.gmaps.DefaultCaptionGenerator",
      "com.vaadin.event.CollapseEvent",
      "com.vaadin.data.BinderValidationStatusHandler",
      "com.vaadin.event.ListenerMethod",
      "com.vaadin.ui.Label",
      "com.vaadin.ui.Grid$FooterImpl",
      "com.vaadin.data.provider.DataCommunicator$ActiveDataHandler",
      "com.vaadin.ui.components.grid.EditorErrorGenerator",
      "com.vaadin.ui.declarative.DesignException",
      "com.vaadin.server.ServerRpcManager",
      "com.vaadin.ui.Window$WindowModeChangeEvent",
      "com.vaadin.shared.util.SharedUtil",
      "com.vaadin.ui.components.grid.Footer$Row$Cell",
      "com.vaadin.ui.Component$Focusable",
      "com.vaadin.ui.AbstractLocalDateTimeField",
      "com.vaadin.ui.Grid$1",
      "com.vaadin.data.provider.GridSortOrderBuilder",
      "com.vaadin.server.Sizeable$Unit",
      "com.vaadin.ui.components.grid.FooterRow",
      "com.vaadin.data.provider.DataKeyMapper",
      "com.vaadin.event.FieldEvents$BlurListener",
      "com.vaadin.shared.data.selection.SelectionServerRpc",
      "com.vaadin.ui.ItemCollapseAllowedProvider",
      "com.vaadin.ui.Flash",
      "com.vaadin.ui.CheckBox",
      "com.vaadin.shared.ui.treegrid.TreeGridState",
      "com.vaadin.shared.ui.grid.ColumnState",
      "com.vaadin.ui.AbstractMultiSelect$MultiSelectDataGenerator",
      "com.vaadin.ui.Grid$FetchItemsCallback",
      "com.vaadin.ui.components.grid.Editor",
      "com.vaadin.server.Extension",
      "com.vaadin.event.FieldEvents$FocusListener",
      "com.vaadin.ui.components.grid.ItemClickListener",
      "com.vaadin.ui.components.grid.ColumnReorderListener",
      "com.vaadin.ui.AbstractTextField",
      "com.vaadin.ui.components.grid.MultiSelectionModelImpl",
      "com.vaadin.shared.ui.grid.AbstractGridExtensionState",
      "org.jsoup.select.Elements",
      "com.vaadin.shared.ui.datefield.AbstractTextualDateFieldState",
      "com.vaadin.ui.Grid$ColumnVisibilityChangeEvent",
      "com.vaadin.data.provider.SortOrderBuilder",
      "com.vaadin.event.EventRouter",
      "com.vaadin.shared.extension.abstractlisting.AbstractListingExtensionState",
      "com.polimi.travlendar.backend.model.user.PreferenceLevel",
      "com.vaadin.data.Validator",
      "com.vaadin.ui.ColorPickerArea",
      "com.vaadin.ui.Tree$TreeMultiSelectionModel",
      "com.vaadin.ui.Accordion",
      "com.vaadin.shared.ui.combobox.ComboBoxState",
      "com.vaadin.shared.communication.FieldRpc$FocusAndBlurServerRpc",
      "com.vaadin.shared.ui.ContentMode",
      "com.vaadin.event.FieldEvents$FocusAndBlurServerRpcDecorator",
      "com.vaadin.ui.AbstractMedia",
      "com.vaadin.data.HasValue$ValueChangeEvent",
      "com.vaadin.ui.HasValueChangeMode",
      "com.vaadin.ui.ComboBox$FetchItemsCallback",
      "com.vaadin.ui.components.grid.HeaderRow",
      "com.vaadin.shared.data.DataRequestRpc",
      "com.vaadin.data.provider.AbstractBackEndDataProvider",
      "com.vaadin.data.provider.CallbackDataProvider",
      "com.vaadin.shared.ui.datefield.LocalDateTimeFieldState",
      "com.vaadin.event.selection.SelectionListener",
      "com.vaadin.shared.AbstractFieldState",
      "com.vaadin.ui.InlineDateTimeField",
      "com.vaadin.data.provider.DataGenerator",
      "com.vaadin.ui.LoginForm$LoginEvent",
      "com.vaadin.shared.ui.loginform.LoginFormState",
      "com.vaadin.ui.components.grid.EditorImpl",
      "com.vaadin.shared.Range",
      "com.vaadin.data.provider.AbstractDataProvider",
      "com.vaadin.ui.declarative.DesignContext",
      "com.vaadin.event.ContextClickEvent",
      "com.vaadin.event.SortEvent$SortListener",
      "com.vaadin.shared.Connector",
      "com.vaadin.ui.ProgressBar",
      "com.polimi.travlendar.backend.model.events.MeetingItem",
      "com.vaadin.shared.ui.slider.SliderOrientation",
      "com.vaadin.ui.TreeGrid",
      "com.vaadin.ui.Grid$DetailsManager",
      "com.vaadin.server.PaintTarget",
      "com.vaadin.util.CurrentInstance",
      "com.vaadin.shared.ui.grid.GridState",
      "com.vaadin.ui.components.grid.StaticSection$StaticCell",
      "com.vaadin.shared.ui.window.WindowRole",
      "com.vaadin.ui.AbstractComponent",
      "com.vaadin.ui.AbstractField",
      "com.vaadin.shared.ui.grid.editor.EditorState",
      "com.vaadin.shared.ui.datefield.InlineDateTimeFieldState",
      "com.vaadin.ui.components.grid.SortOrderProvider",
      "com.vaadin.ui.components.grid.SingleSelectionModel",
      "com.vaadin.shared.ui.textarea.TextAreaState",
      "com.vaadin.shared.ui.accordion.AccordionState",
      "com.vaadin.ui.UI$WindowOrderUpdateListener",
      "com.vaadin.shared.ui.grid.SectionState$CellState",
      "com.polimi.travlendar.backend.model.events.Meeting$State",
      "com.vaadin.data.Converter",
      "com.vaadin.data.ErrorMessageProvider",
      "com.vaadin.event.FieldEvents$BlurEvent",
      "com.vaadin.ui.components.grid.Header$Row",
      "com.vaadin.server.ClientConnector$ConnectorErrorEvent",
      "com.vaadin.ui.Notification",
      "com.vaadin.ui.ComboBox$NewItemHandler",
      "com.vaadin.data.validator.DateRangeValidator",
      "com.vaadin.ui.components.grid.EditorSaveEvent",
      "com.vaadin.server.ClientConnector",
      "com.vaadin.server.KeyMapper",
      "com.vaadin.shared.communication.SharedState",
      "com.vaadin.ui.Tree$TreeContextClickEvent",
      "com.vaadin.ui.dnd.DragSourceExtension",
      "com.vaadin.ui.AbstractEmbedded",
      "com.vaadin.ui.HasComponents$ComponentAttachListener",
      "com.vaadin.shared.ui.grid.HeightMode",
      "com.vaadin.ui.RichTextArea$RichTextAreaServerRpcImpl",
      "com.vaadin.navigator.Navigator",
      "com.vaadin.data.HasItems",
      "com.vaadin.server.VaadinSession",
      "com.vaadin.data.validator.AbstractValidator",
      "com.vaadin.data.provider.HierarchicalQuery",
      "com.vaadin.server.ResourceReference",
      "com.vaadin.ui.SelectiveRenderer",
      "com.vaadin.ui.components.grid.ColumnVisibilityChangeListener",
      "com.vaadin.server.Setter",
      "com.vaadin.ui.Component$ErrorEvent",
      "com.vaadin.shared.ui.TabIndexState",
      "com.vaadin.data.BeanPropertySet$BeanPropertyDefinition",
      "org.jsoup.nodes.Element",
      "com.vaadin.data.PropertyDefinition",
      "com.vaadin.ui.MenuBar$Command",
      "com.vaadin.server.SerializableToIntFunction",
      "com.vaadin.ui.Grid$AbstractGridExtension",
      "com.vaadin.shared.ui.ui.UIServerRpc",
      "com.vaadin.ui.Grid$ColumnReorderEvent",
      "com.vaadin.ui.DateTimeField",
      "com.vaadin.ui.MenuBar",
      "com.vaadin.ui.Slider",
      "com.vaadin.ui.Grid$GridServerRpcImpl",
      "com.vaadin.shared.ui.grid.SingleSelectionModelState",
      "com.vaadin.data.BinderValidationStatus",
      "com.vaadin.server.ClientConnector$AttachEvent",
      "com.vaadin.shared.ui.progressindicator.ProgressBarState",
      "com.vaadin.ui.ComboBox$CaptionFilter",
      "org.vaadin.addon.calendar.item.BasicItem$Notify",
      "com.vaadin.event.CollapseEvent$CollapseListener",
      "com.vaadin.ui.LoginForm$LoginListener",
      "com.vaadin.ui.StyleGenerator",
      "com.vaadin.data.provider.HierarchicalDataProvider",
      "com.vaadin.shared.ui.tabsheet.TabsheetState",
      "com.vaadin.data.provider.DataProvider$3",
      "com.vaadin.event.FieldEvents$BlurNotifier",
      "com.vaadin.ui.HasComponents$ComponentDetachListener",
      "com.vaadin.ui.TabSheet$SelectedTabChangeEvent",
      "com.vaadin.event.SortEvent$SortNotifier",
      "com.vaadin.shared.ui.ui.UIState",
      "com.vaadin.shared.ui.window.WindowState",
      "com.vaadin.ui.TooltipConfiguration",
      "com.vaadin.ui.components.grid.HeaderCell",
      "com.vaadin.event.ConnectorActionManager",
      "com.vaadin.server.AbstractClientConnector",
      "com.polimi.travlendar.backend.model.events.Meeting",
      "com.vaadin.ui.Image",
      "com.vaadin.server.VariableOwner",
      "com.vaadin.data.provider.InMemoryDataProvider",
      "com.vaadin.shared.ui.AbstractEmbeddedState",
      "com.vaadin.shared.ui.image.ImageState",
      "com.vaadin.ui.AbstractSingleComponentContainer",
      "com.vaadin.ui.Grid$Column$1",
      "com.vaadin.ui.LoadingIndicatorConfiguration",
      "com.vaadin.ui.Composite",
      "com.vaadin.shared.ui.grid.editor.EditorServerRpc",
      "com.vaadin.server.SerializableComparator",
      "com.vaadin.shared.data.DataCommunicatorClientRpc",
      "com.vaadin.data.BeanPropertySet$AbstractBeanPropertyDefinition",
      "com.vaadin.server.StreamResource$StreamSource",
      "com.vaadin.shared.ui.embedded.EmbeddedState",
      "com.vaadin.event.Action$Notifier",
      "com.vaadin.shared.ui.richtextarea.RichTextAreaState",
      "com.vaadin.event.Action$Container",
      "com.vaadin.ui.Grid",
      "com.vaadin.ui.components.grid.StaticSection$StaticRow",
      "com.vaadin.ui.components.grid.EditorImpl$EditorStatusHandler",
      "com.vaadin.ui.UI",
      "com.vaadin.ui.Window",
      "com.vaadin.shared.data.sort.SortDirection",
      "com.vaadin.shared.ui.grid.renderers.TextRendererState",
      "com.vaadin.server.SerializableBiPredicate",
      "com.vaadin.event.ConnectorEvent",
      "com.vaadin.ui.ComponentContainer",
      "com.vaadin.event.MethodEventSource",
      "com.vaadin.event.Action$Handler",
      "com.vaadin.ui.ComboBox$2$1",
      "com.vaadin.icons.VaadinIcons",
      "com.vaadin.ui.Tree",
      "com.vaadin.shared.ui.colorpicker.Color",
      "com.vaadin.server.FontIcon",
      "com.vaadin.ui.HasComponents$ComponentAttachEvent",
      "com.vaadin.ui.TabSheet$Tab",
      "com.vaadin.data.SelectionModel",
      "com.vaadin.ui.UI$WindowOrderUpdateEvent",
      "com.vaadin.ui.ConnectorTracker",
      "com.vaadin.shared.ui.menubar.MenuBarState",
      "com.vaadin.server.SerializableSupplier",
      "com.vaadin.data.Binder",
      "com.vaadin.shared.ui.grid.editor.EditorClientRpc",
      "org.jsoup.nodes.Node",
      "com.vaadin.data.provider.QuerySortOrder",
      "com.vaadin.ui.TwinColSelect",
      "com.vaadin.ui.TabSheet",
      "org.vaadin.addon.calendar.item.EditableCalendarItem$ItemChangedEvent",
      "com.vaadin.ui.components.grid.EditorCancelListener",
      "com.vaadin.data.validator.DateTimeRangeValidator",
      "com.vaadin.event.ExpandEvent",
      "com.vaadin.data.provider.HierarchyMapper",
      "com.vaadin.ui.MultiSelect",
      "com.vaadin.data.ValidationResult",
      "com.vaadin.server.Scrollable",
      "com.vaadin.ui.Window$CloseShortcut",
      "com.vaadin.server.LocaleService",
      "com.vaadin.ui.Window$WindowModeChangeListener",
      "com.vaadin.ui.Notification$Type",
      "com.vaadin.shared.ui.grid.GridConstants$Section",
      "com.vaadin.shared.Registration",
      "com.vaadin.ui.ReconnectDialogConfiguration",
      "com.vaadin.shared.ui.datefield.DateTimeResolution",
      "com.vaadin.shared.ui.AbstractComponentContainerState",
      "com.vaadin.shared.ui.twincolselect.TwinColSelectState",
      "com.vaadin.event.Action$ShortcutNotifier",
      "com.vaadin.ui.PushConfiguration",
      "com.vaadin.data.provider.ListDataProvider",
      "com.vaadin.server.PaintException",
      "com.vaadin.server.ErrorEvent",
      "com.vaadin.shared.ui.grid.SectionState$RowState",
      "com.vaadin.server.ErrorMessage",
      "com.vaadin.server.Sizeable",
      "com.vaadin.event.ContextClickEvent$ContextClickListener",
      "com.vaadin.ui.ComboBox$1",
      "com.vaadin.ui.ComboBox$2",
      "com.vaadin.ui.PasswordField",
      "com.vaadin.shared.ui.grid.GridStaticCellType",
      "com.vaadin.event.UIEvents$PollNotifier",
      "com.vaadin.ui.components.grid.Footer$Row",
      "com.vaadin.event.ShortcutListener",
      "com.vaadin.shared.ui.window.WindowServerRpc",
      "com.vaadin.event.SortEvent",
      "com.vaadin.shared.ui.flash.FlashState",
      "com.vaadin.shared.communication.FieldRpc$FocusServerRpc",
      "com.vaadin.ui.AbstractColorPicker$PopupStyle",
      "com.vaadin.server.ServerRpcMethodInvocation",
      "com.vaadin.shared.ui.grid.ColumnResizeMode",
      "com.vaadin.shared.ui.AbstractSingleSelectState",
      "com.vaadin.shared.ui.grid.SectionState",
      "elemental.json.JsonArray",
      "com.vaadin.ui.HasComponents",
      "com.vaadin.server.ErrorHandler",
      "com.vaadin.ui.Window$WindowOrderChangeListener",
      "elemental.json.JsonValue",
      "com.vaadin.data.provider.BackEndDataProvider",
      "com.vaadin.ui.components.grid.Header$Row$Cell",
      "com.vaadin.shared.ui.datefield.DateResolution",
      "com.vaadin.shared.ui.abstractlisting.AbstractListingState",
      "com.vaadin.ui.Window$ResizeListener",
      "com.vaadin.ui.TabSheet$SelectedTabChangeListener",
      "com.vaadin.data.Binder$Binding",
      "com.vaadin.shared.ui.panel.PanelState",
      "com.vaadin.data.Result",
      "com.vaadin.ui.Grid$ItemClick",
      "com.vaadin.shared.ui.grid.DetailsManagerState",
      "com.vaadin.shared.ui.textfield.AbstractTextFieldState",
      "com.vaadin.ui.LoginForm",
      "com.vaadin.shared.ui.ComponentStateUtil",
      "com.vaadin.ui.Tree$ItemClick",
      "com.vaadin.ui.Component$Event",
      "com.vaadin.event.ExpandEvent$ExpandListener",
      "com.vaadin.shared.ui.richtextarea.RichTextAreaServerRpc",
      "com.vaadin.ui.Tree$TreeRenderer",
      "com.vaadin.server.ClientConnector$DetachEvent",
      "com.vaadin.event.selection.SingleSelectionListener",
      "com.vaadin.util.ReflectTools",
      "com.vaadin.shared.ui.datefield.TextualDateFieldState",
      "com.vaadin.server.SizeWithUnit",
      "com.vaadin.server.Resource",
      "com.vaadin.data.provider.SortOrder",
      "com.vaadin.ui.RadioButtonGroup$1",
      "com.vaadin.shared.ui.AbstractSingleComponentContainerState",
      "com.vaadin.shared.communication.FieldRpc$BlurServerRpc",
      "com.vaadin.event.ActionManager",
      "com.vaadin.ui.components.grid.EditorCancelEvent",
      "com.vaadin.data.TreeData",
      "com.vaadin.event.ConnectorEventListener",
      "com.vaadin.data.StatusChangeListener",
      "com.vaadin.data.BindingValidationStatus",
      "com.vaadin.ui.SingleComponentContainer",
      "com.vaadin.ui.Embedded",
      "com.vaadin.ui.AbstractSingleSelect",
      "com.vaadin.ui.HasComponents$ComponentDetachEvent",
      "com.vaadin.ui.components.grid.FooterCell",
      "com.vaadin.ui.Button",
      "com.vaadin.ui.AbstractMultiSelect",
      "com.vaadin.server.ClientConnector$AttachListener",
      "com.vaadin.server.SerializablePredicate",
      "elemental.json.JsonObject",
      "org.vaadin.addon.calendar.item.EditableCalendarItem$ItemChangeNotifier",
      "com.vaadin.ui.AbstractComponentContainer",
      "com.vaadin.shared.ui.abstractmultiselect.AbstractMultiSelectState",
      "com.vaadin.ui.Panel",
      "com.vaadin.data.provider.DataProviderListener",
      "com.vaadin.shared.ui.tree.TreeRendererState",
      "com.vaadin.event.UIEvents$PollListener",
      "com.vaadin.ui.AbstractTextField$AbstractTextFieldFocusAndBlurRpcImpl",
      "com.vaadin.data.provider.DataChangeEvent$DataRefreshEvent",
      "com.vaadin.data.SelectionModel$Single",
      "com.vaadin.ui.components.grid.DetailsGenerator",
      "com.vaadin.shared.ui.ClickRpc",
      "org.vaadin.addon.calendar.item.BasicItem",
      "com.vaadin.shared.extension.datacommunicator.HierarchicalDataCommunicatorState",
      "com.vaadin.ui.NotificationConfiguration",
      "com.vaadin.shared.ui.AbstractMediaState",
      "com.vaadin.server.SerializableConsumer",
      "com.vaadin.shared.ui.PreloadMode",
      "com.vaadin.event.selection.MultiSelectionListener",
      "com.vaadin.event.Action",
      "org.vaadin.addon.calendar.item.EditableCalendarItem",
      "com.vaadin.event.FieldEvents$FocusEvent",
      "com.vaadin.ui.DateField",
      "com.vaadin.shared.ui.textfield.AbstractTextFieldServerRpc",
      "com.vaadin.ui.TabSheet$TabsheetServerRpcImpl",
      "com.vaadin.data.StatusChangeEvent",
      "com.vaadin.data.BeanPropertySet",
      "com.vaadin.ui.components.grid.Footer",
      "com.vaadin.event.ListenerMethod$MethodException",
      "com.vaadin.shared.communication.ClientRpc",
      "com.vaadin.shared.data.selection.MultiSelectServerRpc",
      "com.vaadin.ui.components.grid.StaticSection",
      "com.vaadin.ui.AbstractTextField$AbstractTextFieldServerRpcImpl",
      "com.vaadin.server.ClientConnector$DetachListener",
      "com.vaadin.server.SerializableFunction",
      "com.vaadin.ui.AbstractFocusable",
      "com.vaadin.ui.Grid$ColumnResizeEvent",
      "com.vaadin.ui.Component$Listener",
      "com.vaadin.ui.AbstractSingleSelect$1",
      "com.vaadin.ui.ComboBox",
      "com.vaadin.event.HasUserOriginated",
      "com.vaadin.event.selection.SingleSelectionEvent",
      "com.vaadin.data.HasHierarchicalDataProvider",
      "com.vaadin.ui.AbstractMultiSelect$MultiSelectServerRpcImpl",
      "com.vaadin.shared.ui.composite.CompositeState",
      "com.vaadin.ui.Grid$Column",
      "com.vaadin.shared.ui.datefield.AbstractDateFieldState",
      "com.vaadin.shared.ui.colorpicker.AbstractColorPickerState",
      "com.vaadin.shared.ui.colorpicker.ColorPickerAreaState",
      "com.vaadin.event.MouseEvents$ClickEvent",
      "com.vaadin.ui.AbstractListing",
      "com.vaadin.ui.AbstractColorPicker",
      "com.vaadin.ui.Slider$ValueOutOfBoundsException",
      "com.vaadin.ui.components.grid.MultiSelectionModel",
      "com.vaadin.shared.ui.grid.AbstractSelectionModelState",
      "com.vaadin.ui.IconGenerator",
      "com.vaadin.event.selection.MultiSelectionEvent",
      "com.vaadin.shared.extension.datacommunicator.DataCommunicatorState",
      "com.vaadin.ui.components.grid.SingleSelectionModelImpl",
      "com.vaadin.data.provider.DataCommunicator",
      "com.vaadin.ui.SingleSelect",
      "com.vaadin.ui.ItemCaptionGenerator",
      "com.vaadin.ui.components.grid.EditorOpenListener",
      "com.vaadin.ui.LegacyComponent",
      "com.vaadin.ui.Window$CloseListener",
      "com.vaadin.data.PropertySet",
      "com.vaadin.ui.components.grid.EditorImpl$1",
      "com.vaadin.shared.ui.BorderStyle",
      "com.vaadin.ui.components.grid.GridSelectionModel",
      "com.vaadin.ui.components.grid.Header",
      "com.vaadin.ui.components.grid.EditorSaveListener",
      "com.vaadin.ui.components.grid.DescriptionGenerator",
      "com.vaadin.shared.ui.grid.GridServerRpc",
      "com.vaadin.shared.ui.grid.ScrollDestination",
      "com.vaadin.shared.ui.tabsheet.TabsheetServerRpc",
      "com.vaadin.ui.Grid$HeaderImpl",
      "com.vaadin.data.provider.DataCommunicator$SimpleDataRequestRpc",
      "com.vaadin.event.SerializableEventListener",
      "com.vaadin.ui.NativeSelect",
      "com.vaadin.ui.Component",
      "com.vaadin.shared.ui.optiongroup.RadioButtonGroupState"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(MeetingItem_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "org.vaadin.addon.calendar.item.BasicItem",
      "com.polimi.travlendar.backend.model.events.MeetingItem",
      "com.vaadin.icons.VaadinIcons",
      "com.polimi.travlendar.backend.model.user.PreferenceLevel",
      "com.vaadin.server.Sizeable$Unit",
      "com.polimi.travlendar.backend.model.events.Meeting$State",
      "com.vaadin.shared.ui.ContentMode",
      "com.vaadin.shared.ui.BorderStyle",
      "org.vaadin.addon.calendar.item.BasicItem$Notify",
      "org.vaadin.addon.calendar.item.EditableCalendarItem$ItemChangedEvent",
      "com.vaadin.server.AbstractClientConnector",
      "com.vaadin.util.ReflectTools",
      "com.vaadin.ui.AbstractComponent",
      "com.vaadin.ui.AbstractListing",
      "com.vaadin.ui.AbstractSingleSelect",
      "com.vaadin.ui.NativeSelect",
      "com.vaadin.server.AbstractExtension",
      "com.vaadin.data.provider.DataCommunicator",
      "com.vaadin.data.provider.DataCommunicator$ActiveDataHandler",
      "com.vaadin.data.provider.DataProvider$3",
      "com.vaadin.data.provider.DataProvider",
      "com.vaadin.data.provider.AbstractDataProvider",
      "com.vaadin.data.provider.AbstractBackEndDataProvider",
      "com.vaadin.data.provider.CallbackDataProvider",
      "com.vaadin.shared.Range",
      "com.vaadin.server.AbstractClientConnector$RpcInvocationHandler",
      "com.vaadin.data.provider.DataCommunicator$SimpleDataRequestRpc",
      "com.vaadin.server.ServerRpcManager",
      "com.vaadin.server.KeyMapper",
      "com.vaadin.ui.AbstractSingleSelect$1",
      "com.vaadin.event.FieldEvents$FocusAndBlurServerRpcImpl",
      "com.vaadin.event.FieldEvents$FocusAndBlurServerRpcDecorator",
      "com.vaadin.server.Sizeable",
      "com.vaadin.ui.AbstractMultiSelect",
      "com.vaadin.ui.TwinColSelect",
      "com.vaadin.ui.AbstractMultiSelect$MultiSelectServerRpcImpl",
      "com.vaadin.ui.AbstractMultiSelect$MultiSelectDataGenerator",
      "com.vaadin.shared.communication.SharedState",
      "com.vaadin.shared.AbstractComponentState",
      "com.vaadin.shared.ui.TabIndexState",
      "com.vaadin.shared.AbstractFieldState",
      "com.vaadin.shared.ui.abstractlisting.AbstractListingState",
      "com.vaadin.shared.ui.abstractmultiselect.AbstractMultiSelectState",
      "com.vaadin.shared.ui.twincolselect.TwinColSelectState",
      "com.vaadin.ui.AbstractField",
      "com.vaadin.ui.AbstractDateField",
      "com.vaadin.ui.AbstractLocalDateField",
      "com.vaadin.ui.DateField",
      "com.vaadin.shared.ui.datefield.DateResolution",
      "com.vaadin.data.HasValue$ValueChangeListener",
      "com.vaadin.event.EventRouter",
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
      "com.vaadin.shared.ui.AbstractSingleSelectState",
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
      "com.vaadin.ui.ProgressBar",
      "com.vaadin.shared.ui.progressindicator.ProgressBarState",
      "com.vaadin.ui.RichTextArea",
      "com.vaadin.ui.RichTextArea$RichTextAreaServerRpcImpl",
      "com.vaadin.shared.ui.richtextarea.RichTextAreaState",
      "com.vaadin.shared.ui.ValueChangeMode",
      "com.vaadin.data.HasValue$ValueChangeEvent",
      "com.vaadin.ui.AbstractMedia",
      "com.vaadin.ui.Video",
      "com.vaadin.shared.ui.AbstractMediaState",
      "com.vaadin.shared.ui.video.VideoState",
      "com.vaadin.ui.AbstractLocalDateTimeField",
      "com.vaadin.ui.DateTimeField",
      "com.vaadin.shared.ui.datefield.DateTimeResolution",
      "com.vaadin.ui.Slider",
      "com.vaadin.shared.ui.slider.SliderState",
      "com.vaadin.shared.ui.slider.SliderOrientation",
      "com.vaadin.shared.ui.datefield.AbstractDateFieldState",
      "com.vaadin.shared.ui.datefield.AbstractTextualDateFieldState",
      "com.vaadin.shared.ui.datefield.TextualDateFieldState",
      "com.vaadin.shared.ui.datefield.LocalDateTimeFieldState",
      "com.vaadin.ui.AbstractEmbedded",
      "com.vaadin.ui.Image",
      "com.vaadin.shared.ui.AbstractEmbeddedState",
      "com.vaadin.shared.ui.image.ImageState",
      "com.vaadin.data.BeanPropertySet",
      "com.vaadin.data.util.BeanUtil",
      "com.vaadin.data.BeanPropertySet$AbstractBeanPropertyDefinition",
      "com.vaadin.data.BeanPropertySet$BeanPropertyDefinition",
      "com.vaadin.ui.renderers.AbstractRenderer",
      "com.vaadin.ui.renderers.TextRenderer",
      "com.vaadin.ui.Grid$Column",
      "com.vaadin.ui.Grid$Column$1",
      "com.vaadin.shared.extension.abstractlisting.AbstractListingExtensionState",
      "com.vaadin.shared.ui.grid.AbstractGridExtensionState",
      "com.vaadin.shared.ui.grid.ColumnState",
      "com.vaadin.ui.components.grid.StaticSection$StaticCell",
      "com.vaadin.ui.components.grid.Header$Row$Cell",
      "com.vaadin.shared.ui.grid.SectionState$CellState",
      "com.vaadin.shared.ui.grid.GridStaticCellType",
      "com.vaadin.shared.util.SharedUtil",
      "com.vaadin.shared.communication.URLReference",
      "com.vaadin.server.ResourceReference",
      "com.vaadin.ui.Flash",
      "com.vaadin.shared.ui.flash.FlashState",
      "com.vaadin.ui.AbstractTextField",
      "com.vaadin.ui.TextArea",
      "com.vaadin.ui.AbstractTextField$AbstractTextFieldServerRpcImpl",
      "com.vaadin.ui.AbstractTextField$AbstractTextFieldFocusAndBlurRpcImpl",
      "com.vaadin.ui.RadioButtonGroup",
      "com.vaadin.ui.RadioButtonGroup$1",
      "com.vaadin.shared.ui.optiongroup.RadioButtonGroupState",
      "com.vaadin.ui.InlineDateTimeField",
      "com.vaadin.ui.Composite",
      "com.vaadin.ui.MenuBar",
      "com.vaadin.ui.MenuBar$MenuItem",
      "com.vaadin.ui.AbstractColorPicker",
      "com.vaadin.ui.ColorPickerArea",
      "com.vaadin.shared.ui.colorpicker.Color",
      "com.vaadin.ui.AbstractColorPicker$PopupStyle",
      "com.vaadin.shared.ui.colorpicker.AbstractColorPickerState",
      "com.vaadin.shared.ui.colorpicker.ColorPickerAreaState",
      "com.vaadin.server.ClientConnector$DetachListener",
      "com.vaadin.event.ConnectorEvent",
      "com.vaadin.server.ClientConnector$DetachEvent",
      "com.vaadin.ui.Embedded",
      "com.vaadin.shared.ui.embedded.EmbeddedState",
      "com.vaadin.ui.CheckBox",
      "com.vaadin.shared.ui.checkbox.CheckBoxState",
      "com.vaadin.shared.ui.datefield.LocalDateFieldState",
      "com.vaadin.ui.AbstractSingleComponentContainer",
      "com.vaadin.ui.Panel",
      "com.vaadin.ui.Window",
      "com.vaadin.shared.ui.AbstractSingleComponentContainerState",
      "com.vaadin.shared.ui.panel.PanelState",
      "com.vaadin.shared.ui.window.WindowState",
      "com.vaadin.shared.ui.window.WindowMode",
      "com.vaadin.shared.ui.window.WindowRole",
      "com.vaadin.ui.Window$1",
      "com.vaadin.event.Action",
      "com.vaadin.event.ShortcutAction",
      "com.vaadin.event.ShortcutListener",
      "com.vaadin.ui.Window$CloseShortcut",
      "com.vaadin.event.ActionManager",
      "com.vaadin.shared.ui.nativeselect.NativeSelectState",
      "com.vaadin.ui.Tree",
      "com.vaadin.ui.Tree$TreeRenderer",
      "com.vaadin.server.SizeWithUnit",
      "com.vaadin.event.ExpandEvent$ExpandListener",
      "com.vaadin.event.ListenerMethod",
      "com.vaadin.event.CollapseEvent$CollapseListener",
      "com.vaadin.shared.ui.ComponentStateUtil",
      "com.vaadin.ui.LoginForm",
      "com.vaadin.ui.UI",
      "com.vaadin.util.CurrentInstance",
      "com.vaadin.ui.ComboBox",
      "com.vaadin.ui.ComboBox$2",
      "com.vaadin.ui.ComboBox$2$1",
      "com.vaadin.ui.ComboBox$1",
      "com.vaadin.shared.ui.combobox.ComboBoxState",
      "com.vaadin.ui.Grid$1",
      "com.vaadin.ui.components.grid.Footer$Row",
      "com.vaadin.ui.AbstractComponentContainer",
      "com.vaadin.ui.TabSheet",
      "com.vaadin.ui.Accordion",
      "com.vaadin.ui.TabSheet$TabsheetServerRpcImpl",
      "com.polimi.travlendar.gmaps.DefaultCaptionGenerator"
    );
  }
}
