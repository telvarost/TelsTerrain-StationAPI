# TelsTerrain StationAPI for Minecraft Beta 1.7.3

A StationAPI mod for Minecraft Beta 1.7.3 that tweaks ore generation, sand generation, and more!
* Mod works on Multiplayer with [GlassConfigAPI](https://modrinth.com/mod/glass-config-api) version 3.0+ used to sync configs!
* All changes are disabled by default, enable what you want!
* NOTE: Terrain tweaks do not affect already generated chunks.

## Water and Lava Shaping
This mod adds the ability to enable water and lava shaping using wooden bowls:
* Right click any water or lava block with a wooden bowl to lower its level
  * Lava will consume the bowl when its level is lowered, bring a lot of bowls if you want to shape lava significantly

## Old Terrain Features
This mod adds the ability to disable any vanilla terrain decorations that you don't want!
* For the Overworld you can now disable:
  * Cave & Soil Features: caves/tunnels, dungeons, dirt deposits, gravel deposits, and beach clay
  * Fluid Features: waterfalls, lavafalls, ponds of water, and ponds of lava
  * Ores: Coal, iron, gold, diamond, lapis lazuli, and redstone
  * Small Plants: dandelions, roses, tall grass, dead bushes, sugar cane, cacti, red mushrooms, and brown mushrooms
  * Trees: small oak, large oak, birch, and pine
* For the Nether you can now disable:
  * Tunnels
  * Lava Springs/Lavafalls
  * Fire Patches
  * Glowstone Clusters: A & B
  * Small Plants: red mushrooms and brown mushrooms

## New Terrain Features
This mod adds the ability to enable custom biome ore/soil feature distribution (pros/cons list):
* NOTE: Soil types only effect generation if their block generation is enabled (i.e. sand, sandstone, ice, and clay).
  * Also note that cave soil blocks only generate between Y levels 0 and 47.

|      Biome      | Soil Type   | Pros          | Cons         |
|:---------------:|-------------|:--------------|:-------------|
|   Rainforest    | Sandy       | 150% Dungeons | 50% Pumpkins |
|     Plains      | Sedimentary | 150% Dirt     | 50% Gravel   |
|     Swamps      | Clayey      | 150% Coal     | 50% Gold     |
|      Taiga      | Icy         | 150% Gravel   | 75% Redstone |
|     Forest      | Normal      | 150% Iron     | 50% Lapis    |
|     Desert      | Sandy       | 200% Lapis    | 50% Roses    |
|     Savanna     | Sandy       | 200% Diamonds | 75% Dungeons |
|     Tundra      | Icy         | 150% Redstone | 75% Dirt     |
| Seasonal Forest | Normal      | 200% Gold     | 75% Iron     |
|    Shrubland    | Sedimentary | 200% Pumpkins | 75% Coal     |
|   Ice Desert    | Icy         | 200% Roses    | 50% Diamonds |

* Ability to enable cave sand, affects the following biomes
  * Rainforest
  * Desert
  * Savanna
* Ability to enable cave sandstone, affects the following biomes
  * Plains
  * Shrubland
* Ability to enable cave ice, affects the following biomes
  * Taiga
  * Tundra
  * Ice Desert
* Ability to enable cave clay, affects the following biomes
  * Swamps
* Ability to enable desert stone/gravel swap
  * Below deserts swaps stone for sandstone and gravel for sand
* Ability to increase sandstone blast resistance (recommended if you enable desert stone swap)
* Ability to enable nether clay
  * Adds a very very small amount of clay to the nether walls and ceiling

## Tips and Tricks (Icy Caves)
Cave ice can be really annoying to deal with. I recommend using a mod like [GoldenTweaks](https://modrinth.com/mod/goldentweaks-stationapi) to collect the ice.
You could also use a mod like [NowObtainableRecipes](https://modrinth.com/mod/nowobtainablerecipes-stationapi) to get a sponge to soak up the water from melted ice.
This mod also provides water shaping with a wooden bowl that you could use to remove melted ice water.
Another suggestion is to use an alternative light source in ice caves since torches can be knocked out easily by flowing water.

## Installation using Prism Launcher

1. Download an instance of Babric for Prism Launcher: https://github.com/babric/prism-instance
2. Install Java 17 and set the instance to use it: https://adoptium.net/temurin/releases/
3. Add GlassConfigAPI 3.0.2+ to the mod folder for the instance: https://modrinth.com/mod/glass-config-api
4. Add Glass Networking to the mod folder for the instance: https://modrinth.com/mod/glass-networking
5. (Optional) Add StationAPI to the mod folder for the instance: https://modrinth.com/mod/stationapi
6. (Optional) Add Mod Menu to the mod folder for the instance: https://modrinth.com/mod/modmenu-beta
7. Add this mod to the mod folder for the instance: https://github.com/telvarost/TelsTerrain-StationAPI/releases
8. Run and enjoy! 👍

## Feedback

Got any suggestions on what should be added next? Feel free to share it by [creating an issue](https://github.com/telvarost/TelsTerrain-StationAPI/issues/new). Know how to code and want to do it yourself? Then look below on how to get started.

## Contributing

Thanks for considering contributing! To get started fork this repository, make your changes, and create a PR.

If you are new to StationAPI consider watching the following videos on Babric/StationAPI Minecraft modding: https://www.youtube.com/watch?v=9-sVGjnGJ5s&list=PLa2JWzyvH63wGcj5-i0P12VkJG7PDyo9T
