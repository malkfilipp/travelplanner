import {Component, Input} from '@angular/core';
import {Observable} from 'rxjs';
import {Ticket} from '../model/ticket';

@Component({
  selector: 'app-ticket-table',
  templateUrl: './ticket-table.component.html',
  styleUrls: ['./ticket-table.component.css']
})
export class TicketTableComponent {
  @Input() tickets: Observable<Ticket[]>;
  displayedColumns = [
    'number', 'airline', 'aircraft', 'departure', 'arrival',
    'departureTime', 'arrivalTime', 'travelClass', 'amount'
  ];
}
