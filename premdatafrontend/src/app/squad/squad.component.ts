import { Component } from '@angular/core';
import { Player } from '../types/player';
import { SquadService } from '../services/squad.service';
import { TableModule } from 'primeng/table';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { switchMap } from 'rxjs';



@Component({
  selector: 'app-squad',
  standalone: true,
  imports: [TableModule, CommonModule],
  templateUrl: './squad.component.html',
  styleUrl: './squad.component.css'
})
export class SquadComponent {

  squadData: Player[]
  cols: any[]
  teamId: number;

  constructor(private squadService: SquadService,
    private route: ActivatedRoute) { }


  ngOnInit(){


    this.route.queryParams.subscribe((params) => {
      if(params['teamId'] != null){
        console.log('Team ID:', params['teamId']);

this.teamId = params['teamId'];

          

      }
    });
    
  
      // // Subscribe to route parameters
      // this.route.paramMap.pipe(
      //   switchMap(params => {
      //     this.teamId = +params.get('teamId')!; 

      //     console.log('Team ID:', this.teamId);

      //     return this.squadService.getData(this.teamId);
      //   })
      // ).subscribe(
      //   data => {
      //     this.squadData = data;
      //   }
      // );
    

    this.cols = [
      { field: 'name', header: 'Name' },
      { field: 'position', header: 'Position' },
      { field: 'dateOfBirth', header: 'Date of Birth' },
      { field: 'nationality', header: 'Nationality' }
  ];


  this.bl();

}
  
bl(){
  this.squadService.getData(this.teamId)
          .subscribe((response: Player[]) => {
            this.squadData = response;
          });
}


}
