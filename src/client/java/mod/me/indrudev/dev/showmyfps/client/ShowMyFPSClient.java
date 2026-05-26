package mod.me.indrudev.dev.showmyfps.client;

import net.minecraft.client.Minecraft;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.Minecraft;

public class ShowMyFPSClient implements ClientModInitializer {
	final Runtime runtime = Runtime.getRuntime();

	@Override
	public void onInitializeClient() {

		//If you're reading this, this is a kinda deprecated method, by that I mean DEPRECATED deprecated.
		//It's much better to use HudElementRegistry, but it doesn't work for me.
		//And this is fine for this version anyway.
		HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
			Minecraft client = Minecraft.getInstance();
			long time = System.currentTimeMillis();

			if(client.player == null) return;

			int fps = client.getFps();
			int mspt = 0;
			int ping = 0;
			long memoryUpdate = 0;
			String cachedMemory = "";

			if(time - memoryUpdate >= 1000) {
				long usedram = (runtime.totalMemory() - runtime.freeMemory()) /1024 /1024;
				long maxram = runtime.maxMemory() /1024 /1024;
				double ramperc = (usedram / (double)maxram) * 100;

				cachedMemory = String.format(
						"Memory: %d MB (%.1f%%)",
						usedram,
						ramperc
				);

				memoryUpdate = time;
			}

			if(client.getSingleplayerServer() != null) {
				mspt = (int)client.getSingleplayerServer().getAverageTickTimeNanos() / 1000000;

				drawContext.drawString(
						client.font,
						"@ " + mspt + " ms",
						5,
						15,
						0x00FF00
				);
			} else {
				ping = (int)client.getConnection().getPlayerInfo(client.player.getUUID()).getLatency();

				drawContext.drawString(
						client.font,
						ping + " ms",
						5,
						15,
						0x00FF00
				);
			}

			drawContext.drawString(
					client.font,
					"FPS: " + fps,
					5,
					5,
					0x00FF00
			);

			drawContext.drawString(
					client.font,
					cachedMemory,
					5,
					25,
					0x00FF00
			);

		});
	}
}