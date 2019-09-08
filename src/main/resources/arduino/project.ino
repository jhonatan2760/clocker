#include <Wire.h> //INCLUSÃO DE BIBLIOTECA
#include <LiquidCrystal_I2C.h> //INCLUSÃO DE BIBLIOTECA
#include "RTClib.h" //INCLUSÃO DA BIBLIOTECA
#include <dht.h>

RTC_DS3231 rtc; //OBJETO DO TIPO RTC_DS3231

dht DHT;

#define DHT11_PIN 7

LiquidCrystal_I2C lcd(0x27,2,1,0,4,5,6,7,3, POSITIVE); //ENDEREÇO DO I2C E DEMAIS INFORMAÇÕES

float seno;
int frequencia;

byte termo[] = {
  B00100,
  B01010,
  B01010,
  B01110,
  B01110,
  B11111,
  B11111,
  B01110
};

byte cool[] = {
  B00000,
  B00000,
  B11011,
  B11011,
  B00000,
  B10001,
  B01110,
  B00000
};

byte medium_bar[] = {
  B00000,
  B00000,
  B00000,
  B01111,
  B01111,
  B01111,
  B01111,
  B01111
};

byte low_bar[] = {
  B00000,
  B00000,
  B00000,
  B00000,
  B00000,
  B11111,
  B11111,
  B11111
};

byte blueethoot[] = {
  B00100,
  B00110,
  B10101,
  B01110,
  B01110,
  B10101,
  B00110,
  B00100
};

byte antena[8] = {
  B11111,
  B10101,
  B10101,
  B01110,
  B00100,
  B00100,
  B00100,
  B00100
};

byte Clock[8] = {
  B00000,
  B01110,
  B10101,
  B11101,
  B10001,
  B01110,
  B00000,
  B00000
};

byte Skull[8] = {
0b00000,
0b01110,
0b10101,
0b11011,
0b01110,
0b01110,
0b00000,
0b00000
};


void setup()
{

  Serial.begin(9600);

  if(! rtc.begin()) { // SE O RTC NÃO FOR INICIALIZADO, FAZ
    Serial.println("DS3231 não encontrado"); //IMPRIME O TEXTO NO MONITOR SERIAL
    while(1); //SEMPRE ENTRE NO LOOP
  }
  if(rtc.lostPower()){ //SE RTC FOI LIGADO PELA PRIMEIRA VEZ / FICOU SEM ENERGIA / ESGOTOU A BATERIA, FAZ
    Serial.println("DS3231 OK!"); //IMPRIME O TEXTO NO MONITOR SERIAL
    //REMOVA O COMENTÁRIO DE UMA DAS LINHAS ABAIXO PARA INSERIR AS INFORMAÇÕES ATUALIZADAS EM SEU RTC
    //rtc.adjust(DateTime(F(__DATE__), F(__TIME__))); //CAPTURA A DATA E HORA EM QUE O SKETCH É COMPILADO
    //rtc.adjust(DateTime(2018, 9, 29, 15, 00, 45)); //(ANO), (MÊS), (DIA), (HORA), (MINUTOS), (SEGUNDOS)
  }
  //delay(100);

  pinMode(0, OUTPUT);
  pinMode(9, OUTPUT);

  // initialize LCD and set up the number of columns and rows:
  lcd.begin(16, 2);

  // create a new character
  lcd.setBacklight(1);
  lcd.createChar(0, Skull);
  lcd.createChar(1, Clock);
  lcd.createChar(2, blueethoot);
  lcd.createChar(3, low_bar);
  lcd.createChar(4, medium_bar);
  lcd.createChar(5, cool);
  lcd.createChar(6, termo);
  // Clears the LCD screen
  lcd.clear();

  // Print a message to the lcd.
  //lcd.print("Medidor de gás");

  lcd.setCursor(0, 0);
  lcd.write(byte(5));
  lcd.setCursor(0,1);
  //lcd.createChar(0, Skull);
  lcd.write(byte(1));
  lcd.setCursor(12, 0);
  lcd.write(byte(2));
  lcd.setCursor(13,0);
  lcd.write(byte(3));
  lcd.setCursor(14,0);
  lcd.write(byte(4));
  lcd.setCursor(11,1);
  lcd.write(byte(6));
  //tone(9, 0);
}

// Print All the custom characters
void loop()
{

 DateTime now = rtc.now();
  int gas = analogRead(0);
  lcd.setCursor(2,0);
  lcd.print(gas);
  Serial.println(gas);


  if(gas > 200){
    lcd.setCursor(0, 0);
    lcd.write(byte(0));
    for(int x=0;x<180;x++){
      //converte graus para radiando e depois obtém o valor do seno
      seno=(sin(x*3.1416/180));
      //gera uma frequência a partir do valor do seno
      frequencia = 2000+(int(seno*1000));
      tone(9,frequencia);
      delay(2);
    }
    noTone(9);


  }else{
    lcd.setCursor(0,0);
    lcd.write(byte(5));
    //lcd.print("");
  }

  /*Primeiro parametro horizontal, segundo vertical*/
  lcd.setCursor(2, 2);
  lcd.print(now.hour());
  lcd.setCursor(4,2);
  lcd.print(":");
  lcd.setCursor(5,2);
  lcd.print(now.minute());
  //Serial.println(now.day()+"/"+now.month()+"/"+now.year(), DEC);
  delay(1000);

  lcd.setCursor(12,2);
  int chk = DHT.read11(DHT11_PIN);
 lcd.print((float) (DHT.temperature + 6) , 0);
 lcd.setCursor(14,2);
 lcd.print((char)223); //degree sign
 lcd.setCursor(15,2);
 lcd.println("C");
 Serial.println("Hello World!");
}