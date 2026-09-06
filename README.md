# RealTech Core

**RealTech Core** to mod techniczny do Minecrafta (1.21.1, NeoForge), skupiony na realistycznej, inżynierskiej progresji:

- Ujednolicone materiały (jedno żelazo, jedna miedź itd.)
- Brak bezpośrednich dropów rudy/gemów – wszystko musi przejść przez przetwarzanie
- Przetwarzanie ręczne (kamień/żelazo) → automatyzacja mechaniczna → energia parowa
- Sieć mocy rotacyjnej (SU/RPM) z wałami, przekładniami i silnikami
- Rozszerzalna baza pod przyszłe dodatki (paliwa ciekłe, energia jądrowa, fuzja, egzotyka)

To repozytorium zawiera **mod główny (Core)**. Rozszerzenia na kolejne ery (Industry, Nuclear, Fusion, Exotic) będą osobnymi modami‑addonami.

---

## Funkcje (zakres Core v1)

### Materiały i rudy

- Metale: żelazo, miedź, złoto, cyna, cynk, ołów, srebro  
- Gemy: diament, szmaragd, rubin, szafir  
- Wszystko ujednolicone przez tagi (`c:ingots/*`, `c:gems/*`, `c:ores/*`)

### Łańcuch przetwarzania rud

1. Wydobycie rudy → `dirty_*_chunk`
2. Płukanie → `clean_*_chunk`
3. Kruszenie → `crushed_*_ore` (mała szansa na nuggety)
4. Opcjonalne wzbogacanie → `*_concentrate` (2× wydajność przy topieniu)
5. Topienie → ingoty

Gemy:

- `clean_*_chunk` + woda + materiał ścierny → oszlifowany gem w **Lapidary Machine**  
  (lepsze materiały ścierne = szybsze cięcie)

### Ręczne przetwarzanie (epoka kamienia)

- **Ore Sieve**: stań w wodzie, trzymaj brudny chunk w off‑hand, kliknij PPM, aby wyczyścić.
- **Hand Crusher**: ręczny blok, który zmienia czyste chunki w kruszoną rudę poprzez kręcenie korbą.

Do rozpoczęcia przetwarzania nie jest potrzebny żaden metal.

### Maszyny zasilane

Wszystkie maszyny rotacyjne dzielą:

- Zakres RPM: 32–256 (globalny limit 256)
- Stałe wymaganie SU do działania
- Prędkość pracy skaluje się z RPM

Maszyny m.in.:

- Ore Washer
- Crusher (rudy, kamień, węgiel, rośliny)
- Concentrator (wzbogacanie, ścieżka 2× wydajności)
- Smelter (zasilany paliwem stałym)
- Lapidary Machine (woda + materiał ścierny)
- Mechanical Press (blachy, brykiety, olej roślinny)
- Sawmill, Plant Cutter
- Pump, Fluid Tank, Fluid Pipe
- Coke Oven (przetwarzanie paliwa)

### Mechaniczny system napędowy

- **Steam Boiler**: spala paliwa stałe, grzeje wodę → para
- **Steam Engine**: zużywa parę, generuje moc rotacyjną (SU @ RPM)
- **Shaft**: podstawowy łącznik rotacyjny
- **Direction Gearbox**: 6‑stronny hub 1:1, zmienia kierunek (poziom/pion)
- **Ratio Gearbox**: przelotowy z konfigurowalnymi przełożeniami (1:3, 1:2, 1:1, 2:1, 3:1), zamienia SU ↔ RPM

Zasady:

- Maksymalne RPM: 256
- Maszyny wymagają minimalnego SU i RPM ≥ 32
- Za mało SU → maszyny stają; wyższe RPM → szybsza praca

### Magazyny i logistyka

- Buffer Crate (mały, konfigurowalny)
- RealTech Vault (multiblok, duży magazyn, filtry)
- Conveyor Belt (opcjonalnie, transport przedmiotów zasilany rotacyjnie)

---

## Stack technologiczny

- **Minecraft:** 1.21.1  
- **Loader:** NeoForge  
- **Język:** Java 21  
- **IDE:** VS Code (Java Extension Pack, Gradle)  
- **Build tool:** Gradle (NeoForge MDK)

---

## Rozpoczęcie pracy

### Wymagania

- JDK 21
- Git
- VS Code z:
  - Extension Pack for Java
  - Gradle for Java

### Sklonuj repozytorium

```bash
git clone https://github.com/JakubSledzki/RealTech.git
cd RealTech
```

### Konfiguracja workspace

