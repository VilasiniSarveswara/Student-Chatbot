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

            int id = (int) (Math.random()* 16);


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

        }
        else if(topic.equalsIgnoreCase("business wear")){

        }
        else if(topic.equalsIgnoreCase("jobs")){

        }
        else if(topic.equalsIgnoreCase("behavioral")){

        }
        else if(topic.equalsIgnoreCase("general pathway")){

        }


        return null;
    }
}
