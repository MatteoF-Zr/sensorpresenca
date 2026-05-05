#define PIR 21
#define LED_VERDE 23
#define LED_VERMELHO 22

#define BTN_ADD 18
#define BTN_SUB 19

int contador = 0;
int limite = 10;

unsigned long ultimoTempoPIR = 0;
int intervaloPIR = 1500;

// debounce
unsigned long ultimoCliqueAdd = 0;
unsigned long ultimoCliqueSub = 0;
int debounceDelay = 250;

void setup() {
  pinMode(PIR, INPUT);

  pinMode(LED_VERDE, OUTPUT);
  pinMode(LED_VERMELHO, OUTPUT);

  pinMode(BTN_ADD, INPUT_PULLUP);
  pinMode(BTN_SUB, INPUT_PULLUP);

  Serial.begin(115200);
}

void loop() {
  int movimento = digitalRead(PIR);

  // =====================
  // PIR
  // =====================
  if (movimento == HIGH && millis() - ultimoTempoPIR > intervaloPIR) {
    contador++;
    ultimoTempoPIR = millis();

    Serial.print("PIR: ");
    Serial.println(contador);
  }

  // =====================
  // BOTÃO +
  // =====================
  if (digitalRead(BTN_ADD) == LOW && millis() - ultimoCliqueAdd > debounceDelay) {
    contador++;
    ultimoCliqueAdd = millis();

    Serial.print("+: ");
    Serial.println(contador);
  }

  // =====================
  // BOTÃO -
  // =====================
  if (digitalRead(BTN_SUB) == LOW && millis() - ultimoCliqueSub > debounceDelay && contador > 0) {
    contador--;
    ultimoCliqueSub = millis();

    Serial.print("-: ");
    Serial.println(contador);
  }

  // =====================
  // LEDs
  // =====================
  if (contador >= limite) {
    digitalWrite(LED_VERMELHO, HIGH);
    digitalWrite(LED_VERDE, LOW);
  } else {
    digitalWrite(LED_VERDE, HIGH);
    digitalWrite(LED_VERMELHO, LOW);
  }
}