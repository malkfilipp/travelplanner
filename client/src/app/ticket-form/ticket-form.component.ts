import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {TicketService} from '../service/ticket.service';
import {CityService} from '../service/city.service';
import {Ticket} from '../model/ticket';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';

@Component({
  selector: 'app-ticket-form',
  templateUrl: './ticket-form.component.html',
  styleUrls: ['./ticket-form.component.css'],
})

export class TicketFormComponent {
  ticketForm: FormGroup;
  cities: string[] = [];
  filteredDepartureCities: Observable<string[]>;
  filteredArrivalCities: Observable<string[]>;
  tickets: Observable<Ticket[]>;
  submitted = false;

  constructor(private ticketService: TicketService,
              private cityService: CityService,
              private formBuilder: FormBuilder) {
    this.ticketForm = formBuilder.group({
      'departureCity': ['', Validators.required],
      'arrivalCity': ['', Validators.required],
      'date': ['', Validators.required],
    });

    this.cityService.get().subscribe(cities => {
      cities.forEach(city => this.cities.push(city.name));

      this.filteredDepartureCities = this.getFilteredCities('departureCity');
      this.filteredArrivalCities = this.getFilteredCities('arrivalCity');
    });
  }

  private getFilteredCities(city: string) {
    return this.ticketForm.get(city).valueChanges
      .pipe(
        startWith(''),
        map(value => this.filter(value))
      );
  }

  private filter(value: string): string[] {
    const filterValue = value.toLowerCase();
    return this.cities.filter(city => city.toLowerCase().includes(filterValue));
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
