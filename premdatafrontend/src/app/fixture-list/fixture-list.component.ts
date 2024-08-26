import { Component } from '@angular/core';
import { FixtureService } from '../services/fixture.service';
import { CommonModule } from '@angular/common';
import { DataViewModule } from 'primeng/dataview';
import { PaginatorModule } from 'primeng/paginator';
import { DropdownModule } from 'primeng/dropdown';


@Component({
  selector: 'app-fixture-list',
  standalone: true,
  imports: [CommonModule, DataViewModule, PaginatorModule, DropdownModule],
  templateUrl: './fixture-list.component.html',
  styleUrl: './fixture-list.component.css'
})
export class FixtureListComponent {

  fixtures: any[];
  matchweeks: number[] = []
  matchweek: number = 1;

  constructor(private fixtureService: FixtureService) { }

  ngOnInit(): void {
    
    this.initiateMatchweeksArray();
    this.getFixtures();
  }

  initiateMatchweeksArray(){

    for (let i = 1; i <= 38; i++) {
      this.matchweeks.push(i);
    }
  }
  
  getFixtures(){
    this.fixtureService.getFixtures(this.matchweek).subscribe(data => {
      this.fixtures = data;
    });
  }

}
