/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walmart.reminder.controller;

import com.walmart.reminder.model.ReminderModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author HiepNguyen
 */
@Controller
public class ReminderController {

      private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");

      private static final String REMINDER_BASE = "http://localhost:8080/rest";
      private static final String REMINDER_REST = "reminders";

      private static final String WELCOME_PAGE = "welcome";
      private static final String ERROR_PAGE = "redirect:error";
      private static final String INDEX_PAGE = "index";
      private static final String INDEX_REDIRECT_PAGE = "redirect:list";
      private static final String SEARCH_PAGE = "search";
      private static final String DETAILS_PAGE = "details";
      private static final String UPDATE_PAGE = "update";
      private static final String REMINDER_KEY = "reminder";
      private static final String MESSAGE_KEY = "message";

      @RequestMapping("/")
      public String root() {
            return WELCOME_PAGE;
      }

      @RequestMapping("/list")
      public ModelAndView index(ModelAndView modelAndView) {
            modelAndView.setViewName(INDEX_PAGE);

            WebClient client = getWebClient();
            Response response = null;
            try {
                  response = client.get();
            } catch (Exception exp) {
                  modelAndView.setViewName(ERROR_PAGE);
                  modelAndView.addObject("message", "Can't connect to backed service");
            }
            if (response.getStatus() != Response.Status.OK.getStatusCode()) {
                  modelAndView.addObject("message", errorMessage(response.getStatus()));
            } else {
                  List<ReminderModel> reminderModels = response.readEntity(new GenericType<List<ReminderModel>>() {
                  });
                  modelAndView.addObject("reminderModels", reminderModels);
            }

            return modelAndView;
      }

      @RequestMapping("/add")
      public ModelAndView addReminder(ReminderModel model) {
            ModelAndView modelAndView = new ModelAndView(INDEX_REDIRECT_PAGE);
            WebClient client = getWebClient();
            Response response = null;
            try {
                  response = client.post(Entity.json(model));
            } catch (Exception exp) {
                  modelAndView.setViewName(ERROR_PAGE);
                  modelAndView.addObject(MESSAGE_KEY, "Can't connect to backed service");
            }
            if (response.getStatus() != Response.Status.OK.getStatusCode()) {
                  modelAndView.setViewName(ERROR_PAGE);
                  modelAndView.addObject(MESSAGE_KEY, "Can't add new reminder");
            }
            return modelAndView;
      }

      @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
      public ModelAndView updateGet(@PathVariable("id") Long id, ModelAndView modelAndView) {
            modelAndView.setViewName(UPDATE_PAGE);
            Response response = null;
            try {
                  response = getWebClient().path("{id}", id).get();
            } catch (Exception exp) {
                  modelAndView.setViewName(ERROR_PAGE);
                  modelAndView.addObject(MESSAGE_KEY, "Can't connect to backed service");
            }
            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                  modelAndView.addObject(REMINDER_KEY, response.readEntity(ReminderModel.class));
            } else {
                  modelAndView.addObject(MESSAGE_KEY, String.format("Can't find out Reminder has id %s", id));
            }

            return modelAndView;
      }

      @RequestMapping(value = "/update", method = RequestMethod.POST)
      public ModelAndView updatePost(ReminderModel reminder) {
            ModelAndView modelAndView = new ModelAndView(INDEX_REDIRECT_PAGE);
            WebClient client = getWebClient();
            Response response = null;
            try {
                  response = client.put(Entity.json(reminder));
            } catch (Exception exp) {
                  modelAndView.setViewName(ERROR_PAGE);
                  modelAndView.addObject(MESSAGE_KEY, "Can't connect to backed service");
            }
            if (response.getStatus() != Response.Status.NO_CONTENT.getStatusCode()) {
                  modelAndView.setViewName(ERROR_PAGE);
                  modelAndView.addObject(MESSAGE_KEY, "Can't add new reminder");
            }
            return modelAndView;
      }

      @RequestMapping(value = "/search", method = RequestMethod.GET)
      public String getSearchPage() {
            return SEARCH_PAGE;
      }

      @RequestMapping(value = "/search", method = RequestMethod.POST)
      public ModelAndView searchProcessing(String start, String end, String[] status) {
            ModelAndView modelAndView = new ModelAndView(SEARCH_PAGE);
            Response response = null;
            try {
                  WebClient webClient = getWebClient();
                  if (getDateValue(start) != null) {
                        webClient.query("start", getDateValue(start));

                  }
                  if (getDateValue(end) != null) {
                        webClient.query("end", getDateValue(end));

                  }
                  if (status != null) {
                        webClient.query("status", status);
                  }
                  response = webClient.get();
            } catch (Exception exp) {
                  modelAndView.setViewName(ERROR_PAGE);
                  modelAndView.addObject("message", "Can't connect to backed service");
            }

            if (response.getStatus() != Response.Status.OK.getStatusCode()) {
                  modelAndView.addObject("message", errorMessage(response.getStatus()));
            } else {
                  List<ReminderModel> reminderModels = response.readEntity(new GenericType<List<ReminderModel>>() {
                  });
                  modelAndView.addObject("reminderModels", reminderModels);
            }
            return modelAndView;
      }

      private WebClient getWebClient() {
            final List<Object> providers = new ArrayList<>();
            providers.add(new JacksonJaxbJsonProvider());
            WebClient client = WebClient.create(REMINDER_BASE, providers).path(REMINDER_REST).accept(MediaType.APPLICATION_JSON);
            return client;
      }

      private String getDateValue(String value) {
            return value == null || "".equals(value.trim()) ? null : DATE_FORMAT.format(new Date(value));
      }

      private String errorMessage(int status) {
            return "Status code " + status;
      }

}
