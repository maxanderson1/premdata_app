import { Component } from '@angular/core';
import { TableModule } from 'primeng/table';
import { TeamService } from '../services/team.service';


@Component({
  selector: 'app-team',
  standalone: true,
  imports: [TableModule],
  templateUrl: './team.component.html',
  styleUrl: './team.component.css'
})
export class TeamComponent {

  teamData: any[] = []
  cols: any[] = []

  constructor(private teamService: TeamService) { }


  ngOnInit():void{

    this.cols = [
      {}
    ]

    this.teamService.getData().subscribe(response => {
      this.teamData = response;
    });

  }

}
