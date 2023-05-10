import { Component } from '@angular/core';
import { EmployeeDetails } from './employee-details';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent {

  employeeList : EmployeeDetails[] = [
    new EmployeeDetails(1, "Raj", "Developer","3500"),
    new EmployeeDetails(2, "Rahul", "Tester","3500"),
    new EmployeeDetails(3, "Raghav", "Dev-ops","2500")
  ]

}
