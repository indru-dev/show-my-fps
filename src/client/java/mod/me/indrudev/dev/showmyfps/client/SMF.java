package mod.me.indrudev.dev.showmyfps.client;
import mod.me.indrudev.dev.showmyfps.client.runtime.icex.ICEXloader;
import mod.me.indrudev.dev.showmyfps.client.data.data;
import mod.me.indrudev.dev.showmyfps.client.runtime.icex.InvalidConfigExceptionICEX;
import mod.me.indrudev.dev.showmyfps.ignoreSMF;
import net.fabricmc.api.ClientModInitializer;

public class SMF implements ClientModInitializer {

	ICEXloader icex = ICEXloader.getLoader();

	@Override
	public void onInitializeClient() {

		try {
			icex.loadConfig();
		} catch(InvalidConfigExceptionICEX e) {
			ignoreSMF.LOGGER.info("Config File Could Not be Found<config/showmyfps-conf.json>(" + e + ")");
		} finally {
			ignoreSMF.LOGGER.info("Initializing Show My FPS...");
		}


		HUD.Render();


	}
}