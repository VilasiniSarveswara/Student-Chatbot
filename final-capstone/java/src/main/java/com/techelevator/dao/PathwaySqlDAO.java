package com.techelevator.dao;

import com.techelevator.model.Response;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Component
public class PathwaySqlDAO implements PathwayDAO {

    JdbcTemplate jdbcTemplate;

    public PathwaySqlDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Response getPathwayDetails(String topic) {
        Response response = new Response();
        List<String> responseList = new ArrayList<>();
        List<String> responseLinkList = new ArrayList<>();
        if (topic.equalsIgnoreCase("technical")) {


            String sql = "SELECT response, responselinks FROM technical_questions;";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

            int responseCounter = 0;
            while(results.next()) {
               responseCounter++;
               if( responseCounter < 17) {
                   String responseText = mapToResponse(results);
                   responseList.add(responseText);
               }
               else {
                   String responseLink = mapToResponseLink(results);
                   responseLinkList.add(responseLink);
               }
               response.setResponseTextList(responseList);
               response.setResponseLinkList(responseLinkList);
                return response;
            }

        } else if (topic.equalsIgnoreCase("cover")) {

            int id = (int) ((Math.random() * 7) + 1);


            String sql = "SELECT response FROM cover_letter WHERE id = ?;";

            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

            if (result.next()) {
                String responseLink = result.getString("response");

//                Response response = new Response();
//                response.setResponseLink(responseLink);
                return response;
            }

        } else if (topic.equalsIgnoreCase("business_attire")) {

            int id = (int) ((Math.random() * 3) + 1);


            String sql = "SELECT response FROM business_attire WHERE id = ?;";

            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

            if (result.next()) {
                String responseLink = result.getString("response");

//                Response response = new Response();
//                response.setResponseLink(responseLink);
                return response;
            }


        } else if (topic.equalsIgnoreCase("behavioral")) {

            int id = (int) ((Math.random() * 19) + 1);


            String sql = "SELECT response FROM behavioral_questions WHERE id = ?;";

            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

            if (result.next()) {
                String responseText = result.getString("response");

//                Response response = new Response();
//                response.setResponseText(responseText);
                return response;
            }


        } else if (topic.equalsIgnoreCase("general")) {

            String sql = "SELECT * FROM pathway_general";

            SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

            if (result.next()) {
                String responseLink = result.getString("response");

//                Response response = new Response();
//                response.setResponseLink(responseLink);
                return response;
            }


        }


        return null;
    }

    // helper method
    public String mapToResponse(SqlRowSet results) {
    String response = results.getString("response");
        return response;
    }
    public String mapToResponseLink(SqlRowSet results) {
        String responseLink = results.getString("responseLinks");
        return responseLink;
    }
}
