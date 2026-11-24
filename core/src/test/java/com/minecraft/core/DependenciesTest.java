package com.minecraft.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DependenciesTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "com.google.gson.Gson",
            "org.json.JSONObject",
            "redis.clients.jedis.JedisPool",
            "org.mariadb.jdbc.Driver"
    })
    void dependencyIsOnTheClasspath(String className) {
        assertDoesNotThrow(() -> Class.forName(className));
    }
}
