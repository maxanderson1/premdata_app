import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { DataDisplayComponent } from './data-display/data-display.component';
import { Table } from 'primeng/table';
import { SidebarModule } from 'primeng/sidebar';
import { ToolbarModule} from 'primeng/toolbar'
import { MenubarModule } from 'primeng/menubar';


@Component({
  selector: 'app-root',
  standalone: true,
  
  imports: [RouterOutlet,
    DataDisplayComponent,    
    SidebarModule, ToolbarModule, MenubarModule

  ],
  
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  
  title = 'premdatafrontend';

  visible: boolean = false;

  sidebarVisible = false;

  // Toggle the visibility of the sidebar
  toggleSidebar() {
    this.sidebarVisible = !this.sidebarVisible;
  }

  // Menubar items
  items = [
    { label: 'Home', icon: 'pi pi-home', routerLink: '/standings' },
    { label: 'Fixtures', icon: 'pi pi-calendar', routerLink: '/fixtures' },
    { label: 'Top Scorers', icon: 'pi pi-crown', routerLink: '/top-scorers' }


    // Add more items as needed
  ];


}
