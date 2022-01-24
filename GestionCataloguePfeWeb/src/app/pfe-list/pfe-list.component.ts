import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';
import {Category} from '../Category';
import {Pfe} from '../pfe';
import {PfeService} from '../pfe.service';
import {map, filter, switchMap, count} from 'rxjs/operators';
import { error } from '@angular/compiler/src/util';

@Component({
  selector: 'app-pfe-list',
  templateUrl: './pfe-list.component.html',
  styleUrls: ['./pfe-list.component.css']
})
export class PfeListComponent implements OnInit {
  pfes: Observable<Pfe[]>;
  titre = '';

  categories: Observable<Category[]>;
  id: number=0;
  total: number=0;
  totalcat:number=0;
  categorieid: number;
  constructor(private pfeService: PfeService, private router: Router) {
  }

  ngOnInit(): void {
    this.reloadData();

  }

  reloadData() {
    this.id=0
    
    this.categories = this.pfeService.getCategories()
    this.pfes=this.pfeService.getPfesList()
   
   this.countbyCategoryId(this.id)
  
   console.log(this.total)
    
      
    
     
     }
   
  

  deletePfe(id: number) {
    this.pfeService.deletePfe(id).subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error)
    );
  }


  searchTitle(): void {
    console.log(this.titre);
    if(this.titre!=""){
      this.pfes=this.pfes.pipe(map(pfes => pfes.filter(pfe => pfe.titre === this.titre)));
      //this.titre=""
    }
  }

  filterbyCategoryId(id: number): void {
  this.pfes= this.pfeService.findByCategoryId(id);
  console.log("category ",id);
  this.totalcat=this.countbyCategoryId(id);
        
        console.log(this.totalcat)
      
      
    

    
  }

  countbyCategoryId(id: number):any {
   this.pfeService.count(id).subscribe({
    next:(data:any) =>{
     
      this.total=data ;
      console.log(data)
      
    },
    error:(err:any)=>{},
    complete:()=>{}
  })
 }
  
}



