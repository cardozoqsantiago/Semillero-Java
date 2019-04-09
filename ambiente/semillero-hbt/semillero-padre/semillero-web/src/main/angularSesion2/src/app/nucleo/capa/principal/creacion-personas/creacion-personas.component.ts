import { Component, OnInit } from '@angular/core';
import { personaDTO} from '../creacion-personas/modelo/personaDTO'

@Component({
  selector: 'app-creacion-personas',
  templateUrl: './creacion-personas.component.html'
})
export class CreacionPersonasComponent implements OnInit {
  
  persona : personaDTO;
  personas : personaDTO[];

  
  
  public header : string = 'Crear/Editar personas';
  
  
  constructor() { }

  ngOnInit() {
    
    this.persona = {
      id: 0,
      nombre: "",
      apellido: "",
      tipoIdentificacion: "",
      numeroIdentificacion: "",
      fechaNaci:null,
      mayorEdad:false,
      sexo:""
    };
    this.personas=[];
    
  }
  
  guardar(){
    
      this.personas.push(this.persona)

    
    
    this.persona = {
      id: 0,
      nombre: "",
      apellido: "",
      tipoIdentificacion: "",
      numeroIdentificacion: "",
      fechaNaci:null,
      mayorEdad:false,
      sexo:""
    };
    
   // console.log("guardar()" + this.persona.nombre)
  }
  abrirEditar(persona : personaDTO){
    this.persona = persona;

  }

}
