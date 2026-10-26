
package com.placementhub.servlet;

import com.placementhub.dao.JobDAO;
import com.placementhub.model.Job;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/jobs")
public class JobServlet extends HttpServlet {

    private final JobDAO jobDAO = new JobDAO();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<Job> jobs = jobDAO.getAllJobs();

            request.setAttribute("jobs", jobs);

            request.getRequestDispatcher("/jobs.jsp")
                   .forward(request, response);

        } catch (SQLException e) {
            throw new ServletException(
                "Unable to load jobs from the database.", e
            );
        }
    }
}
