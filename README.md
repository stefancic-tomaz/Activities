# 📱 Razvoj mobilnih aplikacij – Naloga 5
## Delo z različnimi aktivnostmi (Android)

🔗 **GitHub repozitorij:** [https://github.com/stefancic-tomaz/Activities](https://github.com/stefancic-tomaz/Activities)

---

## 📖 Opis projekta

Pri tej nalogi je bila razvita Android aplikacija v okolju Android Studio (jezik Java), katere namen je spoznavanje konceptov življenjskega cikla aplikacije, ustvarjanja, povezovanja in upravljanja več aktivnosti (**Activities**) ter prenosa podatkov med njimi.

Aplikacija obsega tri samostojne aktivnosti:
1. **MainActivity** (glavni zaslon s števcem in navigacijo)
2. **HelloActivity** (zaslon z izpisom besedila "Hello!" in prejetim števcem)
3. **ThirdActivity** (zaslon z izpisom "Activity 3", števcem ter podporo za gumbno in potezno navigacijo)

Med aktivnostmi se podatki (trenutna vrednost števca) prenašajo z uporabo eksplicitnih namenov (**Explicit Intents**), navigacija nazaj na glavno aktivnost pa je optimizirana z ustreznimi zastavicami stoga aktivnosti (`FLAG_ACTIVITY_CLEAR_TOP` in `FLAG_ACTIVITY_SINGLE_TOP`).

---

## ✨ Glavne funkcionalnosti

### 1. MainActivity (Glavna aktivnost)
- Prikaz trenutne vrednosti števca (privzeto `0`).
- Gumb **COUNT** za inkrementiranje trenutnega števca (`counter++`).
- Gumb **GO TO ACTIVITY 2** za prehod na `HelloActivity` s prenosom trenutne vrednosti števca.
- Gumb **GO TO ACTIVITY 3** za prehod na `ThirdActivity` s prenosom trenutne vrednosti števca.
- Ohranjanje stanja števca ob rotaciji zaslona preko `onSaveInstanceState` in ob vnovičnem prikazu preko `onNewIntent`.

### 2. HelloActivity (Druga aktivnost)
- Izpis naslova **Hello!**.
- Prikaz prenesene vrednosti števca iz `MainActivity`.
- Gumb **GO TO ACTIVITY 1** za vrnitev na prvo aktivnost (`MainActivity`), pri čemer se ohrani enoten primerek aktivnosti na stogu.

### 3. ThirdActivity (Tretja aktivnost)
- Izpis naslova **Activity 3**.
- Prikaz prenesene vrednosti števca.
- **Navigacija s kliki na gumbe:**
  - Gumb **GO TO ACTIVITY 1** -> vrnitev na `MainActivity`.
  - Gumb **GO TO ACTIVITY 2** -> prehod na `HelloActivity`.
- **Potezna navigacija (Touch Swipe Gestures):**
  - **Poteg s prstom proti levi (Swipe Left):** sproži takojšen prehod na prvo aktivnost (`MainActivity`).
  - **Poteg s prstom proti desni (Swipe Right):** sproži takojšen prehod na drugo aktivnost (`HelloActivity`).

---

## 👆 Potezna navigacija (Touch Swipe Gestures)

Potezna navigacija je implementirana s pomožnim poslušalnikom `OnSwipeTouchListener`, ki implementira vmesnik `View.OnTouchListener` in uporablja `GestureDetector` z razredom `GestureDetector.SimpleOnGestureListener`:

```java
// OnSwipeTouchListener zaznava smer in hitrost potega (onFling)
OnSwipeTouchListener swipeListener = new OnSwipeTouchListener(this) {
    @Override
    public void onSwipeLeft() {
        // Poteg proti levi -> prehod na MainActivity
        goToMainActivity();
    }

    @Override
    public void onSwipeRight() {
        // Poteg proti desni -> prehod na HelloActivity
        goToHelloActivity();
    }
};

layoutThird.setOnTouchListener(swipeListener);
txtThirdCounter.setOnTouchListener(swipeListener);
```

Za zanesljivo zaznavanje potega sta določena praga premika in hitrosti:
- `SWIPE_DISTANCE_THRESHOLD = 100` slikovnih pik
- `SWIPE_VELOCITY_THRESHOLD = 100` slikovnih pik na sekundo

---

## 🎨 Prilagojena ikona aplikacije

Privzeta Android robotska ikona je bila zamenjana s prilagojeno vektorsko ikono (Adaptive Icon), ki ponazarja prehajanje med več zasloni (aktivnostmi) ter navigacijske poteze.

- **Ozadje (`ic_launcher_background.xml`):** Sodobna temno modra podlaga (`#0F172A`).
- **Ospredje (`ic_launcher_foreground.xml`):** Grafični prikaz več prekrivajočih se oken aplikacije z barvnimi poudarki in navigacijskima puščicama za poteze levo/desno.

---

## 📸 Zaslonski posnetki (Screenshots)

| MainActivity | HelloActivity | ThirdActivity |
|:---:|:---:|:---:|
| ![MainActivity](screenshots/main_activity.png) | ![HelloActivity](screenshots/hello_activity.png) | ![ThirdActivity](screenshots/third_activity.png) |
| *Glavni zaslon s števcem in gumbi* | *Druga aktivnost z napisom Hello!* | *Tretja aktivnost s potezno navigacijo* |

> **Opomba:** Zaslonske posnetke iz vašega telefona shranite v mapo `screenshots/` z imeni `main_activity.png`, `hello_activity.png` in `third_activity.png`.

---

## 📦 Namestitev aplikacije na telefon (*.apk*)

Za namestitev aplikacije na mobilno napravo z operacijskim sistemom Android je bila zgrajena paketna datoteka:
- **Lokacija APK datoteke v projektu:**
  `app/build/outputs/apk/debug/app-debug.apk`

### Postopek namestitve:
1. Povežite telefon z računalnikom preko USB kabla ali prenesite datoteko `app-debug.apk` preko storitve Google Drive / e-pošte / sporočila.
2. Na telefonu v nastavitvah omogočite namestitev iz neznanih virov (če vas sistem na to opozori).
3. Odprite preneseno datoteko `app-debug.apk` in izberite **Namesti / Install**.
4. Po namestitvi ikono aplikacije prestavite na namenski zaslon oz. v posebno mapo za predmet **Mobilne aplikacije**.

---

## ❓ Odgovori na vprašanja iz učnega lista

### 1. Kateri menijski ukaz v Android Studiu uporabite za dodajanje nove aktivnosti v aplikacijo?
**Odgovor:**  
V zgornjem meniju izberemo:  
`File → New → Activity → Empty Views Activity`  
(ali z desnim klikom na paket znotraj mape `java` → `New → Activity → Empty Views Activity`).

---

### 2. Katere datoteke se običajno dodajo, ko v aplikacijo dodate novo aktivnost z imenom HelloActivity, in katera obstoječa datoteka se pri tem posodobi?
**Odgovor:**  
Običajno se samodejno dodata dve novi datoteki:
1. **Izvorna koda razreda:** `HelloActivity.java` (v mapi `app/src/main/java/com/example/activities/`)
2. **Datoteka z uporabniškim vmesnikom (XML postavitev):** `activity_hello.xml` (v mapi `app/src/main/res/layout/`)

Pri tem se samodejno posodobi obstoječa konfiguracijska datoteka:
- **`AndroidManifest.xml`**, v katero se znotraj elementa `<application>` doda deklaracija nove aktivnosti:
  ```xml
  <activity
      android:name=".HelloActivity"
      android:exported="false" />
  ```

---

### 3. Kateri konstruktor uporabite za ustvarjanje novega eksplicitnega namena za prehod iz ene aktivnosti v drugo?
**Odgovor: b) `new Intent(Context context, Class<?> class)`**  
*Primer uporabe:*
```java
Intent intent = new Intent(MainActivity.this, HelloActivity.class);
```

