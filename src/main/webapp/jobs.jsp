
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.placementhub.model.Job" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>PlacementHub | Explore Jobs</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f5f6ff;
            color: #1e2450;
            margin: 0;
            padding: 35px;
        }

        h1 { color: #5638d9; }

        .job-card {
            background: white;
            padding: 22px;
            margin: 16px 0;
            border-radius: 16px;
            box-shadow: 0 5px 20px #20205012;
        }

        .company { color: #777; }
        .salary { color: #13845b; font-weight: bold; }
        .skills { color: #5638d9; }
    </style>
</head>
<body>

<h1>PlacementHub — Explore Jobs</h1>
<p>Explore job opportunities loaded from our database.</p>

<%
    List<Job> jobs = (List<Job>) request.getAttribute("jobs");

    if (jobs == null || jobs.isEmpty()) {
%>
    <p>No jobs found. Add job records in MySQL Workbench first.</p>
<%
    } else {
        for (Job job : jobs) {
%>
    <div class="job-card">
        <h2><%= job.getJobTitle() %></h2>
        <p class="company"><%= job.getCompanyName() %></p>
        <p>Location: <%= job.getLocation() %></p>
        <p>Type: <%= job.getJobType() %></p>
        <p class="salary">Salary: <%= job.getSalary() %></p>
        <p><%= job.getDescription() %></p>
        <p class="skills">Skills: <%= job.getRequiredSkills() %></p>
    </div>
<%
        }
    }
%>

</body>
</html>
