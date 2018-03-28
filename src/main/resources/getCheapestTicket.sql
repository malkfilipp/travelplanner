select
        T.id                id,
        Airline.name        airline,
        Aircraft.type       aircraft,
        F.number            flightNumber,
        DepartureCity.name  departureCity,
        ArrivalCity.name    arrivalCity,
        DepartureAirport.id departureAirport,
        ArrivalAirport.id   arrivalAirport,
        S.departureTime     departureTime,
        S.arrivalTime       arrivalTime,
        T.class             travelClass,
        T.amount            amount,
        T.quantity          quantity

      from Ticket T
        inner join Shedule S on T.sheduleId = S.id
        inner join Flight F on S.flightId = F.id
        inner join Aircraft on F.aircraftId = Aircraft.id
        inner join Airline on F.airlineId = Airline.id
        inner join Airport DepartureAirport on F.departureAirportId = DepartureAirport.id
        inner join Airport ArrivalAirport on F.arrivalAirportId = ArrivalAirport.id
        inner join City DepartureCity on DepartureAirport.cityId = DepartureCity.id
        inner join City ArrivalCity on ArrivalAirport.cityId = ArrivalCity.id
where quantity > 0
      and DepartureCity.name = ?
      and ArrivalCity.name = ?
      and (departureTime between timestamp(concat(?), ' 00:00:00')
and timestamp(concat(?), ' 23:59:59'))
order by amount
limit 5;





