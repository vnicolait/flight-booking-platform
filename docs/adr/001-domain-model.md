Context:
In the class Airport we decided create to 4 fields, the code iata is a standar identify airport and the name and place are fundamental, about desition
we haven't problems.

In the class Seat the most relevant we wereconsidered to add code uuid for avoid that 2 persons reserver at the same time, After that also considered to add
the field description after //

In the class Flight we considered to add one code uuid for we review in the place persistence, we considered decition to add one class Money because
for issue amount is the better than for example float in the other hand in the issue related to currency to used RoundingMode.HALF_EVEN. Also
we decided to 2 Enum StatusFlight and StatusReservation, in the first related to If Flight be in Arrived or no, in the second for example I f two person reserver in the same moment we need to review that


### Context & Decisions

#### 1. Airport Class
We decided to create four fields for the `Airport` class. The IATA code was chosen because it is the industry standard for identifying airports (query of clients). The name and location are also fundamental fields. There were no conflicting alternatives considered for this class as the requirements were straightforward.
For our query  we need one code of type int in this case it's internal related to persistence , it's not necesary one code uuid there isn't miles airport

#### 2. Seat Class
The most critical decision for the `Seat` class was adding a UUID identifier. This ensures each seat instance is unique, preventing concurrency issues where two users might attempt to reserve the same seat simultaneously.
Additionally, we considered adding a description field to store extra seat details.(We have considered removing the latter for the time being.)

#### 3. Flight Class
For the `Flight` class, we decided to use a UUID as the primary identifier to facilitate database persistence and querying.

Furthermore, we made the following architectural choices:
* **Money Representation:** We introduced a dedicated `Money` class. Using a custom object or `BigDecimal` for monetary amounts is a much better practice than using `float` or `double`, as it avoids floating-point rounding errors. To handle currency formatting and calculations properly, we adopted `RoundingMode.HALF_EVEN` (Banker's rounding).
  Alternatives that were considered long for amount but  is more eficient, we also rule out double because issue taxes that they be precise calculations , fees we need that but not forget related to currency
  On the other hand we decided put in this class field of type boolean If one seat is available or not, that operation of business belong to other Entity that maybe will build in the future

Something more or less similar in pseudocode:
@Embeddable
public class Money {

    @Column(name = "amount", precision = 19, scale = 4)
    private BigDecimal amount;

    @Column(name = "currency", length = 3)
    private String currencyCode; // ISO 4217, ej. "EUR"

    public Money add(Money other) {
        if (!this.currencyCode.equals(other.currencyCode)) {
            throw new IllegalArgumentException("No se pueden sumar divisas distintas");
        }
        return new Money(this.amount.add(other.amount), this.currencyCode);
    }

    // Conversión al borde del sistema, ej. hacia pasarela de pago
    public long toMinorUnits() {
        Currency currency = Currency.getInstance(currencyCode);
        int fractionDigits = currency.getDefaultFractionDigits();
        return amount.movePointRight(fractionDigits).setScale(0, RoundingMode.HALF_EVEN).longValueExact();
    }
}
* **Enums:** We created two enums: `FlightStatus` (to track whether a flight is scheduled, delayed, or arrived) and `ReservationStatus` (to manage the lifecycle of a booking and handle race conditions when two people target the same seat at the same time).

Airport :
code: int
iata:String
name:String
city:String
country:String

Seat :
private UUID id // for our query in the place of persistence
seatCode:String
positition:String //window/aisle/middle
typeSeat: TypeSeat // VIP, TOURIST, BUSINESS
//statusReservation: StatusReservation //Enum {PENDING_PAYMENT, CONFIRMED, CANCELLED, EXPIRED}	  
availableSeat: boolean

Flight :
id: UUID //PK in the area persistence, the client should not to know
flightNumber // area of business for the customer can to review the flight
priceFlight: Money // this class has 2 fields amount (BigDecimal) and currency , I think class Money apart is better because
// we have business logiz related to amount and currency
departureFlight: LocalDate
arriveFlight: LocalDate
from:Airport //Airport origin
to: Airport // Airport destination
seat: List<Seat>
status: StatusFlight // Enum { Arrived, Departed, Cancelled, Delayed } Description state of flight

Consequences:
It's important to keep in mind identifiers in Flight and Seat will be referenced by Booking Service, each microservice will have it's own Database 