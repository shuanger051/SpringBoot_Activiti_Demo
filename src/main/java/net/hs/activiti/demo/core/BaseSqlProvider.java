package net.hs.activiti.demo.core;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Author: caijl
 * Package:net.hs.activiti.demo.core
 * Project:ActivitiDemo
 * Description:
 * Date: 2017/7/25
 * Time: 18:56
 * 系统版本:1.0.0
 */
public class BaseSqlProvider {

    public static String getField(final String[] fields){
        return getField(fields,null);
    }

    public static final String SPECIFIC_CHARS = "_,%,*,$,^";

    public static String getField(final String[] srcFields, String aliasName){
        String[] fields = ArrayUtils.clone(srcFields);
        if(StringUtils.isNotBlank(aliasName)){
            for (int i = 0; i < fields.length; i++) {
                fields[i] = aliasName +"." + fields[i] + " as " + fields[i];
            }
        }
        return  StringUtils.join(fields,",");
    }

    /**
     * 校验是否存在通配符注入风险
     * @param params
     * @return
     */
    public static String getSpecificCharsArrFlag(String params){
        String[] paramArr = BaseSqlProvider.SPECIFIC_CHARS.split(",");
        for(int i = 0; i < paramArr.length; i++){
            if(params.trim().indexOf(paramArr[i]) != -1){
                params.replaceAll(paramArr[i],"/"+paramArr[i]);
            }
        }
        return params;
    }


}
