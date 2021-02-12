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
    this.loginForm = this.fb.group({
      email:['', Validators.required],
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

    // pass login to auth service
    this.authService.authenticateLogin(signInData).subscribe((userExists:boolean) => {
      if (userExists){
        console.log("User found.");
        // !!! TODO localstorage
        this.router.navigate(["/user"]);
      }
      else
        console.log("User not found.");
        // print message that login credentials are not correct.
        this.loginError = true;
    });
  }

}
