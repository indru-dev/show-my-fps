package mod.me.indrudev.dev.showmyfps.client;

import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionDescription;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.api.controller.ColorControllerBuilder;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import mod.me.indrudev.dev.showmyfps.client.data.data;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.awt.*;

public class config {

    public static Screen create(Screen parent) {

        return YetAnotherConfigLib.createBuilder()
                .title(Component.literal("SMF Config"))
                .category(ConfigCategory.createBuilder()
                        .name(Component.literal("Basic Settings"))
                        .tooltip(Component.literal("Settings for basic things about the SMF Monitor."))

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

                .category(ConfigCategory.createBuilder()
                        .name(Component.literal("Advanced Settings"))
                        .tooltip(Component.literal("Advanced Options like Components (W.I.P) and Colors"))

                        .option(Option.<Color>createBuilder()
                                .name(Component.literal("Color for FPS Monitor"))
                                .description(OptionDescription.of(Component.literal("Color for the FPS Monitor.")))
                                .binding(
                                        Color.WHITE,
                                        () -> data.get().colfps,
                                        col -> data.get().colfps = col
                                ).controller(ColorControllerBuilder::create)
                                .build())

                        .option(Option.<Color>createBuilder()
                                .name(Component.literal("Color for MSPT Monitor"))
                                .description(OptionDescription.of(Component.literal("Color for the MSPT Monitor.")))
                                .binding(
                                        Color.WHITE,
                                        () -> data.get().colmspt,
                                        col -> data.get().colmspt = col
                                ).controller(ColorControllerBuilder::create)
                                .build())

                        .option(Option.<Color>createBuilder()
                                .name(Component.literal("Color for Memory Monitor"))
                                .description(OptionDescription.of(Component.literal("Color for the Memory Monitor.")))
                                .binding(
                                        Color.WHITE,
                                        () -> data.get().colmem,
                                        col -> data.get().colmem = col
                                ).controller(ColorControllerBuilder::create)
                                .build())

                        .build())

                .save(data.HANDLER::save)
                .build()
                .generateScreen(parent);

    }

}
