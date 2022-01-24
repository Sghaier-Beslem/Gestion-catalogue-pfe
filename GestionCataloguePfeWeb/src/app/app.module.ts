import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreatePfeComponent } from './create-pfe/create-pfe.component';
import { PfeListComponent } from './pfe-list/pfe-list.component';
import { HttpClientModule } from '@angular/common/http';
import { PfeCategorieComponent } from './pfe-categorie/pfe-categorie.component';

@NgModule({
  declarations: [
    AppComponent,
    CreatePfeComponent,
    PfeListComponent,
    PfeCategorieComponent,
    
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
