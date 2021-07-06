import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Employee } from 'src/app/models/employee';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  
  constructor(private empService : EmployeeService) { }

  ngOnInit(): void {
  }

  addEmployee(addForm: NgForm){
    this.empService.addEmployee(addForm.value).subscribe(
      (response: any) => {
        console.log(response);
        location.reload();
      }
    );
  }



}
