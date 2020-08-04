package com.google.sps.servlets;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.gson.Gson;
import com.google.sps.data.Commodity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.*;
import java.time.format.*;
import java.util.Locale;
import com.google.appengine.api.datastore.Key;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {


  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    long item_id = Long.parseLong(request.getParameter("item_id"));
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    datastore.delete(KeyFactory.createKey("Commodity", item_id));
    response.sendRedirect("/index.html");
  }

}