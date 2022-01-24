import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Category } from '../Category';
import { Pfe } from '../pfe';
import { PfeService } from '../pfe.service';

@Component({
  selector: 'app-pfe-categorie',
  templateUrl: './pfe-categorie.component.html',
  styleUrls: ['./pfe-categorie.component.css']
})
export class PfeCategorieComponent implements OnInit {
  categories:Observable<Category[]>;
  pfes:Observable<Pfe[]>;

  constructor(private pfeService: PfeService,private router:Router) { }

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData() {
    this.pfes= this.pfeService.getPfesList() 
    this.categories= this.pfeService.getCategories()
 
       
   }
   filterbyCategoryId(id:number): void {
    

   this.pfeService.findByCategoryId(id).subscribe(
       data => this.pfes =data
     )
    
         console.log(this.pfes)
    }

}


