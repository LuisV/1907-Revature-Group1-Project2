import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { PagestateService} from '../pagestate.service';


@Component({
  selector: 'app-battle',
  templateUrl: './battle.component.html',
  styleUrls: ['./battle.component.css']
})

export class BattleComponent implements OnInit {

  //@ViewChild('canvasId', {static: false}) myCanvas: ElementRef;
  private context: CanvasRenderingContext2D;

  constructor(private pss: PagestateService) {
  }

  private x = 0;
  private y = 0;
  private width = 1100;
  private height = 600;

  makeCanvas(canvas: HTMLCanvasElement) {
    this.context = canvas.getContext('2d');
    window.requestAnimationFrame(() => this.draw());
  }

  draw() {
    // do stuff
    console.log("showing battle window")

    let image = new Image();
    image.src = 'assets/RROD.jpg';
    this.context.fillStyle = "green";
    this.context.fillRect(0, 0, this.width, this.height);
    this.context.drawImage(image, this.x, this.y);

    if (this.pss.getState() == 3)
      window.requestAnimationFrame(() => this.draw());
  }

  ngOnInit() {
    const canvas = <HTMLCanvasElement>document.getElementById('canvasId');
    this.makeCanvas(canvas);
  }

  onKeydown(event) {
    //console.log(event);

    if (event.key === "ArrowUp") {
      this.y -= 20;
    }
    if (event.key === "ArrowDown") {
      this.y += 20;
    }
    if (event.key === "ArrowLeft") {
      this.x -= 20;
    }
    if (event.key === "ArrowRight") {
      this.x += 20;
    }
  }
}
