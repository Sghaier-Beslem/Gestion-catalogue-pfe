import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreatePfeComponent } from './create-pfe/create-pfe.component';
import { PfeListComponent } from './pfe-list/pfe-list.component';

const routes: Routes = [
  { path: '', redirectTo: 'pfes', pathMatch: 'full' },
  { path: 'pfes', component: PfeListComponent },
  { path: 'pfes/formulaire', component:  CreatePfeComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
