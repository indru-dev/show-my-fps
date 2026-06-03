package mod.me.indrudev.dev.showmyfps.client;

import mod.me.indrudev.dev.showmyfps.client.data.data;
import mod.me.indrudev.dev.showmyfps.ignoreSMF;
import net.fabricmc.api.ClientModInitializer;

public class SMF implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		ignoreSMF.LOGGER.info("Initializing SMF Configuration Mappings and Values...");
		data.HANDLER.load();

		ignoreSMF.LOGGER.info("Initializing SMF(Show My FPS)...");
		HUD.Render();


	}
}