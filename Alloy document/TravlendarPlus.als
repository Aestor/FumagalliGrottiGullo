/*			
			Travlendar+
			---Alloy project---

			Paolo Fumagalli
			Pietro Grotti
			Marco Gullo
*/

module TravlendarPlus
open util/boolean

			// SYSTEM
			// Encloses all the users and the external actors

one sig System {
	users: set User,
	externals: set Actor
}

			// EXTERNAL ACTORS
			// Provide services like public transport, car sharing, bike sharing and train

abstract sig Actor {}

sig PublicTransports extends Actor {
	service: one Public,
	issued: some PublicTransportTicket
}

sig CarSharingService extends Actor {
	service: one CarSharing
}

sig BikeSharingService extends Actor {
	service: one BikeSharing
}

sig TrainService extends Actor {
	service: one Train,
	issued: some TrainTicket
}

sig TaxiService extends Actor {
	service: one Taxi
}

	// ...facts

fact actorsInSystem {
	all a: Actor | a in System.externals
}

			// TRANSPORT

abstract sig Transport {}

one sig Car, Walking extends Transport {}

// Theese transports exist only if the service provider exists (see facts)
lone sig Public, CarSharing, BikeSharing, Train, Taxi extends Transport {}

	// ...facts

fact noTransportWithoutService {
	all t: Public | one s: PublicTransports | t in s.service
	all t: CarSharing | one s: CarSharingService | t in s.service
	all t: BikeSharing | one s: BikeSharingService | t in s.service
	all t: Train | one s: TrainService | t in s.service
	all t: Taxi | one s: TaxiService | t in s.service
}

			// USER

abstract sig User {}

sig Registered extends User {
	schedule: one Schedule,
	dailyPath: one DailyPath,
	settings: one Settings,
	tickets: some Ticket,
	balance: one Balance
}

sig Balance {}

sig Guest extends User {}

	// ...facts 

fact usersInSystem {
	all u: User | u in System.users
}

fact balanceOfUser {
	all b: Balance | one u: Registered | b in u.balance
}

			// DAY TIME
			// A discrete representation of the day

abstract sig DayTime {}

one sig Morning, Lunch, Afternoon, Evening, Night extends DayTime {}

			// DISTANCE

abstract sig Distance {}

one sig Short, Medium, Long extends Distance {}

			// USER SETTINGS

sig Settings {
	refuses: some Transport,
	constraints: some TimeConstraint,
	lunchConstraint: one Bool, // defines if the user wants to establisha  lunch break
	walkConstraint: lone Bool, // defines if the user wants to walk only for short paths
	bikeConstraint: lone Bool // defines if the user wants to use the bike only for short paths
}

	// ...facts

fact uniqueSettings {
	all s: Settings | one u: User | s in u.settings
}

fact walkAndBikeConstraints {
	all s: Settings | Walking in s.refuses => #s.walkConstraint = 0 and BikeSharing in s.refuses => #s.bikeConstraint = 0
}

			// TIME CONSTRAINTS
			// Defines the day times the user wants to avoid a kind of transport

sig TimeConstraint {
	transport: one Transport,
	time: some DayTime // denied day times
}

	// ...facts

fact constraintsForSettings {
	all c: TimeConstraint | one s: Settings | c in s.constraints
}

fact noConstraintsOnRefuses {
	all s: Settings | all t: Transport | t in s.refuses => t not in s.constraints.transport
}

fact noDifferentConstraintsOnTheSameTransport {
	all c1, c2: TimeConstraint | all t: Transport | all s: Settings | (c1 != c2 and c1 in s.constraints and c2 in s.constraints and t in c1.transport) => t not in c2.transport
}

			// SCHEDULE AND DAILY PATH

sig Schedule {
	events: set Event
}

sig DailyPath {
	paths: set Path
}

	// ...facts

fact DailyPathForUsers {
	all d: DailyPath | one u: Registered | d in u.dailyPath
}

