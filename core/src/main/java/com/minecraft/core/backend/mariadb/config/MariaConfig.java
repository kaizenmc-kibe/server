package com.minecraft.core.backend.mariadb;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class MariaConfig {

    @NonNull
    @Builder.Default
    String host = "localhost";

    @Builder.Default
    int port = 3306;

    @NonNull
    String database;

    @NonNull
    String username;

    @NonNull
    @Builder.Default
    String password = "";

    @Builder.Default
    int maxPoolSize = 10;

    public String url() {
        return "jdbc:mariadb://" + host + ":" + port + "/" + database + "?maxPoolSize=" + maxPoolSize;
    }
}
