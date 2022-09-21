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
    ReactiveFormsModule

  ]
})
export class NhaxuatbanModule { }
