package com.github.telvarost.telsterrain;

import net.glasslauncher.mods.gcapi3.api.*;

public class Config {

    @ConfigRoot(value = "config", visibleName = "TelsTerrain")
    public static ConfigFields config = new ConfigFields();

    public static class ConfigFields {
        @ConfigCategory(
                name = "New Terrain Generation"
        )
        public NewTerrainGeneration NEW_TERRAIN_GENERATION = new NewTerrainGeneration();

        @ConfigCategory(
                name = "Old Terrain Generation"
        )
        public OldTerrainGeneration OLD_TERRAIN_GENERATION = new OldTerrainGeneration();

        @ConfigEntry(
                name = "Allow Shaping Water & Lava With Bowls",
                multiplayerSynced = true
        )
        public Boolean ALLOW_SHAPING_WATER_AND_LAVA = false;

        @ConfigEntry(
                name = "Increase Sandstone Blast Resistance",
                description = "Recommended with desert stone swap",
                multiplayerSynced = true
        )
        public Boolean INCREASE_SANDSTONE_BLAST_RESISTANCE = false;
    }

    public static class NewTerrainGeneration {
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

    public static class OldTerrainGeneration {
        @ConfigCategory(
                name = "Nether Features"
        )
        public NetherFeatures NETHER_FEATURES = new NetherFeatures();

        @ConfigCategory(
                name = "Overworld Cave And Soil Features"
        )
        public OverworldCaveAndSoilFeatures OVERWORLD_CAVE_AND_SOIL_FEATURES = new OverworldCaveAndSoilFeatures();

        @ConfigCategory(
                name = "Overworld Fluid Features"
        )
        public OverworldFluidFeatures OVERWORLD_FLUID_FEATURES = new OverworldFluidFeatures();

        @ConfigCategory(
                name = "Overworld Ores"
        )
        public OverworldOres OVERWORLD_ORES = new OverworldOres();

        @ConfigCategory(
                name = "Overworld Small Plants"
        )
        public OverworldSmallPlants OVERWORLD_SMALL_PLANTS = new OverworldSmallPlants();

        @ConfigCategory(
                name = "Overworld Trees"
        )
        public OverworldTrees OVERWORLD_TREES = new OverworldTrees();
    }

    public static class NetherFeatures {
        @ConfigEntry(
                name = "Disable Nether Caves",
                multiplayerSynced = true
        )
        public Boolean DISABLE_NETHER_CAVES = false;

        @ConfigEntry(
                name = "Disable Nether Fire Patches",
                multiplayerSynced = true
        )
        public Boolean DISABLE_NETHER_FIRE_PATCHES = false;

        @ConfigEntry(
                name = "Disable Nether Glowstone: Cluster A",
                multiplayerSynced = true
        )
        public Boolean DISABLE_NETHER_GLOWSTONE_CLUSTER_A = false;

        @ConfigEntry(
                name = "Disable Nether Glowstone: Cluster B",
                multiplayerSynced = true
        )
        public Boolean DISABLE_NETHER_GLOWSTONE_CLUSTER_B = false;

        @ConfigEntry(
                name = "Disable Nether Plant: Brown Mushrooms",
                multiplayerSynced = true
        )
        public Boolean DISABLE_NETHER_BROWN_MUSHROOMS = false;

        @ConfigEntry(
                name = "Disable Nether Plant: Red Mushrooms",
                multiplayerSynced = true
        )
        public Boolean DISABLE_NETHER_RED_MUSHROOMS = false;

        @ConfigEntry(
                name = "Disable Nether Spring: Lavafall",
                multiplayerSynced = true
        )
        public Boolean DISABLE_NETHER_LAVAFALLS = false;
    }

    public static class OverworldCaveAndSoilFeatures {
        @ConfigEntry(
                name = "Disable Overworld Caves",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_CAVES = false;

        @ConfigEntry(
                name = "Disable Overworld Dirt Deposits",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_DIRT_DEPOSITS = false;

        @ConfigEntry(
                name = "Disable Overworld Gravel Deposits",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_GRAVEL_DEPOSITS = false;

        @ConfigEntry(
                name = "Disable Overworld Clay Deposits",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_CLAY_DEPOSITS = false;

        @ConfigEntry(
                name = "Disable Overworld Dungeons",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_DUNGEONS = false;
    }

    public static class OverworldFluidFeatures {
        @ConfigEntry(
                name = "Disable Overworld Ponds Of Lava",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_LAVA_PONDS = false;

        @ConfigEntry(
                name = "Disable Overworld Ponds Of Water",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_WATER_PONDS = false;

        @ConfigEntry(
                name = "Disable Overworld Spring: Waterfall",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_WATERFALLS = false;

        @ConfigEntry(
                name = "Disable Overworld Spring: Lavafall",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_LAVAFALLS = false;
    }

    public static class OverworldOres {
        @ConfigEntry(
                name = "Disable Overworld Ore: Coal",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_COAL_ORE = false;

        @ConfigEntry(
                name = "Disable Overworld Ore: Diamond",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_DIAMOND_ORE = false;

        @ConfigEntry(
                name = "Disable Overworld Ore: Gold",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_GOLD_ORE = false;

        @ConfigEntry(
                name = "Disable Overworld Ore: Iron",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_IRON_ORE = false;

        @ConfigEntry(
                name = "Disable Overworld Ore: Lapis Lazuli",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_LAPIS_LAZULI_ORE = false;

        @ConfigEntry(
                name = "Disable Overworld Ore: Redstone",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_REDSTONE_ORE = false;
    }

    public static class OverworldSmallPlants {
        @ConfigEntry(
                name = "Disable Overworld Plant: Brown Mushroom",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_BROWN_MUSHROOMS = false;

        @ConfigEntry(
                name = "Disable Overworld Plant: Cactus",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_CACTI = false;

        @ConfigEntry(
                name = "Disable Overworld Plant: Dandelion",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_DANDELIONS = false;

        @ConfigEntry(
                name = "Disable Overworld Plant: Dead Bush",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_DEAD_BUSHES = false;

        @ConfigEntry(
                name = "Disable Overworld Plant: Pumpkin",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_PUMPKINS = false;

        @ConfigEntry(
                name = "Disable Overworld Plant: Red Mushroom",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_RED_MUSHROOMS = false;

        @ConfigEntry(
                name = "Disable Overworld Plant: Rose",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_ROSES = false;

        @ConfigEntry(
                name = "Disable Overworld Plant: Sugar Cane",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_SUGAR_CANE = false;

        @ConfigEntry(
                name = "Disable Overworld Plant: Tall Grass",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_TALL_GRASS = false;
    }

    public static class OverworldTrees {
        @ConfigEntry(
                name = "Disable Overworld Tree: Birch",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_BIRCH_TREES = false;

        @ConfigEntry(
                name = "Disable Overworld Tree: Large Oak",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_LARGE_OAK_TREES = false;

        @ConfigEntry(
                name = "Disable Overworld Tree: Pine",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_PINE_TREES = false;

        @ConfigEntry(
                name = "Disable Overworld Tree: Small Oak",
                multiplayerSynced = true
        )
        public Boolean DISABLE_OVERWORLD_SMALL_OAK_TREES = false;
    }
}
