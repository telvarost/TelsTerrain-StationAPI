# TerrainTweaks StationAPI for Minecraft Beta 1.7.3

A StationAPI mod for Minecraft Beta 1.7.3 that tweaks ore generation, sand generation, and more!
* Mod works on Multiplayer with [GlassConfigAPI](https://modrinth.com/mod/glass-config-api) version 3.0+ used to sync configs!

## Water and Lava Shaping

* Water and Lava can be shaped using wooden bowls:
  * Right click any water or lava block with a wooden bowl to lower its level
  * Lava will consume the bowl when its level is lowered, bring a lot of bowls if you want to shape lava significantly

## Terrain Features (Under Construction)
All terrain features can be individually disabled through the config if undesired.

* Ability to enable biome specific feature generation, affects the world as follows:
  * Rainforest - Sandy,  150% Dungeons, 75% Pumpkins
  * Plains     - Sandy,  150% Dirt,     75% Gravel
  * Swamps     - Clayey, 150% Gravel,   50% Gold
  * Taiga      - Icy,    150% Coal,     75% Dirt
  * Forest     - Normal, 150% Iron,     50% Lapis
  * Desert     - Sandy,  200% Gold,     50% Roses
  * Savanna    - Sandy,  150% Redstone, 75% Dungeons
  * Tundra     - Icy,    200% Diamonds, 75% Redstone
  * Seasonal   - Normal, 200% Lapis,    75% Iron
  * Shrubland  - Sandy,  150% Pumpkins, 75% Coal
  * Ice Desert - Icy,    200% Roses,    50% Diamonds
* Ability to enable cave sand, affects the following biomes:
  * Rainforest
  * Plains
  * Desert
  * Savanna
  * Shrubland
* Ability to enable cave ice, affects the following biomes:
  * Taiga
  * Tundra
  * Ice Desert
* Ability to enable cave clay, affects the following biomes:
  * Swamps
* Ability to enable nether clay
  * Adds a very very small amount of clay to the nether walls and roof

## Installation using Prism Launcher

1. Download an instance of Babric for Prism Launcher: https://github.com/babric/prism-instance
2. Install Java 17 and set the instance to use it: https://adoptium.net/temurin/releases/
3. Add GlassConfigAPI 3.0.2+ to the mod folder for the instance: https://modrinth.com/mod/glass-config-api
4. Add Glass Networking to the mod folder for the instance: https://modrinth.com/mod/glass-networking
5. (Optional) Add StationAPI to the mod folder for the instance: https://modrinth.com/mod/stationapi
6. (Optional) Add Mod Menu to the mod folder for the instance: https://modrinth.com/mod/modmenu-beta
7. Add this mod to the mod folder for the instance: https://github.com/telvarost/TerrainTweaks-StationAPI/releases
8. Run and enjoy! 👍

## Feedback

Got any suggestions on what should be added next? Feel free to share it by [creating an issue](https://github.com/telvarost/TerrainTweaks-StationAPI/issues/new). Know how to code and want to do it yourself? Then look below on how to get started.

## Contributing

Thanks for considering contributing! To get started fork this repository, make your changes, and create a PR. 

If you are new to StationAPI consider watching the following videos on Babric/StationAPI Minecraft modding: https://www.youtube.com/watch?v=9-sVGjnGJ5s&list=PLa2JWzyvH63wGcj5-i0P12VkJG7PDyo9T
