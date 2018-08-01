import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {City} from '../model/city';


@Injectable()
export class CityService {
  constructor(private http: HttpClient) {
  }

  get() {
    return this.http.get<City[]>(environment.citiesApi);
  }
}
