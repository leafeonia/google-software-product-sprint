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

@WebServlet("/add")
public class AddServlet extends HttpServlet {


  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    long item_id = Long.parseLong(request.getParameter("item_id"));
    long number = Long.parseLong(request.getParameter("number"));
    /*Query<Entity> query = Query.newEntityQueryBuilder()
        .setKind("Commodity")
        .setFilter(PropertyFilter.eq("done", true))
        .build();*/
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    //QueryResults<Entity> tasks = datastore.run(query);

    try {
		Entity entity = datastore.get(KeyFactory.createKey("Commodity", item_id));
        long original_number = (long) entity.getProperty("number");
        entity.setProperty("number", original_number + number);
        entity.setProperty("last_time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd  hh:mm ")));
        datastore.put(entity);
	} catch(EntityNotFoundException e) {
		e.printStackTrace();
	}

    response.sendRedirect("/index.html");
  }

}