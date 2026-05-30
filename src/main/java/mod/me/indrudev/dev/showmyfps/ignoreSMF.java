package mod.me.indrudev.dev.showmyfps;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ignoreSMF implements ModInitializer {
	public static final String MOD_ID = "showmyfps";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.



		LOGGER.info("Hi Im IndruDev, if you are reading this in a crash log, it is probably bcuz of me.");
		LOGGER.info("I'm just kina a dumb coder");
	}
}