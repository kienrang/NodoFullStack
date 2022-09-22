import { ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SachRoutingModule } from './sach-routing.module';
import { SachComponent } from './sach.component';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatExpansionModule } from '@angular/material/expansion';


@NgModule({
  declarations: [
    SachComponent
  ],
  imports: [
    CommonModule,
    SachRoutingModule,
    ReactiveFormsModule,
    MatExpansionModule,
    MatFormFieldModule,
    MatInputModule

  ]
})
export class SachModule { }
