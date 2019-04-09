import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreacionPersonasComponent } from './nucleo/capa/principal/creacion-personas/creacion-personas.component'

import { ModificacionPersonasComponent} from './nucleo/capa/principal/modificacion-personas/modificacion-personas.component';
const routes: Routes = [
	{
	    path: 'personas-crear',
	    component: CreacionPersonasComponent
		},
		
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
