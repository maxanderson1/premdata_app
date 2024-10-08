import { Routes } from '@angular/router';
import { DataDisplayComponent } from './data-display/data-display.component';
import { MainLayoutComponent } from './layout/main-layout/main-layout.component';
import { TeamComponent } from './team/team.component';
import { SquadComponent } from './squad/squad.component';
import { StandingsComponent } from './standings/standings.component';
import { FixtureListComponent } from './fixture-list/fixture-list.component';
import { TopScorersComponent } from './top-scorers/top-scorers.component';

export const routes: Routes = [
    { path: 'data-display', component: DataDisplayComponent },
    { path: 'team', component: TeamComponent },
    { path: 'squad', component: SquadComponent },
    { path: 'standings', component: StandingsComponent },
    { path: 'fixtures', component: FixtureListComponent },
    { path: 'top-scorers', component: TopScorersComponent }




];