fact ScheduleForUsers {
	all s: Schedule | one u: Registered | s in u.schedule
}

			// EVENT

sig Event {
	path: one Path,
	alternative: lone Path,
	time: one DayTime,
	distance: one Distance
}

	// ...facts

fact eventsAssociation {
	all e: Event | one s: Schedule | e in s.events
}

fact eventsAtLunch {
	// If the user set a lunch time, deny any event at that time and deny events at long distances in the afternoon
	all u: Registered | all e: Event | (u.settings.lunchConstraint = True and e in u.schedule.events) => (Lunch not in e.time and (Long in e.distance => Afternoon not in e.time))
}

			// PATH

sig Path {
	transport: one Transport,
	accepted: one Bool, // Accepted by the user
	onTime: one Bool // Defines if the user will be able to be on time following this path
}

	// ...facts

fact pathUnicity {
	all p: Path | one e: Event | p in e.path or p in e.alternative
	all p: Path | all e: Event | all u: Registered | ((p in e.path or p in e.alternative) and e in u.schedule.events) => p in u.dailyPath.paths
	all p: Path | all e: Event | (p in e.path => p not in e.alternative) and (p in e.alternative => p not in e.path)
}

fact alternativesSuggestDifferentTransports {
	all e: Event | all t: Transport | t in e.path.transport => t not in e.alternative.transport
}

fact dontSuggestRefusedTransports {
	all u: Registered | all t: Transport | all e: Event | all p: Path | (e in u.schedule.events and (p in e.path or p in e.alternative) and t in u.settings.refuses) => t not in p.transport
} 

fact trainOrCarForLongDistances {
	all e: Event | all p: Path | ((p in e.path or p in e.alternative) and Long in e.distance) => (Train in p.transport or Car in p.transport)
}

fact walkConstraint {
	all p: Path | all e: Event | all u: Registered | (e in u.schedule.events and (p in e.path or p in e.alternative) and u.settings.walkConstraint = True and Walking in p.transport) => Short in e.distance
} 

fact bikeConstraint {
	all p: Path | all e: Event | all u: Registered | (e in u.schedule.events and (p in e.path or p in e.alternative) and u.settings.bikeConstraint = True and BikeSharing in p.transport) => Short in e.distance
} 

fact timeConstraint {
	all u: Registered | all e: Event | all p: Path | all c: TimeConstraint | all d: DayTime | all t: Transport | (t in c.transport and d in c.time and c in u.settings.constraints 
		and e in u.schedule.events and (p in e.path or p in e.alternative) and d in e.time) => 
			t not in p.transport
}

fact suggestAlternativesIfLateOrRefused {
	all p: Path | all e: Event | (p in e.path and p.accepted = True and p.onTime = True) => #e.alternative = 0
}

			// TICKETS

abstract sig Ticket {}

sig PublicTransportTicket extends Ticket {}

abstract sig TrainTicket extends Ticket {}

sig SingleTrainTicket, DailyTrainTicket, MonthlyTrainTicket extends TrainTicket {}

	// ...facts

fact ticketsForUsers {
	all t: Ticket | one u: Registered | t in u.tickets
}

fact availableTickets {
	all t: TrainTicket | one s: TrainService | t in s.issued
	all t: PublicTransportTicket | one s: PublicTransports | t in s.issued
}

fact oneTrainTicket {
	all u: Registered | all d: DailyTrainTicket | all t: TrainTicket | t!=d and d in u.tickets => t not in u.tickets
	all u: Registered | all m: MonthlyTrainTicket | all t: TrainTicket | t!=m and m in u.tickets => t not in u.tickets
}

			// COMMAND AND PREDICATES

pred externalsExisting {
	#System.externals > 2
}

pred eventsExisting {
	#Event > 1
}

pred moreRegistered {
	#System.users > 1
	no g: Guest | g in System.users
}

run eventsExisting
//run moreRegistered
