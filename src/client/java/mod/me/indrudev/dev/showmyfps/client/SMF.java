package mod.me.indrudev.dev.showmyfps.client;
import com.mojang.blaze3d.platform.InputConstants;
import mod.me.indrudev.dev.showmyfps.client.data.data;
import mod.me.indrudev.dev.showmyfps.client.runtime.icex.InvalidConfigExceptionICEX;
import mod.me.indrudev.dev.showmyfps.ignoreSMF;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

import javax.swing.text.JTextComponent;

public class SMF implements ClientModInitializer {

	public static KeyMapping menuBinding;

	@Override
	public void onInitializeClient() {

		try {
			data.HANDLER.load();
		} catch(InvalidConfigExceptionICEX e) {
            ignoreSMF.LOGGER.error("Config File Could Not be Found<config/showmyfps-conf.json>({})", String.valueOf(e));
		} finally {
			ignoreSMF.LOGGER.info("Initializing Show My FPS...");
		}

		menuBinding = KeyBindingHelper.registerKeyBinding(new KeyMapping(
				"key.smf.open_config_screen",
				InputConstants.Type.KEYSYM,
				GLFW.GLFW_KEY_RIGHT_ALT,                // Default key bind is set to 'AltGr'
				"key.categories.smf"
		));

		MenuScreen.listenForPress(menuBinding);

		HUD.Render();


	}
}