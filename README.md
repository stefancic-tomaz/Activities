📱 Razvoj mobilnih aplikacij – Naloga 5
Delo z različnimi aktivnostmi (Android)
📖 Opis projekta

Pri tej nalogi je bila razvita Android aplikacija, katere namen je spoznavanje ustvarjanja, povezovanja in upravljanja več aktivnosti (Activities) v okolju Android Studio.

Aplikacija vsebuje tri aktivnosti, med katerimi lahko uporabnik prehaja s pomočjo gumbov in potezne navigacije. Glavni zaslon omogoča povečevanje števca, njegova trenutna vrednost pa se prenaša med aktivnostmi z uporabo eksplicitnih namenov (Explicit Intents).

✨ Funkcionalnosti
MainActivity
Prikaz trenutne vrednosti števca.
Gumb Count za povečevanje števca.
Gumb za prehod na HelloActivity.
Gumb za prehod na ThirdActivity.
HelloActivity
Prikaz besedila Hello!.
Prikaz vrednosti števca, prejete iz glavne aktivnosti.
Gumb za vrnitev na MainActivity.
ThirdActivity
Prikaz besedila Activity 3.
Prikaz trenutne vrednosti števca.
Gumb za prehod na MainActivity.
Gumb za prehod na HelloActivity.
Potezna navigacija:
Poteg v levo → prehod na MainActivity.
Poteg v desno → prehod na HelloActivity.
🛠️ Uporabljene tehnologije
Java
Android Studio
Android SDK
XML (uporabniški vmesnik)
Explicit Intents
putExtra() in getIntExtra()
GestureDetector
OnSwipeTouchListener
🔄 Navigacija med aktivnostmi

Za prehajanje med aktivnostmi se uporabljajo eksplicitni nameni (Intent).

Prenos vrednosti števca v drugo aktivnost:

java
Intent intent = new Intent(MainActivity.this, HelloActivity.class);
intent.putExtra("counter", counter);
startActivity(intent);


Pridobivanje vrednosti števca v drugi aktivnosti:

java
Intent intent = getIntent();
int counter = intent.getIntExtra("counter", 0);


Za navigacijo nazaj na glavno aktivnost se uporabljata zastavici:

java
intent.addFlags(
    Intent.FLAG_ACTIVITY_CLEAR_TOP |
    Intent.FLAG_ACTIVITY_SINGLE_TOP
);


Potezna navigacija je implementirana s pomočjo razreda OnSwipeTouchListener, ki zaznava horizontalne poteze uporabnika.

📂 Struktura projekta
text
app/
└── src/
    └── main/
        ├── java/
        │   └── .../
        │       ├── MainActivity.java
        │       ├── HelloActivity.java
        │       ├── ThirdActivity.java
        │       └── OnSwipeTouchListener.java
        │
        ├── res/
        │   └── layout/
        │       ├── activity_main.xml
        │       ├── activity_hello.xml
        │       └── activity_third.xml
        │
        └── AndroidManifest.xml

❓ Odgovori na vprašanja

1. Kateri menijski ukaz v Android Studiu uporabimo za dodajanje nove aktivnosti?

File → New → Activity → Empty Views Activity

2. Katere datoteke se dodajo pri ustvarjanju aktivnosti HelloActivity?

Dodajo se:

HelloActivity.java
activity_hello.xml

Posodobi se tudi obstoječa datoteka AndroidManifest.xml.

3. Kateri konstruktor uporabimo za ustvarjanje novega eksplicitnega namena?

Pravilen odgovor: b)

new Intent(Context context, Class<?> class)

4. Kako trenutni vrednosti števca dodamo v Intent?

Pravilen odgovor: c)

Kot dodaten podatek namena (Extra) z uporabo metode putExtra().

5. S katero metodo zaženemo HelloActivity in ji posredujemo vrednost števca?

Pravilen odgovor: d)

goToActivity1()

6. Kako v HelloActivity pravilno posodobimo prikaz števca?

Pravilen odgovor: d)

Vse navedeno:

Pridobimo Intent.
Iz njega preberemo vrednost števca.
Posodobimo besedilni pogled (TextView).

7. Kateri zastavici omogočata vrnitev na MainActivity brez ustvarjanja dodatnih primerkov aktivnosti?

Pravilen odgovor: b)

Intent.FLAG_ACTIVITY_CLEAR_TOP in Intent.FLAG_ACTIVITY_SINGLE_TOP.

8. Kaj je glavna vloga ThirdActivity?

Pravilen odgovor: c)

Prikaz prenesenega števca in omogočanje dodatne navigacije med aktivnostmi.

🎯 Cilj naloge

S praktično izdelavo aplikacije sem spoznal:

Ustvarjanje in povezovanje več Android aktivnosti.
Uporabo eksplicitnih Intentov.
Prenos podatkov med aktivnostmi.
Upravljanje navigacije med zasloni.
Zaznavanje potez uporabnika s pomočjo GestureDetector.

Predmet: Razvoj mobilnih aplikacij
Naloga: 5 – Delo z različnimi aktivnostmi
Jezik: Java
Platforma: Android
