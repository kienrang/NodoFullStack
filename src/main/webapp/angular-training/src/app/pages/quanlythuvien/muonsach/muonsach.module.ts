import { ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MuonsachRoutingModule } from './muonsach-routing.module';
import { MuonsachComponent } from './muonsach.component';


@NgModule({
  declarations: [
    MuonsachComponent
  ],
  imports: [
    CommonModule,
    MuonsachRoutingModule,
    ReactiveFormsModule
  ]
})
export class MuonsachModule { }
