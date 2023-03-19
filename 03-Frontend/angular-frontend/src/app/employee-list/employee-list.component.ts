
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Employee[] = [];

  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit(): void {
    this.getEmployees();

  }

  //Get employee
  private getEmployees() {
    this.employeeService.getEmployeesList().subscribe(data => {
      this.employees = data;
    });
  }

  // Update employee navigate
  updateEmployee(id: number) {
    this.router.navigate(['update-employee', id]);
  }

  


  // Delete Employee
  deleteEmployee(id: number) {
    this.employeeService.deleteEmployeeByID(id).subscribe(Data => {
      console.log(Data);
      this.getEmployees();
    })
  }

  // Employees Details
  viewEmployee(id: number){
    this.router.navigate(['employee-details', id]);

  }







}
