import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Category } from '../Category';
import { Pfe } from '../pfe';
import { PfeService } from '../pfe.service';

@Component({
  selector: 'app-create-pfe',
  templateUrl: './create-pfe.component.html',
  styleUrls: ['./create-pfe.component.css']
})
export class CreatePfeComponent implements OnInit {
	
	pfes:Observable<Pfe[]>;

	categories:Category[];
	pfe: Pfe= {
		id: 0,
		titre: '',
		categorie:{
			id:0,
			type:'',
		}
		
	};
	submitted = false;
	
	constructor(private pfeService:PfeService ,private router:Router) { }
	
	ngOnInit(): void {
		
	 this.pfeService.getCategories().subscribe((categories: any) => {
		this.categories = categories;
	});
	console.log(this.categories)
	}
	
	
	savePfe(): void {
		const data = {
		  titre: this.pfe.titre,
		  categorie: this.pfe.categorie,
		  
		};
		console.log(data)
		this.pfeService.createPfe(data)
		.subscribe({
			next: (res) => {
			  console.log(res);
			  this.submitted = true;
			  this.gotoList();
			},
			error: (e) => console.error(e)
		});
		
	}
	gotoList() {
		this.router.navigate(['/pfes']);
	  }
	
/*	 newPfe(): void {
		this.submitted = false;
		this.pfe= {
		  titre: '',
		  categorie:{
			  type:''
		  }
		
		};
	  }*/
	
}	