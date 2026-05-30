package mod.me.indrudev.dev.showmyfps.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SMFConfigManager {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final File FILE = new File(FabricLoader.getInstance().getConfigDir().toFile(), "SMF-config.json");


    public static void load() {
        if(FILE.exists()) {
            try(FileReader reader = new FileReader(FILE)) {
                SMFConfig.CONFIG = GSON.fromJson(reader, SMFConfig.class);
            } catch(IOException e) {
                System.err.println("SMF cannot load configs...");
            }
        } else {
            save();
        }
    }

    public static void save() {
        try (FileWriter writer = new FileWriter(FILE)) {
            GSON.toJson(SMFConfig.CONFIG, writer);
        } catch(IOException e){
            System.err.println("SMF unable to save config...");
        }
    }

}
