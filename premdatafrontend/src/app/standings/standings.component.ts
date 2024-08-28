import { Component } from '@angular/core';
import { StandingsService } from '../services/standings.service';
import { TableModule } from 'primeng/table';
import { CommonModule } from '@angular/common';
import { TableEntry } from '../types/tableEntry';
import { Router } from '@angular/router';
import { ButtonModule } from 'primeng/button';
import { DropdownModule } from 'primeng/dropdown';
import { FormsModule } from '@angular/forms';
import { FixtureListComponent } from "../fixture-list/fixture-list.component";




@Component({
  selector: 'app-standings',
  standalone: true,
  imports: [TableModule, ButtonModule, CommonModule, DropdownModule, FormsModule, FixtureListComponent],
  templateUrl: './standings.component.html',
  styleUrl: './standings.component.css'
})
export class StandingsComponent {

  standingData: TableEntry[]
  cols: any[]
  selectedTeam: TableEntry;
  season: string = "2024";
  seasons: string[];
  selectedView: string = 'total';

  constructor(private standingsService: StandingsService,
    private router: Router) { }


  ngOnInit(){

    this.getTotalTable();

    this.seasons = ["2020", "2021", "2022", "2023", "2024"]

    this.cols = [

      { field: 'position', header: 'Position' },
      { field: 'teamName', header: 'Team' },
      { field: 'form', header: 'Form' },
      { field: 'playedGames', header: 'Played' },
      { field: 'won', header: 'Won' },
      { field: 'draw', header: 'Draw' },
      { field: 'lost', header: 'Lost' },
      { field: 'goalsFor', header: 'Goals For' },
      { field: 'goalsAgainst', header: 'Goals Against' },
      { field: 'goalDifference', header: 'Goal Difference' },
      { field: 'points', header: 'Points' }

  ];

  }


  onRowSelect(event: any) {
    
    console.log("row selected " + event.data.teamId);
    
    this.router.navigate(['/squad'], {queryParams:{teamId:event.data.teamId}});

  }

  getTotalTable(){
    this.standingsService.getTotalTable(this.season).subscribe(response =>
      this.standingData = response 
    )
  }

  getHomeTable(){
    this.standingsService.getHomeTable(this.season).subscribe(response =>
      this.standingData = response 
    )
  }


  getAwayTable(){
    this.standingsService.getAwayTable(this.season).subscribe(response =>
      this.standingData = response 
    )
  }

  setView(view: string) {
    this.selectedView = view;
    switch (view) {
      case 'total':
        this.getTotalTable();
        break;
      case 'home':
        this.getHomeTable();
        break;
      case 'away':
        this.getAwayTable();
        break;
    }
  }
}

