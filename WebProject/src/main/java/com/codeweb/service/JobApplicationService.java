/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.codeweb.service;

import com.codeweb.pojos.jobApplication;
import java.util.List;

/**
 *
 * @author toan0
 */
public interface JobApplicationService {
    List<jobApplication>viewAllJobApplication();
    List<jobApplication>findJobApplicationById(String id);
    int editJobApplication(String id);
}