import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  id!: number;
  employee: Employee = new Employee();

  constructor(private employeeService: EmployeeService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    // Active route
    this.id = this.route.snapshot.params[`id`];

    // Calling getEmployeeByID
    this.employeeService.getEmployeeById(this.id).subscribe(data => {
      this.employee = data;
    },
      error => console.log(error));
  }


  // On submit

  OnSubmit() {
    this.employeeService.updateEmployeeById(this.id, this.employee).subscribe(data => {
      this.goToEmployeeList();
    }, error => console.log(error));

  }
  goToEmployeeList() {
    this.router.navigate(['/employees']);
  }


}
