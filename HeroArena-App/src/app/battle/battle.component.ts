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
  private enemyContext: CanvasRenderingContext2D;

  constructor(private pss: PagestateService) {
  }

  private width = 1100;
  private height = 600;
  private playerx = 550;
  private playery = 400;
  private playerimagex = 0;
  private playerimagey = -520;
  private enemyx = 550;
  private enemyy = -50;
  private enemyimagex = 0;
  private enemyimagey = -650;
  public playerImage = new Image();
  public enemyImage = new Image();

  makeCanvas(canvas: HTMLCanvasElement) {
    this.context = canvas.getContext('2d');
    window.requestAnimationFrame(() => this.draw());
  }

  draw() {
    //console.log("showing battle window")

    this.context.fillStyle = "ffffff";
    this.context.fillRect(0, 0, this.width, this.height);

    if (this.pss.getState() == 3)
      window.requestAnimationFrame(() => this.draw());
  }

  makeCanvasPlayer(canvas: HTMLCanvasElement) {
    this.playerContext = canvas.getContext('2d');
    window.requestAnimationFrame(() => this.drawPlayer(canvas));
  }

  drawPlayer(canvas: HTMLCanvasElement) {
    //console.log(this.playerimagex + ", " + this.playerimagey);
    this.playerContext.fillStyle = "rgba(0,0,0,0)";
    this.playerContext.fillRect(0, 0, 60, 60);
    this.playerContext.drawImage(this.playerImage, this.playerimagex, this.playerimagey);
    canvas.style.top = this.playery + "px";
    canvas.style.left = this.playerx + "px";

    if (this.pss.getState() == 3)
      window.requestAnimationFrame(() => this.drawPlayer(canvas));
  }

  makeCanvasEnemy(canvas: HTMLCanvasElement) {
    this.enemyContext = canvas.getContext('2d');
    window.requestAnimationFrame(() => this.drawEnemy(canvas));
  }

  drawEnemy(canvas: HTMLCanvasElement) {
    //console.log(this.playerimagex + ", " + this.playerimagey);
    this.enemyContext.fillStyle = "rgba(0,0,0,0)";
    this.enemyContext.fillRect(0, 0, 60, 60);
    this.enemyContext.drawImage(this.enemyImage, this.enemyimagex, this.enemyimagey);
    canvas.style.top = this.enemyy + "px";
    canvas.style.left = this.enemyx + "px";

    if (this.pss.getState() == 3)
      window.requestAnimationFrame(() => this.drawEnemy(canvas));
  }

  ngOnInit() {
    this.playerImage.src = 'assets/shadowlord.png';
    this.enemyImage.src = 'assets/shadowlord.png';

    const canvas = <HTMLCanvasElement>document.getElementById('canvasId');
    this.makeCanvas(canvas);
    const playerCanvas = <HTMLCanvasElement>document.getElementById('player');
    this.makeCanvasPlayer(playerCanvas);
    const enemyCanvas = <HTMLCanvasElement>document.getElementById('enemy');
    this.makeCanvasEnemy(enemyCanvas);
  }

  movePlayer(playerimagey, playerx, playery) {
    this.playerimagey = playerimagey;

    if (this.playerimagex > -390)
      this.playerimagex -= 64;
    else
      this.playerimagex = 0;

    this.playerx += playerx;
    this.playery -= playery;
  }

  onKeydown(event) {
    //console.log(event);

    if (event.key === "ArrowUp") {
      this.movePlayer(-520, 0, 10);
    }
    if (event.key === "ArrowLeft") {
      this.movePlayer(-585, -10, 0);
    }
    if (event.key === "ArrowDown") {
      this.movePlayer(-650, 0, -10);
    }
    if (event.key === "ArrowRight") {
      this.movePlayer(-715, 10, 0);
    }
  }
}
