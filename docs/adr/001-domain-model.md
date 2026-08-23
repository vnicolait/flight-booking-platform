Airport :
code:int
name:String
locality:String
country:String

Seat :
numberSeat:int
positition:String //window, aisle
typeSeat: TypeSeat // VIP, TOURIST, BUSINESS
availableSeat: boolean // This field represent if there are seat available.

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
We decided to create four fields for the `Airport` class. The IATA code was chosen because it is the industry standard for identifying airports. The name and location are also fundamental fields. There were no conflicting alternatives considered for this class as the requirements were straightforward.

#### 2. Seat Class
The most critical decision for the `Seat` class was adding a UUID identifier. This ensures each seat instance is unique, preventing concurrency issues where two users might attempt to reserve the same seat simultaneously. Additionally, we considered adding a description field to store extra seat details.

#### 3. Flight Class
For the `Flight` class, we decided to use a UUID as the primary identifier to facilitate database persistence and querying.

Furthermore, we made the following architectural choices:
* **Money Representation:** We introduced a dedicated `Money` class. Using a custom object or `BigDecimal` for monetary amounts is a much better practice than using `float` or `double`, as it avoids floating-point rounding errors. To handle currency formatting and calculations properly, we adopted `RoundingMode.HALF_EVEN` (Banker's rounding).
* **Enums:** We created two enums: `FlightStatus` (to track whether a flight is scheduled, delayed, or arrived) and `ReservationStatus` (to manage the lifecycle of a booking and handle race conditions when two people target the same seat at the same time).

Airport :
iata:String
name:String
city:String
country:String

Seat :
private UUID id // for our query in the place of persistence
numberSeat:int
positition:String //window, aisle
typeSeat: TypeSeat // VIP, TOURIST, BUSINESS
availableSeat: boolean // This field represent if there are seat available.

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
statusReservation: StatusReservation //Enum {PENDING_PAYMENT, CONFIRMED, CANCELLED, EXPIRED}