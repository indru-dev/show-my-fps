package mod.me.indrudev.dev.showmyfps.client;

import net.minecraft.client.Minecraft;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.Minecraft;

public class ShowMyFPSClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		Runtime runtime = Runtime.getRuntime();

		HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
			Minecraft client = Minecraft.getInstance();

			if(client.player == null) return;

			int fps = client.getFps();
			int mspt = 0;
			int ping = 0;

			double smoothramperc = 0;
			double smoothram = 0;
			long usedram = (runtime.totalMemory() - runtime.freeMemory()) /1024 /1024;
			long maxram = runtime.maxMemory() /1024 /1024;
			double ramperc = (usedram / (double)maxram) * 100;

			if(smoothram == 0) {
				smoothram = usedram;
			} else {
				smoothram = (usedram - smoothram) * 0.5;
			}
			smoothramperc = ((ramperc - smoothramperc)) * 0.5;

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

			String ram = String.format(
					"Memory: %d MB (%.1f%%)",
					(long)smoothram,
					smoothramperc
			);

			drawContext.drawString(
					client.font,
					ram,
					5,
					25,
					0x00FF00
			);

		});
	}
}