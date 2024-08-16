import { Component, OnInit } from '@angular/core';
import { ApiService } from '../services/api.service';
import { TableModule } from 'primeng/table';


@Component({
  selector: 'app-data-display',
  standalone: true,
  imports: [TableModule],
  templateUrl: './data-display.component.html',
  styleUrl: './data-display.component.css'
})
export class DataDisplayComponent implements OnInit {

  data: any[] = [];

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {

    console.log("initialising data display component");
    

    this.apiService.getData().subscribe(response => {
      this.data = response;
    });
  }
}