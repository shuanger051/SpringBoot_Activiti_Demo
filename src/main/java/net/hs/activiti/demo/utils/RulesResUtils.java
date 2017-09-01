package net.hs.activiti.demo.utils;

/**
 * Project ： net.hs.activiti.demo
 * PackageName ： net.hs.activiti.demo.utils
 * Author ： caijl
 * Date ： 2017/8/15
 * Time ： 10:55
 * Description :
 * 系统版本 ： 1.0
 */
public class RulesResUtils {

    /**
     * 返回对比结果，不符合条件则返回false
     * @param realVal Bean实体类参数值
     * @param compareType 比较类型
     * @param ruleVal 规则值
     * @return
     */
    public static boolean compareRealValAndRuleVal(String realVal,String compareType,String ruleVal){
        boolean flag = true;
        if(">".equals(compareType.trim())){
            if (Long.parseLong(realVal) > Long.parseLong(ruleVal)){}else {flag = false;}
        }else if("<".equals(compareType.trim())){
            if (Long.parseLong(realVal) < Long.parseLong(ruleVal)){}else {flag = false;}
        }else if("!=".equals(compareType.trim())){
            if (Long.parseLong(realVal) != Long.parseLong(ruleVal)){}else {flag = false;}
        }else if(">=".equals(compareType.trim())){
            if (Long.parseLong(realVal) >= Long.parseLong(ruleVal)){}else {flag = false;}
        }else if("<=".equals(compareType.trim())){
            if (Long.parseLong(realVal) <= Long.parseLong(ruleVal)){}else {flag = false;}
        }else if("==".equals(compareType.trim())){
            if (realVal.equals(ruleVal)){}else {flag = false;}
        }
        return flag;
    }

}
