import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HttpClient, HttpClientModule, provideHttpClient } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { routes } from './app.routes';
import { Table, TableModule } from 'primeng/table';
import { DataDisplayComponent } from './data-display/data-display.component';

@NgModule({
  declarations: [

  ],
  imports: [
    BrowserModule,
    AppComponent,
    HttpClientModule,
    RouterModule.forRoot(routes), // Set up routes,  
  ],
  providers: [provideHttpClient()] 
})
export class AppModule { }
