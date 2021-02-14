import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from '../service/auth-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  title:string = "Anime Tab";
  
  constructor(private router:Router, private auth:AuthServiceService) { }

  ngOnInit(): void {
    // !!! solve via resolve on next update please
    if (this.auth.isAuthenticated()) this.router.navigate(['user']);
  }
}