1. Otwórz folder projektu w VS Code.
2. Pozwól Gradle zaimportować projekt.
3. Upewnij się, że NeoForge MDK jest poprawnie skonfigurowany:
   - `gradle.properties` ma właściwe wersje: `minecraft_version`, `neoforge_version`, `mod_version` itd.
   - `src/main/resources/META-INF/neoforge.mods.toml` ma:
     - `modId = "realtech_core"`
     - odpowiednie `displayName`, `authors`, `description`.

### Uruchomienie

```bash
# Klient
./gradlew runClient

# Serwer
./gradlew runServer
```

Możesz też dodać konfiguracje `runClient` i `runServer` w `launch.json` w VS Code i uruchamiać przez F5.

---

## Struktura projektu (skrót)

- `src/main/java/pl/sledzki/realtech_core/`
  - `RealTechMod.java`
  - `registry/` – rejestracje (bloki, przedmioty, block entities, menu, fluidy)
  - `block/` – bloki (rudy, maszyny, napęd, fluidy)
  - `item/` – przedmioty (Ore Sieve, materiały, narzędzia)
  - `blockentity/` – logika maszyn
  - `menu/` – kontenery i ekrany
  - `recipe/` – typy i serializery receptur
  - `power/` – sieć rotacyjna (SU/RPM)
  - `fluid/` – zbiorniki, rury, pompy, kotły
  - `worldgen/` – generowanie rud
  - `config/` – konfiguracja
  - `util/` – pomocnicze klasy

- `src/main/resources/`
  - `META-INF/neoforge.mods.toml`
  - `assets/realtech_core/` – modele, tekstury, lang, dźwięki
  - `data/realtech_core/` – receptury, loot table, tagi, worldgen

---

## Workflow deweloperski

1. Zaplanuj funkcję (np. „Ore Washer”)
2. Zarejestruj blok i block entity w `RTBlocks` / `RTBlockEntities`
3. Zaimplementuj logikę w `blockentity/` (przetwarzanie, SU/RPM, zbiorniki)
4. Dodaj menu i ekran w `menu/`
5. Zdefiniuj receptury w `data/realtech_core/recipes/`
6. Dodaj modele i tekstury w `assets/realtech_core/`
7. Przetestuj w grze przez `runClient`
8. Zcommituj i wypchnij na GitHuba

Zalecane gałęzie:

- `main` – stabilne wersje
- `dev` – bieżący rozwój
- Feature branchy: `feature/ore-washer`, `feature/rotational-network` itd.

---

## Aktualny status

- [ ] Konfiguracja projektu i podstawowe rejestracje
- [ ] Materiały i przedmioty (rudy, chunki, ingoty, gemy, blachy, pyły)
- [ ] Ręczne przetwarzanie (ore sieve, hand crusher)
- [ ] Maszyny zasilane (washer, crusher, concentrator, smelter, lapidary, press itd.)
- [ ] Sieć rotacyjna (SU/RPM, wały, przekładnie, silnik)
- [ ] Fluidy i para (zbiorniki, rury, pompa, kocioł)
- [ ] Generowanie świata (żyły rud)
- [ ] Balans, tooltipy, podstawowa dokumentacja

Szczegółowe zadania i roadmapa w [Issues](https://github.com/JakubSledzki/RealTech/issues).

---

## Konfiguracja

Pliki konfiguracyjne będą w:

- `config/realtech-core-common.toml` (ustawienia wspólne)
- Ewentualnie osobne klient/serwer w przyszłości.

Początkowo mogą zawierać:

- Włącz/wyłącz poszczególne maszyny
- Stałe SU/RPM (do balansu)
- Przełączniki generowania rud

---

## Contributing

Współpraca mile widziana:

- Sprawdź istniejące issue przed rozpoczęciem pracy.
- Używaj feature branchy i otwieraj PR‑y do `dev`.
- Trzymaj się stylu kodu i nazewnictwa z projektu.
- Commity powinny być zwarte i opisowe.

Przy większych funkcjach najpierw otwórz issue/discussion, żeby uzgodnić projekt.

---

## Licencja

[Wybierz licencję i zostaw np.:]

Ten projekt jest dostępny na licencji MIT – szczegóły w pliku [LICENSE](LICENSE).

---

## Autorzy

- Autor: Jakub „JakubSledzki” Śledzki  
- Inspirowane rzeczywistą metalurgią, przetwórstwem minerałów i wczesną inżynierią przemysłową.  
- Zbudowane z użyciem NeoForge i narzędzi społeczności moderskiej Minecrafta.

---

## Linki

- Repozytorium: https://github.com/JakubSledzki/RealTech  
- Issues: https://github.com/JakubSledzki/RealTech/issues  
- Wersja Minecrafta: 1.21.1  
- Loader: NeoForge  
- Język: Java 21