import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import * as jspdf from 'jspdf';  
import html2canvas from 'html2canvas'; 
import { TelefonoService } from 'src/app/services/telefono.service';

@Component({
  selector: 'app-factura',
  templateUrl: './factura.component.html',
  styleUrls: ['./factura.component.scss']
})
export class FacturaComponent implements OnInit {

  constructor(private activatedRoute: ActivatedRoute,
    private telefonoService:TelefonoService) { }

  telefono:string;
  mes:string;
  anio:string;

  costoTotal:number = 0;
  // Data Users
  public cdrs = [];
  public usuarios = [];
  public usuario:string = null;
  public usuarioPlan:string = null;
  


  ngOnInit(): void {
    this.getRouteData();
    this.getUserData();
    this.getCDRData();
  }

  getRouteData():void{
    this.activatedRoute.params.subscribe(params => {
      this.telefono = params['telefono'];
      this.anio = params['anio'];
      this.mes=params['mes'];
    });
  }

  getUserData():void{
    this.telefonoService.getUsers().subscribe(data =>{
      this.usuarios = data; 
      for( let dat of data){
        if(dat.numero == this.telefono){
           this.usuario = dat.nombre; 
           this.usuarioPlan = dat.plan;
        }
      }
      })
  }

  getCDRData(): void{
    var cont = 0;
    this.telefonoService.getCDRs().subscribe(data =>{
      for( let dat of data){
        if(dat.telefonoOrigen == this.telefono ){
            this.cdrs[cont] = dat;
            this.costoTotal= +dat.costo + this.costoTotal;
            cont++;
        }
      }
    })
  }



  public captureScreen()  
  {  
    var data = document.getElementById('contentToConvert');  
    html2canvas(data).then(canvas => {  
      var imgWidth = 210;  
      var imgHeight = canvas.height * imgWidth / canvas.width;  
      const contentDataURL = canvas.toDataURL('image/png')  
      let pdf = new jspdf('p', 'mm', 'a4'); 
      var position = 0;  
      pdf.addImage(contentDataURL, 'PNG', 0, position, imgWidth, imgHeight)  
      pdf.save('Factura'+ '_' +this.telefono + '_' + this.anio + '_' + this.mes +'.pdf'); 
    });  
  }  

}
