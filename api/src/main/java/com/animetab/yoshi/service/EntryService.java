
/*
    Basic database operations
    
    Future updates will have a few more complex queries
    for search queries within the webapp.
*/

package com.animetab.yoshi.service;

import java.util.List;

import com.animetab.yoshi.dao.IEntryDAO;
import com.animetab.yoshi.model.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EntryService {

    @Autowired
    IEntryDAO entryRepo;

    public List<Entry> allEntries(){
        return entryRepo.findAll();
    }

    public void addEntry(Entry entry){
        entryRepo.save(entry);
    }

    public void deleteEntry(Integer entryID){
        entryRepo.deleteById(entryID);
    }

    public Entry viewEntry(Integer entryID){
        return entryRepo.findById(entryID).get();
    }
    
}
