package mod.me.indrudev.dev.showmyfps.client;

import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionDescription;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.api.controller.ColorControllerBuilder;
import dev.isxander.yacl3.api.controller.StringControllerBuilder;
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
                        .name(Component.literal("FPS Monitor"))
                        .tooltip(Component.literal("Settings for FPS Monitor"))

                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Enable"))
                                .description(OptionDescription.of(Component.literal("Enable FPS Monitor?")))
                                .binding(
                                        true,
                                        () -> data.get().fps,
                                        en -> data.get().fps = en
                                ).controller(TickBoxControllerBuilder::create)
                                .build())

                        .option(Option.<Color>createBuilder()
                                .name(Component.literal("Color"))
                                .description(OptionDescription.of(Component.literal("Color of FPS Monitor")))
                                .binding(
                                        Color.WHITE,
                                        () -> data.get().colfps,
                                        col -> data.get().colfps = col
                                ).controller(ColorControllerBuilder::create)
                                .build())

                        .option(Option.<String>createBuilder()
                                .name(Component.literal("Component"))
                                .description(OptionDescription.of(Component.literal("Text showed on the FPS Monitor. Default is 'FPS:''")))
                                .binding(
                                        "FPS: ",
                                        () -> data.get().strfps,
                                        str -> data.get().strfps = str
                                ).controller(StringControllerBuilder::create)
                                .build())

                        .build())

                .category(ConfigCategory.createBuilder()
                        .name(Component.literal("MSPT/Ping Monitor"))
                        .tooltip(Component.literal("Settings for MSPT/Ping Monitor"))

                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Enable"))
                                .description(OptionDescription.of(Component.literal("Enable MSPT/Ping Monitor?")))
                                .binding(
                                        true,
                                        () -> data.get().mspt,
                                        en -> data.get().mspt = en
                                ).controller(TickBoxControllerBuilder::create)
                                .build())

                        .option(Option.<Color>createBuilder()
                                .name(Component.literal("Color"))
                                .description(OptionDescription.of(Component.literal("Color of MSPT/String Monitor")))
                                .binding(
                                        Color.WHITE,
                                        () -> data.get().colmspt,
                                        col -> data.get().colmspt = col
                                ).controller(ColorControllerBuilder::create)
                                .build())

                        .option(Option.<String>createBuilder()
                                .name(Component.literal("Component"))
                                .description(OptionDescription.of(Component.literal("Text showed on the MSPT/String Monitor.")))
                                .binding(
                                        "@ ",
                                        () -> data.get().strmspt,
                                        str -> data.get().strmspt = str
                                ).controller(StringControllerBuilder::create)
                                .build())

                        .build())

                .category(ConfigCategory.createBuilder()
                        .name(Component.literal("Memory Monitor"))
                        .tooltip(Component.literal("Settings for Memory Monitor"))

                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Enable Numeric"))
                                .description(OptionDescription.of(Component.literal("Enable Memory Monitor With Megabytes?")))
                                .binding(
                                        false,
                                        () -> data.get().mem,
                                        en -> data.get().mem = en
                                ).controller(TickBoxControllerBuilder::create)
                                .build())

                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Enable Percentile"))
                                .description(OptionDescription.of(Component.literal("Enable Memory Monitor with Percentile?")))
                                .binding(
                                        true,
                                        () -> data.get().perc,
                                        enperc -> data.get().perc = enperc
                                ).controller(TickBoxControllerBuilder::create)
                                .build())

                        .option(Option.<Color>createBuilder()
                                .name(Component.literal("Color"))
                                .description(OptionDescription.of(Component.literal("Color of Memory Monitor")))
                                .binding(
                                        Color.WHITE,
                                        () -> data.get().colmem,
                                        col -> data.get().colmem = col
                                ).controller(ColorControllerBuilder::create)
                                .build())

                        .option(Option.<String>createBuilder()
                                .name(Component.literal("Component"))
                                .description(OptionDescription.of(Component.literal("Text showed on the Memory Monitor.")))
                                .binding(
                                        "Memory: ",
                                        () -> data.get().strmem,
                                        str -> data.get().strmem = str
                                ).controller(StringControllerBuilder::create)
                                .build())

                        .build())

                .save(data.HANDLER::save)
                .build()
                .generateScreen(parent);

    }

}
