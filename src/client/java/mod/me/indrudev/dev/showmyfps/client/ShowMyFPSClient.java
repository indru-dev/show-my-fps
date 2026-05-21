package mod.me.indrudev.dev.showmyfps.client;

import net.minecraft.client.Minecraft;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.Minecraft;

public class ShowMyFPSClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
			Minecraft client = Minecraft.getInstance();

			if(client.player == null) return;

			int fps = client.getFps();
			int mspt = 0;

			if(client.getSingleplayerServer() != null) {
				mspt = (int)client.getSingleplayerServer().getAverageTickTimeNanos() / 1000000;
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
					"@ " + mspt + " ms",
					5,
					15,
					0x00FF00
			);
		});
	}
}