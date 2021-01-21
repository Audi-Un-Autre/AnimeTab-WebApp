
/*
    User Home controller
*/

package com.animetab.yoshi.controller;

import java.util.List;

import com.animetab.yoshi.model.Entry;
import com.animetab.yoshi.service.EntryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class HomeController {
    
    @Autowired
    EntryService entryService;

    @GetMapping("/entries")
    public List<Entry> viewAllEntries(){
        return entryService.allEntries();
    }

    @GetMapping("/{id}")
    public Entry viewEntry(@PathVariable Integer entryID){
        return entryService.viewEntry(entryID);
    }

}
