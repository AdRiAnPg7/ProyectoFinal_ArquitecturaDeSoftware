import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { HomeComponent } from './pages/home/home.component';
import { TelefonoComponent } from './pages/telefono/telefono.component';
import { FacturarComponent } from './pages/facturar/facturar.component';
import { HttpClientModule } from '@angular/common/http';
import { FacturaComponent } from './pages/factura/factura.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({

  declarations: [
    AppComponent,
    HomeComponent,
    TelefonoComponent,
    FacturarComponent,
    FacturaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MDBBootstrapModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
