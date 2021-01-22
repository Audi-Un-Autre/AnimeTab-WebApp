import { Component, OnInit } from '@angular/core';
import { IEntry } from '../model/entry';
import { EntryServiceService } from '../service/entry-service.service';

@Component({
  selector: 'app-entry-list',
  templateUrl: './entry-list.component.html',
  styleUrls: ['./entry-list.component.css']
})
export class EntryListComponent implements OnInit {

  entries : IEntry[] = [];

  constructor(private entryService: EntryServiceService) {
  }

  ngOnInit(): void {
    this.entryService.getEntries()
        .subscribe(data => this.entries = data);
  }

}
