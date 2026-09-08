# RealTech Core

**RealTech Core** is a technical Minecraft mod for version 1.21.1 using NeoForge. The project focuses on realistic, engineering-style progression, resource processing, and the gradual development of industrial systems.

The mod is designed as the foundation for future technology add-ons such as:

- Industry
- Nuclear
- Fusion
- Exotic technology

Each major technological era may eventually be developed as a separate add-on mod.

> **Current version:** 0.2.0  
> **Minecraft:** 1.21.1  
> **Loader:** NeoForge  
> **Java:** 21  
> **License:** MIT

---

## Project Vision

RealTech Core aims to introduce a more structured and believable progression system to Minecraft:

- Materials are unified through common tags.
- Ores and resources are processed instead of being converted directly into final materials.
- Early progression relies on manual processing.
- Later progression will introduce mechanical power and steam technology.
- Data generation is used to create recipes, tags, models, blockstates, loot tables, and other resources.
- The project is designed to be extended by future add-on mods.

The mod is currently in active development. Many systems described in the long-term design are planned but have not yet been implemented.

---

## Current Features

Version 0.2.0 contains the initial foundation of the mod.

### Materials and Items

The current implementation includes selected materials and processing items such as:

- Iron
- Copper
- Gold
- Ruby
- Sapphire
- Diamond
- Dirty ore clumps
- Clean ore clumps
- Uncut gems
- Cut gems
- Sandpaper
- Ore Sieve

The material list will be expanded in future versions.

### Current Processing

The current version includes the initial ore and gem processing concepts:

- Ore sieve processing
- Clean and dirty ore clumps
- Smelting recipes
- Blasting recipes
- Basic gem processing
- Uncut and cut gems
- Abrasive materials such as sandpaper

More advanced processing machines and multi-stage production chains will be added progressively.

### Current Blocks

Version 0.2.0 currently includes selected blocks such as:

- Ruby Ore
- Sapphire Ore

Additional ores, machines, storage blocks, and power-system components are planned for future releases.

---

## Planned Features

The following systems are part of the long-term development plan. They are not necessarily available in the current version.

### Materials and Ores

Planned metals:

- Iron
- Copper
- Gold
- Tin
- Zinc
- Lead
- Silver

Planned gems:

- Diamond
- Emerald
- Ruby
- Sapphire

Materials will be unified through common tags such as:

```text
c:ingots/*
c:gems/*
c:ores/*
```

### Ore Processing Chain

The planned processing chain is:

```text
Ore
→ Dirty Clump
→ Clean Clump
→ Crushed Ore
→ Concentrate
→ Ingot
```

The intended stages include:

1. Mining ore
2. Washing or sieving
3. Crushing
4. Optional concentration
5. Smelting or blasting

Some materials may also provide secondary outputs such as nuggets or dusts.

### Manual Processing

The early game is planned to support manual processing without requiring metal tools:

- **Ore Sieve** for washing dirty clumps
- **Hand Crusher** for processing clean clumps
- Other primitive tools and processing blocks

### Powered Machines

Future machines may include:

- Ore Washer
- Crusher
- Concentrator
- Smelter
- Lapidary Machine
- Mechanical Press
- Sawmill
- Plant Cutter
- Pump
- Fluid Tank
- Fluid Pipe
- Coke Oven
- Conveyor Belt

### Mechanical Power System

The planned mechanical power system will use a rotational network based on SU and RPM.

Planned components include:

- Shafts
- Steam Boiler
- Steam Engine
- Direction Gearbox
- Ratio Gearbox
- Mechanical machines powered by rotational energy

The planned system is based on the following principles:

- Machines require a minimum amount of SU.
- Machines require a minimum RPM.
- Higher RPM increases processing speed.
- Gearboxes can change direction or modify the speed-to-power ratio.
- The global RPM limit is planned to be 256.

These values may change during development and balancing.

---

## Data Generation

RealTech Core uses Java-based data generation instead of manually creating most JSON resources.

The data generation system is used for:

- Recipes
- Item tags
- Block tags
- Fluid tags
- Item models
- Block models
- Blockstates
- Loot tables
- World generation
- Other generated resources

The main data-generation classes are located in:

```text
src/main/java/net/krogul/realtech/datagen/
```

Current data providers include:

- `DataGenerators.java`
- `ModBlockLootTableProvider.java`
- `ModBlockStateProvider.java`
- `ModBlockTagProvider.java`
- `ModItemModelProvider.java`
- `ModItemTagProvider.java`
- `ModRecipeProvider.java`

To regenerate data, run:

```bash
./gradlew runData
```

Generated files are written to:

```text
src/generated/resources/
```

Generated resources should generally not be edited manually. Changes should be made in the appropriate data provider and then regenerated.

---

## Project Structure

The current project structure is organized as follows:

```text
src/
├── generated/
│   └── resources/
│       ├── assets/
│       │   └── realtech/
│       │       ├── blockstates/
│       │       └── models/
│       │           ├── block/
│       │           └── item/
│       └── data/
│           ├── minecraft/
│           │   └── tags/
│           │       └── block/
│           └── realtech/
│               ├── advancement/
│               ├── loot_table/
│               │   └── blocks/
│               └── recipe/
│
└── main/
    ├── java/
    │   └── net/
    │       └── krogul/
    │           └── realtech/
    │               ├── block/
    │               │   └── custom/
    │               ├── datagen/
    │               ├── event/
    │               ├── item/
    │               │   └── custom/
    │               ├── Config.java
    │               └── RealTech.java
    │
    └── resources/
        ├── assets/
        │   └── realtech/
        │       ├── blockstates/
        │       ├── lang/
        │       │   └── en_us.json
        │       ├── models/
        │       │   ├── block/
        │       │   └── item/
        │       └── textures/
        │           ├── block/
        │           └── item/
        └── data/
```

