package mod.me.indrudev.dev.showmyfps.client.data;

import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;

import java.awt.*;

public class data {

    private static ResourceLocation ID = ResourceLocation.fromNamespaceAndPath("showmyfps", "config");

    public static final ConfigClassHandler<data> HANDLER = ConfigClassHandler.<data>createBuilder(data.class)
            .id(ID)
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(FabricLoader.getInstance().getConfigDir().resolve("showmyfps-conf.json"))
                    .build()
            )
            .build();

    public static data get() {
        return HANDLER.instance();
    }

    //Entries<FPS>
    @SerialEntry public Boolean fps = true;
    @SerialEntry public Color colfps = Color.WHITE;

    //Entries<MSPT>
    @SerialEntry public Boolean mspt = true;
    @SerialEntry public Color colmspt = Color.WHITE;

    //Entries<MEM>
    @SerialEntry public Boolean mem = false;
    @SerialEntry public Boolean perc = true;
    @SerialEntry public Color colmem = Color.WHITE;


}
