# Inteligentne systemy pomiarowe

Celem projektu było opracowanie modelu matematycznego służącego do prognozowania zmian pogody na podstawie danych przychodzących z kilku czujników jednocześnie. Zaimplementowanie algorytmu predykcyjnego, wykorzystanie archiwalnych danych jako zbioru uczącego.

## Wykorzystane technlogie
- Spring Boot jako backend
- HTML + JavaScript jako frontend
- Python do opracowania modelu
- Docker

## Uruchamianie
Po wykonaniu poniższych komend aplikacja będzie dostępna pod adresem http://localhost:8080
```bash
docker build -t isp .
docker run -p 8080:8080 isp
```

## Wdrażanie aplikacji na chmurę
```bash
docker tag isp pawstern.azurecr.io:model
docker push pawstern.azurecr.io:model
```
Aplikacja jest dostępna pod adresem https://storm-api-model.azurewebsites.net

## Wysyłanie pomiarów do serwera
Przykład wysłania nowego pomiaru
```
curl -X POST --data {"id":id, "timestamp":"1200", "temperature":temperature, "dew":dew, "humidity":humidity, "pressure":pressure, "wind":wind} http://localhost:8080/samples
 ```
Na potrzeby prezentacji stworzono aplikację która losuje dane pomiarowe i wysyła do serwera co 15 sekund. Można ją uruchomić za pomocą:
```bash
docker build -t isp-post api_post
docker run --rm isp-post
```

## Model matematyczny
Do wyznaczenia modelu wykorzystano metodę regresji liniowej. Program wykorzystany do wyznaczenia współczynników funkcji liniowej można znaleźć w folderze `linear_regression`.  Model wyznacza przewidywaną temperaturę, na podstawie panujących w danej chwili warunków:
- temperatury punktu rosy [st. C]
- wilgotności [%]
- ciśnienia [hPa]
- prędkości wiatru [m/s]

$$
T = a + b (AvgDew) + c (AvgHum) + d (AvgPress) + e (AvgWind)
$$
Gdzie:
- AvgDew - średnia temperatura punktu rosy
- AvgHum - średnia wilgotność
- AvgPress - średnie ciśnienie
- AvgWind - średnia prędkość wiatru
- a...e - współczynniki równania