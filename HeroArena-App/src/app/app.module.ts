import { CharacterService } from './character.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { MainpageComponent } from './mainpage/mainpage.component';
import { RosterService } from './roster.service';
import { BattleComponent } from './battle/battle.component';
import { RosterDisplayComponent } from './roster-display/roster-display.component';
import { CharacterListComponent } from './character-list/character-list.component';
import { CharacterItemComponent } from './character-list/character-item/character-item.component';
import { LevelUpComponent } from './level-up/level-up.component';
import { CharacterCreateComponent } from './character-list/character-create/character-create.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserService } from './user.service';
import { UserItemComponent } from './user-list/user-item/user-item.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MainpageComponent,
    BattleComponent,
    RosterDisplayComponent,
    CharacterListComponent,
    CharacterItemComponent,
    LevelUpComponent,
    CharacterCreateComponent,
    UserListComponent,
    UserItemComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [RosterService, UserService, CharacterService, HTMLCanvasElement],
  bootstrap: [AppComponent]
})
export class AppModule { }
