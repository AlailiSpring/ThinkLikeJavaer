package com.alalili.common.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlCharReplaceTest {
    public static void main(String[] args) {
        String sqlQuery = "select A.*, B.* from A, B where A.id = B.id and A.c1 = #{bgq} and B.c2 = #{bgq} and b.C4=#{bgq}";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("bgq", "20220101");

        List<Object> paramValues = new ArrayList<>();

        String replacedColumn = "";
        for (Map.Entry<String, Object> stringObjectEntry : paramMap.entrySet()) {
            replacedColumn = "#\\{" + stringObjectEntry.getKey() + "\\}";
            do {
                sqlQuery = sqlQuery.replaceFirst(replacedColumn, "?");
                paramValues.add(stringObjectEntry.getValue());
            } while (sqlQuery.contains(stringObjectEntry.getKey()));
        }


        System.out.println("Replaced Query: " + sqlQuery);
        System.out.println("Param Values: " + paramValues);


        String testOrgCode = "110100000000";
        System.out.println(getTargetLevelFullOrgCode(testOrgCode, 3));
    }


    public static String getManagePlaceCodingRulesBitCode(String processPlace,Integer level){
        return processPlace.substring(0,getCodingRulesBitLength("0,2,2,2,3,3",level));
    }

    public static String getTargetLevelFullOrgCode(String processPlace,Integer level) {
        String countryCode = "000000000000";
        Integer cutNumber = getCodingRulesBitLength("0,2,2,2,3,3", level);
        return getManagePlaceCodingRulesBitCode(processPlace, level) + countryCode.substring(cutNumber, 12);
    }


    public static Integer getCodingRulesBitLength(String codingRules,Integer level){
        Integer index = 0;
        String[] codingRuleArr = codingRules.split(",");
        for(int i=0;i<level;i++){
            index+=Integer.parseInt(codingRuleArr[i]);
        }
        return index;
    }

}
