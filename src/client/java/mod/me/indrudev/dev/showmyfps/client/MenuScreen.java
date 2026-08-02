package mod.me.indrudev.dev.showmyfps.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;

public class MenuScreen {

    public static void listenForPress(KeyMapping keymapping) {

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(client.player != null) {
                while (keymapping.consumeClick()) {
                    Minecraft.getInstance().setScreen(config.create(null));
                }
            }
        });

    }

}
