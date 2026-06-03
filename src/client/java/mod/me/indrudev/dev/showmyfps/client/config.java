package mod.me.indrudev.dev.showmyfps.client;

import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionDescription;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import mod.me.indrudev.dev.showmyfps.client.data.data;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class config {

    public static Screen create(Screen parent) {

        return YetAnotherConfigLib.createBuilder()
                .title(Component.literal("SMF Config"))
                .category(ConfigCategory.createBuilder()
                        .name(Component.literal("SMF Settings"))
                        .tooltip(Component.literal("Settings for the SMF FPS Monitor."))

                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Enable FPS Monitor"))
                                .description(OptionDescription.of(Component.literal("Enables/Disables the FPS Monitor.")))
                                .binding(
                                        true,
                                        () -> data.get().fps,
                                        fps -> data.get().fps = fps
                                )
                                .controller(TickBoxControllerBuilder::create)
                                .build())

                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Enable MSPT/Ping Monitor"))
                                .description(OptionDescription.of(Component.literal("Enables/Disables the MSPT Monitor in Singleplayer and Ping Monitor in Multiplayer.")))
                                .binding(
                                        true,
                                        () -> data.get().mspt,
                                        mspt -> data.get().mspt = mspt
                                )
                                .controller(TickBoxControllerBuilder::create)
                                .build())

                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Enable Memory Usage Monitor"))
                                .description(OptionDescription.of(Component.literal("Enables/Disables the Memory Usage Monitor, the part which displays the Memory Usage in Megabytes.")))
                                .binding(
                                        false,
                                        () -> data.get().mem,
                                        mem -> data.get().mem = mem
                                )
                                .controller(TickBoxControllerBuilder::create)
                                .build())

                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Enable Memory Utility Monitor"))
                                .description(OptionDescription.of(Component.literal("Enables/Disables the Memory Usage Monitor, the part which displays the Memory Usage in Percentage.")))
                                .binding(
                                        true,
                                        () -> data.get().perc,
                                        perc -> data.get().perc = perc
                                )
                                .controller(TickBoxControllerBuilder::create)
                                .build())

                        .build())

                .save(data.HANDLER::save)
                .build()
                .generateScreen(parent);

    }

}
