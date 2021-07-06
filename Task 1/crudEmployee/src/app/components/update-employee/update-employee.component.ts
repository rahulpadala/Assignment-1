import { HttpErrorResponse } from '@angular/common/http';
import { Inject } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Employee } from 'src/app/models/employee';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  public editEmployee : Employee | undefined;

  constructor(@Inject(MAT_DIALOG_DATA) public data : any,private empservice : EmployeeService) { }

  ngOnInit(): void {
    this.getEmployee(this.data.eid)
  }

  public getEmployee(id:number){
    this.empservice.getEmployeeByID(id).subscribe(
      (response:Employee)=>{
        console.log(response);
        this.editEmployee = response; 
      }
      );
  }

  public updateEmployee(employee : Employee){
    // document.getElementById('add-employee-form').click();
    this.empservice.updateEmployee(employee).subscribe(
      (response:any) => {
        console.log(response);
        location.reload(); 
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

}
