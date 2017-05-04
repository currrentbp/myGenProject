package com.bp.util.all;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * 资源UTIL
 *
 * @author current_bp
 * @createTime 20170504
 */
public class PropertiesUtil {

    private static Map<String ,ResourceBundle> configs ;
    private ResourceBundle currentConfig ;

    public static PropertiesUtil getInstance(String file){
        if(null == configs){
            synchronized (PropertiesUtil.class){
                if(null == configs){
                    configs = new HashMap<String, ResourceBundle>();
                }
            }
        }
        if(null != configs.get(file)){
            ResourceBundle conf = configs.get(file);
            PropertiesUtil propertiesUtil = new PropertiesUtil();
            propertiesUtil.setCurrentConfig(conf);
            return propertiesUtil;
        }else {
            ResourceBundle conf = ResourceBundle.getBundle(file);
            configs.put(file, conf);
            PropertiesUtil propertiesUtil = new PropertiesUtil();
            propertiesUtil.setCurrentConfig(conf);
            return propertiesUtil;
        }

    }

    public String getValueByKey(String key){
        return currentConfig.getString(key);
    }



    //==================== get set function ===============================================================//
    public ResourceBundle getCurrentConfig() {
        return currentConfig;
    }

    public void setCurrentConfig(ResourceBundle currentConfig) {
        this.currentConfig = currentConfig;
    }
}
