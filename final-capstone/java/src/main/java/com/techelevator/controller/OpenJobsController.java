package com.techelevator.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.techelevator.model.JobSearch;
import com.techelevator.services.JobSearchService;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class OpenJobsController {
    JobSearchService jobService = new JobSearchService();

     @RequestMapping(path="/openJobs/{city}", method= RequestMethod.GET)
     public List<JobSearch> getOpenJobLinks(@PathVariable String city) throws JsonProcessingException {
         return jobService.getOpenJobs(city);
     }
}
