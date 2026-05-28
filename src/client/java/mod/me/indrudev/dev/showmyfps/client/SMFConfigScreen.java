package mod.me.indrudev.dev.showmyfps.client;

import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionDescription;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.w3c.dom.Text;

public class SMFConfigScreen {


    public static Screen create(Screen parent) {

        return YetAnotherConfigLib.createBuilder()
                .title(Component.literal("Show My FPS Config"))
                .save(SMFConfigManager::save)
                .category(ConfigCategory.createBuilder()
                        .name(Component.literal("Settings"))
                        .tooltip(Component.literal("Settings for Show My FPS."))

                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Show FPS"))
                                .description(OptionDescription.of(Component.literal("Whether to show the FPS on screen or not.")))
                                .binding(
                                        true,
                                        () -> SMFConfig.CONFIG.FPS,
                                        fpsVal -> SMFConfig.CONFIG.FPS = fpsVal
                                )
                                        .controller(TickBoxControllerBuilder::create)
                                        .build()
                        )

                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Show MSPT / Ping"))
                                .description(OptionDescription.of(Component.literal("Whether to show the MSPT or Ping on screen or not.")))
                                .binding(
                                        true,
                                        () -> SMFConfig.CONFIG.MSPT,
                                        val -> SMFConfig.CONFIG.MSPT = val
                                )
                                .controller(TickBoxControllerBuilder::create)
                                .build()
                        )

                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Show Memory Usage"))
                                .description(OptionDescription.of(Component.literal("Whether to show Memory Usage or not.")))
                                .binding(
                                        true,
                                        () -> SMFConfig.CONFIG.Mem,
                                        memVal -> SMFConfig.CONFIG.Mem = memVal
                                )
                                .controller(TickBoxControllerBuilder::create)
                                .build())
                        .build()
                )
                .build()
                .generateScreen(parent);


    }

}
