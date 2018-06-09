import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Ticket} from '../model/ticket';

@Injectable()
export class TicketService {
  // TODO: move to config file
  public API = '//localhost:8080';
  public TICKET_API = this.API + '/tickets';

  constructor(private http: HttpClient) {
  }

  get(departure: string, arrival: string, date: string): Observable<Ticket[]> {
    return this.http.get<Ticket[]>(this.TICKET_API, {
      params: new HttpParams()
        .set('departure', departure)
        .set('arrival', arrival)
        .set('date', date)
    }); // TODO: errors
  }
}
