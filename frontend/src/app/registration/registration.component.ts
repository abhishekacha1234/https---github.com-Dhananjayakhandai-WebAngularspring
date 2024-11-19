import { Component } from '@angular/core';
import { UserService } from '../user.service';  // Import the service

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {
  username: string = '';
  email: string = '';
  password: string = '';
  message: string = '';

  constructor(private userService: UserService) { }

  onRegister() {
    const user = {
      username: this.username,
      email: this.email,
      password: this.password
    };

    this.userService.registerUser(user).subscribe(
      response => {
        this.message = 'User registered successfully';
        // Redirect to login or dashboard page
      },
      error => {
        this.message = 'User already exists';
      }
    );
  }
}
