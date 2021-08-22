## Project backlog:
- integracja z 3 giełdami (po jednej na story)
  - możliwość pobierania kursu waluty ze zdefiniowanej giełdy w danym momemcie
  - interwał czasu dla odpytań
  - zakres czasu z którego chcemy zobaczyć kurs
  - waluty:
      - Crypto:
      - BTC
      - ETH
      - Fiat:
      - USD
      - EURO
      - PLN
      - złoto
      - srebro
  - https://binance-docs.github.io/apidocs/spot/en/
  - https://bittrex.github.io/api/v3
  - https://coinmarketcap.com/api/
  - https://bitbay.net/pl/api-prywatne
  - dev todo: 5 sda days - 15 sda days
    - rozpoznanie API
    - zbudować importer per giełda
    - entity:
    - dto
    - repository
    - serwis
    - serwis webowy (thymeleaf)
    - serwis restowy (dla Angulara)
    - UI Angular
  
- wykresy: 1 - 3 sda days
  - cena - czas
  - rozny kolor w zaleznosci od tego czy jest tendencja spadkowa czy wzrostowa
  - zbudowany slupek od minimalnej do maksymalnej ceny w zaleznosci od interwalu czasowego
  - dev TODO:
    - wybór biblioteki
    - filtrowanie
    - sortowanie
    - kontroler
    - UI Angular

- transakcje 2 - 4 sda days
  - możliwość przeprowadzania transakcji
  - historia
    - informacje o naszych transakcjach (cena, punkt na osi czasu)
  - dev TODO:
    - kontroler
    - UI Angular
    - integracja z portfelem

#### REFINEMENT
- wyswietlanie TOP/sortowanie
- maksymalna i minnimalna cena w miesiacu
- przeliczanie walut
- wiadomości ze świata  😀
    - market research
- wyswietlanie paska z wartościami np. WIG 20
- alerty
- portfel
- filtry
- zleć kupno lub sprzedaż gdy wartość jest wybrana
- panel administracji konta
- może logowanie uzytkownika
- zmiana hasla
- opcja premium

#### MVC (Model, View, Controller)
V - view
C - controller
M - model (data + operations)

View - dto
Controller - returns dto
Service - operations
Repository - data (entities)

#### Responsibilities

Controller
- returns views/data
- handle queries

Service
- business logic :)

Repository
- data management

#### Restfull (CRUD on Http)
- resource has URI
- Read - GET
- Create - POST
- Delete - DELETE
- Update - PUT (replace), PATCH (partial update)

#### Http Response codes
- 1xx - processing in progress
- 2xx - ok
- 3xx - redirect
- 4xx - client error
- 5xx - server error
