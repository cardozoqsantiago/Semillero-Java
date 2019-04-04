import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { EncabezadoComponent } from './nucleo/capa/encabezado/encabezado.component';
import { MainComponent } from './nucleo/capa/main/main.component';
import { PiepaginaComponent } from './nucleo/capa/piepagina/piepagina.component';
import { CreacionPersonaComponent } from './nucleo/capa/main/creacion-persona/creacion-persona.component';


const routes: Routes = [
{path: 'Encabezado' , component: EncabezadoComponent},
{path: 'Main' , component: MainComponent},
{path: 'PiePagina' , component: PiepaginaComponent},
{path: 'CreacionPersona' , component: CreacionPersonaComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
