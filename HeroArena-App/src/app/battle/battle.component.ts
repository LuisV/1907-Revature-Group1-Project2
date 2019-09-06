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
  private playerContext: CanvasRenderingContext2D;

  constructor(private pss: PagestateService) {
  }

  private width = 1100;
  private height = 600;
  private playerx = -550;
  private playery = 0;
  private playerimagex = 0;
  private playerimagey = -520;

  makeCanvas(canvas: HTMLCanvasElement) {
    this.context = canvas.getContext('2d');
    window.requestAnimationFrame(() => this.draw());
  }

  draw() {
    // do stuff
    //console.log("showing battle window")

    this.context.fillStyle = "ffffff";
    this.context.fillRect(0, 0, this.width, this.height);

    if (this.pss.getState() == 3)
      window.requestAnimationFrame(() => this.draw());
  }

  makeCanvasPlayer(canvas: HTMLCanvasElement) {
    this.playerContext = canvas.getContext('2d');
    window.requestAnimationFrame(() => this.drawPlayer());
  }

  drawPlayer() {
    let image = new Image();
    image.src = 'assets/shadowlord.png';
    this.playerContext.drawImage(image, this.playerimagex, this.playerimagey);
    (<HTMLCanvasElement>document.getElementById('player')).style.top = this.playery + "px";
    (<HTMLCanvasElement>document.getElementById('player')).style.left = this.playerx + "px";


    if (this.pss.getState() == 3)
      window.requestAnimationFrame(() => this.drawPlayer());
  }

  ngOnInit() {
    const canvas = <HTMLCanvasElement>document.getElementById('canvasId');
    this.makeCanvas(canvas);
    const playerCanvas = <HTMLCanvasElement>document.getElementById('player');
    this.makeCanvasPlayer(playerCanvas);
  }

  onKeydown(event) {
    //console.log(event);

    if (event.key === "ArrowUp") {
      this.playery -= 20;
    }
    if (event.key === "ArrowDown") {
      this.playery += 20;
    }
    if (event.key === "ArrowLeft") {
      this.playerx -= 20;
    }
    if (event.key === "ArrowRight") {
      this.playerx += 20;
    }
  }
}
