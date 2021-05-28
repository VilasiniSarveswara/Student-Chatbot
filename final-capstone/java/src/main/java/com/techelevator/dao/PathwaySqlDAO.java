package com.techelevator.dao;

import com.techelevator.model.Response;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;


@Component
public class PathwaySqlDAO implements PathwayDAO{

    JdbcTemplate jdbcTemplate;

    public PathwaySqlDAO (DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Response getPathwayDetails(String topic) {

        if(topic.equalsIgnoreCase("technical")){

            int id = (int) ((Math.random()* 16) + 1) ;


            String sql = "SELECT response FROM technical_questions WHERE id = ?;";

            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

            if(result.next()){
                String responseText = result.getString("response");

                Response response = new Response();
                response.setResponseText(responseText);
                return response;
            }

        }
        else if(topic.equalsIgnoreCase("cover")){

            int id = (int) ((Math.random()* 7) + 1) ;


            String sql = "SELECT response FROM cover_letter WHERE id = ?;";

            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

            if(result.next()){
                String responseLink = result.getString("response");

                Response response = new Response();
                response.setResponseLink(responseLink);
                return response;
            }

        }
        else if(topic.equalsIgnoreCase("business_attire")){

            int id = (int) ((Math.random()* 3) + 1) ;


            String sql = "SELECT response FROM business_attire WHERE id = ?;";

            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

            if(result.next()){
                String responseLink = result.getString("response");

                Response response = new Response();
                response.setResponseLink(responseLink);
                return response;
            }



        }


        else if(topic.equalsIgnoreCase("behavioral")){

            int id = (int) ((Math.random()* 19) + 1) ;


            String sql = "SELECT response FROM behavioral_questions WHERE id = ?;";

            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

            if(result.next()){
                String responseText = result.getString("response");

                Response response = new Response();
                response.setResponseText(responseText);
                return response;
            }




        }
        else if(topic.equalsIgnoreCase("general")){

            String sql = "SELECT * FROM pathway_general";

            SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

            if(result.next()){
                String responseLink = result.getString("response");

                Response response = new Response();
                response.setResponseLink(responseLink);
                return response;
            }


        }


        return null;
    }
}
