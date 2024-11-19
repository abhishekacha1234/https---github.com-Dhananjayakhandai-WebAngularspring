import { Component } from '@angular/core';
import { UserService } from '../user.service';  // Import the service

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  message: string = '';

  constructor(private userService: UserService) { }

  onLogin() {
    const user = { username: this.username, password: this.password };

    this.userService.loginUser(user).subscribe(
      response => {
        this.message = 'Login successful';
        // Navigate to another page or store session details if needed
      },
      error => {
        this.message = 'Invalid credentials';
      }
    );
  }
}
