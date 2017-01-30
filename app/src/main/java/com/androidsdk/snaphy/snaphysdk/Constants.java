package com.androidsdk.snaphy.snaphysdk;

/**
 * Created by Ravi-Gupta on 11/14/2016.
 */

public class Constants {

    //INSTA
    //https://github.com/TheLester/Instagram-Helper
    //https://github.com/lorensiuswlt/AndroidInstagram
    //http://www.theappguruz.com/blog/instagram-integration-android-application-tutorial

    public static final String SHA_DEBUG = "D6:E7:88:AB:D1:8E:4F:88:A8:0D:34:ED:6E:57:FC:9F:EB:8C:7B:CC";
    public static final String TAG = "BrandZoomr";
    public static String CLIENT_ID = "170595455668-0ce0q99ca54si9aap0c40bq5gd3kjbae.apps.googleusercontent.com";

    public static final String INSTA_CLIENT_ID = "dd2463be1d8b44d88ce8753366594761";
    public static final String INSTA_CLIENT_SECRET = "ba14234e59274f1380754edbf3f96ae3";
    public static final String INSTA_CALLBACK_URL = "http://www.brandzoomr.com";

    public static String baseUrl = "http://192.168.0.4:3001";
    //public static String baseUrl = "http://admin.orthopg.com";
    //public static String baseUrl = "http://ec2-54-209-33-191.compute-1.amazonaws.com:3000";
    public static String apiUrl = baseUrl+"/api";

    public static String LOOPBACK_APP_ID = "orthopg-snaphy-push-application";
    public static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    public static String SENDER_ID = "1045211377196";

    public static String LOGIN_CUSTOMER = "loginCustomer";

    public static final String AMAZON_CLOUD_FRONT_URL = "http://d3j3ux0h7dntsg.cloudfront.net";

    public static final String APP_MAIL = "brandzoomr@gmail.com";
    public static final String APP_PHONE = "tel:+91-96434";
    public static String APP_PLAY_STORE = "com.brandzoomr";
    public static String APP_SHARE_TEXT = "Know your brands better \n\n";

    /*PRESENTER*/
    public static String WEB_VIEW_INSTANCE = "webViewInstance";
    public static String DEAL_DETAILS = "dealsDetails";
    /*PRESENTER*/

     /*DATA LIST IDs*/
    public static final String BRAND_LIST_HOME_FRAGMENT = "Brand_Lits_Home_Fragment";
    public static final String REMOVE_BRAND_LIST_REMOVE_BRAND_FRAGMENT = "Remove_Brand_List_Remove_Brand_Fragment";
    public static final String DAILY_FEED_LIST_BRAND_DETAILS_FRAGMENT = "Daily_Feed_List_Brand_Detail_Fragment";
    public static final String CATEGORY_LIST_SELECT_CATEGORY_FRAGMENT = "Category_List_Select_Category_Fragment";
    public static final String ALL_BRANDS_SELECT_BRANDS_FRAGMENT = "All_Brands_Select_Brands_Fragment";
    public static final String TRENDING_BRANDS_TRENDING_BRANDS_FRAGMENT = "Trending_Brands_Tredning_Brands_Fragment";
    public static final String HOT_DEALS_HOT_DEALS_FRAGMENT = "Hot_Deals_Hot_Deals_Fragment";
    public static final String SAVED_DEALS_HOT_DEALS_FRAGMENT = "Saved_Deals_Hot_Deals_Fragment";
    public static final String CURRENT_ITEMS_SEARCH_LIST = "Current_Items_Search_List";
    public static final String BRANDS_IN_VIEW = "Brands_In_View";
     /*DATA LIST IDs*/

    /*LOGIN ID*/
    public static String GOOGLE_API_CLIENT = "googleApiClient";
    /*LOGIN ID*/


    /** MESSAGES **/
    public static String ERROR_MESSAGE = "Cannot login ! Try again later";
    public static String UPLOAD_ERROR = "Cannot Upload Image ! Try again";
    public static String ERROR_UPDATING_MCI = "Cannot Update MCI! Try again later";
    public static String ERROR_UPDATING_NAME = "Cannot Update Name! Try again later";
    public static String ERROR_FIRST_NAME_EMPTY = "First Name cannot be empty";
    public static String CASE_UPLOAD_ERROR = "Cannot Save! Check your network";
    public static String HEADING_REQUIRED_MESSAGE = "Heading cannot be blank";
    public static String DELETE_BRAND = "Sure delete this brand?";
    public static String NEW_BRAND_ADDED = "New Brand has been added";
    /** MESSAGES **/
}
