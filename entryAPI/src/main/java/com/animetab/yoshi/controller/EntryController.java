
/*
    User Home controller
*/

package com.animetab.yoshi.controller;

import java.util.List;

import com.animetab.yoshi.model.Entry;
import com.animetab.yoshi.service.EntryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entry") // replace to username later on
public class EntryController {
    
    @Autowired
    EntryService entryService;

    @GetMapping("/all")
    public List<Entry> viewAllEntries(){
        return entryService.allEntries();
    }

    @GetMapping("/{id}")
    public Entry viewEntry(@PathVariable("id") Integer entryID){
        return entryService.viewEntry(entryID);
    }

    @PostMapping("/new")
    public void addEntry(@RequestBody Entry entry){
        entryService.addEntry(entry);
    }

    @DeleteMapping("/delete")
    public void deleteEntry(@RequestBody Entry entry){
        entryService.deleteEntry(entry.getId());
    }

}
