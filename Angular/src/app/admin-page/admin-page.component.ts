import { Component, OnInit } from '@angular/core';
import { TowerService } from '../tower.service';
import { FloorService } from '../floor.service';
import { Tower } from '../tower';
import { Floor } from '../floor';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit{
  TowerName!:string;
  FloorName!:string;

  constructor(private towerservice:TowerService,private floorservice:FloorService,private spinner:NgxSpinnerService){}

  combinedAction(): void {
    this.addTower();
    this.openScanner();
  }

  openScanner(){
    /** spinner starts on init */
    this.spinner.show();

    setTimeout(() => {
      /** spinner ends after 5 seconds */
      this.spinner.hide();
    }, 2000);
  }

  ngOnInit(){}
  addTower(){
    if(this.TowerName)
    {
      const tower=new Tower(this.TowerName);

      this.towerservice.tower(tower).subscribe({
        next:(_)=>{
          
          alert("Tower Added")
          
          // this.router.navigate(['login']); router logic

        },error:(err)=>{alert("404");
      }
      })
    }
    else{
      alert("Enter Tower Name")
    }
  }
  addFloor(){
    if(this.FloorName)
    {
      const floor=new Floor(this.FloorName);

      this.floorservice.floor(floor).subscribe({
        next:(_)=>{
          
          alert("Floor Added")
          
          // this.router.navigate(['login']); router logic

        },error:(err)=>{alert("404");
      }
      })
    }
    else{
      alert("Enter Floor Name")
    }
  }
      }
 