import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Employee } from '../models/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private apiUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getEmployees(): Observable<Employee[]>{
    return this.http.get<Employee[]>(`${this.apiUrl}/findAllEmployees`)
  }

  public addEmployee(employee : Employee): Observable<any>{
    return this.http.post<Employee>(`${this.apiUrl}/addEmployee`,employee)
  }

  public updateEmployee(employee: Employee):Observable<any>{
    return this.http.put<Employee>(`${this.apiUrl}/updateEmployee`,employee)
  }

  public deleteEmployee(id:number){
    return this.http.delete(`${this.apiUrl}/deleteEmployee/${id}`)
  }

  public getEmployeeByID(id: number): Observable<Employee>{
    return this.http.get<Employee>(`${this.apiUrl}/findEmployee/${id}`)
  }
}
