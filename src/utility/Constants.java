package utility;

public class Constants
{
	public static String xPathItemManagementPageTitle = "/html/body[@class='no-skin']/div[@id='main-container']/div[@id='main-content']/div[@class='main-content']/div[@class='page-content']/div[@class='page-content-area']/div[@class='page-header']/h1";
	public static String xPathLocationManagementPageTitle = "/html/body[@class='no-skin']/div[@id='main-container']/div[@id='main-content']/div[@class='main-content']/div[@class='page-content']/div[@class='page-content-area']/div[@class='page-header']/h1";
	
	public static String xPathAdminLeftNav = "/html/body[@class='no-skin']/div[@id='main-container']/div[@id='sidebar']/ul[@class='nav nav-list']/li[@class='hsub'][1]/a[@class='dropdown-toggle']/span[@class='menu-text']";
	public static String xPathItemLeftNav = "//*[@id='sidebar']/ul/li[2]/ul/li[1]/a";
	public static String xPathLocationLeftNav = "/html/body[@class='no-skin']/div[@id='main-container']/div[@id='sidebar']/ul[@class='nav nav-list']/li[@class='hsub open']/ul[@class='submenu nav-show']/li[@class='hsub'][2]/a[@class='dropdown-toggle']";
	public static String xPathUserLeftNav = "/html/body[@class='no-skin']/div[@id='main-container']/div[@id='sidebar']/ul[@class='nav nav-list']/li[@class='hsub open']/ul[@class='submenu nav-show']/li[@class='hsub open']/a[@class='dropdown-toggle']";
	
	public static String xPathAddItemPageGaugeRadioButton = "/html/body[@class='no-skin']/div[@id='main-container']/div[@id='main-content']/div[@class='main-content']/div[@class='page-content']/div[@class='page-content-area']/div[@class='row']/div[@class='col-xs-6'][1]/div[@class='widget-box']/div[@class='widget-body']/div[@class='widget-main']/form[@id='createItemFrom']/div[@id='step-container']/div[@id='step1']/div[@class='form-group'][6]/div[@class='col-xs-12 col-sm-5']/span[@class='block input-icon input-icon-right']/label[@class='radio-inline'][1]";
	public static String xPathAddLocationPageFactoryRadioButton = "/html/body[@class='no-skin']/div[@id='main-container']/div[@id='main-content']/div[@class='main-content']/div[@class='page-content']/div[@class='page-content-area']/div[@class='row']/div[@class='col-xs-6'][1]/div[@class='widget-box']/div[@class='widget-body']/div[@class='widget-main']/form[@id='createLocationForm']/div[@id='step-container']/div[@id='step1']/div[@class='form-group'][6]/div[@class='col-xs-12 col-sm-5']/span[@class='block input-icon input-icon-right']/label[@class='radio-inline'][1]";
	
	public static String xPathDeactivateItemButton = "/html/body[@class='no-skin']/div[@id='main-container']/div[@id='main-content']/div[@class='main-content']/div[@class='page-content']/div[@class='row']/div[@class='col-xs-12']/div[@class='row']/div[@class='col-xs-12']/div[2]/div[@id='item-table_wrapper']/table[@id='item-table']/tbody/tr[@class='even'][2]/td[8]/div[@id='table-buttons']/a[@class='red']/i[@class='ace-icon fa fa-ban bigger-130']";
	public static String xPathItemManagementPageEditItemButton = "/html/body[@class='no-skin']/div[@id='main-container']/div[@id='main-content']/div[@class='main-content']/div[@class='page-content']/div[@class='page-content-area']/div[@class='row']/div[@class='col-xs-12']/div[2]/div[@id='user-profile-1']/div[@class='col-xs-12 col-sm-9']/div[@class='profile-user-info profile-user-info-striped']/div[@class='profile-info-row'][8]/a[@class='btn btn-lg btn-success']";
	public static String xPathLocationManagementPageEditLocationButton = "/html/body[@class='no-skin']/div[@id='main-container']/div[@id='main-content']/div[@class='main-content']/div[@class='page-content']/div[@class='page-content-area']/div[@class='row']/div[@class='col-xs-12']/div[2]/div[@id='user-profile-1']/div[@class='col-xs-12 col-sm-9']/div[@class='profile-user-info profile-user-info-striped']/div[@class='profile-info-row'][6]/a[@class='btn btn-lg btn-success']";
	
	public static String idGoToAddItem = "goToAddItem";
	public static String idGoToAllItems = "goToAllItems";
	public static String idGoToAddLocation = "goToAddLocation";
	public static String idGoToAllLocations = "goToAllLocations";
	public static String idGoToAddUser = "goToAddUser";
	public static String idGoToAllUsers = "goToAllUsers";
}
