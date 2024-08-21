package com.systelab.inventory.controller;

import com.systelab.inventory.service.ApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = {"Application Entity"})
@RestController()
@CrossOrigin(origins = "*", allowedHeaders="*", exposedHeaders = "Authorization", allowCredentials = "true")
@RequestMapping(value = "api/application", produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("hasAuthority('ADMIN')")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @ApiOperation(value = "Init some data", notes = "Initialize the DB with basic information in order to test the API.", authorizations = {@Authorization(value = "Bearer")})
    @PostMapping("init")
    public boolean initSomeData() {
        return applicationService.initSomeData();
    }

}