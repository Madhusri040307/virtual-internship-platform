# VIRTUAL INTERNSHIP PLATFORM FOR STUDENTS

## 1. Title

Virtual Internship Platform for Students

## 2. Domain

EdTech / Career Development

## 3. Who is the user?

**Student** – Searches and applies for virtual internships and tracks applications.

**Company** – Posts internship opportunities and manages student applications.

**Admin** – Manages students, companies, internships, and platform activities.

## 4. What problem are we solving?

Students often find it difficult to discover suitable virtual internship opportunities and track their applications in one place. Companies also need a simple platform to publish internship opportunities and manage student applications. The proposed platform brings students and companies together through a centralized virtual internship management system. It reduces manual communication and makes the internship application process easier and more organized.

## 5. Proposed Solution

The application will provide:

- Student registration and login
- Company registration and login
- Internship posting and management
- Internship search and filtering
- Student internship applications
- Application status tracking
- Resume management
- Company application management
- Admin management
- Email notifications
- Role-based access control

## 6. Core Entities / Database Tables

- User
- Student
- Company
- Internship
- Application
- Resume
- Notification
- Skill

## 7. User Roles & Permissions

### Student

- Register and login
- Manage profile
- Browse internships
- Search and filter internships
- Apply for internships
- Upload resume
- Track application status

### Company

- Register and login
- Manage company profile
- Create and manage internships
- View student applications
- Accept or reject applications

### Admin

- Manage students and companies
- Manage internship postings
- Monitor applications
- Manage platform activities

## 8. Success Criteria

- Students should be able to register and login successfully.
- Students should be able to find and apply for internships.
- Companies should be able to create internship postings.
- Companies should be able to manage applications.
- Students should be able to track their application status.
- Admin should be able to manage the platform.
- The main workflows should work successfully from frontend to backend to database.

## 9. Out of Scope

- Real-time video interviews
- Online payment processing
- Full learning management system
- Real-time chat system
- Automatic internship certificate generation
- Advanced AI features in the initial MVP

## 10. Chosen Track

Java (Spring Boot)

## 11. Objectives

1. To provide a centralized platform for students to discover virtual internship opportunities.

2. To allow students to search and filter internships based on skills, interests, duration, and work mode.

3. To provide an easy application process for students.

4. To help students track the status of their internship applications.

5. To allow companies to post and manage internship opportunities.

6. To help companies manage and review student applications.

7. To provide role-based access for Students, Companies, and Admins.

8. To reduce manual communication and organize the internship management process.

## 12. Existing System

Currently, students use multiple internship websites, company websites, social media platforms, and other online sources to find internship opportunities.

The existing approach has the following limitations:

- Internship information is scattered across multiple platforms.
- Finding internships matching student skills and interests can be time-consuming.
- Managing multiple applications is difficult.
- Application status tracking may not be available in one centralized place.
- Companies may use different methods to collect and manage applications.
- Communication between students and companies can involve manual processes.

## 13. Proposed System

The proposed Virtual Internship Platform for Students is a centralized web-based system that connects students, companies, and administrators in one platform.

Students can create an account, manage their profile, search and filter virtual internships, view internship details, apply for suitable opportunities, upload resumes, and track their application status.

Companies can create company accounts, post internship opportunities, manage internship details, view student applications, and accept or reject applications.

Administrators can manage students, companies, internship postings, applications, and other platform activities.

The system uses role-based access control to provide appropriate permissions for Students, Companies, and Admins. Email notifications can be used to keep users informed about important application updates.

The proposed system aims to make the internship discovery and application process more organized, centralized, and easier to manage.

## 14. Requirements

### 14.1 Functional Requirements

- User registration and login
- Student profile management
- Company profile management
- Internship creation and management
- Internship search and filtering
- Internship details viewing
- Internship application submission
- Resume upload and management
- Application status tracking
- Company application management
- Admin management
- Email notifications
- Role-based access control

### 14.2 Non-Functional Requirements

- Security
- Reliability
- Usability
- Performance
- Scalability
- Maintainability
- Data consistency
- Responsive user interface

### 14.3 Software Requirements

- Java
- Spring Boot
- React.js
- MySQL
- REST API
- Spring Security
- JWT
- Git
- GitHub

### 14.4 Hardware Requirements

- Computer or laptop
- Minimum 4 GB RAM
- Internet connection
- Modern web browser

## 15. System Modules

### 15.1 User Management Module

Handles registration, login, profile management, and role-based access for Students, Companies, and Admins.

### 15.2 Student Module

Allows students to manage their profiles, browse internships, search and filter opportunities, apply for internships, upload resumes, and track application status.

### 15.3 Company Module

Allows companies to manage their profiles, create internship postings, manage internship details, and review student applications.

### 15.4 Internship Management Module

Handles internship creation, updating, viewing, searching, filtering, and management.

### 15.5 Application Management Module

Handles internship applications and allows students to track their application status. Companies can review and update application status.

### 15.6 Resume Management Module

Allows students to upload and manage their resumes for internship applications.

### 15.7 Notification Module

Provides notifications to users about important internship and application updates.

### 15.8 Admin Module

Allows administrators to manage users, companies, internships, applications, and overall platform activities.