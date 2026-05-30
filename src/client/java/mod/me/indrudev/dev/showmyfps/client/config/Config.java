package mod.me.indrudev.dev.showmyfps.client.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionDescription;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Config {

    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static final File FILE = new File(FabricLoader.getInstance().getConfigDir().toFile(), "SMFconf.json");

    public static void load() {
        if(FILE.exists()) {
            try(FileReader reader = new FileReader(FILE)) {
                ConfigData.CONF = GSON.fromJson(reader, ConfigData.class);
            } catch(IOException e) {
                System.err.println("SMF: config.gson.load /failed /catched-" + e);
            }
        } else {
            save();
        }
    }

    public static void save() {
        try(FileWriter writer = new FileWriter(FILE)) {
            GSON.toJson(ConfigData.CONF, writer);
        } catch(IOException e) {
            System.err.println("SMF: config.gson.save /failed /catched-" + e);
        }
    }

    public static Screen create(Screen parent) {

        return YetAnotherConfigLib.createBuilder()
                .title(Component.literal("Show My FPS Config"))
                .save(Config::save)
                .category(ConfigCategory.createBuilder()
                        .name(Component.literal("SMF Settings"))
                        .tooltip(Component.literal("Settings for Show My FPS."))

                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Show FPS"))
                                .description(OptionDescription.of(Component.literal("Whether to display the FPS monitor on screen.")))
                                .binding(
                                        true,
                                        () -> ConfigData.CONF.showFPS,
                                        fps -> ConfigData.CONF.showFPS = fps
                                )
                                .controller(TickBoxControllerBuilder::create)
                                .build()
                        )

                        .option(Option.<Boolean>createBuilder()
                                .name(Component.literal("Show MSPT/Ping"))
                                
                        )
                        .build()
                )
                .build()
                .generateScreen(parent);

    }

}
