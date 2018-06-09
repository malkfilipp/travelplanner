import {Component} from '@angular/core';

import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {TicketService} from '../service/ticket.service';
import {Ticket} from '../model/ticket';
import {Observable} from 'rxjs/Observable';

@Component({
  selector: 'app-ticket-form',
  templateUrl: './ticket-form.component.html',
  styleUrls: ['./ticket-form.component.css'],
})

export class TicketFormComponent {
  ticketForm: FormGroup;
  tickets: Observable<Ticket[]>;
  submitted = false;

  constructor(private ticketService: TicketService,
              private fb: FormBuilder) {
    this.ticketForm = fb.group({
      'departureCity': ['', Validators.required],
      'arrivalCity': ['', Validators.required],
      'date': ['', Validators.required],
    });

  }

  onSubmit() {
    const date = new Date(this.ticketForm.get('date').value);
    const formattedDate = date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();

    this.tickets = this.ticketService.get(
      this.ticketForm.get('departureCity').value,
      this.ticketForm.get('arrivalCity').value,
      formattedDate
    );

    this.submitted = true;
  }
}
