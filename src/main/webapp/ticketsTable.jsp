<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, th, td {
            border: 1px solid black;
            text-align: center;
            padding: 15px;
        }
    </style>
</head>
<body>
<table>
    <tbody>
    <tr>
        <th>Flight number</th>
        <th>Airline</th>
        <th>Aircraft</th>
        <th>Departure</th>
        <th>Arrival</th>
        <th>Departure time</th>
        <th>Arrival time</th>
        <th>Class</th>
        <th>Amount</th>
    </tr>
    <c:forEach items="${requestScope.tickets}" var="ticket">
        <tr>
            <td>${ticket.shedule.flight.number}</td>
            <td>${ticket.shedule.flight.airline.name}</td>
            <td>${ticket.shedule.flight.aircraft.type}</td>
            <td>${ticket.shedule.flight.departureAirport.id}</td>
            <td>${ticket.shedule.flight.arrivalAirport.id}</td>
            <td>${ticket.shedule.departureTime}</td>
            <td>${ticket.shedule.arrivalTime}</td>
            <td>${ticket.travelClass}</td>
            <td>${ticket.amount}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
