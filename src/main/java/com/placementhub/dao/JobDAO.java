
package com.placementhub.dao;

import com.placementhub.config.DBConnection;
import com.placementhub.model.Job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobDAO {

    public List<Job> getAllJobs() throws SQLException {

        List<Job> jobs = new ArrayList<>();

        String sql =
            "SELECT j.job_id, c.company_name, j.job_title, " +
            "j.job_type, j.location, j.salary, " +
            "j.description, j.required_skills " +
            "FROM jobs j JOIN companies c " +
            "ON j.company_id = c.company_id " +
            "ORDER BY j.posted_at DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Job job = new Job(
                    rs.getInt("job_id"),
                    rs.getString("company_name"),
                    rs.getString("job_title"),
                    rs.getString("job_type"),
                    rs.getString("location"),
                    rs.getString("salary"),
                    rs.getString("description"),
                    rs.getString("required_skills")
                );

                jobs.add(job);
            }
        }

        return jobs;
    }
}
