package com.nhattruongnguyen.ckfinder.config;

import com.cksource.ckfinder.config.Config;
import org.springframework.stereotype.Component;

public class CustomConfig extends Config {
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    private boolean enabled = false;
}
