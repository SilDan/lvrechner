# LVRechner

Eine Spring Boot Anwendung zur Berechnung von Lebensversicherungsbeiträgen.

## Beschreibung

Diese Anwendung bietet eine REST-API, um den monatlichen Beitrag einer Lebensversicherung zu berechnen.  
Der Beitrag wird basierend auf Alter, Versicherungssumme und Laufzeit berechnet.

## API

### Endpunkt

`POST /api/berechne`

### Request Body (JSON)

```json
{
  "alter": 35,
  "versicherungssumme": 100000,
  "laufzeit": 20
}
