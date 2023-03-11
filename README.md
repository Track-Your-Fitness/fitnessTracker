# Project Prep

| Table of Contents - Fitness Tracker                                    |
| -----------------------------------------------------------------------|
| [Collaborators](https://github.com/Track-Your-Fitness/fitnessTracker/blob/staging/README.md#collaborators)
| [Project Prep 1](https://github.com/Track-Your-Fitness/fitnessTracker/blob/staging/README.md#project-prep-1) |
| [Project Prep 2](https://github.com/Track-Your-Fitness/fitnessTracker/blob/staging/README.md#project-prep-2) |
| [Project Prep 4](https://github.com/Track-Your-Fitness/fitnessTracker/blob/staging/README.md#project-prep-4) |
| [Wireframe](https://github.com/Track-Your-Fitness/fitnessTracker/blob/staging/README.md#wireframe) |
| [Database](https://github.com/Track-Your-Fitness/fitnessTracker/blob/staging/README.md#data-base) |
| [Schema](https://github.com/Track-Your-Fitness/fitnessTracker/blob/staging/README.md#schema) |
| [WRRC](https://github.com/Track-Your-Fitness/fitnessTracker/blob/staging/README.md#wrrc) |
| [Tutorial](https://github.com/Track-Your-Fitness/fitnessTracker/blob/staging/README.md#tutorial) |

## Collaborators

 Adrian, Devon, Ryan, Sharmarke

## Project Prep 1

### Cooperation Plan

Strengths: Sharmarke: Being empathic Ryan: CSS Adrian: Communication Devon: Research, Design, Tech Writing We can best utilize these strengths in the execution of your project by working as a team and utilizing each others strengths to accomplish and finish our midterm gracefully. Professional competencies do you each want to develop greater strength: Sharmarke: Technical writing Ryan: Process Adrian: Tool Proficiency Devon: Technical writing We plan to approach the day-to-day work by communicating what we want to accomplish.

### Conflict Plan
Our group’s process to resolve conflict, when it arises will be to communicate with one another to solve conflicts. If one person is taking over the project and not letting the other members contribute, we will have a meeting as a group and have a conversation on that conflict. We will attempt to solve everything within the group first. Seeing each others commits to see and have morning meeting do discuss problems and work together if the problem arises, is how we would approach those concerns. We will raise those concerns through slack or our morning meetings is how we would raise concerns to members who are not adequately contributing. Having a 3 strike rule, then have a conversation with Alex and Rey about it once it reaches the 3rd strike.

### Communication Plan
From 9 am - 6 pm and possibly after hours. The platform we will be using is Zoom and Slack for communication and Github project management for tracking progress. One break every hour, one hour break at lunch. Working after hours if we fall behind. We will be communicating after hours through Slack. The strategy to ensure that everyone’s voice is heard is by having honest feedback on how everyone is doing. We will ensure that we are creating a safe environment where everyone feels comfortable speaking up by being empathetic on each other and also make sure we are all on the same page.

### Work Plan
Communicate in Slack, Remo, Zoom, and a GitHub project tool on what task we split into doing and have a discussion where we are, when we are stuck, and when we are complete. Github will be used is the project management tool.

### Presentation Deck
https://docs.google.com/presentation/d/1yiC31JEpZOm4efh9_J0sK6p43QuAhOhmZaMqe6dH4B4/edit#slide=id.g2accd1c413_3_31

### Git Process
HTML, Java, AWS, Android Studio, and CSS will the be components on Github. We are all collaborators so we will have copies of the repos. The Git flow will be everything on the staging branch with a new name and then each day have one branch for a specific implementation that would be merged into the staging branch. Everyone will review staging into main. We won't merge our own code. We will push to a branch and wait for 2 approvers. At the end of the day we will merge into the staging branch. Communicate in zoom and slack when it is time to merge.

## Project Prep 2

Summary: 

Fitness Tracking app where you are able to keep track on what muscle group the user is working on.

Pain Point: 

Where the user is able to work on different muscle groups and track their work out throughout the week. A personalized page to sign up so they can be authorized. Keep track of their progress and look at locations to different gyms that are nearest to the user.

Minimum Viable Product (MVP):

MVP: Authorizing the user using auth, implementing S3, adding workouts, and filter workouts by muscle group.

## Project Prep 4

### User Story 1

User Authentication

User Story

As a user, I want to have an authentication sign up, then login, and log out so that I can have a secured my account with my information.

Feature Tasks

User can successfully sign up.

User can successfully login.

Have the option for signup or log in.

Once the user is logged in, they can log out.

DynamoDB saving data.

Following sign up takes user to login.

Following login user will be taken to their page.

Acceptance Tests

Ensure the user can choose sign up, login, and logout.

Ensure the user can type in the edit text.

Provide an error and success message for signup and login.

Ensure data saved to database.

### User Story 2

Search Workout

User Story

As a user, I want to have the ability to search for workouts.

Feature Tasks

Show the categories for workouts.

Able to select category and workout.

Acceptance Tests

Ensure the category and workout links to correct path.

Ensure API data is displaying.

### User Story 3

Tracking Data

User Story

As a user, I want to be able to save/ keep track of my data.

Feature Tasks

User can input data into input.

User can see saved data.

Ability to edit data.

Acceptance Tests

Provide error  and success message.

Ensure data successfully saved to data base.

### User Story 4

Showing Workout

User Story

As a user, I want to be able to have examples of the work out.

Feature Tasks

Implement API to have access to workout examples.

Successfully retrieving API data.

Acceptance Tests

Providing success and failure log messages.

Ensure the users are able to see the work outs.

### User Story 5

Edit Data

User Story

As a user, I want to be able to edit my data.

Feature Tasks

Allow user to edit username, email, password.

Update username, email, and password when changed.

Display new changed username.

Acceptance Tests

Username, email, and password will change when user changes it in settings

Username will display as changed username after user changes it.

Software Requirement

Vision

The vision of this product is for a “fun” interactive way, to allow people to sign up for a fitness tracker app, create workouts, follow workouts, and track progress.

The pain point this project solves is for users having to keep track of their workouts and find exercises for workouts on their own. They may do it easily and conveniently on one app. This project is great to improve the health and well being of users, while presenting it in a creative app.

Scope (In/Out)

IN - What will your product do

App will allow users to create an account with AWS  Cognito.

A person may search for workouts to do and save those workouts to their plan.

A person may see workout examples performed. 

OUT - What will your product not do?

Will not offer nutrition information. 

Minimum Viable Product vs

What will your MVP functionality be?

Create an account with AWS Cognito with authorization. View and create new workouts. Filter workouts by muscle group. Delete workouts. 

What are your stretch goals?

Stretch goals include, a nutrition tracker, a workout calendar, and a location tracker. 

Stretch

Nutrition tracker, and workout calendar. 

Functional Requirements

List the functionality of your product. This will consist of tasks such as the following:

An admin can create and delete user accounts.

A user can update their profile information.

A user can search for different workouts by body group or exercise type. 

A user may save those workouts to their personal workout plan. 

A user may track their reps, for workouts. 

A user may add images of their workout. 

Data Flow
When a user opens the app, they are taken to the base page, where they may either sign up, if they haven’t already, or they may log in, if they have already signed up. If they are newly signing up, they will be taken to the sign up page to input their information. Afterwards, they will be taken back to the sign in page, to sign in. From there, they will be redirected to the home page after signing in. At the home page, users will be able to directly begin to look for workouts they would like to perform. There will be access here, to take users to a settings page where they may update profile information, workout category page, and the current users workouts page.

Non-Functional Requirements :

Security with AWS Cognito

Location access

S3 to upload images

UI/UX (usability, and ease of use of the app)

Proper encapsulation

Testing with Espresso

Security with AWS Cognito will be used to allow secure login to users accounts. Testing with Espresso will be used to test for desired functionality. 

## WireFrame

<img width="630" alt="WireFrame" src="https://user-images.githubusercontent.com/115438182/224453799-653f1bf0-e6a5-4c1e-9b9b-c7fa2df0180e.png">

## Data Base

<img width="730" alt="Database" src="https://user-images.githubusercontent.com/115438182/224453834-083c3e05-d124-4c0f-992d-f5510c466580.png">

## Schema

<img width="484" alt="db1" src="https://user-images.githubusercontent.com/115438182/224453955-a292466f-c68e-471b-871c-db309bcb7924.png">
<img width="719" alt="db2" src="https://user-images.githubusercontent.com/115438182/224453959-38f5242f-a306-4b87-a41b-a87d2dc4963d.png">

## WRRC

<img width="1069" alt="WRRC" src="https://user-images.githubusercontent.com/115438182/224453887-05fb23c2-f478-4f77-b07d-0a106cb9b2fe.png">

# Tutorial




