/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walmart.reminder.reminder.controller;

import com.walmart.reminder.model.ReminderModel;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author HiepNguyen
 */
@Controller
public class ReminderController {

      private static final String REMINDER_BASE = "http://localhost:9090/rest";
      private static final String REMINDER_REST = "reminders";

      private static final String ERROR_PAGE = "redirect:./error";
      private static final String INDEX_PAGE = "index";

      @RequestMapping("/")
      public String root() {
            return index();
      }

      @RequestMapping("/index")
      public String index() {

            WebClient client = getWebClient();
            Response response = client.get();
            if (response.getStatus() != Response.Status.OK.getStatusCode()) {
                  return ERROR_PAGE;
            }

            List<ReminderModel> reminderModels = response.readEntity(new GenericType<List<ReminderModel>>() {
            });
            
            return INDEX_PAGE;
      }

      @RequestMapping("/add")
      public String addReminder(ReminderModel model) {
            WebClient client = getWebClient();
            Response response = client.post(Entity.json(model));
            if (response.getStatus() != Response.Status.OK.getStatusCode()) {
                  return ERROR_PAGE;
            }
            return index();
      }

      @RequestMapping("/get")
      public String getReminder() {

            WebClient client = getWebClient().path("{id}", 1);
            Response response = client.get();
            if (response.getStatus() != Response.Status.OK.getStatusCode()) {
                  return ERROR_PAGE;
            }

            final ReminderModel products = response.readEntity(ReminderModel.class);

            return INDEX_PAGE;
      }

      private WebClient getWebClient() {
            final List<Object> providers = new ArrayList<>();
            providers.add(new JacksonJaxbJsonProvider());
            WebClient client = WebClient.create(REMINDER_BASE, providers).path(REMINDER_REST).accept(MediaType.APPLICATION_JSON);
            return client;
      }

}
