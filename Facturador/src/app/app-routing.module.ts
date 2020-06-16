import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { TelefonoComponent } from './pages/telefono/telefono.component';
import { FacturarComponent } from './pages/facturar/facturar.component';
import { FacturaComponent } from './pages/factura/factura.component';


const routes: Routes = [
  { path:'', redirectTo:'inicio', pathMatch:'full' },
  { path:'inicio', component: HomeComponent },
  { path:'telefono', component: TelefonoComponent },
  { path:'telefono/:telefono/facturar', component: FacturarComponent },
  { path:'telefono/:telefono/facturar/:anio/:mes/factura', component: FacturaComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
