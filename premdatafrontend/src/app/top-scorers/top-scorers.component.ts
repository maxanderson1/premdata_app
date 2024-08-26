import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { TableModule } from 'primeng/table';
import { Scorer } from '../types/scorer';
import { TopScorersService } from '../services/top-scorers.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-top-scorers',
  standalone: true,
  imports: [TableModule, CommonModule],
  templateUrl: './top-scorers.component.html',
  styleUrl: './top-scorers.component.css',
})
export class TopScorersComponent {

  topScorers: any[] = [] 
  cols: any[]
  
  constructor(private topScorerService: TopScorersService,
    private router: Router) { }


  ngOnInit(){

    this.cols = [

      { field: 'playerName', header: 'Name' },
      { field: 'playedMatches', header: 'Matches Played' },
      { field: 'goals', header: 'Goals' },
      { field: 'assists', header: 'Assists' },
      { field: 'penalties', header: 'Penalties' },
      { field: 'teamName', header: 'Team' }

  ];

    this.topScorerService.getTopScorers().subscribe(response => {
      this.topScorers = response;
    })
  }


}
