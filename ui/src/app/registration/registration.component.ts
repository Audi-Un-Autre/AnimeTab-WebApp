import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SignUp } from '../model/signup';
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
  newAccountForm:FormGroup = this.fb.group({});

  constructor(private regService:RegServiceService, private fb:FormBuilder, private router:Router) {
    this.newAccountForm = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(4)]],
      email: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.minLength(8)]]
    });
   }

  ngOnInit(): void { }

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

    if (this.newAccountForm.value.username != "" && this.newAccountForm.value.email != "" && this.newAccountForm.value.password != null)
      // call to api
      this.regService.authNewUser(newUser).subscribe((userExists:any) => {
        console.log(userExists);
        if (userExists === "email_exists"){
          this.newAccountFail = true;
          this.newAccountError = "Email already exists.";
          console.log("email exists.");
        }
        else if (userExists === "username_exists"){
          this.newAccountFail = true;
          this.newAccountError = "Username already exists.";
          console.log("username exists");
        } 
        else {
          this.newAccountFail = false;
          this.newAccountError = "";
          this.router.navigate(["/welcome"]);
        }
      });
  }
}
