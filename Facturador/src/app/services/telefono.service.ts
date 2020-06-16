import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LineaTelefonica } from '../pages/models/LineaTelefonica';
import { CDR } from '../pages/models/CDR';
@Injectable({
  providedIn: 'root'
})
export class TelefonoService {

  APIUrlUser='http://localhost:4567/UsuariosJson';
  constructor(private http: HttpClient) { }

  getUsers():Observable <LineaTelefonica[]>{
    return this.http.get<LineaTelefonica[]>(this.APIUrlUser);
  }

  APIUrlCDR='http://localhost:4567/CDRsJson';
  getCDRs():Observable <CDR[]>{
    return this.http.get<CDR[]>(this.APIUrlCDR);
  }

}
