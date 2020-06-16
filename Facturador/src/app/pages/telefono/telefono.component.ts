import { Component, OnInit, ViewChild } from '@angular/core';
import { MdbTableDirective } from 'angular-bootstrap-md';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-telefono',
  templateUrl: './telefono.component.html',
  styleUrls: ['./telefono.component.scss']
})
export class TelefonoComponent implements OnInit {

  constructor() { }

  // Vars
  
  telefono :string;

  ngOnInit(): void { 
  }

}
