package com.github.telvarost.telsterrain;

import net.glasslauncher.mods.gcapi3.api.*;

public class Config {

    @ConfigRoot(value = "config", visibleName = "TelsTerrain")
    public static ConfigFields config = new ConfigFields();

    public static class ConfigFields {

        @ConfigEntry(
                name = "Allow Shaping Water & Lava With Bowls",
                multiplayerSynced = true
        )
        public Boolean ALLOW_SHAPING_WATER_AND_LAVA = true;

        @ConfigEntry(
                name = "Enable Biome Specific Generation Tweaks",
                multiplayerSynced = true
        )
        public Boolean ENABLE_BIOME_SPECIFIC_GENERATION = false;

        @ConfigEntry(
                name = "Enable Cave Clay Generation",
                multiplayerSynced = true
        )
        public Boolean ENABLE_CAVE_CLAY_GENERATION = false;

        @ConfigEntry(
                name = "Enable Cave Ice Generation",
                multiplayerSynced = true
        )
        public Boolean ENABLE_CAVE_ICE_GENERATION = false;

        @ConfigEntry(
                name = "Enable Cave Sand Generation",
                multiplayerSynced = true
        )
        public Boolean ENABLE_CAVE_SAND_GENERATION = false;

        @ConfigEntry(
                name = "Enable Cave Sandstone Generation",
                multiplayerSynced = true
        )
        public Boolean ENABLE_CAVE_SANDSTONE_GENERATION = false;

        @ConfigEntry(
                name = "Enable Desert Stone/Gravel Swap",
                description = "Swap stone to sandstone and gravel to sand",
                multiplayerSynced = true
        )
        public Boolean ENABLE_DESERT_STONE_AND_GRAVEL_SWAP = false;

        @ConfigEntry(
                name = "Enable Nether Clay Generation",
                multiplayerSynced = true
        )
        public Boolean ENABLE_NETHER_CLAY_GENERATION = false;
    }
}
