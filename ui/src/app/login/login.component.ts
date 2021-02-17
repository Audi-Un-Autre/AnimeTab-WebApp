import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SignIn } from '../model/signin';
import { AuthServiceService } from '../service/auth-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  submitted:boolean = false;
  loginForm:FormGroup = this.fb.group({});
  loginError:boolean = false;

  constructor(private authService: AuthServiceService, private fb:FormBuilder, private router: Router) { }

  ngOnInit(): void {
    if (this.authService.isAuthenticated()) this.router.navigate(['user']);

    this.loginForm = this.fb.group({
      email:['', Validators.required], // Validators.email left off for testing purposes
      password:['', Validators.required]
    })
  }

  get values(){
    return this.loginForm.controls;
  }

  onSubmit(){
    this.submitted = true;
    
    // test values being retrieved
    console.log(this.loginForm.value.email, this.loginForm.value.password);

    // Get and store login details
    const signInData:SignIn = new SignIn(this.loginForm.value.email, this.loginForm.value.password);

    // pass login info to auth service
    this.authService.authenticateLogin(signInData).subscribe((login:any) => {
      if (login.response === 1){

        // recieve token from user api
        localStorage.setItem('user_token', login.jwt);
        this.router.navigate(["/user"]);
      }
      else if(login.response === 0)
        this.loginError = true;
    });
  }

}