---

### 4. Kako trenutni vrednosti števca dodate v namen (Intent), da jo lahko prenesete v drugo aktivnost?
**Odgovor: c) kot dodaten podatek namena**  
*Obrazložitev:* Za posredovanje dodatnih podatkov (angl. *extras*) uporabimo metodo `putExtra(String name, int value)`:
```java
intent.putExtra("counter", counter);
```

---

### 5. S katero metodo v razredu MainActivity zaženete HelloActivity in ji posredujete trenutno vrednost števca?
**Odgovor: c) `showToast(View view)`** (oziroma v prilagojeni kodi namenska poslušalna metoda / `btnActivity2.setOnClickListener(...)`)  
*Obrazložitev:* V originalnem gradivu HelloToast, iz katerega izhaja naloga, je bila metoda za klik gumba poimenovana `showToast(View view)`, ki so jo študenti nato prilagodili za prehod na novo aktivnost z `Intent`. V sodobni implementaciji uporabimo poslušalnik klika na ustreznem gumbu (`btnActivity2`).

---

### 6. Kako v aktivnosti HelloActivity pravilno posodobite prikaz števca, da prikaže trenutno vrednost?
**Odgovor: d) Vse navedeno.**  
*Obrazložitev:* Postopek obsega vse tri korake:
1. Pridobitev namena z metodo `getIntent()`.
2. Branje vrednosti števca z `intent.getIntExtra("counter", 0)`.
3. Posodobitev pogleda z `txtHelloCounter.setText(String.valueOf(counter))`.

