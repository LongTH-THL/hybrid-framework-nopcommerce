package pageUIs.user;

public class BasePageUI {
    public static String CUSTOMER_LINK = "xpath=//div[@class='listbox']//a[text()='Customer info']";
    public static String ADDRESSES_LINK = "xpath=//div[@class='listbox']//a[text()='Addresses']";
    public static String ORDER_LINK = "xpath=//div[@class='listbox']//a[text()='Orders']";
    public static String DOWNLOADABLE_PRODUCT_LINK = "xpath=//div[@class='listbox']//a[text()='Downloadable products']";
    public static String BACK_IN_STOCK_SUBSCRIPTIONS_LINK = "xpath=//div[@class='listbox']//a[text()='Back in stock subscriptions']";
    public static String REWARD_POINT_LINK = "xpath=//div[@class='listbox']//a[text()='Reward points']";
    public static String CHANGE_PASSWORD_LINK = "xpath=//div[@class='listbox']//a[text()='Change password']";
    public static String MY_PRODUCT_REVIEWS_LINK = "xpath=//div[@class='listbox']//a[text()='My product reviews']";
    public static String LOGOUT_LINK_USER = "xpath=//a[@class='ico-logout']";
    public static String LOGOUT_LINK_ADMIN = "xpath=//div[@id='navbarText']//a[text()='Logout']";

    public static String DYNAMIC_PAGE_AT_MY_ACCOUT_AREA = "xpath=//div[@class='listbox']//a[text()='%s']";

    public static void main(String[] args){
        clickToSideBarLink(DYNAMIC_PAGE_AT_MY_ACCOUT_AREA,"Customer info");
        clickToSideBarLink(DYNAMIC_PAGE_AT_MY_ACCOUT_AREA,"Addresses");
        clickToSideBarLink(DYNAMIC_PAGE_AT_MY_ACCOUT_AREA,"Reward points");
        clickToSideBarLink(DYNAMIC_PAGE_AT_MY_ACCOUT_AREA,"My product reviews");
    }

    // hàm có 1-n tham số động -> sử dụng hàm này để truyền tham số
    public static void clickToSideBarLink(String dynamicLocator, String... params){
        String locator = String.format(dynamicLocator, (Object[]) params);
        System.out.println("Click to: " + locator);
    }
}
