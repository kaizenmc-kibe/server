package com.minecraft.core.backend.mariadb.config;

import com.minecraft.core.Constant;
import lombok.Builder;
import lombok.Value;
@Value
@Builder
public class MariaConfig {
    @Builder.Default
    int maxPoolSize = 10;
    public String url() {
        return "jdbc:mariadb://" + Constant.backend_host + ":" + Constant.port + "/" + Constant.backend_name + "?maxPoolSize=" + maxPoolSize;
    }
}
