import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SignUp } from '../model/signup';
import { AuthServiceService } from '../service/auth-service.service';
import { RegServiceService } from '../service/reg-service.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  submitted:boolean = false;
  newAccountFail:boolean = false;
  newAccountError:string = "";
  usernameError:string = "";
  emailError:string = "";
  newAccountForm:FormGroup = this.fb.group({});

  constructor(private regService:RegServiceService, private fb:FormBuilder, private router:Router, private auth:AuthServiceService) {
    this.newAccountForm = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(4)]],
      email: ['', [Validators.email, Validators.required]],
      password: ['', [Validators.required, Validators.minLength(8)]]
    });
   }

  ngOnInit(): void { 
    if (this.auth.isAuthenticated()) this.router.navigate(['user']);
  }

  // get form fields
  get values(){
    return this.newAccountForm.controls;
  }

  onSubmit(){
    this.submitted = true;

    // check data from form
    console.log(this.newAccountForm.value.username, this.newAccountForm.value.email, this.newAccountForm.value.password);

    // create new user information
    const newUser:SignUp = new SignUp(this.newAccountForm.value.email, this.newAccountForm.value.username, this.newAccountForm.value.password, "LIMITED");

    if (this.newAccountForm.valid){
      // call to api
      this.regService.authNewUser(newUser).subscribe((userExists:any) => {
        console.log(userExists);
        // username and email already exist
        if (userExists === "email_exists"){
          this.newAccountFail = true;
          this.emailError = "Email already exists.";
          console.log("email exists.");
        }
        else if (userExists === "username_exists"){
          this.newAccountFail = true;
          this.usernameError = "Username already exists.";
          console.log("username exists");
        } 
        else {
          this.newAccountFail = false;
          this.usernameError = "";
          this.emailError = "";
          this.router.navigate(["/welcome"]);
        }
      });
    }
  }
}
