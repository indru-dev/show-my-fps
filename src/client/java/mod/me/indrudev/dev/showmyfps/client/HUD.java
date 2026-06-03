package mod.me.indrudev.dev.showmyfps.client;


import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import mod.me.indrudev.dev.showmyfps.client.data.data;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;

public class HUD {
    private static String cached = "";
    private static long lastUpdate = 0;

    public static void Render() {
        HudRenderCallback.EVENT.register((gui, tickDelta) -> {

            Minecraft client = Minecraft.getInstance();
            final Runtime runtime = Runtime.getRuntime();
            long time = Util.getMillis();
            Font font = client.font;


            if(client.player == null) return;

            //FPS Monitor
            int fps = client.getFps();

            //MSPT/Ping Monitor
            long mspt = 0;
            long ping = 0;

            if(client.getSingleplayerServer() != null) {
                mspt = client.getSingleplayerServer().getAverageTickTimeNanos() / 1000000;
            } else {
                ping = client.getConnection().getPlayerInfo(client.player.getUUID()).getLatency();
            }

            //Memory Monitor
            long used = 0;
            long max = 0;
            double perc = 0;

            used = (runtime.totalMemory() - runtime.freeMemory()) /1024 /1024;
            max = runtime.totalMemory() /1024 /1024;
            perc = (used / (double)max) * 100;

            //Display
            if(data.get().fps) {
                gui.drawString(
                        font,
                        "FPS: " + fps,
                        5, 5,
                        0xFFFFFF
                );
            }
            if(client.getSingleplayerServer() != null) {
                if(data.get().mspt && data.get().fps) {
                    gui.drawString(
                            font,
                            "@ " + mspt + " ms",
                            5, 15,
                            0xFFFFFF
                    );
                } else if(data.get().mspt) {
                    gui.drawString(
                            font,
                            "@ " + mspt + " ms",
                            5, 5,
                            0xFFFFFF
                    );
                } else {
                    if (data.get().mspt && data.get().fps) {
                        gui.drawString(
                                font,
                                "@ " + ping + " ms",
                                5, 15,
                                0xFFFFFF
                        );
                    } else if (data.get().mspt) {
                        gui.drawString(
                                font,
                                "@ " + ping + " ms",
                                5, 5,
                                0xFFFFFF
                        );
                    }
                }
            }


            int memloc = 0;


            if(data.get().fps && data.get().mspt) {
                memloc = 25;
            } else if(data.get().fps) {
                memloc = 15;
            } else if(data.get().mspt) {
                memloc = 15;
            } else {
                memloc = 5;
            }

            if(data.get().mem && data.get().perc) {
                cached = String.format(
                        "Memory: %d (%.1f%%)",
                        used, perc
                );

                gui.drawString(
                        font,
                        cached,
                        5, memloc,
                        0xFFFFFF
                );
            } else if(data.get().mem) {
                cached = String.format(
                        "Memory: %d", used
                );

                gui.drawString(
                        font,
                        cached,
                        5, memloc,
                        0xFFFFFF
                );
            } else if(data.get().perc) {
                cached = String.format(
                        "Memory: %.1f%%", perc
                );

                gui.drawString(
                        font,
                        cached,
                        5, memloc,
                        0xFFFFFF
                );
            }




        });
    }

}
