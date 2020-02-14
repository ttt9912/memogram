import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-input',
  templateUrl: './input.component.html',
  styleUrls: ['./input.component.scss']
})
export class InputComponent implements OnInit {
  @Output()
  submitted = new EventEmitter<string>();

  inputForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.inputForm = fb.group({
      input: ['', Validators.required]
    });
  }

  ngOnInit() {
  }

  submit() {
    this.submitted.emit(this.inputForm.value.input);
    this.inputForm.reset();
  }

}
