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

Flight :
id: UUID //PK in the area persistence, the client should not to know
flightNumber // area of business for the customer can to review the flight
priceFlight: Money // this class has 2 fields amount (BigDecimal) and currency , I think class Money apart is better because
// we have business logiz related to amount and currency
departureFlight: LocalDate
arriveFlight: LocalDate
nameAirport:String //here I doubt because I dont it's necesary to bring all class
seat: Seat
status: Status // Enum { AVAILABLE, PENDING, CANECELLED, CONFIRMED } Description state of flight
	  