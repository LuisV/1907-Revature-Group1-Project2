import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { PagestateService } from '../pagestate.service';


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
  public playerImage = new Image();

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
    console.log(this.playerx + ", " + this.playery);
    this.playerContext.fillStyle = "ffffff";
    this.playerContext.fillRect(0, 0, this.width, this.height);
    this.playerContext.drawImage(this.playerImage, this.playerimagex, this.playerimagey);
    (<HTMLCanvasElement>document.getElementById('player')).style.top = this.playery + "px";
    (<HTMLCanvasElement>document.getElementById('player')).style.left = this.playerx + "px";


    if (this.pss.getState() == 3)
      window.requestAnimationFrame(() => this.drawPlayer());
  }

  ngOnInit() {
    this.playerImage.src = 'assets/shadowlord.png';
    const canvas = <HTMLCanvasElement>document.getElementById('canvasId');
    this.makeCanvas(canvas);
    const playerCanvas = <HTMLCanvasElement>document.getElementById('player');
    this.makeCanvasPlayer(playerCanvas);
  }

  onKeydown(event) {
    //console.log(event);

    if (event.key === "ArrowUp") {
      this.playerimagey = -520;

      if (this.playerimagex > -390)
        this.playerimagex -= 64;
      else
        this.playerimagex = 0;

      this.playery -= 10;
    }
    if (event.key === "ArrowDown") {
      this.playerimagey = -650;

      if (this.playerimagex > -390)
        this.playerimagex -= 64;
      else
        this.playerimagex = 0;

      this.playery += 10;
    }
    if (event.key === "ArrowRight") {
      this.playerimagey = -715;

      if (this.playerimagex > -390)
        this.playerimagex -= 64;
      else
        this.playerimagex = 0;

      this.playerx += 10;
    }
    if (event.key === "ArrowLeft") {
      this.playerimagey = -585;

      if (this.playerimagex > -390)
        this.playerimagex -= 64;
      else
        this.playerimagex = 0;
        
      this.playerx -= 10;
    }
  }
}
