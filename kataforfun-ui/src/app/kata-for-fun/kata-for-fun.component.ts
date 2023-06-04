import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { KataForFunService } from '../kata-for-fun.service';

@Component({
  selector: 'app-kata-for-fun',
  templateUrl: './kata-for-fun.component.html'
})
export class KataForFunComponent implements OnInit, OnDestroy {

  previousConvertResults: Array<any>  = [];

  constructor(private kataForFunService: KataForFunService) { }

  ngOnInit(): void {
  }

  ngOnDestroy(): void {
  }

  convertNumber(inputNumber: number): void {
    this.kataForFunService.convertNumber(inputNumber).subscribe(res => {
      this.previousConvertResults.push({
        "number": inputNumber,
        "convertedNumber": res.result
      })
      console.log(this.previousConvertResults)
    });
  }

}

interface NumberConverted {
  numberToConvert: number;
  result: string;
}
