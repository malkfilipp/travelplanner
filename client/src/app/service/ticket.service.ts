import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Ticket} from '../model/ticket';
import {environment} from '../../environments/environment';

@Injectable()
export class TicketService {
  constructor(private http: HttpClient) {
  }

  get(departure: string, arrival: string, date: string) {
    return this.http.get<Ticket[]>(environment.ticketsApi, {
      params: new HttpParams()
        .set('departure', departure)
        .set('arrival', arrival)
        .set('date', date)
    });
  }
}
