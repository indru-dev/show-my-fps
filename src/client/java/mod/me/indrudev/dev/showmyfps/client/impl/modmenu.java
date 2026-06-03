package mod.me.indrudev.dev.showmyfps.client.impl;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import mod.me.indrudev.dev.showmyfps.client.config;

public class modmenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> config.create(parent);
    }
}
