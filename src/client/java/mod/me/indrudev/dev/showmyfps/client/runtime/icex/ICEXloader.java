package mod.me.indrudev.dev.showmyfps.client.runtime.icex;
import com.google.gson.JsonParseException;
import mod.me.indrudev.dev.showmyfps.client.data.data;
import mod.me.indrudev.dev.showmyfps.ignoreSMF;

public class ICEXloader {
    public void loadConfig() {
        try {
            data.HANDLER.load();
        } catch(JsonParseException e) {
            throw new InvalidConfigExceptionICEX("mod.me.indrudev.dev.showmyfps: failed to read: GSON-DESERIALIZATION-ERROR<showmyfps-conf.json>", e);
        }
    }

    private static ICEXloader INSTANCE = new ICEXloader();

    public static ICEXloader getLoader() {
        return INSTANCE;
    }
}
