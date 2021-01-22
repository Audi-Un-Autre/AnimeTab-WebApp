/*
    repository interface
*/

package com.animetab.yoshi.dao;

import com.animetab.yoshi.model.Entry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IEntryDAO extends JpaRepository<Entry, Integer> {
}
