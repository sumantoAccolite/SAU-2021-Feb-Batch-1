import { MatCardModule } from '@angular/material/card';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';   
import { FormsModule } from '@angular/forms';
import {MatButtonModule} from '@angular/material/button'; 


//import { MatButtonModule} from '@angular/material';  

@NgModule({
  declarations: [
    AppComponent,

  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatCardModule,
    FormsModule,
    MatButtonModule
    
   // MatButtonModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
