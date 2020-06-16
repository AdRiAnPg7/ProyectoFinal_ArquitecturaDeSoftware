import { Component, OnInit, ViewChild } from '@angular/core';
import { MdbTableDirective } from 'angular-bootstrap-md';
import { ActivatedRoute } from '@angular/router';
import { TelefonoService } from 'src/app/services/telefono.service';
import { Factura } from '../models/Factura';


@Component({
  selector: 'app-facturar',
  templateUrl: './facturar.component.html',
  styleUrls: ['./facturar.component.scss']
})
export class FacturarComponent implements OnInit {

  constructor( 
    private activatedRoute: ActivatedRoute,
    private telefonoService:TelefonoService
    ) { }

  // Data Users
  public cdrs = [];
  public factura: Factura = new Factura();

  //
  hayFactura : Boolean;

  //Factura Data
  facturas : Array<Factura> = [];

  @ViewChild(MdbTableDirective, { static: true })
  mdbTable: MdbTableDirective; 
  headElements = [ 'AÑO','MES' ,'Facturar']; 
  
  //user vars
  telefono: string;

  ngOnInit(): void {
    this.getRouteData();
    this.getCDRData();
  
  }

  getRouteData():void{
    this.activatedRoute.params.subscribe(params => {
      this.telefono = params['telefono'];
    });
  }


  getCDRData(): void{
    var cont = 0;
    this.telefonoService.getCDRs().subscribe(data =>{
      for( let dat of data){
        if(dat.telefonoOrigen == this.telefono){
            this.cdrs[cont] = dat;
            this.hayFactura=true;
            cont++;
        }
      }
      for( let cdr of this.cdrs){
        var sAnio = cdr.fecha.split('/').pop().split('/')[0];
        var sMes = cdr.fecha.split('/')[1];
        this.factura.mes=sMes;
        this.factura.anio=sAnio;
        this.facturas.push(this.factura);
      }
    })
  }


}
