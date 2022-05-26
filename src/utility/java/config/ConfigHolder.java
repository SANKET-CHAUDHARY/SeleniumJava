package config;

public class ConfigHolder{

    static final String USER_NAME_PROPERTY = "username";
    static final String PASSWORD_PROPERTY = "password";
    static final String BASE_URL_PROPERTY = "url";
    static final String BROWSER_PROPERTY = "browser";
    static final String ENV_PROPERTY = "env";

    public static ConfigFileReader configFileReader = new ConfigFileReader();

    static {
        if(System.getProperty(USER_NAME_PROPERTY)== null){
            System.setProperty(USER_NAME_PROPERTY,configFileReader.getUserName());
        }if(System.getProperty(PASSWORD_PROPERTY)== null){
            System.setProperty(PASSWORD_PROPERTY,configFileReader.getPassword());
        }if(System.getProperty(BASE_URL_PROPERTY)== null){
            System.setProperty(BASE_URL_PROPERTY,configFileReader.getBaseUrl());
        }if(System.getProperty(BROWSER_PROPERTY)== null){
            System.setProperty(BROWSER_PROPERTY,configFileReader.getBrowser());
        }if(System.getProperty(ENV_PROPERTY)== null){
            System.setProperty(ENV_PROPERTY,configFileReader.getEnv());
        }
    }


    public static String getUserName(){
        return System.getProperty(USER_NAME_PROPERTY);
    } public static String getPassword(){
        return System.getProperty(PASSWORD_PROPERTY);
    }
    public static String getBrowser(){
        return System.getProperty(BROWSER_PROPERTY);
    }

    public static String getEnv(){
        return System.getProperty(ENV_PROPERTY);
    }

    public static String getUrl(){
        if(System.getProperty(ENV_PROPERTY).equalsIgnoreCase("local")){
            return "https://local."+System.getProperty(BASE_URL_PROPERTY);
        }if(System.getProperty(ENV_PROPERTY).equalsIgnoreCase("test")){
            return "https://test."+System.getProperty(BASE_URL_PROPERTY);
        }if(System.getProperty(ENV_PROPERTY).equalsIgnoreCase("staging")){
            return "https://staging."+System.getProperty(BASE_URL_PROPERTY);
        }if(System.getProperty(ENV_PROPERTY).equalsIgnoreCase("prod")){
            return "https://www."+System.getProperty(BASE_URL_PROPERTY);
        }else{
            return "https://local."+System.getProperty(BASE_URL_PROPERTY);
        }
    }
}
