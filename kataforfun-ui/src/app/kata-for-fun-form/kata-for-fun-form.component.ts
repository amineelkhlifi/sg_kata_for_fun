import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-kata-for-fun-form',
  templateUrl: './kata-for-fun-form.component.html'
})
export class KataForFunFormComponent {

  @Output() submitNumberOutput: EventEmitter<number> = new EventEmitter();
  kataForFunForm = new FormGroup({
    numberToConvert:  new FormControl('numberToConvert'),
  });

 

  submitNumber(): void {
    console.log('coucou')
    this.submitNumberOutput.emit(this.numberToConvert);
  }

  get numberToConvert(): number{
    return this.kataForFunForm.get('numberToConvert').value;
  }

}
