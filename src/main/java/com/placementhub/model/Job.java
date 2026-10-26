
package com.placementhub.model;

public class Job {

    private int jobId;
    private String companyName;
    private String jobTitle;
    private String jobType;
    private String location;
    private String salary;
    private String description;
    private String requiredSkills;

    public Job(int jobId, String companyName,
               String jobTitle, String jobType,
               String location, String salary,
               String description, String requiredSkills) {

        this.jobId = jobId;
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.jobType = jobType;
        this.location = location;
        this.salary = salary;
        this.description = description;
        this.requiredSkills = requiredSkills;
    }

    public int getJobId() {
        return jobId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getJobType() {
        return jobType;
    }

    public String getLocation() {
        return location;
    }

    public String getSalary() {
        return salary;
    }

    public String getDescription() {
        return description;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }
}
