package com.minecraft.core.backend.mariadb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MariaConfigTest {

    @Test
    void usesDefaults() {
        MariaConfig config = MariaConfig.builder().database("flame").username("root").build();

        assertEquals("jdbc:mariadb://localhost:3306/flame?maxPoolSize=10", config.url());
        assertEquals("", config.getPassword());
    }

    @Test
    void usesCustomValues() {
        MariaConfig config = MariaConfig.builder().host("db.example.com").port(3307).database("core").username("flame").password("secret").maxPoolSize(4).build();

        assertEquals("jdbc:mariadb://db.example.com:3307/core?maxPoolSize=4", config.url());
    }

    @Test
    void databaseAndUsernameAreRequired() {
        assertThrows(NullPointerException.class, () -> MariaConfig.builder().username("root").build());
        assertThrows(NullPointerException.class, () -> MariaConfig.builder().database("flame").build());
    }
}
