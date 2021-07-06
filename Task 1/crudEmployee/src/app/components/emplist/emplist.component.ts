import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Employee } from 'src/app/models/employee';
import { EmployeeService } from 'src/app/services/employee.service';
import { AddEmployeeComponent } from '../add-employee/add-employee.component';
import { UpdateEmployeeComponent } from '../update-employee/update-employee.component';



@Component({
  selector: 'app-emplist',
  templateUrl: './emplist.component.html',
  styleUrls: ['./emplist.component.css']
})
export class EmplistComponent implements OnInit {

  public employees: Employee[] = [];

  constructor( private empService : EmployeeService,private router: Router,private dialog : MatDialog) { }

  ngOnInit(): void {
    this.getEmployees()
  }

  allComplete: boolean = false;

  updateAllComplete() {
    this.allComplete = this.employees != null && this.employees.every(t => t.completed);
  }

  someComplete(): boolean {
    if (this.employees == null) {
      return false;
    }
    return this.employees.filter(t => t.completed).length > 0 && !this.allComplete;
  }

  setAll(completed: boolean) {
    this.allComplete = completed;
    if (this.employees == null) {
      return;
    }
    this.employees.forEach(t => t.completed = completed);
  }

  public getEmployees(): void {
    this.empService.getEmployees().subscribe(
      (response: Employee[]) => {
        this.employees = response;
        this.employees.forEach(t => t.completed = false);
        console.log(response);
      },
      (error: HttpErrorResponse)=> {
        alert(error.message);
      }
    );
  }

  public deleteEmployee(id : number){
    this.empService.deleteEmployee(id).subscribe(
      (response)=> {
        location.reload();
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    );
  }

  updateEmployee(id: number){
    this.dialog.open(UpdateEmployeeComponent,{data:{eid:id}});
  }

  addEmployee(){
    this.dialog.open(AddEmployeeComponent);
  }

  public searchProducts(key: string): void {
    const results: Employee[] = [];
    for (const employee of this.employees) {
      if (employee.employeeName.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.id.toString().toLowerCase().indexOf(key.toLowerCase()) !== -1
      ) 
      {
        results.push(employee);
        break;
      }
    }
    this.employees = results;
    // if (results.length === 0 || !key) {
    //   this.getProducts();
    // }
    if (!key) {
      this.getEmployees();  
    }
  }

  public download()
  {
    const results: Employee[] = [];
    for (const employee of this.employees) { 
      if (employee.completed)
      {
        results.push(employee);
      }
    }
    console.log(results);
  }






  

}