The project structure will continue to evolve as additional systems are implemented.

---

## Technology Stack

- **Minecraft:** 1.21.1
- **Mod loader:** NeoForge
- **Programming language:** Java 21
- **Build system:** Gradle
- **Modding environment:** NeoForge MDK
- **IDE:** Visual Studio Code
- **Data generation:** NeoForge Java data providers
- **Version control:** Git and GitHub

Recommended VS Code extensions:

- Extension Pack for Java
- Gradle for Java

---

## Getting Started

### Requirements

- JDK 21
- Git
- VS Code
- Java Extension Pack
- Gradle for Java

### Clone the Repository

```bash
git clone [https://github.com/JakubSledzki/RealTech.git](https://github.com/JakubSledzki/RealTech.git)
cd RealTech
```

### Run the Client

```bash
./gradlew runClient
```

On Windows, you can use:

```bat
gradlew runClient
```

### Run Data Generation

```bash
./gradlew runData
```

After running data generation, verify the contents of:

```text
src/generated/resources/
```

---

## Development Workflow

A typical feature-development workflow is:

1. Plan the feature.
2. Add or update the required registry entries.
3. Implement the Java logic.
4. Add textures and manually created resource files if needed.
5. Update the appropriate data providers.
6. Run data generation.
7. Start the client and test the feature.
8. Fix bugs and balance issues.
9. Commit the changes.
10. Push the feature branch and open a pull request.

Recommended branch structure:

- `main` – stable versions
- `dev` – active development
- `feature/<name>` – individual features

Examples:

```text
feature/ore-processing
feature/ruby-ore
feature/data-generation
feature/mechanical-power
```

---

## Current Status

**Current version: 0.2.0**

Implemented or partially implemented:

- [x] Initial NeoForge project setup
- [x] Basic mod entry point
- [x] Initial item registration
- [x] Initial block registration
- [x] Ruby ore
- [x] Sapphire ore
- [x] Dirty ore clumps
- [x] Clean ore clumps
- [x] Uncut gems
- [x] Cut gems
- [x] Sandpaper
- [x] Ore Sieve
- [x] Basic smelting recipes
- [x] Basic blasting recipes
- [x] Initial loot tables
- [x] Initial tags
- [x] Item models generated through Datagen
- [x] Block models and blockstates generated through Datagen
- [x] Recipe generation through Datagen
- [x] English language file

Planned or not yet fully implemented:

- [ ] Complete material system
- [ ] Additional ores and gems
- [ ] Hand Crusher
- [ ] Powered processing machines
- [ ] Mechanical power network
- [ ] Steam system
- [ ] Fluids and fluid transport
- [ ] Storage and logistics
- [ ] Advanced world generation
- [ ] Configuration options
- [ ] Balancing and progression documentation
- [ ] Additional translations

Detailed tasks and the development roadmap are available in the [Issues](https://github.com/JakubSledzki/RealTech/issues) section.

---

## Configuration

Configuration support is planned for future versions.

Possible configuration options may include:

- Enabling or disabling specific features
- Enabling or disabling individual machines
- Ore generation settings
- SU/RPM values
- Processing speeds
- Machine power requirements
- Balance-related settings

The exact configuration structure will be documented after the system is implemented.

---

## Contributing

Contributions are welcome.

Before starting work:

- Check existing issues.
- Discuss large features before implementation.
- Use a separate feature branch.
- Follow the existing naming and code style.
- Keep commits focused and descriptive.
- Regenerate data after modifying data providers.
- Test changes in a development client.

For larger changes, open an issue or discussion before submitting a pull request.

---

## Changelog

### Version 0.2.0

#### Added

- Initial RealTech Core project foundation.
- NeoForge 1.21.1 integration.
- Initial item and block registries.
- Ruby ore.
- Sapphire ore.
- Dirty ore clumps.
- Clean ore clumps.
- Ruby, sapphire, and diamond gem items.
- Uncut and processed gem items.
- Sandpaper.
- Ore Sieve.
- Basic smelting recipes.
- Basic blasting recipes.
- Initial loot tables.
- Initial Minecraft and RealTech tags.
- English language support.

#### Data Generation

- Added centralized data-generation entry point.
- Added blockstate generation.
- Added block model generation.
- Added item model generation.
- Added recipe generation.
- Added item tag generation.
- Added block tag generation.
- Added loot table generation.
- Added generated assets and data resources.

#### Project Structure

- Reorganized Java packages.
- Added dedicated `datagen` package.
- Added dedicated `event` package.
- Added custom block package.
- Added custom item package.
- Added generated resources directory.
- Updated the resource layout for future expansion.

#### Planned for Future Versions

The following systems are planned but are not yet part of the complete 0.2.0 feature set:

- More materials and ores.
- Complete ore-processing chains.
- Manual crushing.
- Powered processing machines.
- Rotational power.
- Steam generation.
- Fluids and logistics.
- Additional world-generation features.
- Configuration options.
- More translations.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Author

- Jakub "Krogul" Śledzki

RealTech Core is inspired by real-world metallurgy, mineral processing, mechanical engineering, and early industrial technology.

---

## Links

- Repository: [https://github.com/JakubSledzki/RealTech](https://github.com/JakubSledzki/RealTech)
- Issues: [https://github.com/JakubSledzki/RealTech/issues](https://github.com/JakubSledzki/RealTech/issues)
- Minecraft: 1.21.1
- NeoForge: 1.21.1
- Java: 21