---

### 7. Kateri zapis v HelloActivity ali ThirdActivity omogoča vrnitev na MainActivity brez ustvarjanja več zaporednih primerkov iste aktivnosti?
**Odgovor: b) `Intent.FLAG_ACTIVITY_CLEAR_TOP in Intent.FLAG_ACTIVITY_SINGLE_TOP`**  
*Obrazložitev:*
```java
intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
```
Zastavica `FLAG_ACTIVITY_CLEAR_TOP` odstrani vse aktivnosti nad ciljno aktivnostjo na stogu, `FLAG_ACTIVITY_SINGLE_TOP` pa poskrbi, da se že obstoječi primerek na vrhu ponovno uporabi namesto ustvarjanja novega.

---

### 8. Kaj je glavna vloga aktivnosti ThirdActivity v tej nalogi?
**Odgovor: c) prikaz prenesenega števca in omogočanje dodatne navigacije med aktivnostmi**  
*Obrazložitev:* `ThirdActivity` prikazuje vrednost prejetega števca ter poleg gumbov demonstrira še potezno navigacijo (poteg levo/desno) med posameznimi aktivnostmi.

---

## 📂 Struktura projekta

```text
Activities/
├── app/
│   ├── build.gradle.kts
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml
│           ├── java/com/example/activities/
│           │   ├── MainActivity.java           // Glavna aktivnost s števcem
│           │   ├── HelloActivity.java          // Druga aktivnost "Hello!"
│           │   ├── ThirdActivity.java          // Tretja aktivnost z gumbi in potezami
│           │   └── OnSwipeTouchListener.java   // Poslušalnik za potezno navigacijo
│           └── res/
│               ├── drawable/
│               │   ├── ic_launcher_background.xml
│               │   └── ic_launcher_foreground.xml
│               └── layout/
│                   ├── activity_main.xml
│                   ├── activity_hello.xml
│                   └── activity_third.xml
├── screenshots/                                // Mapa za zaslonske slike
└── README.md
```

---

## 🛠️ Tehnične podrobnosti
- **Jezik:** Java
- **Minimalni SDK:** Android 7.0 (API level 24+)
- **Ciljni SDK:** Android 15 / Android 14 (API level 34+)
- **Gradilni sistem:** Gradle 8+ z AGP (Android Gradle Plugin)
