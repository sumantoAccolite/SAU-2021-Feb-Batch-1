import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'AUDetails';
  array:any = [];
  SessionName = "";
  InstructorName = "";
  Description = "";
  id:any = 1;

  index = 0;
  AddtoDetails(){
    
      this.array[this.index] = {"session-name":this.SessionName,"trainer-name":this.InstructorName ,
     "description":this.Description,"id":this.id};
      this.SessionName = "";
      this.InstructorName = "";
      this.Description = "";
      //this.id += 1 ;
      this.index += 1;

  }
   UpdateDetails(index:any){
      
    
    this.SessionName = this.array[index]["session-name"];
    this.InstructorName = this.array[index]["trainer-name"];
    this.Description = this.array[index]["description"];
    this.deleteDetails(index);

    //this.AddtoDetails();
      

   }
  deleteDetails(index: any){
    
    console.log(index);
    if(this.array.length > 1){
    this.array.splice(index,1);
    }
    else{
      this.array = [];
    }
    this.index -= 1
    console.log(this.array);
  }

}
