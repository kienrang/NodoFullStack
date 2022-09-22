import { MatRadioModule } from '@angular/material/radio';
import { MatFormFieldModule } from '@angular/material/form-field';
import { ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NhaxuatbanRoutingModule } from './nhaxuatban-routing.module';
import { NhaxuatbanComponent } from './nhaxuatban.component';


@NgModule({
  declarations: [
    NhaxuatbanComponent
  ],
  imports: [
    CommonModule,
    NhaxuatbanRoutingModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatRadioModule

  ]
})
export class NhaxuatbanModule { }
