import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {
  MatAutocompleteModule,
  MatButtonModule,
  MatCardModule,
  MatDatepickerModule,
  MatFormFieldModule,
  MatInputModule,
  MatListModule,
  MatNativeDateModule,
  MatProgressSpinnerModule,
  MatTableModule,
  MatToolbarModule
} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {AppComponent} from './app.component';
import {TicketService} from './service/ticket.service';
import {TicketTableComponent} from './ticket-table/ticket-table.component';
import {TicketFormComponent} from './ticket-form/ticket-form.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CityService} from './service/city.service';

@NgModule({
  declarations: [
    AppComponent,
    TicketTableComponent,
    TicketFormComponent
  ],
  imports: [
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatAutocompleteModule,
    MatButtonModule,
    MatCardModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatInputModule,
    MatListModule,
    MatNativeDateModule,
    MatToolbarModule,
    MatTableModule,
    MatProgressSpinnerModule,
  ],
  providers: [TicketService, CityService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
