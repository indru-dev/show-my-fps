package mod.me.indrudev.dev.showmyfps.client;

import net.minecraft.client.Minecraft;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class ShowMyFPSClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {

		SMFConfigManager.load();
		SMFDisplay.display();

	}
}