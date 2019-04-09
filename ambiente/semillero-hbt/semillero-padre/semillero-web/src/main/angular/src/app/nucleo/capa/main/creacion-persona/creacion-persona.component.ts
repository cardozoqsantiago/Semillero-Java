import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-creacion-persona',
  templateUrl: './creacion-persona.component.html',
  styleUrls: ['./creacion-persona.component.css']
})
export class CreacionPersonaComponent implements OnInit {
  
  public id:number = 10;
  public nombre:string = "Alejandra";
  public apellido:string = "Cardozo";
  public numeroIdentificacion:string = "1097402974";
  public tipoIdentificacion:string = "";
  
  
  constructor() { }
  
  ngOnInit() {
  }

}
