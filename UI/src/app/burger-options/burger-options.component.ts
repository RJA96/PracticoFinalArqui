import { Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-burger-options',
  templateUrl: './burger-options.component.html',
  styleUrls: ['./burger-options.component.css']
})
export class BurgerOptionsComponent implements OnInit {
  oculto = true;
  mostrarOptions(){
    this.oculto = !this.oculto;
  }
  constructor() { }

  ngOnInit(): void {
  }

}
