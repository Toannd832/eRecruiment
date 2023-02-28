/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeweb.repository;

import com.codeweb.pojos.candidate;
import java.util.List;

/**
 *
 * @author KHOA
 */
public interface CandidateRepository {
    List<candidate> getCandidateById(String id);
    boolean addOrUpdate(candidate candidate);
    List<candidate> getAll();
    candidate getCandidateById_2(String id);
    List<candidate> findByEmail(String email);
}
